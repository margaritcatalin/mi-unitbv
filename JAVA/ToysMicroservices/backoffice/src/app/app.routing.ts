import {ModuleWithProviders} from '@angular/core';
import {Routes, RouterModule} from '@angular/router';
import {LoginComponent} from './components/login/login.component';
import {AddNewCarComponent} from './components/add-new-car/add-new-car.component';
import {CarListComponent} from './components/car-list/car-list.component';
import {ViewCarComponent} from './components/view-car/view-car.component';
import {EditCarComponent} from './components/edit-car/edit-car.component';

const appRoutes: Routes = [
	{
		path : '',
		redirectTo: '/login',
		pathMatch: 'full'
	},
	{
		path: 'login',
		component: LoginComponent
	},
	{
		path: 'addNewCar',
		component: AddNewCarComponent
	},
	{
		path: 'carList',
		component: CarListComponent
	},
	{
		path: 'viewCar/:id',
		component: ViewCarComponent
	},
		{
		path: 'editCar/:id',
		component: EditCarComponent
	}
];

export const routing: ModuleWithProviders = RouterModule.forRoot(appRoutes);