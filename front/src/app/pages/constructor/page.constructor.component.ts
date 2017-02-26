import {Component} from "@angular/core";
import {PagesService} from "../pages.service";
import {Router} from "@angular/router";
import {Page} from "../page/model/page.model";

@Component({
    selector: 'add-page-form',
    templateUrl: './page.constructor.component.html',
    styleUrls: ['./page.constructor.component.css']
})
export class PageConstructor {

    public page = {
        title: '',
        uri: ''
    };

    constructor(private service: PagesService,
                private router: Router) {}

    construct(): void {
        let page = new Page(this.page.title, this.page.uri);

        this.service
            .createPage(page)
            .subscribe(this.processSuccessfulResponse(), this.handleErroneousResponse)
    }

    private processSuccessfulResponse() {
        return page => {
            this.service.addPageLocally(page);
            this.router.navigate(['']);
        }
    }

    private handleErroneousResponse(page : Page) {
        // todo
    }

}