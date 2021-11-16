package com.telus.ds.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Getter
@Setter
@ToString
public class Artist {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String phone;
    private Integer age;

    public Artist() {
    }

    public Artist(Integer id, String name, String phone, Integer age) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.age = age;
    }
}
