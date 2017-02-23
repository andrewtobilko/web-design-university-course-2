package com.tobilko;

import com.tobilko.page.PageRepository;
import com.tobilko.page.entity.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

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
            p.setIdentifier("sample1");
            p.setTitle("Title Sample 1");
            repository.save(p);

            p = new Page();
            p.setIdentifier("sample2");
            p.setTitle("Title Sample 2");
            repository.save(p);
        };
    }

}
