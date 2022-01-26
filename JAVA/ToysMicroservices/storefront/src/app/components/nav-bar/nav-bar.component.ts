import { Component, OnInit } from '@angular/core';
import { LoginService } from '../../services/login.service';
import { Router, NavigationExtras } from '@angular/router';
import {CarService} from '../../services/car.service';
import {Car} from '../../models/car';

@Component({
  selector: 'app-nav-bar',
  templateUrl: './nav-bar.component.html',
  styleUrls: ['./nav-bar.component.css']
})
export class NavBarComponent implements OnInit {
  private loggedIn = false;
  private keyword: string;
  private carList:Car[] =[];

  constructor(
    private loginService: LoginService,
    private router: Router,
    private carService: CarService
    ) { }

  logout() {
    this.loginService.logout().subscribe(
      res => {
        location.reload();
      },
      err => {
        console.log(err);
      }
    );
  }

  onSearchByName() {
    this.carService.searchCar(this.keyword).subscribe(
      res=> {
        this.carList = res.json();
        console.log(this.carList);
        let navigationExtras: NavigationExtras = {
          queryParams: {
            "carList" : JSON.stringify(this.carList)
          }
        };

        this.router.navigate(['/carList'], navigationExtras);
      },
      error=>{
        console.log(error);
      }
      );
  }

  ngOnInit() {
    this.loginService.checkSession().subscribe(
      res => {
        this.loggedIn = true;
      },
      err => {
        this.loggedIn =false;
      }
    );
  }

}
