package com.example.mountainclimbing.service;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.stereotype.Service;

import com.example.mountainclimbing.model.Album;
import com.example.mountainclimbing.repository.AlbumRepository;

@Service
public class AlbumService {

	private final AlbumRepository albumRepository;
	
	public AlbumService(AlbumRepository albumRepository) {
		this.albumRepository = albumRepository;
	}

	public Optional<Album> createAlbum(Album album) {
		return Optional.of(albumRepository.save(album));
	}

	public Optional<Album> readAlbum(int id) {
		return albumRepository.findById(id);
	}

	public boolean deleteAlbum(int id) {
		if(albumRepository.existsById(id)) {
			albumRepository.deleteById(id);
			return true;
		}
		return false;
	}

	public Optional<Album> updateAlbum(int id, @Valid Album album) {
		if(albumRepository.existsById(id)) {
			Album update = albumRepository.findById(id).get();
			return Optional.of(albumRepository.save(update));
		}
		return null;
	}

}
