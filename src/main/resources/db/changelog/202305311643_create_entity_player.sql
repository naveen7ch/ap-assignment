CREATE TABLE players (
    ID IDENTITY NOT NULL PRIMARY KEY ,
    email varchar(150) NOT NULL,
    level int NOT NULL,
    age int NOT NULL,
    gender varchar(6) NOT NULL,
    CONSTRAINT chk_level CHECK (level>=1 AND level <= 10),
    CONSTRAINT chk_gender CHECK (gender='Male' OR gender = 'Female')
);