package com.example.ap.controller;

import com.example.ap.dto.SportsDto;
import com.example.ap.entity.Sports;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.jdbc.Sql;

import java.util.LinkedHashMap;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.springframework.test.context.jdbc.Sql.ExecutionPhase.AFTER_TEST_METHOD;
import static org.springframework.test.context.jdbc.Sql.ExecutionPhase.BEFORE_TEST_METHOD;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@Sql(scripts = "/init-data.sql", executionPhase = BEFORE_TEST_METHOD)
@Sql(scripts = "/cleanup-data.sql", executionPhase = AFTER_TEST_METHOD)
public class SportsControllerTest {
    @Value(value="${local.server.port}")
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void getByNamesTest() {
        ResponseEntity<List> responseEntity = restTemplate.getRestTemplate().getForEntity("http://localhost:" + port + "/api/sports?names=tennis",
                List.class);
        assertEquals(HttpStatusCode.valueOf(200), responseEntity.getStatusCode());
        assertTrue( responseEntity.hasBody());
        List sportsBody = responseEntity.getBody();
        LinkedHashMap sports = (LinkedHashMap) (sportsBody.get(0));
        List players = (List) sports.get("players");
        assertEquals(2, players.size());
    }

    @Test
    public void deleteSportsTest() {
        restTemplate.getRestTemplate().delete("http://localhost:" + port + "/api/sports/4");
        assertTrue(true);
    }
}
