import { Component, OnInit } from '@angular/core';
import {Router} from "@angular/router";
import {Location} from "@angular/common";
import {RunningActivities} from "../shared/runningActivities.model";
import {RunningActivitiesService} from "../shared/runningActivities.service";

@Component({
  selector: 'app-running-list',
  templateUrl: './running-list.component.html',
  styleUrls: ['./running-list.component.css']
})
export class RunningListComponent implements OnInit {

  statusMessage: string;
  errorMessage: string;
  runningData: Array<RunningActivities>;
  selectedActivity: RunningActivities;


  constructor(private activitiesService: RunningActivitiesService,
              private router: Router,
              private location: Location) { }

  ngOnInit() {
    this.getActivities();
  }


  getActivities() {
    this.activitiesService.getRunningActivities()
      .subscribe(
        activitati => this.runningData = activitati,
        error => this.errorMessage = <any>error
      );
  }

  parseMyDate(value: any): Date | null {
    if ((typeof value === 'string') && (value.indexOf('-') > -1)) {
      const str = value.split('-');

      const year = Number(str[0]);
      const month = Number(str[1]) - 1;
      const date = Number(str[2]);

      return new Date(year, month, date);
    } else if((typeof value === 'string') && value === '') {
      return new Date();
    }
    const timestamp = typeof value === 'number' ? value : Date.parse(value);
    return isNaN(timestamp) ? null : new Date(timestamp);
  }
}
