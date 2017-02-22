import { OpaqueToken } from "@angular/core";

export let CONSTANTS = new OpaqueToken("app.constans");

export interface Constants {
    GLOBAL: any;
    PAGE: any;
}

export const ApplicationConstants : Constants =  {

    GLOBAL: {
        SERVER_URL: 'localhost:8080',
        SERVER_URL_API: this.SERVER_URL + '/api'
    },

    PAGE: {
        CREATE: this.GLOBAL.SERVER_URL_API + '/pages/create',
        FETCH_ALL: this.GLOBAL.SERVER_URL_API + '/pages',
        DELETE: this.GLOBAL.SERVER_URL_API + '/pages/delete'
    }

};