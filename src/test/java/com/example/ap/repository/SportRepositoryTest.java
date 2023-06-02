package com.example.ap.repository;

import com.example.ap.ApAssignmentApplication;
import com.example.ap.entity.Sports;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(classes = ApAssignmentApplication.class)
public class SportRepositoryTest {
    @Autowired
    private SportsRepository sportsRepository;


    @Test
    public void findByPlayersMoreThan1Test() {
        List<Sports> sportsList = sportsRepository.findByPlayersMoreThan1().orElseThrow(() -> new RuntimeException());
        System.out.println(sportsList.stream().map(s -> s.getName()).collect(Collectors.toList()));
        assertNotNull(sportsList);
        assertEquals(2, sportsList.size());
        List<String> sportsNames = sportsList.stream().map(s -> s.getName()).collect(Collectors.toList());
        assertTrue(sportsNames.contains("tennis"));
        assertTrue(sportsNames.contains("boxing"));
    }

    @Test
    public void findByNoPlayersTest() {
        List<Sports> sportsList = sportsRepository.findByNoPlayers().orElseThrow(() -> new RuntimeException());
        assertNotNull(sportsList);
        assertEquals(2, sportsList.size());
        List<String> sportsNames = sportsList.stream().map(s -> s.getName()).collect(Collectors.toList());
        assertTrue(sportsNames.contains("badminton"));
        assertTrue(sportsNames.contains("hockey"));
    }
}
