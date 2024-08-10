package io.github.renansereia.quarkussocial.rest;

import io.github.renansereia.quarkussocial.domain.model.Post;
import io.github.renansereia.quarkussocial.domain.model.User;
import io.github.renansereia.quarkussocial.domain.repository.FollowerRepository;
import io.github.renansereia.quarkussocial.domain.repository.PostRepository;
import io.github.renansereia.quarkussocial.domain.repository.UserRepository;
import io.github.renansereia.quarkussocial.rest.dto.CreatePostRequestDTO;
import io.github.renansereia.quarkussocial.rest.dto.PostResponse;
import io.quarkus.panache.common.Sort;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Path("users/{userId}/posts")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class PostResource {

    private UserRepository userRepository;
    private PostRepository postRepository;
    private FollowerRepository followerRepository;

    @Inject
    public PostResource(UserRepository userRepository, PostRepository postRepository,FollowerRepository followerRepository) {
        this.userRepository = userRepository;
        this.postRepository = postRepository;
        this.followerRepository = followerRepository;
    }

    @POST
    @Transactional
    public Response savePost(@PathParam("userId") Long userId, CreatePostRequestDTO createPostRequestDTO) {
        User user = this.userRepository.findById(userId);

        if (user == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }

        Post post = Post.builder()
                .text(createPostRequestDTO.getMessage())
                .user(user)
                .build();

        postRepository.persist(post);

        return Response.status(Response.Status.CREATED).build();
    }

    @GET
    public Response listPost(
            @PathParam("userId") Long userId,
            @HeaderParam("followerId") Long followerId) {
        User user = this.userRepository.findById(userId);
        if (user == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }

        if (followerId == null){
            return Response.status(Response.Status.BAD_REQUEST).entity("No headers present").build();
        }

        User follow = this.userRepository.findById(followerId);
        if (follow == null){
            return Response.status(Response.Status.NOT_FOUND).entity("No follow found").build();
        }

        boolean follows = followerRepository.follows(follow, user);
        if (!follows){
            return Response.status(Response.Status.FORBIDDEN).entity("You can't see these post").build();
        }

        var query = postRepository.find("user", Sort.by("dateTime", Sort.Direction.Descending), user);
        List<Post> list = query.list();

        List<PostResponse> collect = list.stream().map(PostResponse::fromEntity).collect(Collectors.toList());

        return Response.ok().entity(collect).build();
    }


}
