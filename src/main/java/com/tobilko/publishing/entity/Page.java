package com.tobilko.publishing.entity;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Page {

    @Id
    @GeneratedValue
    private Long id;

    @Embedded
    private PageConfiguration configuration;

}
