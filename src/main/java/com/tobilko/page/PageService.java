package com.tobilko.page;

import com.tobilko.page.entity.Page;
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
public class PageService {

    public final @NonNull PageRepository repository;

    public Page getPageByIdentifier(String identifier) {
        return repository.findByIdentifier(identifier);
    }

}
