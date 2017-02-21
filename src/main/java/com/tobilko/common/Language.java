package com.tobilko.common;

/**
 * Demonstrates a language the resource is written in.
 *
 * Created by Andrew Tobilko on 21.02.17.
 *
 */
public enum Language {

    EN("en"),
    UA("ua");

    private String value;

    Language(String stringRepresentation) {
        value = stringRepresentation;
    }

    public String getStringRepresentation() {
        return value;
    }

}
