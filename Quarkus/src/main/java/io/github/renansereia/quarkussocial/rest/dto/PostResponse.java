package io.github.renansereia.quarkussocial.rest.dto;

import io.github.renansereia.quarkussocial.domain.model.Post;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class PostResponse {

    private String message;
    private LocalDateTime dateTime;

    public static PostResponse fromEntity(Post post){
        var postResponse = new PostResponse();
        postResponse.setMessage(post.getText());
        postResponse.setDateTime(post.getDateTime());
        return postResponse;
    }
}
