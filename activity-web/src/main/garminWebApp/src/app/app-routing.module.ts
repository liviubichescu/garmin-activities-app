import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {CyclingComponent} from "./activities/cycling/cycling.component";

const routes: Routes = [

  {path: 'activities', component: CyclingComponent},
  // {path: 'runningActivities', component: RunningComponent},

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
