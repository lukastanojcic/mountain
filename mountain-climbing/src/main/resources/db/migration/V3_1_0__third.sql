

DROP TABLE IF EXISTS images;
DROP TABLE IF EXISTS album;

CREATE TABLE IF NOT EXISTS `images` (

    `id` int NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `name` varchar(20),
    `size` int(11),
    `content_type` varchar(256),
    `insert_date` datetime
)ENGINE=InnoDB DEFAULT CHARSET=UTF8;

CREATE TABLE IF NOT EXISTS `album` (
    `id` int(11) NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `name` varchar(20),
    `description` varchar(50),
    `creation_date` timestamp,
    `cover_id` int(11)

)ENGINE=InnoDB DEFAULT CHARSET=UTF8;

ALTER TABLE images ADD album_id int(11);