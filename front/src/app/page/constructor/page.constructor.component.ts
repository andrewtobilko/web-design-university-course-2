import {Component} from "@angular/core";
import {Page} from "../entity/page.model";
import {PageService} from "../page.service";
import {Router} from "@angular/router";

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

    constructor(private service: PageService,
                private router: Router) {}

    construct() : void {
        this.service.createPage(
            new Page(this.page.title, this.page.uri)
        );
        // todo : return to the previous (parent) state if everything is ok
        this.router.navigate(['']);
    }

}