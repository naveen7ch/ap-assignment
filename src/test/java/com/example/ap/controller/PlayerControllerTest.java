package com.example.ap.controller;

import com.example.ap.entity.Player;
import com.example.ap.entity.Sports;
import com.example.ap.repository.PlayerRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.transaction.annotation.Transactional;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.springframework.test.context.jdbc.Sql.ExecutionPhase.AFTER_TEST_METHOD;
import static org.springframework.test.context.jdbc.Sql.ExecutionPhase.BEFORE_TEST_METHOD;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@Sql(scripts = "/init-data.sql", executionPhase = BEFORE_TEST_METHOD)
@Sql(scripts = "/cleanup-data.sql", executionPhase = AFTER_TEST_METHOD)
public class PlayerControllerTest {
    @Value(value="${local.server.port}")
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    private PlayerRepository playerRepository;

    @Test
    public void getPlayersWithNoSportsTest() {
        ResponseEntity<List> responseEntity = restTemplate.getRestTemplate().getForEntity("http://localhost:" + port + "/api/players/no-sports",
                List.class);
        assertEquals(HttpStatusCode.valueOf(200), responseEntity.getStatusCode());
        assertTrue( responseEntity.hasBody());
        assertEquals(2, responseEntity.getBody().size());
    }


    @Test
    @Transactional
    public void updatePlayerSports() {
        restTemplate.getRestTemplate().put("http://localhost:" + port + "/api/players/4/sports",
                Set.of(2, 1));
        assertTrue(true);
    }
}
