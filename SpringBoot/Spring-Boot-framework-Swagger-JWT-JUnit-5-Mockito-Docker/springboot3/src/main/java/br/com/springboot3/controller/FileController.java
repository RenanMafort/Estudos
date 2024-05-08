package br.com.springboot3.controller;

import br.com.springboot3.data.vo.v1.UploadFileResponseVO;
import br.com.springboot3.exception.MyFileNotFoundException;
import br.com.springboot3.services.FileStorageService;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Collectors;

@Tag(name = "File Endpoint")
@RestController
@RequestMapping("/api/file/v1")
public class FileController {

    private Logger logger = Logger.getLogger(FileController.class.getName());

    @Autowired
    private FileStorageService fileStorageService;

    @PostMapping("/uploadFile")
    public UploadFileResponseVO uploadFile(@RequestParam("file")MultipartFile file){
        var fileName = fileStorageService.storeFile(file);
        String uriString = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path("/api/file/v1/downloadFile/")
                .path(fileName)
                .toUriString();

        return new UploadFileResponseVO(fileName,uriString,file.getContentType(),file.getSize());
    }

    @PostMapping("/uploadMultipleFiles")
    public List<UploadFileResponseVO> uploadMultipleFiles(@RequestParam("files")MultipartFile[] files){

        return Arrays.asList(files)
                .stream().map(this::uploadFile)
                .collect(Collectors.toList());

    }
    @GetMapping("/downloadFile/{filename:.+}")
    public ResponseEntity<Resource> downloadFile(@PathVariable String filename, HttpServletRequest request) {
        logger.info("Reading a file on disk");
        Resource resource = fileStorageService.loadFileAsResource(filename);
        String contentType = "";
        try {
            contentType = request.getServletContext().getMimeType(resource.getFile().getAbsolutePath());
        } catch (Exception e) {
            logger.info("Could not determine file type!");
        }

        if (contentType.isBlank()) contentType = "application/octet-stream";

        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + resource.getFilename() + "\"")
                .contentType(MediaType.parseMediaType(contentType))
                .body(resource);
    }
}
