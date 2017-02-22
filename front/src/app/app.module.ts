import {NgModule} from "@angular/core";
import {BrowserModule} from "@angular/platform-browser";
import {AppComponent} from "./app.component";
import {MaterialModule} from "@angular/material";
import "hammerjs";
import {Routes, RouterModule} from "@angular/router";
import {PageComponent} from "./page/page.component";
import {PageNotFoundComponent} from "./error/error.component";
import {PageConstructor} from "./page/constructor/page.constructor.component";
import {FormsModule} from "@angular/forms";
import {JsonpModule, HttpModule} from "@angular/http";
import {ApplicationConstants, CONSTANTS} from "../app.config";

const routes: Routes = [
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
  { // todo : temporal
    path: '',
    redirectTo: '/pages',
    pathMatch: 'full'
  },
  {
    path: '**',
    component: PageNotFoundComponent
  }
];

@NgModule({
  imports: [
    RouterModule.forRoot(routes),
    BrowserModule,
    MaterialModule,
    FormsModule,
    HttpModule,
    JsonpModule
  ],
  declarations: [
    AppComponent,
    PageComponent,
    PageNotFoundComponent,
    PageConstructor
  ],
  bootstrap:[
    AppComponent
  ],
  providers: [
    { provide: CONSTANTS, useValue: ApplicationConstants }
  ]
})
export class AppModule { }