import {Injectable, Inject} from "@angular/core";
import {Page} from "./entity/page.model";
import {Response, Http, RequestOptions, Headers} from "@angular/http";
import {CONSTANTS} from "../app.constants";
import {Observable} from "rxjs";
import {Constants} from "../app.constants.interface";

@Injectable()
export class PageService {

    private pages : Page[];

    constructor(private http: Http,
                @Inject(CONSTANTS) private constants: Constants) {}

    getAllPages() : Observable<Page[]> {
        return this.pages ?
            Observable.of(this.pages) :
            this.fetchAllPages();
    }

    createPage(page: Page): Observable<Page> {
        if (!this.isValidPage(page)) {
            // todo : message
            return Observable.empty();
        }

        let options = new RequestOptions({ headers: new Headers(this.constants.DEFAULT_HEADERS) });
        return this.http
                   .post(this.constants.PAGE.CREATE, page, options)
                   .map(this.processSuccessfulResponseForCreating)
                   .catch(this.handleErroneousResponse);
    }

    removePage(page: Page) : void {
        // todo
    }

    private fetchAllPages(): Observable<Page[]> {
        return this.http
                   .get(this.constants.PAGE.FETCH_ALL)
                   .map(this.processSuccessfulResponseForFetchingAllPages)
                   .catch(this.handleErroneousResponse);
    }

    private processSuccessfulResponseForFetchingAllPages(response: Response) {
        // todo
    }

    private processSuccessfulResponseForCreating(response: Response) {
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