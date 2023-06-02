package com.example.ap.dto;

import com.example.ap.entity.Player;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Set;

@Getter
@Setter
public class SportsDto implements Serializable {
    private Long id;
    @NotNull
    @Size(max = 150)
    private String name;
    private Set<Player> players;
}
