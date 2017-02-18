package com.tobilko.configuration;

import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurerAdapter;
import org.springframework.stereotype.Component;

import static com.tobilko.utils.RouterConstant.Configuration.*;
import static org.springframework.http.MediaType.*;

@Component
public class GlobalWebConfiguration extends RepositoryRestConfigurerAdapter {

    @Override
    public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config) {
        config
                .setBasePath(BASE_PATH)
                .setDefaultMediaType(APPLICATION_JSON)
                .setSortParamName(SORT_PARAM_NAME)
                .setPageParamName(PAGE_PARAM_NAME)
                .setLimitParamName(LIMIT_PARAM_NAME);
    }

}
