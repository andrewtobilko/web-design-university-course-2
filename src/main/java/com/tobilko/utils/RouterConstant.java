package com.tobilko.utils;

/**
 *
 * Created by Andrew Tobilko on 20.02.17.
 *
 */
public class RouterConstant {

    public interface PublishingConstant {
        String
                PATH = "publishing",
                CREATE = "create";
    }

    public interface PageConstant {
        String
                IDENTIFIER = "identifier",
                GET_BY_IDENTIFIER = "pages/{" + IDENTIFIER + "}";
    }

    public interface Configuration {
        String
                BASE_PATH = "/api",
                SORT_PARAM_NAME = "s",
                LIMIT_PARAM_NAME = "l",
                PAGE_PARAM_NAME = "p";
    }

}
