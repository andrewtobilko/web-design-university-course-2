import {NgModule} from "@angular/core";
import {BrowserModule} from "@angular/platform-browser";
import {AppComponent} from "./app.component";
import {MaterialModule} from "@angular/material";
import "hammerjs";
import {Routes, RouterModule} from "@angular/router";
import {PageComponent} from "./page/page.component";
import {PageNotFoundComponent} from "./error/error.component";

const routes: Routes = [
  {
    path: 'pages',
    component: PageComponent,
    data: {
      title: 'Pages'
    }
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

@NgModule({
  imports: [
    RouterModule.forRoot(routes),
    BrowserModule,
    MaterialModule
  ],
  declarations: [
    AppComponent,
    PageComponent,
    PageNotFoundComponent
  ],
  bootstrap:[
    AppComponent
  ]
})
export class AppModule { }