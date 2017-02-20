package com.tobilko.page;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

/**
 *
 * Created by Andrew Tobilko on 20.02.17.
 *
 */
public class IdentifierValidator implements Validator {

    @Override
    public boolean supports(Class<?> c) {
        return c.equals(String.class);
    }

    @Override
    public void validate(Object target, Errors errors) {
        String instance = target.toString();
        // todo : validate
    }

}
