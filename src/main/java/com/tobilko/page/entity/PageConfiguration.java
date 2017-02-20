package com.tobilko.page.entity;

import lombok.Data;

import javax.persistence.Embeddable;

@Data
@Embeddable
public class PageConfiguration {

    public boolean isVisible;

}
