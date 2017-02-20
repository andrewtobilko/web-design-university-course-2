package com.tobilko.page.entity;

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

    @Embedded
    private PageConfiguration configuration;


    public LocalDateTime lastEditingTime;

}
