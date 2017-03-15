package com.tobilko.page.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

import static com.tobilko.utils.ModelViewConstant.MODEL.CONTAINER;

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

    @OneToMany(mappedBy = CONTAINER)
    private Set<LocalisedPage> localisedPages;

    /**
     * If a parent field is null, then the page considered a root.
     */
    @OneToOne
    private Page parent;

    /**
     * If that field is not null, then it is a container page.
     */
    @OneToMany
    private Set<Page> children;


    public Page() {
        children = new CopyOnWriteArraySet<>();
    }

    public boolean isContainerPage() {
        return children != null && children.size() > 0;
    }

}
