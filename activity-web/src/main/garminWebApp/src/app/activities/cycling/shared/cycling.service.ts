import {Injectable} from "@angular/core";
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Cycling} from "./cycling.model";

@Injectable()
export class CyclingService {
  private cyclingActivitiesUrl = "http://localhost:8080/api/cyclingActivities";

  constructor(private httpClient: HttpClient) {
  }

  getActivities(): Observable<Cycling[]> {
    return this.httpClient.get<Array<Cycling>>(this.cyclingActivitiesUrl);
  }

  save(name, activity_type, dateTime, duration, distance): Observable<Cycling> {
    let cyclingActiv = {name, activity_type, dateTime, duration, distance };
    return this.httpClient
      .post<Cycling>(this.cyclingActivitiesUrl, cyclingActiv);
  }


}
