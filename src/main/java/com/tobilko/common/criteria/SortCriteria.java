package com.tobilko.common.criteria;

import com.tobilko.page.entity.Page;
import org.springframework.data.domain.Sort;

import java.util.function.Function;

public enum SortCriteria {

    POPULARITY(Page::getPopularity),
    RATING(Page::getRating);

    private Function<Page, Integer> extractorFunction;

    SortCriteria(Function<Page, Integer> extractor) {
        extractorFunction = extractor;
    }

    public Function<Page, Integer> getExtractor() {
        return extractorFunction;
    }

}
