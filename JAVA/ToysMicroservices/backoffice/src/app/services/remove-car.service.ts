import { Injectable } from '@angular/core';
import {Http, Headers} from '@angular/http';
import {Car} from '../models/car';

@Injectable()
export class RemoveCarService {

  constructor(private http:Http) { }

  sendCar(carId: number) {
  	let url = "http://localhost:8282/car/remove";
    
    let headers = new Headers ({
      'Content-Type': 'application/json',
      'x-auth-token' : localStorage.getItem('xAuthToken')
    });

    return this.http.post(url, carId, {headers: headers});
  }

}
