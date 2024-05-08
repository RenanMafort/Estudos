package br.com.springboot3.services;

import br.com.springboot3.config.FileStorage;
import br.com.springboot3.exception.FileStorageException;
import br.com.springboot3.exception.MyFileNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.*;

@Service
public class FileStorageService {

    private final Path fileStorageLocation;

    @Autowired
    public FileStorageService(FileStorage fileStorage){
        this.fileStorageLocation = Paths.get(fileStorage.getUploadDir()).toAbsolutePath().normalize();

        try {
            Files.createDirectories(this.fileStorageLocation);

        }catch (Exception e){
            throw new FileStorageException(
                    "Could not create the directory where the uploaded files will be stored!",e);
        }
    }

    public String storeFile(MultipartFile file){
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());
        try {
            if (fileName.contains("..") || fileName.contains(" ")){
                throw new FileStorageException("File " + fileName + "contains invalid character");
            }

            Path resolve = this.fileStorageLocation.resolve(fileName);
            Files.copy(file.getInputStream(),resolve, StandardCopyOption.REPLACE_EXISTING);
            return fileName;
        }catch (Exception e){
            throw new FileStorageException("Could not stored file " +
                    fileName + "Please Try again!");
        }
    }

    public Resource loadFileAsResource(String filename){
        try {
            Path filePath = this.fileStorageLocation.resolve(filename).normalize();

            Resource urlResource = new UrlResource(filePath.toUri());
            if (urlResource.exists()) return urlResource;
            else throw new MyFileNotFoundException("File not Found " + filename);
        }catch (Exception e){
            throw new MyFileNotFoundException("File not Found " + filename,e);
        }
    }
}
