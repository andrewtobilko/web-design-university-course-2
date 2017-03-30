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

            Map<Language, LocalisedPage> localisedPages = new HashMap<>();

            LocalisedPage p1 = new LocalisedPage();

            p1.setTitle("Title");
            p1.setContent("It is a long established fact that a reader will be distracted by the readable content of a page when looking at its layout. The point of using Lorem Ipsum is that it has a more-or-less normal distribution of letters, as opposed to using ...");

            LocalisedPage p2 = new LocalisedPage();

            p2.setTitle("Заголовок");
            p2.setContent("Вже давно відомо, що читабельний зміст буде заважати зосередитись людині, яка оцінює композицію сторінки. Сенс використання Lorem Ipsum полягає в тому, що цей текст має більш-менш нормальне розподілення літер.");

            localisedPages.put(Language.EN, p1);
            localisedPages.put(Language.UA, p2);

            page.setLocalisedPages(localisedPages);

            List<Page> pages = new ArrayList<>();

            Page p3 = new Page();
            p3.setIdentifier("example-first-child");
            p3.setPopularity(1);
            p3.setRating(100);
            p3.setParent(page);

            Page p4 = new Page();
            p4.setPopularity(2);
            p4.setRating(1000);
            p4.setIdentifier("example-second-child");
            p4.setParent(page);

            Page p5 = new Page();
            p5.setPopularity(3);
            p5.setRating(500);
            p5.setIdentifier("example-third-child");
            p5.setParent(page);

            pages.add(p3);
            pages.add(p4);
            pages.add(p5);

            page.setChildren(pages);

            Page page2 = new Page();
            page2.setIdentifier("example-2");
            repository.save(getAlias(page2));

            repository.save(page);
            repository.save(page2);

        };
    }

    private Page getAlias(Page aliasFor) {
        Page alias = new Page();

        alias.setAliasFor(aliasFor);
        alias.setIdentifier("alias-example");

        Map<Language, LocalisedPage> localisedPages = new HashMap<>();
        LocalisedPage p = new LocalisedPage();

        p.setContent("Alias content");
        p.setTitle("Alias title");

        localisedPages.put(Language.EN, p);

        alias.setLocalisedPages(localisedPages);

        return alias;
    }

}
