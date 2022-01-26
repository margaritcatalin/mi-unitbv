import {Car} from './car';
import {ShoppingCart} from './shopping-cart';

export class CartItem {
	public id: number;
	public qty: number;
	public subtotal: number;
	public car: Car;
	public shoppingCart: ShoppingCart
	public toUpdate:boolean;
}
