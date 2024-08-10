package io.github.renansereia.quarkussocial.rest.dto;

import lombok.Data;

import java.util.List;

@Data
public class FollowersPerUserResponse {
    private Long followersCount;
    private List<FollowerResponse> content;
}
