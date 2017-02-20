package com.tobilko.publishing.entity;

import lombok.Data;

import javax.persistence.Embeddable;

@Data
@Embeddable
public class PageConfiguration {

    public boolean isVisible;

}
