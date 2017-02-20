package com.tobilko.publishing;

import com.tobilko.publishing.entity.Page;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface PageRepository extends PagingAndSortingRepository<Page, Long> {}
