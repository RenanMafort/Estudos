package br.com.springboot3.controller;

import br.com.springboot3.data.vo.v1.PersonVO;
import br.com.springboot3.data.vo.v2.v1.PersonVOV2;
import br.com.springboot3.model.Person;
import br.com.springboot3.services.PersonServices;
import br.com.springboot3.utils.constants.Constants;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.PagedModel;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/person/v1")
@Tag(name = "Person", description = "EndoPoints for Managing Peoples")
public class PersonController {

//    private PersonServices personServices = new PersonServices();

    @Autowired
    private PersonServices service;

    @CrossOrigin(origins = {"http://localhost:8080","https://renan.sereia.com"})
    @GetMapping(value = "/{id}", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE,
            Constants.MEDIA_TYPE_APPLICATION_YAML})
    @Operation(summary = "Find by id", description = "Find by id",
            tags = {"People"},
            responses ={
                @ApiResponse(description = "Sucess",responseCode = "200",
                content = @Content(schema = @Schema(implementation = PersonVO.class)
                        )
                ),
                    @ApiResponse(description = "No Content", responseCode = "204", content = @Content),
                    @ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
                    @ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
                    @ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
                    @ApiResponse(description = "Internal Server Erro", responseCode = "500", content = @Content)
            })
    public PersonVO findById(
            @PathVariable(value = "id") Long id) {

        return service.findById(id);

    }

    @PatchMapping(value = "/{id}", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE,
            Constants.MEDIA_TYPE_APPLICATION_YAML})
    @Operation(summary = "Disable a spesific person by your Id", description = "Disable Person",
            tags = {"People"},
            responses ={
                    @ApiResponse(description = "Sucess",responseCode = "200",
                            content = @Content(schema = @Schema(implementation = PersonVO.class)
                            )
                    ),
                    @ApiResponse(description = "No Content", responseCode = "204", content = @Content),
                    @ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
                    @ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
                    @ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
                    @ApiResponse(description = "Internal Server Erro", responseCode = "500", content = @Content)
            })
    public PersonVO disablePerson(
            @PathVariable(value = "id") Long id) {

        return service.disablePerson(id);

    }

    @CrossOrigin(origins = "http://localhost:8080",methods = {RequestMethod.GET})
    @GetMapping(produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE, Constants.MEDIA_TYPE_APPLICATION_YAML})
    @Operation(summary = "Find all Peoples", description = "Find all People",
            tags = {"People"},
            responses = {
                    @ApiResponse(description = "Sucess", responseCode = "200",
                            content = {
                                    @Content(
                                            mediaType = "appilication/json",
                                            array = @ArraySchema(schema = @Schema(implementation = PersonVO.class))
                                    )
                            }),
                    @ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
                    @ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
                    @ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
                    @ApiResponse(description = "Internal Server Erro", responseCode = "500", content = @Content),
            }
    )
    public ResponseEntity<PagedModel<EntityModel<PersonVO>>> findAll(
            @RequestParam(value = "page",defaultValue = "0") Integer page,
            @RequestParam(value = "limit",defaultValue = "12") Integer limit,
            @RequestParam(value = "direction",defaultValue = "asc") String direction) {

        var sortDirection = "desc".equalsIgnoreCase(direction) ? Sort.Direction.DESC : Sort.Direction.ASC;
        Pageable pageable = PageRequest.of(page,limit,Sort.by(sortDirection,"firstName"));
        return ResponseEntity.ok(service.findAll(pageable));

    }

    @PostMapping(
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE, Constants.MEDIA_TYPE_APPLICATION_YAML},
            consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE, Constants.MEDIA_TYPE_APPLICATION_YAML}
    )
    @Operation(summary = "Create a Person", description = "Create a Person",
            tags = {"People"},
            responses ={
                    @ApiResponse(description = "Sucess",responseCode = "200",
                            content = @Content(schema = @Schema(implementation = PersonVO.class)
                            )
                    ),
                    @ApiResponse(description = "Bad Re quest", responseCode = "400", content = @Content),
                    @ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
                    @ApiResponse(description = "Internal Server Erro", responseCode = "500", content = @Content)
            })
    public PersonVO create(@RequestBody PersonVO person) {
        return service.createPerson(person);
    }


    @PostMapping(value = "/v2",
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE, Constants.MEDIA_TYPE_APPLICATION_YAML},
            consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE, Constants.MEDIA_TYPE_APPLICATION_YAML}
    )
    public PersonVOV2 createV2(@RequestBody PersonVOV2 person) {
        return service.createPersonV2(person);
    }

    @PutMapping(produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE, Constants.MEDIA_TYPE_APPLICATION_YAML},
            consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE, Constants.MEDIA_TYPE_APPLICATION_YAML}
    )
    @Operation(summary = "Update a Person", description = "Update a Person",
            tags = {"People"},
            responses ={
                    @ApiResponse(description = "Sucess",responseCode = "200",
                            content = @Content(schema = @Schema(implementation = PersonVO.class)
                            )
                    ),
                    @ApiResponse(description = "Bad Re quest", responseCode = "400", content = @Content),
                    @ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
                    @ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
                    @ApiResponse(description = "Internal Server Erro", responseCode = "500", content = @Content)
            })
    public PersonVO udpate(@RequestBody PersonVO person) {
        return service.updatePerson(person);

    }

    @DeleteMapping(value = "/{id}"
    )
    @Operation(summary = "Delete a Person", description = "Delete a Person",
            tags = {"People"},
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
