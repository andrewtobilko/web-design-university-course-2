package com.tobilko.page.entity;

import lombok.Data;

import javax.persistence.*;

/**
 *
 * Created by Andrew Tobilko on 20.02.17.
 *
 */
@Data
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

    private String title;

}
