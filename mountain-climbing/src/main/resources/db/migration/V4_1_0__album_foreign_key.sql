ALTER TABLE images
ADD CONSTRAINT FK_images FOREIGN KEY (album_id) REFERENCES albums(id);