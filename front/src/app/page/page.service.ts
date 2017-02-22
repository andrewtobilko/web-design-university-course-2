import {Injectable, Inject} from "@angular/core";
import {Page} from "./entity/page.model";
import {Response, Http} from "@angular/http";
import {Constants, CONSTANTS} from "../../app.config";
import {Observable} from "rxjs";

@Injectable()
export class PageService {

    constructor(private http: Http, @Inject(CONSTANTS) private constants: Constants) {}

    createPage(page: Page): Observable<Page> {
        return this.isValidPage(page) ?
            this.http
                .post(this.constants.PAGE.CREATE, page)
                .map(this.processSuccessfulResponse)
                .catch(this.handleErroneousResponse) :
            Observable.empty();
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