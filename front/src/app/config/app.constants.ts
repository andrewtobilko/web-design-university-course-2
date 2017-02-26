import {OpaqueToken} from "@angular/core";
import {Constants} from "./app.constants.interface";

export let CONSTANTS = new OpaqueToken("app.constants");

export const GLOBAL = {
    SERVER_URL: 'http://localhost:8080',
    SERVER_API_URL: 'http://localhost:8080/api'
};

export const ApplicationConstants : Constants =  {

    PAGE: {
        CREATE: GLOBAL.SERVER_API_URL + '/pages',
        FETCH_ALL: GLOBAL.SERVER_API_URL + '/pages',
        DELETE: GLOBAL.SERVER_API_URL + '/pages',
        GET_PUBLISHED: GLOBAL.SERVER_URL + '/publishedPages/'
    },

    DEFAULT_HEADERS: {
        'Content-Type': 'application/json'
    }

};