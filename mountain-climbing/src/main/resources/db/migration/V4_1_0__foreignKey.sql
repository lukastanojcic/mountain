ALTER TABLE images
ADD FOREIGN KEY (album_id) REFERENCES album(id);