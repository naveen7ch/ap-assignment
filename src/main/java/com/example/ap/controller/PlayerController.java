package com.example.ap.controller;

import com.example.ap.dto.PlayerDto;
import com.example.ap.entity.Player;
import com.example.ap.entity.Sports;
import com.example.ap.mapper.PlayerMapper;
import com.example.ap.mapper.SportsMapper;
import com.example.ap.repository.PlayerRepository;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/players")
public class PlayerController {
    private final PlayerRepository playerRepository;

    private final PlayerMapper playerMapper;

    private final SportsMapper sportsMapper;

    public PlayerController(PlayerRepository playerRepository, PlayerMapper playerMapper, SportsMapper sportsMapper) {
        this.playerRepository = playerRepository;
        this.playerMapper = playerMapper;
        this.sportsMapper = sportsMapper;
    }

    @GetMapping("/no-sports")
    public ResponseEntity<List<PlayerDto>> playersWithNoSports() {
        List<Player> players = playerRepository.findByNoSports().orElseThrow();
        return ResponseEntity.ok(playerMapper.toDto(players));
    }

    @PutMapping("/{playerId}/sports")
    public ResponseEntity<Void> updatePlayerSports(@PathVariable Long playerId, @RequestBody Set<Long> sportsIds) {
        Player player = playerRepository.findById(playerId).orElseThrow();
        player.setSports(sportsIds.stream().map(id -> {
            Sports s = new Sports();
            s.setId(id);
            return s;
        }).collect(Collectors.toList()));
        playerRepository.save(player);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity<List<PlayerDto>> players(@RequestParam("sportsId") Long sportsId, Pageable pageable) {
       List<Player> players = playerRepository.findBySports_Id(sportsId, pageable).orElseThrow();
       return ResponseEntity.ok(playerMapper.toDto(players));
    }
}
