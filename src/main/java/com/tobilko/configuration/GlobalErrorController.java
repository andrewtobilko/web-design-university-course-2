package com.tobilko.configuration;

import org.springframework.boot.autoconfigure.web.ErrorController;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import static com.tobilko.utils.ModelViewConstant.MODEL.EXCEPTION;
import static com.tobilko.utils.ModelViewConstant.VIEW.ERROR;
import static com.tobilko.utils.RouterConstant.Configuration.ERROR_PATH;

/**
 *
 * Created by Andrew Tobilko on 24.02.17.
 *
 */
@RestController
@ControllerAdvice
public class GlobalErrorController implements ErrorController {

    @ExceptionHandler
    @RequestMapping(path = ERROR_PATH)
    private ModelAndView handleGlobalErrors(Exception exception) {
        return new ModelAndView(ERROR, EXCEPTION, exception);
    }

    @Override
    public String getErrorPath() {
        return ERROR_PATH;
    }

}
