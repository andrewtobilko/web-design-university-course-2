import {Injectable, Inject} from "@angular/core";
import {Page} from "./entity/page.model";
import {Response, Http, RequestOptions, Headers} from "@angular/http";
import {CONSTANTS} from "../app.constants";
import {Observable} from "rxjs";
import {Constants} from "../app.constants.interface";

@Injectable()
export class PageService {

    constructor(private http: Http, @Inject(CONSTANTS) private constants: Constants) {}

    createPage(page: Page): Observable<Page> {
        if (!this.isValidPage(page)) {
            return Observable.empty();
        }

        let options = new RequestOptions({ headers: new Headers(this.constants.DEFAULT_HEADERS) });
        return this.http
                   .post(this.constants.PAGE.CREATE, page, options)
                   .map(this.processSuccessfulResponse)
                   .catch(this.handleErroneousResponse);
    }

    removePage(page: Page) : void {
        // todo : delete to the server
        alert('Page has been deleted');
    }

    private processSuccessfulResponse(response: Response) {
        alert('Page has been created');
        return response.json().data || {};
    }

    private handleErroneousResponse(response: Response | any) {
        let errorMessage = 'errorMessage';
        // todo
        return Promise.reject(errorMessage);
    }

    private isValidPage(page: Page) : boolean {
        return !!page.getTitle && !!page.getURI;
    }

}