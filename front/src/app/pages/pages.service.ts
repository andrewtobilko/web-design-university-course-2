import {Injectable, Inject} from "@angular/core";
import {Response, Http, RequestOptions, Headers} from "@angular/http";
import {CONSTANTS} from "../config/app.constants";
import {Observable} from "rxjs";
import {Constants} from "../config/app.constants.interface";
import {Page} from "./page/model/page.model";

@Injectable()
export class PagesService {

    pages : Array<Page>;

    constructor(private http: Http,
                @Inject(CONSTANTS) private constants: Constants) {}

    getAllPages() : Observable<Page[]> {
        return this.pages ? Observable.of(this.pages) : this.fetchAllPages();
    }

    addPageLocally(page: Page) :void {
        // todo
        this.pages ? this.pages.push(page) : (this.pages = []).push(page);
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
        this.http.delete(this.constants.PAGE.DELETE, page).subscribe(response => {
            console.log(response);
        });
    }

    private fetchAllPages(): Observable<Page[]> {
        return this.http
                   .get(this.constants.PAGE.FETCH_ALL)
                   .map(this.processSuccessfulResponseForFetchingAllPages)
                   .catch(this.handleErroneousResponse);
    }

    private processSuccessfulResponseForFetchingAllPages(response: Response) {
        response
            .json()
            .content
            .map(o => new Page(o.title, o.identifier))
            .forEach(o => this.pages ? this.pages.push(o) : (this.pages = []).push(o));

        return this.pages;
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
        return !!page.getTitle && !!page.getIdentifier;
    }

}