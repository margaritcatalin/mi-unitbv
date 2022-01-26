import { Injectable } from '@angular/core';
import {Http, Headers} from '@angular/http';
import {AppConst} from '../constants/app-const';

@Injectable()
export class CartService {

  constructor(private http:Http) { }

  addItem(id:number, qty: number) {
  	let url = AppConst.serverPathBilling+"/cart/add";
  	let cartItemInfo = {
  		"carId" : id,
  		"qty" : qty
  	}
  	let tokenHeader = new Headers({
  		'Content-Type' : 'application/json',
  		'x-auth-token' : localStorage.getItem("xAuthToken")
  	});
  	return this.http.post(url, cartItemInfo, {headers: tokenHeader});
  }

  getCartItemList() {
  	let url = AppConst.serverPathBilling+"/cart/getCartItemList";

  	let tokenHeader = new Headers({
  		'Content-Type' : 'application/json',
  		'x-auth-token' : localStorage.getItem("xAuthToken")
  	});
  	return this.http.get(url, {headers: tokenHeader});
  }

  getShoppingCart() {
  	let url = AppConst.serverPathBilling+"/cart/getShoppingCart";

  	let tokenHeader = new Headers({
  		'Content-Type' : 'application/json',
  		'x-auth-token' : localStorage.getItem("xAuthToken")
  	});
  	return this.http.get(url, {headers: tokenHeader});
  }

  updateCartItem(cartItemId: number, qty: number) {
  	let url = AppConst.serverPathBilling+"/cart/updateCartItem";
  	let cartItemInfo = {
  		"cartItemId" : cartItemId,
  		"qty" : qty
  	}
  	let tokenHeader = new Headers({
  		'Content-Type' : 'application/json',
  		'x-auth-token' : localStorage.getItem("xAuthToken")
  	});
  	return this.http.post(url, cartItemInfo, {headers: tokenHeader});
  }

  removeCartItem(id: number) {
  	let url = AppConst.serverPathBilling+"/cart/removeItem";

  	let tokenHeader = new Headers({
  		'Content-Type' : 'application/json',
  		'x-auth-token' : localStorage.getItem("xAuthToken")
  	});
  	return this.http.post(url, id, {headers: tokenHeader});
  }

}
