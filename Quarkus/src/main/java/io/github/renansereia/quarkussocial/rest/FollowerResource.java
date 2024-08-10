package io.github.renansereia.quarkussocial.rest;

import io.github.renansereia.quarkussocial.domain.model.Followers;
import io.github.renansereia.quarkussocial.domain.model.User;
import io.github.renansereia.quarkussocial.domain.repository.FollowerRepository;
import io.github.renansereia.quarkussocial.domain.repository.UserRepository;
import io.github.renansereia.quarkussocial.rest.dto.CreateFollowerRequest;
import io.github.renansereia.quarkussocial.rest.dto.FollowerResponse;
import io.github.renansereia.quarkussocial.rest.dto.FollowersPerUserResponse;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.Comparator;
import java.util.List;

@Path("/users/{userId}/follwers")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class FollowerResource {

    private FollowerRepository followerRepository;
    private UserRepository userRepository;

    public FollowerResource(FollowerRepository repository, UserRepository userRepository){
        this.followerRepository = repository;
        this.userRepository = userRepository;
    }


    @PUT
    @Transactional
    public Response followUser(@PathParam("userId")Long userId, CreateFollowerRequest followerRequest){

        if (userId.equals(followerRequest.getId())){
            return Response.status(Response.Status.CONFLICT).entity("You can't follow yourself").build();
        }

        User byId = this.userRepository.findById(userId);
        if (userId == null){
            return Response.status(Response.Status.NOT_FOUND).build();
        }

        var follower = this.userRepository.findById(followerRequest.getId());

        if (!followerRepository.follows(byId,follower)){
            var entity = new Followers();
            entity.setUser(byId);
            entity.setFollower(follower);
            followerRepository.persist(entity);
        }

        return Response.status(Response.Status.NO_CONTENT).build();
    }

    @GET
    public Response listFollower(@PathParam("userId")Long userId){
        User byId = userRepository.findById(userId);
        if (byId == null){
            return Response.status(Response.Status.NOT_FOUND).build();
        }

        List<Followers> list = followerRepository.findByUser(userId);

        FollowersPerUserResponse followers = new FollowersPerUserResponse();
        followers.setFollowersCount((long) list.size());
        followers.setContent(list.stream().map(FollowerResponse::new).sorted().toList());

        return Response.ok().entity(followers).build();

    }

    @DELETE
    @Transactional
    public Response unfollow(@PathParam("userId")Long userId,
                             @QueryParam("followerId") Long followerId) {
        User byId = userRepository.findById(userId);
        if (byId == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }

        this.followerRepository.deleteByFollowerAndUser(followerId,byId.getId());
        return Response.status(Response.Status.NO_CONTENT).build();
    }
}
