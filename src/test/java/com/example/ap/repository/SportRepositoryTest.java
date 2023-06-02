package com.example.ap.repository;

import com.example.ap.ApAssignmentApplication;
import com.example.ap.entity.Sports;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;

import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.context.jdbc.Sql.ExecutionPhase.AFTER_TEST_METHOD;
import static org.springframework.test.context.jdbc.Sql.ExecutionPhase.BEFORE_TEST_METHOD;

@SpringBootTest(classes = ApAssignmentApplication.class)
@Sql(scripts = "/init-data.sql", executionPhase = BEFORE_TEST_METHOD)
@Sql(scripts = "/cleanup-data.sql", executionPhase = AFTER_TEST_METHOD)
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
