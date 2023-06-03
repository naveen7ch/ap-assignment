package com.example.ap.repository;

import com.example.ap.ApAssignmentApplication;
import com.example.ap.entity.Gender;
import com.example.ap.entity.Player;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.jdbc.Sql;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.springframework.test.context.jdbc.Sql.ExecutionPhase.AFTER_TEST_METHOD;
import static org.springframework.test.context.jdbc.Sql.ExecutionPhase.BEFORE_TEST_METHOD;

@SpringBootTest(classes = ApAssignmentApplication.class)
@Sql(scripts = "/init-data.sql", executionPhase = BEFORE_TEST_METHOD)
@Sql(scripts = "/cleanup-data.sql", executionPhase = AFTER_TEST_METHOD)
public class PlayerRepositoryTest {
    @Autowired
    private PlayerRepository playerRepository;

    @Test
    public void findByGenderAndLevelAndAgeTest() {
        List<Player> players = playerRepository.findByGenderAndLevelAndAge(Gender.Female, 7, 32)
                .orElse(null);
        assertNotNull(players);
        assertEquals(1, players.size());
        Player player = players.get(0);
        assertEquals(32, player.getAge());
        assertEquals("jane@test.com", player.getEmail());
        assertEquals(Gender.Female, player.getGender());
    }

    @Test
    public void findByNoSportsTest() {
        List<Player> players = playerRepository.findByNoSports()
                .orElse(null);
        assertNotNull(players);
        assertEquals(2, players.size());
    }

    @Test
    public void findBySports_IdTest() {
        List<Player> players = playerRepository.findBySports_Id(1l, Pageable.ofSize(2))
                .orElse(null);
        assertNotNull(players);
        assertEquals(2, players.size());
    }
}
