import { Component, OnInit } from '@angular/core';
import {Car} from '../../models/car';
import {Router} from '@angular/router';
import {LoginService} from '../../services/login.service';
import {GetCarListService} from '../../services/get-car-list.service';
import {MatDialog, MatDialogRef} from '@angular/material';
import {RemoveCarService} from '../../services/remove-car.service';

@Component({
  selector: 'app-car-list',
  templateUrl: './car-list.component.html',
  styleUrls: ['./car-list.component.css']
})
export class CarListComponent implements OnInit {
	private selectedCar : Car;
	private checked: boolean;
	private carList: Car[];
	private allChecked: boolean;
	private removeCarList: Car[] = new Array();

  constructor(
  		private getCarListService: GetCarListService,
      private removeCarService: RemoveCarService,
  		private router:Router,
      public dialog:MatDialog
  	) { }

  onSelect(car:Car) {
    this.selectedCar=car;
    this.router.navigate(['/viewCar', this.selectedCar.id]);
  }

  openDialog(car:Car){
    let dialogRef = this.dialog.open(DialogBoxComponent);
    dialogRef.afterClosed().subscribe(
      result => {
        console.log(result);
        if (result=='yes'){
          this.removeCarService.sendCar(car.id).subscribe(
            res =>{
              console.log(res);
              this.getCarList();
            },
            err => {
              console.log(err);
            }
          );
        }       
      }     
    ); 
  }

  updateRemoveCarList(checked:boolean, car:Car) {
    if(checked) {
      this.removeCarList.push(car);
    } else {
      this.removeCarList.splice(this.removeCarList.indexOf(car), 1);
    }
  }

  updateSelected(checked: boolean) {
    if(checked) {
      this.allChecked = true;
      this.removeCarList=this.carList.slice();
    } else {
      this.allChecked=false;
      this.removeCarList=[];
    }
  }

  removeSelectedCars() {
    let dialogRef = this.dialog.open(DialogBoxComponent);
    dialogRef.afterClosed().subscribe(
      result => {
        console.log(result);
        if(result=="yes") {
          for (let car of this.removeCarList) {
            this.removeCarService.sendCar(car.id).subscribe(
              res => {

              }, 
              err => {

              }
             );
          }
          location.reload();
        }
      }
    ); 
  }

  getCarList(){
      this.getCarListService.getCarList().subscribe(
      res => {
        console.log(res.json());
        this.carList=res.json();
      }, 
      error => {
        console.log(error);
      }
    );
  }

  ngOnInit() {
    this.getCarList();
  }
}

@Component({
  selector: 'dialog-box-component',
  templateUrl: './dialog-box-component.html'
  })
export class DialogBoxComponent{
  constructor(public dialogRef: MatDialogRef<DialogBoxComponent>) {}
}

