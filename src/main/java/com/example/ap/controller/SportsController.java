package com.example.ap.controller;

import com.example.ap.dto.SportsDto;
import com.example.ap.entity.Sports;
import com.example.ap.mapper.PlayerMapper;
import com.example.ap.mapper.SportsMapper;
import com.example.ap.repository.SportsRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/sports")
public class SportsController {
    private final SportsRepository sportsRepository;
    private final SportsMapper sportsMapper;

    public SportsController(SportsRepository sportsRepository, SportsMapper sportsMapper) {
        this.sportsRepository = sportsRepository;
        this.sportsMapper = sportsMapper;
    }

    @GetMapping
    public ResponseEntity<List<SportsDto>> getByNames(@RequestParam List<String> names) {
        List<Sports> sports = sportsRepository.findByNameIn(names).orElseThrow();
        return ResponseEntity.ok(sportsMapper.toDto(sports));
    }

}
