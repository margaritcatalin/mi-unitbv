import { Injectable } from '@angular/core';
import { AppConst } from '../constants/app-const';
import { Http, Headers } from '@angular/http';
import { UserPayment } from '../models/user-payment';

@Injectable()
export class PaymentService {

  constructor(private http : Http) { }

  newPayment(payment: UserPayment) {
  	let url = AppConst.serverPathUserManagement+"/payment/add";

  	let tokenHeader = new Headers({
  		'Content-Type' : 'application/json',
  		'x-auth-token' : localStorage.getItem("xAuthToken")
  	});
  	return this.http.post(url, JSON.stringify(payment), {headers: tokenHeader});
  }

  getUserPaymentList() {
  	let url = AppConst.serverPathUserManagement+"/payment/getUserPaymentList";

  	let tokenHeader = new Headers({
  		'Content-Type' : 'application/json',
  		'x-auth-token' : localStorage.getItem("xAuthToken")
  	});
  	return this.http.get(url,  {headers: tokenHeader});
  }

  removePayment(id: number) {
  	let url = AppConst.serverPathUserManagement+"/payment/remove";

  	let tokenHeader = new Headers({
  		'Content-Type' : 'application/json',
  		'x-auth-token' : localStorage.getItem("xAuthToken")
  	});
  	return this.http.post(url, id, {headers: tokenHeader});
  }

  setDefaultPayment (id: number) {
  	let url = AppConst.serverPathUserManagement+"/payment/setDefault";

  	let tokenHeader = new Headers({
  		'Content-Type' : 'application/json',
  		'x-auth-token' : localStorage.getItem("xAuthToken")
  	});
  	return this.http.post(url, id, {headers: tokenHeader});
  }
}
