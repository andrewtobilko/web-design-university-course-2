package com.tobilko.page;

import com.tobilko.common.criteria.SortCriteria;
import com.tobilko.page.entity.Page;
import com.tobilko.page.exception.PublishingException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.function.Function;

import static com.tobilko.common.criteria.SortCriteria.*;
import static java.util.Comparator.*;
import static java.util.Optional.*;
import static java.util.stream.Collectors.*;

/**
 *
 * Created by Andrew Tobilko on 20.02.17.
 *
 */
@Service
@RequiredArgsConstructor
public class PageService {

    public final PageRepository repository;

    public Page getPageByIdentifier(String identifier) {
        return repository.findByIdentifier(identifier).orElseThrow(PublishingException::new);
    }

    public Page sortPageChildrenElementsIfAny(Page page, SortCriteria criteria) {
        List<Page> children = page.getChildren();

        page.setChildren(children
                .stream()
                .sorted(comparing(getKeyExtractorFromCriteria(criteria)))
                .collect(toList()));

        return page;
    }

    public Page processPossibleAliasPage(Page page) {

        if (page.isAliasPage()) {
            Page mainPage = page.getAliasFor();

            page.setIdentifier(mainPage.getIdentifier());
            copyDataFromMainPageToAliasPage(mainPage, page);
        }

        return page;
    }

    private Function<Page, Integer> getKeyExtractorFromCriteria(SortCriteria criteria) {
        return ofNullable(criteria).orElse(POPULARITY).getExtractor();
    }

    private void copyDataFromMainPageToAliasPage(Page mainPage, Page page) {

        if (page.getChildren() == null) {
            page.setChildren(mainPage.getChildren());
        }

        if (page.getParent() == null) {
            page.setParent(mainPage.getParent());
        }

    }

}
