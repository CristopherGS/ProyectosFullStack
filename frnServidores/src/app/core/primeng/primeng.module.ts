import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import {ProgressSpinnerModule} from "primeng/progressspinner";     //accordion and accordion tab
import {ButtonModule} from 'primeng/button';



@NgModule({
  declarations: [],
  exports:[
    ProgressSpinnerModule,
    ButtonModule
  ],
  imports: [
    CommonModule,
  ]
})
export class PrimengModule { }
