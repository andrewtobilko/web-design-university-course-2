import {NgModule} from "@angular/core";
import {BrowserModule} from "@angular/platform-browser";
import {AppComponent} from "../app.component";
import {MaterialModule} from "@angular/material";
import "hammerjs";
import {Routes, RouterModule} from "@angular/router";
import {PagesComponent} from "../pages/pages.component";
import {PageNotFoundComponent} from "../error/error.component";
import {PageConstructor} from "../pages/constructor/page.constructor.component";
import {FormsModule, ReactiveFormsModule} from "@angular/forms";
import {JsonpModule, HttpModule} from "@angular/http";
import {ApplicationConstants, CONSTANTS} from "./app.constants";
import {APPLICATION_ROUTERS} from "./app.routers";
import {PageComponent} from "../pages/page/page.component";

@NgModule({
  imports: [
    RouterModule.forRoot(APPLICATION_ROUTERS),
    BrowserModule,
    MaterialModule,
    FormsModule,
    HttpModule,
    JsonpModule,
    ReactiveFormsModule
  ],
  declarations: [
    AppComponent,
    PageComponent,
    PagesComponent,
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