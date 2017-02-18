package com.tobilko.publishing;

import com.tobilko.publishing.entity.Page;
import com.tobilko.publishing.entity.PageConfiguration;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class PublishingService {

    public final @NonNull PageRepository repository;

    public Page publishPageFromConfiguration(PageConfiguration configuration) {
        return new Page();
    }

}
