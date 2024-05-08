import { Component } from '@angular/core';

@Component({
  selector: 'app-first-component',
  templateUrl: './first-component.component.html',
  styleUrls: ['./first-component.component.css']
})
export class FirstComponentComponent {

  name: string = "Renan";
  age: number = 24;
  job= "Programador";
  hobbies: string[] = ['jogar','cagar', 'mijar'];
  car = {
    name: 'Ferrari',
    marca: 'VW'
  }

}
