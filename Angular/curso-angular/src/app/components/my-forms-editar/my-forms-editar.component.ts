import {Component, OnInit} from '@angular/core';
import {ActivatedRoute} from "@angular/router";
import {ListService} from "../../service/list.service";
import {Animal} from "../../Animal";

@Component({
  selector: 'app-my-forms-editar',
  templateUrl: './my-forms-editar.component.html',
  styleUrls: ['./my-forms-editar.component.css']
})
export class MyFormsEDITARComponent implements OnInit{

  animal!: Animal;
  id!:string | null;
  buttonName: string = 'Editar'

  constructor(private listService: ListService,private route:ActivatedRoute) {

  }

  ngOnInit(): void {
      this.id = this.route.snapshot.paramMap.get("id");
      console.log(this.id)
      this.listService.getAnimal(Number(this.id)).subscribe((response) => this.animal = response);
      console.log(this.animal)

  }

  editAnimal(animal: Animal){
    this.listService.updateAnimal(animal).subscribe({
      next: v => console.log(v)
    });
  }


}
