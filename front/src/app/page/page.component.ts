import {Component, OnInit} from "@angular/core";
import {ActivatedRoute, Router} from "@angular/router";
import {PageService} from "./page.service";

@Component({
    selector: 'page',
    templateUrl: './page.component.html',
    styleUrls: ['./page.component.css'],
    providers: [
        PageService
    ]
})
export class PageComponent implements OnInit {

    private title;

    constructor(
        private activatedRoute: ActivatedRoute,
        private router: Router,
        private service: PageService
    ) {}

    ngOnInit(): void {
        this.activatedRoute.data.subscribe((data: {title: 'Pages'}) => {
            this.title = data.title;
        });
        this.getPages();
    }

    getPages(): void {
        // todo
    }

}