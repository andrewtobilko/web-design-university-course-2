import {PageNotFoundComponent} from "../error/error.component";
import {PageConstructor} from "../pages/constructor/page.constructor.component";
import {PagesComponent} from "../pages/pages.component";
import {Routes} from "@angular/router";

export const APPLICATION_ROUTERS: Routes = [
    {
        path: 'pages',
        component: PagesComponent,
        data: {
            title: 'Pages'
        },
        children: [
            {
                path: 'create',
                component: PageConstructor
            }
        ]
    },
    {
        path: '',
        redirectTo: '/pages',
        pathMatch: 'full'
    },
    {
        path: '**',
        component: PageNotFoundComponent
    }
];