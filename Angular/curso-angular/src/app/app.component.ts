import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  userName: string = "renan";
  userData = {
    middleName: 'Mafort',
    lastName: 'Sereia',
  }

  roles: {admin: string, isAproveed: boolean} = {
    admin: "ADMIN",
    isAproveed: false,
}

  title = 'curso-angular';
}
