package com.tobilko.publishing.entity;

import org.springframework.data.annotation.Id;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;

@Entity
public class Page {

    @Id
    @GeneratedValue
    private Long id;

    @Embedded
    private PageConfiguration configuration;

}
