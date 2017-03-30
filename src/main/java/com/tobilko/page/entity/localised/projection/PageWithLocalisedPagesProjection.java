package com.tobilko.page.entity.localised.projection;

import com.tobilko.common.language.Language;
import com.tobilko.page.entity.Page;
import com.tobilko.page.entity.localised.LocalisedPage;
import org.springframework.data.rest.core.config.Projection;

import java.util.Map;

import static com.tobilko.utils.ModelViewConstant.PROJECTION.WITH_LOCALISED_PAGES;

/**
 *
 * Created by Andrew Tobilko on 15.03.17.
 *
 */
@Projection(name = WITH_LOCALISED_PAGES, types = Page.class)
public interface PageWithLocalisedPagesProjection {

    Long getId();
    String getIdentifier();

    Map<Language, LocalisedPage> getLocalisedPages();

}
