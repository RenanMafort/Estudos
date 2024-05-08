import { Component } from '@angular/core';

@Component({
  selector: 'app-directives',
  templateUrl: './directives.component.html',
  styleUrls: ['./directives.component.css']
})
export class DirectivesComponent {
  color = 'red';
  size = 52;
  classes = ['green-title','red-title'];
  underline = "underline-text";
}
