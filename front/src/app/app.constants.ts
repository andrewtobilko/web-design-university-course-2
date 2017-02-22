import {OpaqueToken} from "@angular/core";
import {Constants} from "./app.constants.interface";

export let CONSTANTS = new OpaqueToken("app.constants");

const GLOBAL = {
    SERVER_URL: 'http://localhost:8080/api'
};

export const ApplicationConstants : Constants =  {

    PAGE: {
        CREATE: GLOBAL.SERVER_URL + '/pages',
        FETCH_ALL: GLOBAL.SERVER_URL + '/pages',
        DELETE: GLOBAL.SERVER_URL + '/pages'
    },

    DEFAULT_HEADERS: {
        'Content-Type': 'application/json'
    }

};