import { Component, OnInit } from '@angular/core';
import {CyclingService} from "../shared/cycling.service";
import {Cycling} from "../shared/cycling.model";

@Component({
  selector: 'app-cycling-add',
  templateUrl: './cycling-add.component.html',
  styleUrls: ['./cycling-add.component.css']
})
export class CyclingAddComponent implements OnInit {

  public activTypes: string[] = ['CYCLING','RUNNING', 'SWIMMING'];
  public distanceUnit: string[] = ['Meters','Kilometers', 'Miles'];

  constructor(private cyclingService: CyclingService) {

  }

  ngOnInit() {
  }

  save(name, activity_type, dateTime, duration, distance ) {
    this.cyclingService.save(name, activity_type, dateTime, duration, distance)
      .subscribe(activ => {
        console.log("activity saved: name: "+ name +" dateTime: "+dateTime+" activity tipe: "+ activity_type);
        // this.location.back();
      });

  }

  onChange(event): void {  // event will give you full breif of action
    const newVal = event.target.value;
    console.log(newVal);
  }

  convertToKm(event: number): string {
    const newVal = event * 1000;
    console.log(newVal);
    return newVal.toString();
  }

  convertToInt(val){
    return parseInt(val);
  }
  convertToStr(val :number){
    return val.toString();
  }



}
