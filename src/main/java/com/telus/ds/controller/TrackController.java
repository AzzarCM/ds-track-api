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
import com.telus.ds.service.TrackService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/track/")
public class TrackController {
	
	@Autowired
	private TrackService trackService;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@GetMapping("/")
	public List<Track> getTracks() {
		return trackService.getTracks();
	}
	
	@GetMapping("/getTrack")
	public TrackDTO getTrack(@RequestParam("isrc") String isrc) {
		Track track = trackService.getTrack(isrc);
		
		//TrackDTO trackDTO = new TrackDTO(track.getIsrc(), track.getDuration(), track.getCreationDate());
		
		//return trackDTO;
		return convertToDTO(track);
	}
	
	@PostMapping("/")
	public Track create(@RequestBody Track track) {
		log.info("Creating a track");
		return trackService.create(track);
	}
	
	private TrackDTO convertToDTO(Track track) {
		return modelMapper.map(track, TrackDTO.class);
	}
	
	private Track convertToEntity(TrackDTO trackDTO) {
		return modelMapper.map(trackDTO, Track.class);
	}

}
