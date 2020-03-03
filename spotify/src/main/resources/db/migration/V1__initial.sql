create TABLE users (
id INT AUTO_INCREMENT PRIMARY KEY,
first_name VARCHAR(255) NOT NULL,
last_name VARCHAR(255) NOT NULL,
email VARCHAR(255) NOT NULL,
birth_date DATE,
paid BOOLEAN
);

create TABLE artists (
id INT AUTO_INCREMENT PRIMARY KEY,
first_name VARCHAR(255) NOT NULL,
last_name VARCHAR(255) NOT NULL,
birth_date DATE,
genre VARCHAR(255)
);

create TABLE songs (
id INT AUTO_INCREMENT PRIMARY KEY,
`name` VARCHAR(255) NOT NULL,
release_date DATE NOT NULL,
seconds_length INT NOT NULL,
artist_id INT NOT NULL,
FOREIGN KEY (artist_id) REFERENCES artists(id));