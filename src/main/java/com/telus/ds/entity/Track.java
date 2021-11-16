package com.telus.ds.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@ToString
@Table(name = "TRACKS")
public class Track {
	
	public Track() {}
	
	public Track(String isrc, Integer duration) {
		super();
		this.isrc = isrc;
		this.duration = duration;
	}
	
	@Id
	@Column(name="TRACK_ID", updatable=false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name="ISRC", updatable=false)
	@Length(max = 12, min = 12)
	@NotNull(message = "ISRC is required")
	private String isrc;
	
	@Column(name="DURATION", updatable=false)
	@NotNull(message = "DURATION is required")
	private Integer duration;
	
	@Column(name="CREATION_DATE", updatable=false)
	@NotNull(message = "CREATION DATE is required")
	private LocalDateTime creationDate;
}
