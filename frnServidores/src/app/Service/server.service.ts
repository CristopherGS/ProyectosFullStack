import { Injectable } from '@angular/core';
import {HttpClient,  HttpErrorResponse} from "@angular/common/http";
import {Observable, throwError} from 'rxjs';
import { catchError, tap } from 'rxjs/operators';
import {CustomResponse} from "../interfaces/custom-response";
import {Server} from "../interfaces/server";
import { HttpHeaders } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class ServerService {
  headers = new HttpHeaders();
  private readonly apiUrl = 'http://10.10.96.84:8080';
  constructor(
    private http: HttpClient
  ) {
    this.headers = this.headers.set('Content-type', 'application/json;charset=UTF-8')
  }

  getServers() : Observable<any> {
    let header = new HttpHeaders()
      .set('Access-Control-Allow-Origin', '*');
    return this.http.get<CustomResponse>(`${this.apiUrl}/server/list`)
      .pipe(
        tap(console.log),
        catchError(this.handleError)
      );
  }
  save$ = (server: Server) => <Observable<CustomResponse>>
    this.http.post<CustomResponse>(`${this.apiUrl}/server/save`, server)
      .pipe(
        tap(console.log),
        catchError(this.handleError)
      )
  ping$ = (ipAdress: string) => <Observable<CustomResponse>>
    this.http.get<CustomResponse>(`${this.apiUrl}/server/ping/${ipAdress}`)
      .pipe(
        tap(console.log),
        catchError(this.handleError)
      )
  delete$ = (serverId: number) => <Observable<CustomResponse>>
    this.http.delete<CustomResponse>(`${this.apiUrl}/server/delete/${serverId}`)
      .pipe(
        tap(console.log),
        catchError(this.handleError)
      )

  private handleError(error: HttpErrorResponse): Observable<never> {
    console.log(error)
    return throwError (`Method not implemented. - Error code: ${error.status}` );
  }






}
