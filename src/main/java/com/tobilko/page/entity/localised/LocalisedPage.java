package com.tobilko.page.entity.localised;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 *
 * Created by Andrew Tobilko on 15.03.17.
 *
 */
@Data
@Entity
public class LocalisedPage {

    @Id
    @GeneratedValue
    private Long id;

    private String title;
    private String content;

}
