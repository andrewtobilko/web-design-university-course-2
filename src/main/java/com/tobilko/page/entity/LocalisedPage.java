package com.tobilko.page.entity;

import com.tobilko.common.Language;
import lombok.Data;

import javax.persistence.*;

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

    @ManyToOne
    private Page container;

    private Language language;
    private String title;
    private String content;

}
