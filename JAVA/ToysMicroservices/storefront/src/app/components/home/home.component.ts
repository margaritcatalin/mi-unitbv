import { Component, OnInit } from '@angular/core';
@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {
  imageSources: string[] = [
    '../../../assets/image/baner1.jpg',
    '../../../assets/image/baner2.jpg',
    '../../../assets/image/baner3.jpg'
  ];
  constructor() { }

  ngOnInit() {
  }

}
