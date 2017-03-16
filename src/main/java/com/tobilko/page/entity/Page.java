package com.tobilko.page.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.tobilko.common.Language;
import com.tobilko.page.entity.localised.LocalisedPage;
import lombok.Data;

import javax.persistence.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;

import static javax.persistence.CascadeType.PERSIST;
import static javax.persistence.CascadeType.REMOVE;

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

    @Column(unique = true)
    private String identifier;

    @OneToMany(cascade = {PERSIST, REMOVE}, fetch = FetchType.EAGER)
    private Map<Language, LocalisedPage> localisedPages;

    /**
     * If a parent field is null, then the page considered a root.
     */
    @OneToOne
    private Page parent;

    /**
     * If that field is not null, then it is a container page.
     */
    @OneToMany(cascade = {PERSIST, REMOVE}, fetch = FetchType.EAGER)
    private List<Page> children;

    public Page() {
        children = new CopyOnWriteArrayList<>();
        localisedPages = new HashMap<>();
    }

    @JsonIgnore
    public boolean isContainerPage() {
        return children != null && children.size() > 0;
    }

}