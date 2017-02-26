package com.tobilko.page.exception;

import static com.tobilko.utils.ErrorMessageConstant.PUBLISHING_EXCEPTION_MESSAGE;

/**
 *
 * Created by Andrew Tobilko on 24.02.17.
 *
 */
public class PublishingException extends RuntimeException {

    public PublishingException() {
        super(PUBLISHING_EXCEPTION_MESSAGE);
    }

}
