package com.example.ap.controller;

import com.example.ap.Gender;
import com.example.ap.entity.Player;
import com.example.ap.entity.Sports;
import com.example.ap.repository.SportsRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/sports")
public class SportsController {
    private final SportsRepository sportsRepository;

    public SportsController(SportsRepository sportsRepository) {
        this.sportsRepository = sportsRepository;
    }

    @GetMapping("/with-players-more-than-1")
    public Optional<List<Sports>> getPlayersMoreThan1() {
        return sportsRepository.findByPlayersMoreThan1();
    }
}
