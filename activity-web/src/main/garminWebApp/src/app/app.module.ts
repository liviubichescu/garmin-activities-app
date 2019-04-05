import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import {FormsModule} from "@angular/forms";
import {HttpClientModule} from "@angular/common/http";
import {AppRoutingModule} from "./app-routing.module";
import {CyclingListComponent} from "./activities/cycling/cycling-list/cycling-list.component";
import {CyclingComponent} from "./activities/cycling/cycling.component";
import {CyclingService} from "./activities/cycling/shared/cycling.service";
import {RunningComponent} from "./activities/running/running.component";
import {RunningListComponent} from "./activities/running/running-list/running-list.component";
import {RunningActivitiesService} from "./activities/running/shared/runningActivities.service";
import {InsightsComponent} from "./insights/insights.component";
import { CyclingAddComponent } from './activities/cycling/cycling-add/cycling-add.component';


@NgModule({
  declarations: [
    AppComponent,
    CyclingListComponent,
    CyclingComponent,
    InsightsComponent,
    RunningComponent,
    RunningListComponent,
    CyclingAddComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpClientModule,
    AppRoutingModule
  ],
  providers: [CyclingService, RunningActivitiesService],
  bootstrap: [AppComponent]
})
export class AppModule { }
