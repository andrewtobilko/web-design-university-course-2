package com.tobilko.configuration;

import com.tobilko.common.language.Language;
import com.tobilko.page.PageRepository;
import com.tobilko.page.entity.Page;
import com.tobilko.page.entity.localised.LocalisedPage;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * Created by Andrew Tobilko on 17.03.17.
 *
 */
@Configuration
public class GlobalConfiguration {

    @Bean
    public ApplicationRunner fill(PageRepository repository) {
        return args -> {
            Page page = new Page();

            page.setIdentifier("example");
            createLocalisedContentForPage(page,
                    "Title", "It is a long established fact that a reader will be distracted by the readable content of a page when looking at its layout. The point of using Lorem Ipsum is that it has a more-or-less normal distribution of letters, as opposed to using ...",
                    "Заголовок", "Вже давно відомо, що читабельний зміст буде заважати зосередитись людині, яка оцінює композицію сторінки. Сенс використання Lorem Ipsum полягає в тому, що цей текст має більш-менш нормальне розподілення літер."
            );

            Page page2 = new Page();

            page2.setIdentifier("example-2");
            createLocalisedContentForPage(page2,
                    "Original Title", "It is a long established fact that a reader will be distracted by the readable content of a page when looking at its layout. The point of using Lorem Ipsum is that it has a more-or-less normal distribution of letters, as opposed to using ...",
                    "Оригінальний Заголовок", "Вже давно відомо, що читабельний зміст буде заважати зосередитись людині, яка оцінює композицію сторінки. Сенс використання Lorem Ipsum полягає в тому, що цей текст має більш-менш нормальне розподілення літер."
            );

            List<Page> pages = new ArrayList<>();

            Page p3 = getMockChildPageBy(1, 100, "example-first-child", page, null, "Child title", "Child content", "Заголовок", "Контент дочірнього елемента");
            Page p4 = getMockChildPageBy(2, 1000, "example-second-child", page, null, "Child title", "Child content", "Заголовок", "Контент дочірнього елемента");
            Page p5 = getMockChildPageBy(3, 500, "example-third-child", page, null, "Child title", "Child content", "Заголовок", "Контент дочірнього елемента");
            Page p6 = getMockChildPageBy(4, 750, "example-fake-child", page, page2, "Child fake title", "Child fake content", "Підроблений заголовок", "Підроблений контент");

            pages.add(p3);
            pages.add(p4);
            pages.add(p5);
            pages.add(p6);

            page.setChildren(pages);
            repository.save(page);
            repository.save(page2);

        };
    }

    private Page getMockChildPageBy(int popularity, int rating, String identifier, Page parent, Page alias, String... strings) {
        Page page = new Page();

        page.setPopularity(popularity);
        page.setRating(rating);
        page.setIdentifier(identifier);
        page.setParent(parent);
        page.setAliasFor(alias);

        createLocalisedContentForPage(page, strings);

        return page;
    }

    private void createLocalisedContentForPage(Page page, String... strings) {
        // values need to be hard-coded due to conciseness, sorry
        Map<Language, LocalisedPage> localisedPages = new HashMap<>();

        LocalisedPage p1 = new LocalisedPage();
        setLocalisedDataForPage(p1, strings[0], strings[1]);

        LocalisedPage p2 = new LocalisedPage();
        setLocalisedDataForPage(p2, strings[2], strings[3]);

        localisedPages.put(Language.EN, p1);
        localisedPages.put(Language.UA, p2);

        page.setLocalisedPages(localisedPages);
    }

    private void setLocalisedDataForPage(LocalisedPage page, String title, String description) {
        page.setTitle(title);
        page.setContent(description);
    }

}
