package com.tobilko.page.entity;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 *
 * Created by Andrew Tobilko on 20.02.17.
 *
 */
@Entity
public class Page {

    @Id
    @GeneratedValue
    private Long id;

    /**
     * An unique identifier, it's likely just an url.
     */
    @Column(unique = true)
    private String identifier;

    @Embedded
    private PageConfiguration configuration;


    public LocalDateTime lastEditingTime;

}
