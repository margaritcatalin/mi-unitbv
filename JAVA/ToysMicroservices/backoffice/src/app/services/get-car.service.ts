import { Injectable } from '@angular/core';
import {Http, Headers} from '@angular/http';


@Injectable()
export class GetCarService {

  constructor(private http:Http) { }

  getCar(id:number) {
  	let url = "http://localhost:8282/car/"+id;
    let headers = new Headers ({
      'Content-Type': 'application/json',
      'x-auth-token' : localStorage.getItem('xAuthToken')
    });

    return this.http.get(url, {headers: headers});
  }
}
