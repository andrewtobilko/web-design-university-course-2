package com.tobilko.publishing.entity;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity
public class Page {

    @Id
    @GeneratedValue
    private Long id;

    private 

    @Embedded
    private PageConfiguration configuration;


    public LocalDateTime lastEditingTime;

}
