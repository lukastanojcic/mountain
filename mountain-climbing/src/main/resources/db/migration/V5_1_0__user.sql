CREATE TABLE IF NOT EXISTS `user` (
    `id` int(11) NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `create_date` datetime DEFAULT CURRENT_TIMESTAMP, 
    `username` varchar(150),
    `password` varchar(100),
    `email` varchar(100),
    `name` varchar(256),
    `surname` varchar(256),
    `gender` int(11),
    `birthdate` date,
    `address` varchar(256),
    `city` varchar(256),
    `postal_code` int(11),
    `picture_url` varchar(256)
)ENGINE=InnoDB DEFAULT CHARSET=UTF8;