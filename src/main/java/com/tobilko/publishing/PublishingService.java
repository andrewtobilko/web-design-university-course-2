package com.tobilko.publishing;

import com.tobilko.page.entity.Page;
import com.tobilko.page.entity.PageConfiguration;
import com.tobilko.page.PageRepository;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * Created by Andrew Tobilko on 20.02.17.
 *
 */
@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class PublishingService {

    public final @NonNull PageRepository repository;

    public Page publishPageFromConfiguration(PageConfiguration configuration) {
        return new Page();
    }

}
