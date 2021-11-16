package com.telus.ds.controller;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.telus.ds.entity.Track;
import com.telus.ds.entity.dto.TrackDTO;
import com.telus.ds.exception.ResourceNotFoundException;
import com.telus.ds.service.TrackService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/track")
public class TrackController {
	
	@Autowired
	TrackService trackService;
	
	 @Autowired
	 private ModelMapper modelMapper;
	 
	@GetMapping("/getTrack")
	public TrackDTO getTrack(@RequestParam("isrc") String isrc) {
		
		Track trackFound = trackService.getTrack(isrc);
		
		if (trackFound == null) {
			throw new ResourceNotFoundException("Track not found in DS repository with ISRC=" + isrc);
		}
		
		return convertToDTO(trackFound);
	}
	
	@GetMapping("/getTracks")
	public List<Track> getTracks() {
		return trackService.getTracks();
	}
	

	
	@PostMapping("/")
	public Track create(@RequestBody Track track) {
		log.info("Creating a track");
		return trackService.create(track);
	}
	
	private TrackDTO convertToDTO(Track track) {
		return modelMapper.map(track, TrackDTO.class);
	}
	
	@SuppressWarnings("unused")
	private Track convertToEntity(TrackDTO trackDTO) {
		return modelMapper.map(trackDTO, Track.class);
	}

}
