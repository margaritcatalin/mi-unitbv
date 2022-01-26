import { Component, OnInit } from '@angular/core';
import { Car } from '../../models/car';
import { CarService } from '../../services/car.service';
import {Params, ActivatedRoute, Router} from '@angular/router';
import {Http} from '@angular/http';
import {AppConst} from '../../constants/app-const';

@Component({
	selector: 'app-car-list',
	templateUrl: './car-list.component.html',
	styleUrls: ['./car-list.component.css']
})
export class CarListComponent implements OnInit {

	public filterQuery = "";
	public rowsOnPage = 5;

	private selectedCar: Car;
	private carList: Car[];
	private serverPathWarehouse = AppConst.serverPathWarehouse;

	constructor(
		private carService:CarService,
		private router:Router,
		private http:Http,
		private route:ActivatedRoute
		) { }

	onSelect(car: Car) {
		this.selectedCar = car;
		this.router.navigate(['/carDetail', this.selectedCar.id]);
	}

	ngOnInit() {
		this.route.queryParams.subscribe(params => {
			if(params['carList']) {
				console.log("filtered car list");
				this.carList = JSON.parse(params['carList']);
			} else {
				this.carService.getCarList().subscribe(
					res => {
						console.log(res.json());
						this.carList = res.json();
					},
					err => {
						console.log(err);
					}
					);
			}
		});

	}
}


