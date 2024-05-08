import { Injectable } from '@angular/core';
import {Animal} from "../Animal";
import {Observable} from "rxjs";
import {HttpClient, HttpResponse} from "@angular/common/http";

@Injectable({
  providedIn: 'root'
})
export class ListService {

  private apiUrl = "http://localhost:3000/animals"

  constructor(private http: HttpClient) { }

  getAll(): Observable<HttpResponse<Animal[]>>{
    return this.http.get<Animal[]>(this.apiUrl,{observe: 'response'});
  }
  remove(animal:Animal){
    // return animals.filter((a) => a.name !== animal.name);
    return this.http.delete<Animal>(`${this.apiUrl}/${animal.id}`);
  }

  getAnimal(id: number): Observable<Animal>{
    return this.http.get<Animal>(`${this.apiUrl}/${id}`);
  }

}
