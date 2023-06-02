package com.example.ap.controller;

import com.example.ap.Gender;
import com.example.ap.entity.Player;
import com.example.ap.repository.PlayerRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/players")
public class PlayerController {
    private final PlayerRepository playerRepository;

    public PlayerController(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }

    @GetMapping
    public Optional<List<Player>> getPlayers(@RequestParam("gender") Gender gender, @RequestParam("level") Integer level, @RequestParam("age") Integer age) {
        return playerRepository.findByGenderAndLevelAndAge(gender, level, age);
    }



    @GetMapping("/ping")
    public String ping() {
        return "pong";
    }
}
