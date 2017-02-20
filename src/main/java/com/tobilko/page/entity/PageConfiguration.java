package com.tobilko.page.entity;

import lombok.Data;

import javax.persistence.Embeddable;

/**
 *
 * Created by Andrew Tobilko on 20.02.17.
 *
 */
@Data
@Embeddable
public class PageConfiguration {

    public boolean isVisible;

}
