package com.example.ap.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "player_sports")
@IdClass(PlayerSportsId.class)
public class PlayerSports {
    @Id
    @Column(name = "player_id")
    private Long playerId;
    @Id
    @Column(name = "sports_id")
    private Long sportsId;

    public Long getPlayerId() {
        return playerId;
    }

    public void setPlayerId(Long playerId) {
        this.playerId = playerId;
    }

    public Long getSportsId() {
        return sportsId;
    }

    public void setSportsId(Long sportsId) {
        this.sportsId = sportsId;
    }
}
