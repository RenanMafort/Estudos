package io.github.renansereia.quarkussocial.rest.dto;

import io.github.renansereia.quarkussocial.domain.model.Followers;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode
public class FollowerResponse implements Comparable<FollowerResponse> {
    private Long id;
    private String name;


    public FollowerResponse(Followers followers){
        this(followers.getFollower().getId(),followers.getFollower().getName());
    }

    public FollowerResponse(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public FollowerResponse() {
    }

    @Override
    public int compareTo(FollowerResponse o) {
        return this.getId().compareTo(o.getId());
    }
}
