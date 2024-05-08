import {Component} from '@angular/core';
import {Animal} from "../../Animal";
import {ListService} from "../../service/list.service";
import {HttpResponse, HttpStatusCode} from "@angular/common/http";

@Component({
  selector: 'app-list-render',
  templateUrl: './list-render.component.html',
  styleUrls: ['./list-render.component.css']
})
export class ListRenderComponent {
  animalsDetails!: number;

  animals:Animal[] = []


  constructor(private listService: ListService) {
    this.getAnimals();
  }

  showAge(animal:Animal){
    this.animalsDetails = animal.age
  }

  removeAnimal(animal:Animal){
    this.listService.remove(animal).subscribe();
    this.animals = this.animals.filter(a => a.id !== animal.id);
  }

  // getAnimals(): void {
  //   this.listService.getAll().subscribe((response:any) => {
  //     let status = response.status;
  //     if (status === HttpStatusCode.Ok){
  //       this.animals = response.body;
  //     }
  //   },(error) =>{
  //     console.log(error.message)
  //   });
  // }

  getAnimals(): void {
    this.listService.getAll().subscribe({
      next: (v) => {
        if (v.status === HttpStatusCode.Ok && v.body){
          this.animals = v.body
        }
      },
      error: (e) => console.log(e.message)
    });
  }
}
