import { platformBrowserDynamic } from '@angular/platform-browser-dynamic';
import { AppModule }              from './app/config/app.module';
import {enableProdMode}           from '@angular/core';

enableProdMode();

platformBrowserDynamic().bootstrapModule(AppModule);