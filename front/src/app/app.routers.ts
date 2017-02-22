import {PageNotFoundComponent} from "./error/error.component";
import {PageConstructor} from "./page/constructor/page.constructor.component";
import {PageComponent} from "./page/page.component";
import {Routes} from "@angular/router";

export const APPLICATION_ROUTERS: Routes = [
    {
        path: 'pages',
        component: PageComponent,
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