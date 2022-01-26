import { Component, OnInit } from '@angular/core';
import { Car} from '../../models/car';
import { AddCarService} from '../../services/add-car.service';
import { UploadImageService} from '../../services/upload-image.service';


@Component({
  selector: 'app-add-new-car',
  templateUrl: './add-new-car.component.html',
  styleUrls: ['./add-new-car.component.css']
})
export class AddNewCarComponent implements OnInit {

  private newCar: Car = new Car;
  private carAdded: boolean;

  constructor(private addCarService: AddCarService, private uploadImageService: UploadImageService ) { }

  onSubmit() {
  	this.addCarService.sendCar(this.newCar).subscribe(
  		res => {
        this.uploadImageService.upload(JSON.parse(JSON.parse(JSON.stringify(res))._body).id);
  			this.carAdded=true;
  			this.newCar = new Car();
  			this.newCar.active=true;
  			this.newCar.category="Commun";
  		},
  		error => {
  			console.log(error);
  		}
  	);
  }

  ngOnInit() {
  	this.carAdded=false;
  	this.newCar.active=true;
  	this.newCar.category="Commun";
  }

}
