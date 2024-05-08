import { Injectable } from '@angular/core';

import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {environment} from "../../environments/environment.development";
import {Moments} from "../Moments";
import {Response} from "../Response";

@Injectable({
  providedIn: 'root'
})
export class MomentService {
  private baseApiUrl = environment.baseApiUrl;
  private apiUrl = `${this.baseApiUrl}api/moments`;

  constructor(private http:HttpClient) { }

  getMoments():Observable<Response<Moments[]>>{
    return this.http.get<Response<Moments[]>>(this.apiUrl);
  }

  getMoment(id: number):Observable<Response<Moments>>{
    const url = `${this.apiUrl}/${id}`;
    return this.http.get<Response<Moments>>(url);
  }

  createMoment(formData:FormData):Observable<FormData>{
    return this.http.post<FormData>(this.apiUrl,formData);
  }

  removeMoment(id:number){
    const url = `${this.apiUrl}/${id}`;
    return this.http.delete(url);
  }
  updateMoment(id: number, formData:FormData): Observable<FormData>{
    const url = `${this.apiUrl}/${id}`;
    return this.http.put<FormData>(url,formData);
  }
}
