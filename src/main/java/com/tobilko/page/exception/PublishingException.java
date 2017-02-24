package com.tobilko.page.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import static com.tobilko.utils.ErrorMessageConstant.PUBLISHING_EXCEPTION_MESSAGE;

/**
 *
 * Created by Andrew Tobilko on 24.02.17.
 *
 */
@ResponseStatus(code = HttpStatus.PRECONDITION_FAILED, reason = PUBLISHING_EXCEPTION_MESSAGE)
public class PublishingException extends RuntimeException {}
