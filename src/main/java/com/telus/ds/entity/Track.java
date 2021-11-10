package com.telus.ds.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "TRACKS")
public class Track {
	
	public Track() {}
	
	public Track(String isrc, Integer duration) {
		super();
		this.isrc = isrc;
		this.duration = duration;
		this.creationDate = LocalDateTime.now();
	}
	
	@Id
	@Column(name="TRACK_ID", updatable=false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)//review
	private Long id;
	
	@Column(name="ISRC", updatable=false)
	private String isrc;
	
	@Column(name="DURATION", updatable=false)
	private Integer duration;
	
	@Column(name="CREATION_DATE", updatable=false)
	private LocalDateTime creationDate;
}
