import {OpaqueToken} from "@angular/core";
import {Headers} from "@angular/http";

export let CONSTANTS = new OpaqueToken("app.constans");

export interface Constants {
    PAGE;
    DEFAULT_HEADERS: Headers;
}

const GLOBAL = {
    SERVER_URL: 'http://localhost:8080/api'
};

export const ApplicationConstants : Constants =  {

    PAGE: {
        CREATE: GLOBAL.SERVER_URL + '/pages',
        FETCH_ALL: GLOBAL.SERVER_URL + '/pages',
        DELETE: GLOBAL.SERVER_URL + '/pages'
    },

    DEFAULT_HEADERS: new Headers({
        'Content-Type': 'application/json'
    })

};