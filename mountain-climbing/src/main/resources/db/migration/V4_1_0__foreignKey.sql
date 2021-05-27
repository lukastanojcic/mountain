ALTER TABLE image
ADD FOREIGN KEY (album_id) REFERENCES album(id);