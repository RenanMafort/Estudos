import { Component } from '@angular/core';
import {Animal} from "../../Animal";
import {HttpClient} from "@angular/common/http";

@Component({
  selector: 'app-my-forms-cadastrar',
  templateUrl: './my-forms-cadastrar.component.html',
  styleUrls: ['./my-forms-cadastrar.component.css']
})
export class MyFormsCadastrarComponent {

  buttonName='Cadastrar'


  constructor(private http: HttpClient) {
  }

  createHandler(animal: Animal){
    const path = "http://localhost:3000/animals"
    this.http.post(path,animal).subscribe({
      next: (v)=>console.log(v),
      error: (e) => console.log(e)
    });

  }

}
