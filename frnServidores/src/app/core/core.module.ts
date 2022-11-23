import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { PrimengModule } from './primeng/primeng.module';



@NgModule({
  declarations: [],
  exports:[PrimengModule,CommonModule],
  imports: [
    CommonModule,
    PrimengModule
  ]
})
export class CoreModule { }
