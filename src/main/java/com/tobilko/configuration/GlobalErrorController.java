package com.tobilko.configuration;

import org.springframework.boot.autoconfigure.web.ErrorController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.tobilko.utils.RouterConstant.Configuration.ERROR_PATH;

/**
 *
 * Created by Andrew Tobilko on 24.02.17.
 *
 */
@RestController
public class GlobalErrorController implements ErrorController {

    @RequestMapping(path = ERROR_PATH)
    private String handleGlobalErrors() {
        return "There will be a good error page..."; // todo
    }

    @Override
    public String getErrorPath() {
        return ERROR_PATH;
    }

}
