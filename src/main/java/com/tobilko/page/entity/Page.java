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

    /**
     * If a parent field is null, then the page considered a root.
     */
    @OneToOne
    private Page parent;

    /**
     * If that field is not null, then it is a container page.
     */
    @Embedded
    private PageChildren children;

}
