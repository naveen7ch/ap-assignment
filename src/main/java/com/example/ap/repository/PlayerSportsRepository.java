package com.example.ap.repository;

import com.example.ap.entity.PlayerSports;
import com.example.ap.entity.PlayerSportsId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface PlayerSportsRepository extends JpaRepository<PlayerSports, PlayerSportsId> {
    @Query("delete from PlayerSports where sportsId = :sportsId")
    @Modifying
    void deleteBySportsId(Long sportsId);
}
