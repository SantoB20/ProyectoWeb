import { Component } from '@angular/core';
import { user } from '../models/user.model';
import { ServicioService } from '../services/servicio.service';

@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.css'],
})
export class SignupComponent {
  show!: boolean;
  message!: boolean;

  constructor(public service: ServicioService) {}

  public register(username: string,password: string,cel: string,email: string,esAdmin: boolean) {
    if (username == '' || password == '' || cel == '' || email == '') {
      alert('Por faver ingrese todos los datos');
      return;
    }
    let nuevo: user = new user();

    nuevo.username = username;
    nuevo.password = password;
    nuevo.celular = cel;
    nuevo.email = email;
    if (esAdmin) {
      nuevo.rol = 'ADMIN';
    } else {
      nuevo.rol = 'CLIENT';
    }

    this.service.register(nuevo).subscribe((data) => {
      if (data) {
        this.show = true;
        this.message = true;
      } else {
        this.show = true;
        this.message = false;
      }
    });
  }
}
