package com.tobilko.page.entity;

import com.tobilko.common.Language;
import lombok.Data;

import javax.persistence.ElementCollection;
import javax.persistence.Embeddable;
import java.util.Map;

/**
 *
 * Created by Andrew Tobilko on 26.02.17.
 *
 */
@Data
@Embeddable
public class Content {

    @ElementCollection
    private Map<Language, String> content;

}
