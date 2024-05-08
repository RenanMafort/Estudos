import { Component } from '@angular/core';
import {ListService} from "../../service/list.service";
import {Animal} from "../../Animal";
import {ActivatedRoute} from "@angular/router";

@Component({
  selector: 'app-item-detail',
  templateUrl: './item-detail.component.html',
  styleUrls: ['./item-detail.component.css']
})
export class ItemDetailComponent {
  animal? : Animal

  constructor(private listService: ListService, private route: ActivatedRoute) {
    this.getAnimal();
  }

  getAnimal(){
    const id = this.route.snapshot.paramMap.get("id");
    console.log(id)
     this.listService.getAnimal(Number(id)).subscribe(a => this.animal = a);
  }

}
