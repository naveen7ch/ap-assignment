package com.example.ap.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.util.Set;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.springframework.test.context.jdbc.Sql.ExecutionPhase.AFTER_TEST_METHOD;
import static org.springframework.test.context.jdbc.Sql.ExecutionPhase.BEFORE_TEST_METHOD;

@SpringBootTest
@Sql(scripts = "/init-data.sql", executionPhase = BEFORE_TEST_METHOD)
@Sql(scripts = "/cleanup-data.sql", executionPhase = AFTER_TEST_METHOD)
public class PlayerSportsRepositoryTest {
    @Autowired
    private PlayerSportsRepository playerSportsRepository;
    @Test
    @Transactional
    public void deleteBySportsIdTest() {
        Set<Long> sportsIds = playerSportsRepository.findAll().stream().map(ps -> ps.getSportsId()).filter(ps -> ps == 1l).collect(Collectors.toSet());
        assertTrue(sportsIds.contains(1l));
        playerSportsRepository.deleteBySportsId(1l);
        sportsIds = playerSportsRepository.findAll().stream().map(ps -> ps.getSportsId()).filter(ps -> ps == 1l).collect(Collectors.toSet());
        assertTrue(CollectionUtils.isEmpty(sportsIds));
    }
}
