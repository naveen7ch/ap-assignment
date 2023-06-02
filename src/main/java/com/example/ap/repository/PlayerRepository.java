package com.example.ap.repository;

import com.example.ap.Gender;
import com.example.ap.entity.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PlayerRepository extends JpaRepository<Player, Long> {
    /*
    select * from player where gender = ? and level = ? and age = ?
     */
    Optional<List<Player>> findByGenderAndLevelAndAge(Gender gender, Integer level, Integer age);

    @Query("select p from Player p where size(p.sports) = 0")
    public Optional<List<Player>> findByNoSports();
}
