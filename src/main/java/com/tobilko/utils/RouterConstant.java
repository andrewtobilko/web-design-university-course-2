package com.tobilko.utils;

public class RouterConstant {

    public interface PublishingConstant {
        String
                PATH = "publishing",
                CREATE = "create";
    }

    public interface Configuration {
        String
                BASE_PATH = "/api",
                SORT_PARAM_NAME = "s",
                LIMIT_PARAM_NAME = "l",
                PAGE_PARAM_NAME = "p";
    }

}
