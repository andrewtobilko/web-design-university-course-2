import {Injectable, Inject} from "@angular/core";
import {Response, Http, RequestOptions, Headers} from "@angular/http";
import {CONSTANTS} from "../config/app.constants";
import {Observable} from "rxjs";
import {Constants} from "../config/app.constants.interface";
import {Page} from "./page/model/page.model";

@Injectable()
export class PagesService {

    pages : Array<Page> = [];

    constructor(private http: Http,
                @Inject(CONSTANTS) private constants: Constants) {}

    getAllPages() : Observable<Page[]> {
        return this.pages ? Observable.of(this.pages) : this.fetchAllPages();
    }

    addPageLocally(page: Page) :void {
        // todo
        this.pages ? this.pages.push(page) : (this.pages = []).push(page);
    }

    private removePageLocally(page: Page) :void {
        console.log('removePageLocally >', this.pages);
        var index = this.pages.indexOf(page);
        if (index > -1) {
            this.pages.splice(index, 1);
        }
        console.log('removePageLocally <', this.pages);
    }

    createPage(page: Page): Observable<Page> {
        if (!this.isValidPage(page)) {
            alert('Page didn\'t pass the validation...')
            return Observable.empty();
        }

        let options = new RequestOptions({ headers: new Headers(this.constants.DEFAULT_HEADERS) });
        return this.http
                   .post(this.constants.PAGE.CREATE, page, options)
                   .map(this.processSuccessfulResponseForCreating)
                   .catch(this.handleErroneousResponse);
    }

    removePage(page: Page) : void {
        this.http.delete(this.constants.PAGE.DELETE.replace('{id}', page.getId), page).subscribe(response => {
            if (response.status === 204) {
                alert('The page was removed!');
                this.removePageLocally(page);
            }
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
            .map(o => new Page(o.title, o.identifier, o.id))
            .forEach(o => {
                console.log('>1>', this.pages)
                this.pages.push(o);
                console.log('>2>', this.pages)
            });

        console.log('processSuccessfulResponseForFetchingAllPages, pages out', this.pages);
        return this.pages;
    }

    private processSuccessfulResponseForCreating(response: Response) {
        alert('The page was created!')
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