insert into players (id, email, level, age, gender)
values
(1, 'john@test.com', 4, 24, 'Male'),
(2, 'jane@test.com', 7, 32, 'Female'),
(3, 'ramesh@test.com', 8, 22, 'Male'),
(4, 'swathi@test.com', 6, 27, 'Female');

insert into sports (id, name)
values
(1, 'tennis'),
(2, 'cricket'),
(3, 'football'),
(4, 'boxing'),
(5, 'badminton'),
(6, 'hockey');

insert into player_sports (player_id, sports_id)
values
(1, 1),
(1, 4),
(1, 3),
(2, 1),
(3, 2),
(4, 4);