CREATE TABLE IF NOT EXISTS `album` (

    `id` int(11) NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `name` varchar(20),
    `description` varchar(50),
    `creation_date` timestamp,
    `cover_id` int(11)

)ENGINE=InnoDB DEFAULT CHARSET=UTF8;