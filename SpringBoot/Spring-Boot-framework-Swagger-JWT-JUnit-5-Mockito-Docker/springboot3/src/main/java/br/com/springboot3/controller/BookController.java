package br.com.springboot3.controller;

import br.com.springboot3.data.vo.v1.BookVO;
import br.com.springboot3.services.BookServices;
import br.com.springboot3.utils.constants.Constants;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/book/v1")
@Tag(name = "Book", description = "EndoPoints for Managing Books")
public class BookController {

//    private BookService bookServices = new BookService();

    @Autowired
    private BookServices service;

    @GetMapping(value = "/{id}", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE,
            Constants.MEDIA_TYPE_APPLICATION_YAML})
    @Operation(summary = "Find by id", description = "Find by id",
            tags = {"Book"},
            responses ={
                @ApiResponse(description = "Sucess",responseCode = "200",
                content = @Content(schema = @Schema(implementation = BookVO.class)
                        )
                ),
                    @ApiResponse(description = "No Content", responseCode = "204", content = @Content),
                    @ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
                    @ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
                    @ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
                    @ApiResponse(description = "Internal Server Erro", responseCode = "500", content = @Content)
            })
    public BookVO findById(
            @PathVariable(value = "id") Long id) {

        return service.findById(id);

    }

    @GetMapping(produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE, Constants.MEDIA_TYPE_APPLICATION_YAML})
    @Operation(summary = "Find all Books", description = "Find all Book",
            tags = {"Book"},
            responses = {
                    @ApiResponse(description = "Sucess", responseCode = "200",
                            content = {
                                    @Content(
                                            mediaType = "appilication/json",
                                            array = @ArraySchema(schema = @Schema(implementation = BookVO.class))
                                    )
                            }),
                    @ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
                    @ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
                    @ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
                    @ApiResponse(description = "Internal Server Erro", responseCode = "500", content = @Content),
            }
    )
    public List<BookVO> findAll() {
        return service.findAll();

    }

    @PostMapping(
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE, Constants.MEDIA_TYPE_APPLICATION_YAML},
            consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE, Constants.MEDIA_TYPE_APPLICATION_YAML}
    )
    @Operation(summary = "Create a Book", description = "Create a Book",
            tags = {"Book"},
            responses ={
                    @ApiResponse(description = "Sucess",responseCode = "200",
                            content = @Content(schema = @Schema(implementation = BookVO.class)
                            )
                    ),
                    @ApiResponse(description = "Bad Re quest", responseCode = "400", content = @Content),
                    @ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
                    @ApiResponse(description = "Internal Server Erro", responseCode = "500", content = @Content)
            })
    public BookVO create(@RequestBody BookVO book) {
        return service.createBook(book);
    }


//    @PostMapping(value = "/v2",
//            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE, Constants.MEDIA_TYPE_APPLICATION_YAML},
//            consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE, Constants.MEDIA_TYPE_APPLICATION_YAML}
//    )
//    public BookVOV2 createV2(@RequestBody BookVOV2 book) {
//        return service.createBookV2(book);
//    }

    @PutMapping(produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE, Constants.MEDIA_TYPE_APPLICATION_YAML},
            consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE, Constants.MEDIA_TYPE_APPLICATION_YAML}
    )
    @Operation(summary = "Update a Book", description = "Update a Book",
            tags = {"Book"},
            responses ={
                    @ApiResponse(description = "Sucess",responseCode = "200",
                            content = @Content(schema = @Schema(implementation = BookVO.class)
                            )
                    ),
                    @ApiResponse(description = "Bad Re quest", responseCode = "400", content = @Content),
                    @ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
                    @ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
                    @ApiResponse(description = "Internal Server Erro", responseCode = "500", content = @Content)
            })
    public BookVO udpate(@RequestBody BookVO book) {
        return service.updateBook(book);

    }

    @DeleteMapping(value = "/{id}"
    )
    @Operation(summary = "Delete a Book", description = "Delete a Book",
            tags = {"Book"},
            responses ={
                    @ApiResponse(description = "No Content",responseCode = "204",content = @Content),
                    @ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
                    @ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
                    @ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
                    @ApiResponse(description = "Internal Server Erro", responseCode = "500", content = @Content)
            })
    public ResponseEntity<?> delete(@PathVariable(value = "id") Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();

    }

}
