package com.tobilko.page.entity.localised;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 *
 * Created by Andrew Tobilko on 15.03.17.
 *
 */
@RepositoryRestResource
public interface LocalisedPageRepository extends PagingAndSortingRepository<LocalisedPage, Long> {}
