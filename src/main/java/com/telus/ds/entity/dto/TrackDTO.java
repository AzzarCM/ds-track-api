package com.telus.ds.entity.dto;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class TrackDTO {
	
	/* review
	public TrackDTO(String isrc, Integer duration, LocalDateTime creationDate) {
		super();
		this.isrc = isrc;
		this.duration = duration;
		this.creationDate = creationDate;
	}*/
	
	private String isrc;
	private Integer duration;
	private LocalDateTime creationDate;
}
