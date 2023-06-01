package com.example.ap.entity;

import com.example.ap.Gender;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;


@Entity
@Table(name = "players")
@Getter
@Setter
public class Player {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 150)
    @NotNull
    @Size(max = 150)
    @Email
    private String email;

    @Column(nullable = false)
    @NotNull
    @Min(1)
    @Max(10)
    private Integer level;

    @Column(nullable = false)
    @Min(1)
    private Integer age;

    @Enumerated(EnumType.STRING)
    @NotNull
    private Gender gender;

    @ManyToMany
    @JoinTable(
            name = "player_sports",
            joinColumns = @JoinColumn(name = "player_id"),
            inverseJoinColumns = @JoinColumn(name = "sports_id"))
    Set<Sports> sports;
}
