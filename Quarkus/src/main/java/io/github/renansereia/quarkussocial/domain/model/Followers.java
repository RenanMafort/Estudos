package io.github.renansereia.quarkussocial.domain.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Comparator;

@Entity
@Table(name = "followers")
@Data
public class Followers {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "follower_id")
    private User follower;

}
