package com.tobilko.page;

import com.tobilko.page.entity.Page;
import com.tobilko.page.exception.PublishingException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

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

    public Page processPossibleAliasPage(Page page) {

        if (page.isALiasPage()) {
            Page mainPage = page.getAliasFor();

            page.setIdentifier(mainPage.getIdentifier());
            copyDataFromMainPageToAliasPage(mainPage, page);
        }

        return page;
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
