package com.telus.ds.entity.dto;

import java.time.LocalDateTime;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class GenreDTO {
    
    private Integer genre_name;
    private LocalDateTime creationDate;
}
