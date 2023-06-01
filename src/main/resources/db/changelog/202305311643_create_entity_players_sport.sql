CREATE TABLE player_sports (
    player_id int NOT NULL,
    sports_id int NOT NULL,
    CONSTRAINT FK_PLAYER FOREIGN KEY (player_id) REFERENCES players (id),
    CONSTRAINT FK_SPORTS FOREIGN KEY (sports_id) REFERENCES sports (id),
    PRIMARY KEY(player_id, sports_id)
);