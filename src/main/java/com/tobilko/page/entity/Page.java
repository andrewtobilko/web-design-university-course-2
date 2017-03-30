package com.tobilko.page.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.tobilko.common.criteria.SortCriteria;
import com.tobilko.common.criteria.type.Populatable;
import com.tobilko.common.criteria.type.Rated;
import com.tobilko.common.language.Language;
import com.tobilko.page.entity.localised.LocalisedPage;
import lombok.Data;
import lombok.Getter;

import javax.persistence.*;
import java.util.List;
import java.util.Map;

import static javax.persistence.CascadeType.PERSIST;
import static javax.persistence.CascadeType.REMOVE;

/**
 *
 * Created by Andrew Tobilko on 20.02.17.
 *
 */
@Data
@Entity
public class Page implements Rated, Populatable {

    @Id
    @GeneratedValue
    private Long id;

    @Column(unique = true)
    private String identifier;

    @OneToMany(cascade = {PERSIST, REMOVE}, fetch = FetchType.EAGER)
    private Map<Language, LocalisedPage> localisedPages;

    private int popularity;
    private int rating;

    /**
     * If a parent field is null, then the page considered a root.
     */
    @OneToOne
    private Page parent;

    @OneToMany(cascade = {PERSIST, REMOVE}, fetch = FetchType.EAGER)
    private List<Page> children;

    private SortCriteria criteria;

    @OneToOne(cascade = {PERSIST})
    private Page aliasFor;

    @JsonIgnore
    public boolean isContainerPage() {
        return children != null && children.size() > 0;
    }

    @JsonIgnore
    public boolean isAliasPage() {
        return aliasFor != null;
    }

    @Override
    public int getRating() {
        return rating;
    }
    @Override
    public void setRating(int value) {
        rating = value;
    }


    @Override
    public void setPopularity(int value) {
        popularity = value;
    }
    @Override
    public int getPopularity() {
        return popularity;
    }

}