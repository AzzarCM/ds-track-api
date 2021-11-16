
package com.telus.ds.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.telus.ds.entity.Genre;

@Repository
public interface GenreRepository extends JpaRepository<Genre, Integer>{
    
    Genre findGenreByGenreId(Integer genre_id);
}
