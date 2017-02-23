import {Component, Input} from "@angular/core";
import {Page} from "./model/page.model";
import {GLOBAL} from "../../config/app.constants";
import {PagesService} from "../pages.service";

@Component({
    selector: 'page',
    styleUrls: [ './page.component.css' ],
    templateUrl: './page.component.html'
})
export class PageComponent {

    @Input() page: Page;

    constructor(private service: PagesService) {}

    getFullURL = (): string => {
        return GLOBAL.SERVER_URL + '/' + this.page.getIdentifier;
    };

    removePage = (page: Page): void => {
        this.service.removePage(page);
    };

}