import { OpaqueToken } from "@angular/core";

export let CONSTANTS = new OpaqueToken("app.constans");

export interface Constants {
    PAGE;
}

const GLOBAL = {
    SERVER_URL: 'localhost:8080',
    SERVER_URL_API: this.SERVER_URL + '/api'
};

export const ApplicationConstants : Constants =  {

    PAGE: {
        CREATE: GLOBAL.SERVER_URL_API + '/pages/create',
        FETCH_ALL: GLOBAL.SERVER_URL_API + '/pages',
        DELETE: GLOBAL.SERVER_URL_API + '/pages/delete'
    }

};