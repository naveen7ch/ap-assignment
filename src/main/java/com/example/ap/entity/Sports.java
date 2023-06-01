package com.example.ap.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Entity
@Table(name = "sports")
@Getter
@Setter
public class Sports {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, length = 150)
    @NotNull
    @Size(max = 150)
    private String name;
    @ManyToMany(mappedBy = "sports")
    @JsonIgnoreProperties("sports")
    Set<Player> players;

}