import { Component, OnInit } from '@angular/core';
import {Params, ActivatedRoute, Router} from '@angular/router';
import {GetCarService} from '../../services/get-car.service';
import {Car} from '../../models/car';

@Component({
  selector: 'app-view-car',
  templateUrl: './view-car.component.html',
  styleUrls: ['./view-car.component.css']
})
export class ViewCarComponent implements OnInit {

  private car:Car = new Car();
  private carId: number;

  constructor(private getCarService:GetCarService,
  	private route:ActivatedRoute, private router:Router) { }

    onSelect(car:Car) {
    this.router.navigate(['/editCar', this.car.id])
    // .then(s => location.reload())
    ;
  }

  ngOnInit() {
  	this.route.params.forEach((params: Params) => {
  		this.carId = Number.parseInt(params['id']);
  	});

  	this.getCarService.getCar(this.carId).subscribe(
  		res => {
  			this.car = res.json();
  		},
  		error => {
  			console.log(error);
  		}
  	);

  	
  }

}
