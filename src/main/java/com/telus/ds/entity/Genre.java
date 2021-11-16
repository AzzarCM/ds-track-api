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
/**
 *
 * @author axel.hernandez02
 */

@Entity
@Getter
@Setter
@ToString
@Table(name = "GENRE")
public class Genre {
    public Genre() {}
	
	public Genre(Integer genre_id, String genre_name) {
		super();
		this.genreId = genre_id;
		this.genre_name = genre_name;
	}
        
        @Id
	@Column(name="GENRE_ID", updatable=false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer genreId;
	
	@Column(name="GENRE_NAME", updatable=false)
	@Length(max = 12, min = 12)
	@NotNull(message = "Genre Name is required")
	private String genre_name;
        
        @Column(name="CREATION_DATE", updatable=false)
	@NotNull(message = "CREATION DATE is required")
	private LocalDateTime creationDate;
}
