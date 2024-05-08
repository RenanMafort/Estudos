import {Component, EventEmitter, Input, OnInit, Output} from '@angular/core';
import {FormControl, FormGroup, Validators} from "@angular/forms";
import {Moments} from "../../Moments";

@Component({
  selector: 'app-moment-form',
  templateUrl: './moment-form.component.html',
  styleUrls: ['./moment-form.component.css']
})
export class MomentFormComponent implements OnInit{
  @Output() onSubmit = new EventEmitter<Moments>();
  @Input() btnText!:string
  @Input()  momentData: Moments | null = null;
  momentForm!:FormGroup;

  ngOnInit(): void {
    this.momentForm = new FormGroup({
      id: new FormControl(this.momentData ?  this.momentData.id :''),
      title: new FormControl(this.momentData ?  this.momentData.title :'',[Validators.required]),
      description: new FormControl(this.momentData ?  this.momentData.description :'',[Validators.required]),
      image: new FormControl('')

    });
  }

  onFileSelected(event:any){
    const file:File = event.target.files[0];

    this.momentForm.patchValue({image: file});
  }

  get title(){
    return this.momentForm.get('title')!;
  }

  get description(){
    return this.momentForm.get("description")!;
  }

  submit(){
    if (this.momentForm.invalid){
      return;
    }

    console.log(this.momentForm.value);

    this.onSubmit.emit(this.momentForm.value);
  }
}
