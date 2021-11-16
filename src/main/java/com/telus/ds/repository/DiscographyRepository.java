package com.telus.ds.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.telus.ds.entity.Discography;

@Repository
public interface DiscographyRepository extends JpaRepository<Discography, Integer> {
  Discography findByYear(String year);
}
