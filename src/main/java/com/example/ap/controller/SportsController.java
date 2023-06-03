package com.example.ap.controller;

import com.example.ap.dto.SportsDto;
import com.example.ap.entity.Sports;
import com.example.ap.mapper.SportsMapper;
import com.example.ap.repository.PlayerSportsRepository;
import com.example.ap.repository.SportsRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/sports")
public class SportsController {
    private final SportsRepository sportsRepository;
    private final SportsMapper sportsMapper;
    private final PlayerSportsRepository playerSportsRepository;

    public SportsController(SportsRepository sportsRepository, SportsMapper sportsMapper, PlayerSportsRepository playerSportsRepository) {
        this.sportsRepository = sportsRepository;
        this.sportsMapper = sportsMapper;
        this.playerSportsRepository = playerSportsRepository;
    }

    @GetMapping
    public ResponseEntity<List<SportsDto>> getByNames(@RequestParam List<String> names) {
        List<Sports> sports = sportsRepository.findByNameIn(names).orElseThrow();
        return ResponseEntity.ok(sportsMapper.toDto(sports));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<Void> deleteSports(@PathVariable Long id) {
        sportsRepository.findById(id).orElseThrow();
        playerSportsRepository.deleteBySportsId(id);
        sportsRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }

}
