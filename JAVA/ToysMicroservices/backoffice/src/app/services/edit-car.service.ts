import { Injectable } from '@angular/core';
import {Http, Headers} from '@angular/http';
import {Car} from '../models/car';

@Injectable()
export class EditCarService {

  constructor(private http:Http) { }

    sendCar(car:Car) {
  	let url = "http://localhost:8282/car/update";
    
    let headers = new Headers ({
      'Content-Type': 'application/json',
      'x-auth-token' : localStorage.getItem('xAuthToken')
    });

    return this.http.post(url, JSON.stringify(car), {headers: headers});
  }

}
