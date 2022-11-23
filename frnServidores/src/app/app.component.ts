import {Component, OnInit} from '@angular/core';
import {map, Observable, of, startWith} from "rxjs";
import {CustomResponse} from "./interfaces/custom-response";
import {AppState} from "./interfaces/app-state";
import {ServerService} from "./Service/server.service";
import {DataState} from "./enum/data-state.enum";
import {catchError} from "rxjs/operators";
import {error} from "@angular/compiler-cli/src/transformers/util";

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit{

  data: CustomResponse | undefined;
  title = '';

  constructor(
    private serverService: ServerService
  )
  {
    this.getServers();
    console.log(this.data)
    this.borrar(this.data);
  }

  ngOnInit(): void {
  }

  getServers(): void {
    this.serverService.getServers()
      .subscribe((data: CustomResponse) => {
        this.data = data;
        console.log('dentro del servicio', data)
      });
  }

  borrar(data:any ):void {
    console.log()
  }
  }

