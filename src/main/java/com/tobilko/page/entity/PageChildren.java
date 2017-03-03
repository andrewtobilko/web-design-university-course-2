package com.tobilko.page.entity;

import javax.persistence.Embeddable;
import javax.persistence.OneToMany;
import java.util.List;

/**
 *
 * Created by Andrew Tobilko on 02.03.17.
 *
 */
@Embeddable
public class PageChildren {

    @OneToMany
    private List<Page> children;

    /**
     * Defines how children should be obtained from the database.
     */
    private SortCriterion criterion;

    public boolean hasChildren() {
        return !(children == null || children.isEmpty());
    }

}
