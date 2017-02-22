package com.tobilko.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurerAdapter;

import static com.tobilko.utils.RouterConstant.Configuration.*;
import static org.springframework.http.MediaType.APPLICATION_JSON;

/**
 *
 * Created by Andrew Tobilko on 22.02.17.
 *
 */
@Configuration
public class GlobalRepositoryRestConfigurer extends RepositoryRestConfigurerAdapter {

    @Override
    public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config) {
        config

                /* path configuration */
                .setBasePath(BASE_PATH)
                .setDefaultMediaType(APPLICATION_JSON)
                .setSortParamName(SORT_PARAM_NAME)
                .setPageParamName(PAGE_PARAM_NAME)
                .setLimitParamName(LIMIT_PARAM_NAME)

                /* CORS configuration */
                .getCorsRegistry()
                    .addMapping(CORS_BASE_PATTERN)
                    .allowedOrigins(ALLOWED_ORIGINS)
                    .allowedHeaders(ALLOWED_HEADERS)
                    .allowedMethods(ALLOWED_METHODS);
    }

}