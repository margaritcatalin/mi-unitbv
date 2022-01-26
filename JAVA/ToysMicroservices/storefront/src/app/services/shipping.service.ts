import { Injectable } from '@angular/core';
import { AppConst } from '../constants/app-const';
import { Http, Headers } from '@angular/http';
import { UserShipping } from '../models/user-shipping';

@Injectable()
export class ShippingService {

  constructor(private http : Http) { }

  newShipping(shipping: UserShipping) {
  	let url = AppConst.serverPathUserManagement+"/shipping/add";

  	let tokenHeader = new Headers({
  		'Content-Type' : 'application/json',
  		'x-auth-token' : localStorage.getItem("xAuthToken")
  	});
  	return this.http.post(url, JSON.stringify(shipping), {headers: tokenHeader});
  }

  getUserShippingList() {
  	let url = AppConst.serverPathUserManagement+"/shipping/getUserShippingList";

  	let tokenHeader = new Headers({
  		'Content-Type' : 'application/json',
  		'x-auth-token' : localStorage.getItem("xAuthToken")
  	});
  	return this.http.get(url, {headers: tokenHeader});
  }

  removeShipping(id:number){
  	let url = AppConst.serverPathUserManagement+"/shipping/remove";

  	let tokenHeader = new Headers({
  		'Content-Type' : 'application/json',
  		'x-auth-token' : localStorage.getItem("xAuthToken")
  	});
  	return this.http.post(url, id, {headers: tokenHeader});
  }

  setDefaultShipping(id:number){
  	let url = AppConst.serverPathUserManagement+"/shipping/setDefault";

  	let tokenHeader = new Headers({
  		'Content-Type' : 'application/json',
  		'x-auth-token' : localStorage.getItem("xAuthToken")
  	});
  	return this.http.post(url, id, {headers: tokenHeader});
  }
}
