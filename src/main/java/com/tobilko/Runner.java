package com.tobilko;

import com.tobilko.common.Language;
import com.tobilko.page.PageRepository;
import com.tobilko.page.entity.Page;
import com.tobilko.page.entity.localised.LocalisedPage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * Created by Andrew Tobilko on 20.02.17.
 *
 */
@SpringBootApplication
public class Runner {

    public static void main(String[] args) {
        SpringApplication.run(Runner.class, args);
    }

    @Bean
    public ApplicationRunner fill(@Autowired PageRepository repository) {
        return args -> {
            Page p = new Page();

            p.setIdentifier("example");

            //List<LocalisedPage> localisedPages = new ArrayList<>();
            Map<Language, LocalisedPage> localisedPages = new HashMap<>();

            LocalisedPage p1 = new LocalisedPage();

            p1.setTitle("Title");
            p1.setContent("<h1>Hello!</h1>");
            //p1.setLanguage(Language.EN);

            LocalisedPage p2 = new LocalisedPage();

            p2.setTitle("Заголовок");
            p2.setContent("<h1>Привіт!</h1>");
            //p2.setLanguage(Language.UA);

            localisedPages.put(Language.EN, p1);
            localisedPages.put(Language.UA, p2);

            p.setLocalisedPages(localisedPages);

            List<Page> pages = new ArrayList<>();
            Page p3 = new Page();
            p3.setIdentifier("example/first-child");

            pages.add(p3);
            p.setChildren(pages);

            repository.save(p);
        };
    }

}
