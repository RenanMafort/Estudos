import {Component, Input} from '@angular/core';

@Component({
  selector: 'app-parent-data',
  templateUrl: './parent-data.component.html',
  styleUrls: ['./parent-data.component.css']
})
export class ParentDataComponent {
  @Input()
  name: string = '';
  @Input()
  userData!: { middleName: string; lastName: string; };
  @Input()
  roles!: { admin: string; isAproveed: boolean };
}
