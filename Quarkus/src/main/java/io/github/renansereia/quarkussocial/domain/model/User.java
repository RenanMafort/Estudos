package io.github.renansereia.quarkussocial.domain.model;

import jakarta.persistence.*;
import io.quarkus.hibernate.orm.panache.*;
import lombok.Data;

import java.util.Objects;

@Entity
@Table(name = "users")
@Data
public class User extends PanacheEntityBase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "age")

    private Integer age;

}
