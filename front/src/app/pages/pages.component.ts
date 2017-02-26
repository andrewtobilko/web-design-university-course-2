import {Component, OnInit} from "@angular/core";
import {ActivatedRoute, Router} from "@angular/router";
import {PagesService} from "./pages.service";
import {Page} from "./page/model/page.model";

@Component({
    templateUrl: 'pages.component.html',
    styleUrls: ['pages.component.css'],
    providers: [
        PagesService
    ]
})
export class PagesComponent implements OnInit {

    private title;
    private pages: Array<Page> = this.service.pages;

    constructor(
        private activatedRoute: ActivatedRoute,
        private router: Router,
        private service: PagesService
    ) {}

    ngOnInit(): void {
        this.activatedRoute.data.subscribe((data: {title: 'Pages'}) => {
            this.title = data.title;
        });

        this.service.getAllPages()
                    .subscribe(this.subscribeToSuccessfulFetchResponse(),
                               this.handleErroneousFetchResponse);
    }

    hasPages(): boolean {
        return this.pages != undefined && this.pages.length > 0;
    }

    private subscribeToSuccessfulFetchResponse() {
        return pages => {
            this.pages = pages;
        };
    }

    private handleErroneousFetchResponse() {
        // todo
    }

}