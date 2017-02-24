package com.tobilko.page;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import static com.tobilko.utils.ErrorMessageConstant.IDENTIFIER_NOT_NULL;
import static com.tobilko.utils.RouterConstant.PageConstant.IDENTIFIER;
import static java.util.Objects.requireNonNull;
import static org.springframework.validation.ValidationUtils.rejectIfEmptyOrWhitespace;

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
        String instance = requireNonNull(target, IDENTIFIER_NOT_NULL).toString();
        rejectIfEmptyOrWhitespace(errors, instance, IDENTIFIER, IDENTIFIER_NOT_NULL);
    }

}
