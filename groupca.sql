"CREATE TABLE Weather (
    Day DATE PRIMARY KEY,
    Value ENUM('Sunny', 'Rainy', 'Cloudy') NOT NULL,
    Temp DECIMAL(5,2) NOT NULL,
    WindSpeed DECIMAL(5,2) NOT NULL,
    Humidity INT NOT NULL
);

INSERT INTO Weather (Day, Value, Temp, WindSpeed, Humidity) VALUES
('2024-04-14', 'Sunny', 25.5, 15.2, 30),
('2024-04-15', 'Rainy', 16.0, 5.5, 85),
('2024-04-16', 'Cloudy', 20.0, 10.0, 60);

CREATE TABLE Room (
    RoomNumber INT PRIMARY KEY,
    Available BOOLEAN NOT NULL,
    Location VARCHAR(100),
    Capacity INT,
    OccupiedSeat INT
);

INSERT INTO Room (RoomNumber, Available, Location, Capacity, OccupiedSeat) VALUES
(101, TRUE, 'First Floor', 30, 10),
(102, FALSE, 'Second Floor', 25, 25),
(103, TRUE, 'Third Floor', 50, 20);

CREATE TABLE Event (
    EventName VARCHAR(255),
    Date DATE,
    Time TIME,
    PRIMARY KEY (EventName, Date, Time)
);

INSERT INTO Event (EventName, Date, Time) VALUES
('Conference', '2024-05-20', '09:00:00'),
('Workshop', '2024-05-21', '14:00:00'),
('Meetup', '2024-06-01', '18:00:00');
"