package com.example.ap.repository;

import com.example.ap.ApAssignmentApplication;
import com.example.ap.Gender;
import com.example.ap.entity.Player;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest(classes = ApAssignmentApplication.class)
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
}
