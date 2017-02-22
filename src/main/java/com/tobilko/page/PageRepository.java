package com.tobilko.page;

import com.tobilko.page.entity.Page;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 *
 * Created by Andrew Tobilko on 20.02.17.
 *
 */
@RepositoryRestResource
public interface PageRepository extends PagingAndSortingRepository<Page, Long> {

    Page findByIdentifier(String identifier);

}
