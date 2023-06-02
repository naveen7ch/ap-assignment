package com.example.ap.entity;

import jakarta.persistence.*;
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
    private String name;
    @ManyToMany(mappedBy = "sports", fetch = FetchType.LAZY)
    Set<Player> players;

}
