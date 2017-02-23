import {Component, Input} from "@angular/core";
import {Page} from "./model/page.model";

@Component({
    selector: 'page',
    styleUrls: [ './page.component.css' ],
    templateUrl: './page.component.html'
})
export class PageComponent {

    @Input() page: Page;

}