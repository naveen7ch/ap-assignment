package com.example.ap.repository;

import com.example.ap.entity.Sports;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface SportsRepository extends JpaRepository<Sports, Long> {
    @Query("select s from Sports s where size(s.players) >= 2")
    public Optional<List<Sports>> findByPlayersMoreThan1();

    @Query("select s from Sports s where size(s.players) = 0")
    public Optional<List<Sports>> findByNoPlayers();

    public Optional<List<Sports>> findByNameIn(List<String> names);
}
