import {ModuleWithProviders} from '@angular/core';
import {Routes, RouterModule} from '@angular/router';
import {HomeComponent} from './components/home/home.component';
import {MyAccountComponent} from './components/my-account/my-account.component';
import {MyProfileComponent} from './components/my-profile/my-profile.component';
import {CarListComponent} from './components/car-list/car-list.component';
import {CarDetailComponent} from './components/car-detail/car-detail.component';
import {ShoppingCartComponent} from './components/shopping-cart/shopping-cart.component';
import {OrderComponent} from './components/order/order.component';
import {OrderSummaryComponent} from './components/order-summary/order-summary.component';


const appRoutes: Routes = [
	{
		path : '',
		redirectTo: '/home',
		pathMatch: 'full'
	},
	{
		path: 'home',
		component: HomeComponent
	},
	{
		path: 'myAccount',
		component: MyAccountComponent
	},
	{
		path: 'myProfile',
		component: MyProfileComponent
	},
	{
		path: 'carList',
		component: CarListComponent
	},
	{
		path: 'carDetail/:id',
		component: CarDetailComponent
	},
	{
		path: 'shoppingCart',
		component: ShoppingCartComponent
	},
	{
		path: 'checkout',
		component: OrderComponent
	},
	{
		path: 'orderSummary',
		component: OrderSummaryComponent
	}

];

export const routing: ModuleWithProviders = RouterModule.forRoot(appRoutes);