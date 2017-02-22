package com.tobilko.utils;

import static org.springframework.http.HttpMethod.*;

/**
 *
 * Created by Andrew Tobilko on 20.02.17.
 *
 */
public interface RouterConstant {

    interface PageConstant {
        String
                IDENTIFIER = "identifier",
                GET_BY_IDENTIFIER = "pages/{" + IDENTIFIER + "}";
    }

    interface Configuration {
        String
                BASE_PATH = "/api",
                CORS_BASE_PATTERN = BASE_PATH  + "/**",
                SORT_PARAM_NAME = "s",
                LIMIT_PARAM_NAME = "l",
                PAGE_PARAM_NAME = "p";

        String[]
                ALLOWED_ORIGINS = {"http://localhost:4200"},
                ALLOWED_METHODS = {POST.name(), PUT.name(), DELETE.name()},
                ALLOWED_HEADERS = {"Content-Type", "Accept", "X-Requested-With", "remember-me"};
    }

}
