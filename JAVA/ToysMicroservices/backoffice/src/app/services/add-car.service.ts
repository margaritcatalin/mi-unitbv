import { Injectable } from '@angular/core';
import {Http, Headers} from '@angular/http';
import {Car} from '../models/car';
import {LogHistory} from '../models/loghistory';

@Injectable()
export class AddCarService {

  private newLog: LogHistory = new LogHistory;

  constructor(private http:Http) { }

    sendCar(car:Car) {
  	let url = "http://localhost:8282/car/add";
    
    let headers = new Headers ({
      'Content-Type': 'application/json',
      'x-auth-token' : localStorage.getItem('xAuthToken')
    });
    this.newLog.author="Administrator";
    this.newLog.objectName="Car";
    this.newLog.message="Added a new object";
    this.sendLog(this.newLog);
    return this.http.post(url, JSON.stringify(car), {headers: headers});
  }
  sendLog(log:LogHistory) {
  	let url = "http://localhost:8484/logg/add";
    
    let headers = new Headers ({
      'Content-Type': 'application/json',
      'x-auth-token' : localStorage.getItem('xAuthToken')
    });

    return this.http.post(url, JSON.stringify(log), {headers: headers});
  }
}
