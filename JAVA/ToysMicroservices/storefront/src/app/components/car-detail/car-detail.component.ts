import { Component, OnInit } from '@angular/core';
import { Car } from '../../models/car';
import { CarService } from '../../services/car.service';
import { CartService } from '../../services/cart.service';
import {Params, ActivatedRoute, Router} from '@angular/router';
import {Http} from '@angular/http';
import {AppConst} from '../../constants/app-const';

@Component({
  selector: 'app-car-detail',
  templateUrl: './car-detail.component.html',
  styleUrls: ['./car-detail.component.css']
})
export class CarDetailComponent implements OnInit {

  private carId: number;
  private car: Car = new Car();
	private serverPathWarehouse = AppConst.serverPathWarehouse;
  private numberList: number[] = [1,2,3,4,5,6,7,8,9];
  private qty: number;

  private addCarSuccess: boolean = false;
  private notEnoughStock:boolean = false;

  constructor(
    private carService:CarService,
    private cartService: CartService,
    private router:Router,
    private http:Http,
    private route:ActivatedRoute
    ) { }

  onAddToCart() {
    this.cartService.addItem(this.carId, this.qty).subscribe(
      res => {
        console.log(res.text());
        this.addCarSuccess=true;
      },
      err => {
        console.log(err.text());
        this.notEnoughStock=true;
      }
    );
  }



  ngOnInit() {
    this.route.params.forEach((params: Params) => {
      this.carId = Number.parseInt(params['id']);
    });

    this.carService.getCar(this.carId).subscribe(
      res => {
        this.car=res.json();
      },
      error => {
        console.log(error);
      }
    );

    this.qty = 1;
  }

}
