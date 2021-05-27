package com.example.mountainclimbing.service;

import java.util.Optional;
import javax.validation.Valid;
import org.springframework.stereotype.Service;
import com.example.mountainclimbing.dto.AlbumDto;
import com.example.mountainclimbing.mapper.AlbumMapper;
import com.example.mountainclimbing.model.Album;
import com.example.mountainclimbing.repository.AlbumRepository;

@Service
public class AlbumService {

	private final AlbumRepository albumRepository;
	private final AlbumMapper albumMapper;
	
	public AlbumService(AlbumRepository albumRepository, AlbumMapper albumMapper) {
		this.albumRepository = albumRepository;
		this.albumMapper = albumMapper;
	}

	public Optional<AlbumDto> createAlbum(Album album) {
		final Optional<AlbumDto> aOptional = Optional.of(this.albumMapper.entityToDto(this.albumRepository.save(album)));
		return aOptional;
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
			return Optional.of(albumRepository.save(album));
		}
		return null;
	}

}
