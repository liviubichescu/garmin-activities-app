import { Component, OnInit } from '@angular/core';
import {CyclingService} from "../shared/cycling.service";
import {Router} from "@angular/router";
import {Location} from "@angular/common";
import {Cycling} from "../shared/cycling.model";

@Component({
  selector: 'app-cycling-list',
  templateUrl: './cycling-list.component.html',
  styleUrls: ['./cycling-list.component.css']
})
export class CyclingListComponent implements OnInit {
  statusMessage: string;
  errorMessage: string;
  activitiesData: Array<Cycling>;
  selectedActivity: Cycling;


  constructor(private activitiesService: CyclingService,
              private router: Router,
              private location: Location) { }

  ngOnInit() {
    this.getActivities();
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


  getActivities() {
    this.activitiesService.getActivities()
      .subscribe(
        activitati => this.activitiesData = activitati,
        error => this.errorMessage = <any>error
      );
  }

  onSelect(activity: Cycling): void {
    this.selectedActivity = activity;
  }

  // gotoDetail(): void {
  //   this.router.navigate(['/activity/detail', this.selectedActivity.id]);
  // }

  goBack(): void {
    this.location.back();
  }

  calculateKm(value:number):number{
    if (value>0){
      return value/1000;
    }
    else {
      return value;
    }
  }

}
