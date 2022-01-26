import { Component, OnInit } from '@angular/core';
import { UploadImageService } from '../../services/upload-image.service';
import { Car } from '../../models/car';
import { Params, ActivatedRoute, Router } from '@angular/router';
import { GetCarService } from '../../services/get-car.service';
import { EditCarService } from '../../services/edit-car.service';

@Component({
  selector: 'app-edit-car',
  templateUrl: './edit-car.component.html',
  styleUrls: ['./edit-car.component.css']
})
export class EditCarComponent implements OnInit {

  private carId: number;
  private car: Car = new Car();
  private carUpdated: boolean;

  constructor(
  	private uploadImageService: UploadImageService,
  	private editCarService: EditCarService,
  	private getCarService: GetCarService,
  	private route: ActivatedRoute,
  	private router: Router
  	) { }

  onSubmit() {
  	this.editCarService.sendCar(this.car).subscribe(
  		data => {
  			this.uploadImageService.modify(JSON.parse(JSON.parse(JSON.stringify(data))._body).id);
  			this.carUpdated=true;
  		},
  		error => console.log(error)
  	);
  }

  ngOnInit() {
  	this.route.params.forEach((params: Params) => {
  		this.carId = Number.parseInt(params['id']);
  	});

  	this.getCarService.getCar(this.carId).subscribe(
  		res => {
  			this.car = res.json();
  		}, 
  		error => console.log(error)
  	)
  }

}
