import {Component, Input, Inject} from "@angular/core";
import {Page} from "./model/page.model";
import {GLOBAL, CONSTANTS} from "../../config/app.constants";
import {PagesService} from "../pages.service";
import {Constants} from "../../config/app.constants.interface";

@Component({
    selector: 'page',
    styleUrls: [ './page.component.css' ],
    templateUrl: './page.component.html'
})
export class PageComponent {

    @Input() private page: Page;

    constructor(private service: PagesService,
                @Inject(CONSTANTS) private constants: Constants) {}

    getFullURL = (): string => {
        return this.constants.PAGE.GET_PUBLISHED + this.page.getIdentifier;
    };

    removePage = (): void => {
        this.service.removePage(this.page);
    };

}