package com.example.ap.entity;

import java.io.Serializable;
import java.util.Objects;

public class PlayerSportsId implements Serializable {
    private Long playerId;
    private Long sportsId;

    public PlayerSportsId() {
    }

    public PlayerSportsId(Long playerId, Long sportsId) {
        this.playerId = playerId;
        this.sportsId = sportsId;
    }

    public Long getPlayerId() {
        return playerId;
    }

    public Long getSportsId() {
        return sportsId;
    }

    public void setPlayerId(Long playerId) {
        this.playerId = playerId;
    }

    public void setSportsId(Long sportsId) {
        this.sportsId = sportsId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PlayerSportsId that = (PlayerSportsId) o;
        return playerId.equals(that.playerId) && sportsId.equals(that.sportsId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(playerId, sportsId);
    }
}
