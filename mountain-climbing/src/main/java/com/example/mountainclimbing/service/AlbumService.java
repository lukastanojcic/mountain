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

	public Optional<AlbumDto> createAlbum(AlbumDto albumDto) {
		Album album = albumMapper.dtoToEntity(albumDto);
		return Optional.of(this.albumMapper.entityToDto(this.albumRepository.save(album)));
	}

	public Optional<AlbumDto> readAlbum(int id) {
		Album album = albumRepository.findById(id).get();
		return Optional.of(this.albumMapper.entityToDto(album));
	}

	public boolean deleteAlbum(int id) {
		if(albumRepository.existsById(id)) {
			albumRepository.deleteById(id);
			return true;
		}
		return false;
	}

	public Optional<AlbumDto> updateAlbum(int id, @Valid AlbumDto albumDto) {
		if(albumRepository.existsById(id)) {
			Album updated = albumRepository.save(this.albumMapper.dtoToEntity(albumDto));
			return Optional.of(this.albumMapper.entityToDto(updated));
		}
		return null;
	}

}
