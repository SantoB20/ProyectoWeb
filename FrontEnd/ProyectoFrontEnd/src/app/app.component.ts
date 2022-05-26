import { Component, OnInit} from '@angular/core';
import { LoginComponent} from './login/login.component';
import { Licor } from './models/licor.model';
import { user } from './models/user.model';
import { ServicioService } from './services/servicio.service';
import { SignupComponent } from './signup/signup.component';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit{

  constructor(public service : ServicioService){
  }

  ngOnInit(): void {
  }
}
