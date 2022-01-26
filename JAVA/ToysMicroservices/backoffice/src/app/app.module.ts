import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { HttpModule } from '@angular/http';
import { routing } from './app.routing';
import { MatButtonModule } from '@angular/material/button';
import { MatToolbarModule } from '@angular/material/toolbar';
import { MatGridListModule} from '@angular/material/grid-list';
import { MatInputModule } from '@angular/material/input';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { MatSelectModule } from '@angular/material/select';
import { MatSlideToggleModule } from '@angular/material/slide-toggle';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatListModule } from '@angular/material/list';
import {MatDialogModule} from '@angular/material/dialog';

import { LoginService } from './services/login.service';
import { AddCarService } from './services/add-car.service';
import { UploadImageService } from './services/upload-image.service';
import { GetCarListService } from './services/get-car-list.service';
import { GetCarService } from './services/get-car.service';
import { EditCarService } from './services/edit-car.service';
import { RemoveCarService } from './services/remove-car.service';



import { AppComponent } from './app.component';
import { NavBarComponent } from './components/nav-bar/nav-bar.component';
import { AddNewCarComponent } from './components/add-new-car/add-new-car.component';
import { LoginComponent } from './components/login/login.component';
import { CarListComponent, DialogBoxComponent } from './components/car-list/car-list.component';
import { ViewCarComponent } from './components/view-car/view-car.component';
import { EditCarComponent } from './components/edit-car/edit-car.component';

@NgModule({
  declarations: [
    AppComponent,
    NavBarComponent,
    LoginComponent,
    AddNewCarComponent,
    CarListComponent,
    ViewCarComponent,
    EditCarComponent,
    DialogBoxComponent
  ],
    entryComponents: [
    DialogBoxComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpModule,
    routing,
    MatButtonModule,
    MatToolbarModule,
    MatGridListModule,
    MatInputModule,
    BrowserAnimationsModule,
    MatSelectModule,
    MatSlideToggleModule,
    MatFormFieldModule,
    MatListModule,
    MatDialogModule
  ],
  providers: [
    LoginService,
    AddCarService,
    UploadImageService,
    GetCarListService,
    GetCarService,
    EditCarService,
    RemoveCarService
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
