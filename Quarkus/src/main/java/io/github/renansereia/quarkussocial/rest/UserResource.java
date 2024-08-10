package io.github.renansereia.quarkussocial.rest;

import io.github.renansereia.quarkussocial.domain.model.User;
import io.github.renansereia.quarkussocial.domain.repository.UserRepository;
import io.github.renansereia.quarkussocial.rest.dto.CreateUserRequestDTO;
import io.github.renansereia.quarkussocial.rest.dto.ResponseError;
import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import io.quarkus.hibernate.orm.panache.PanacheQuery;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validator;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.Set;

@Path("/users")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class UserResource {

    private final UserRepository userRepository;
    private final Validator validator;

    @Inject
    public UserResource(UserRepository userRepository, Validator validator) {
        this.userRepository = userRepository;
        this.validator = validator;
    }

    @POST
    @Transactional
    public Response createUser(CreateUserRequestDTO userRequest){
        Set<ConstraintViolation<CreateUserRequestDTO>> validate = validator.validate(userRequest);

        if (!validate.isEmpty()){
            return ResponseError.createFromValidation(validate).withStatusCode(422);
        }

        User user = new User();
        user.setName(userRequest.getName());
        user.setAge(userRequest.getAge());
        userRepository.persist(user);

        return Response.ok(user).status(Response.Status.CREATED).build();
    }

    @GET
    public Response listAllUsers(){
        PanacheQuery<User> all = userRepository.findAll();
        return Response.ok(all.list()).build();
    }

    @DELETE
    @Transactional
    @Path("{id}")
    public Response deleteById(@PathParam("id") Long id){
        PanacheEntityBase byId = userRepository.findById(id);
        if (byId != null){
            byId.delete();
            return Response.noContent().build();
        }

        return Response.ok().status(Response.Status.NOT_FOUND).build();
    }

    @PUT
    @Transactional
    @Path("{id}")
    public Response update(@PathParam("id") Long id, CreateUserRequestDTO userRequestDTO){
        User user = User.findById(id);
        if (user != null){
            user.setName(userRequestDTO.getName());
            user.setAge(userRequestDTO.getAge());
            return Response.ok(user).build();
        }
        return Response.ok().status(Response.Status.NOT_FOUND).build();
    }
}
