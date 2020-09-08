INSERT INTO trajectory (id, description, distance, trajectory_time)
VALUES (5, 'Biougra, Inzgan, Agadir', '120 km','2020-012-06T11:40:45.637+00:00' );
INSERT INTO trajectory (id, description, distance, trajectory_time)
VALUES (6, 'Belfaa, Irsmokn, Tiznit', '156 Km', '2020-10-06T11:40:45.637+00:00');
INSERT INTO trajectory (id, description, distance, trajectory_time)
VALUES (7, 'Kayi Obsi, Shavdar Obasi, Karajisar', '500 km', '2020-11-06T11:40:45.637+00:00');
INSERT INTO trajectory (id, description, distance, trajectory_time)
VALUES (8, 'Bouwassay, Botboqalt, sibt','70 km', '2020-09-29T11:40:45.637+00:00');
INSERT INTO trajectory (id, description, distance, trajectory_time)
VALUES (9, 'Bouwassay, sibt','70 km', '2020-06-29T11:40:45.637+00:00');

INSERT INTO trip_tourist (id, trip_name, description, trajectory_id)
VALUES (1, 'agadir', 'My first trip', 5);
INSERT INTO trip_tourist (id, trip_name, description, trajectory_id)
VALUES (2, 'Tznit', 'Ad ndwr hdar zin', 6);
INSERT INTO trip_tourist (id, trip_name, description, trajectory_id)
VALUES (3, 'To Turkey', 'Visit Artugal', 7);
INSERT INTO trip_tourist (id, trip_name, description, trajectory_id)
VALUES (4, 'To BouwassayTrip', 'Ad ndwr h Tmazirt', 8);

INSERT INTO trip_guide (id, trip_name, description, trajectory_id, price, trip_date)
VALUES (10, 'To BouwassayTrip', 'Ad ndwr h Tmazirt', 9, 299.99, '2020-09-29T11:40:45.637+00:00' );