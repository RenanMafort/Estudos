import { Component } from '@angular/core';
import {Animal} from "../../Animal";

@Component({
  selector: 'app-pipes-operator',
  templateUrl: './pipes-operator.component.html',
  styleUrls: ['./pipes-operator.component.css']
})
export class PipesOperatorComponent {

  someText = "ALGUM TEXTO PARA TESTE!"

  data = new Date();

  animals:Animal[] = [
    {"id": 1, "name": "Turca", "type": "Dog", "age": 2},
    {"id": 2, "name": "Whiskers", "type": "Cat", "age": 8},
    {"id": 3, "name": "Buddy", "type": "Dog", "age": 4},
    {"id": 4, "name": "Mittens", "type": "Cat", "age": 6},
    {"id": 5, "name": "Rocky", "type": "Dog", "age": 3},
    {"id": 6, "name": "Smokey", "type": "Cat", "age": 5},
    {"id": 7, "name": "Charlie", "type": "Dog", "age": 7},
    {"id": 8, "name": "Luna", "type": "Cat", "age": 2},
    {"id": 9, "name": "Max", "type": "Dog", "age": 5},
    {"id": 10, "name": "Cleo", "type": "Cat", "age": 4},
    {"id": 11, "name": "Bailey", "type": "Dog", "age": 6},
    {"id": 12, "name": "Oreo", "type": "Cat", "age": 3},
    {"id": 13, "name": "Daisy", "type": "Dog", "age": 4},
    {"id": 14, "name": "Oliver", "type": "Cat", "age": 7},
    {"id": 15, "name": "Coco", "type": "Dog", "age": 5},
    {"id": 16, "name": "Milo", "type": "Cat", "age": 6},
    {"id": 17, "name": "Rosie", "type": "Dog", "age": 3},
    {"id": 18, "name": "Chloe", "type": "Cat", "age": 4},
    {"id": 19, "name": "Teddy", "type": "Dog", "age": 2},
    {"id": 20, "name": "Shadow", "type": "Cat", "age": 5}
  ]

}
