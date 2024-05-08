import {Component, OnInit} from '@angular/core';
import {FormBuilder, FormControl, FormGroup, Validators} from "@angular/forms";
import {HttpClient} from "@angular/common/http";

@Component({
  selector: 'app-my-forms',
  templateUrl: './my-forms.component.html',
  styleUrls: ['./my-forms.component.css']
})
export class MyFormsComponent implements OnInit{

  formTest!: FormGroup;


  constructor(private http: HttpClient) {
  }

  ngOnInit(): void {
    this.formTest = new FormGroup({
      name: new FormControl('',[Validators.required]),
      type: new FormControl(''),
      age: new FormControl(''),
    });
  }
  submit() {
    let id = 30;
    const url = "http://localhost:3000/animals";
    const data = {
      id: ++id,
      name: this.formTest.value.name,
      type: this.formTest.value.type,
      age: this.formTest.value.age,
    }
    if (this.formTest.valid){
      this.http.post<FormData>(url,data,{observe:'response'}).subscribe({
        next: (value) => console.log(value.status),
        error: (error) => console.error(error)
      })
    }
  }
}
