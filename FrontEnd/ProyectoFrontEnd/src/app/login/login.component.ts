import {
  Component,
} from '@angular/core';
import { ServicioService } from '../services/servicio.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css'],
})
export class LoginComponent {

  constructor(public service: ServicioService) {}

  public login(username: string, password: string){
    if(username == "" || password == ""){
      alert("Ingrese todos los campos")
      return
    }
    this.service.login(username,password).subscribe((res) =>{
      let token = res.headers.get("Authorization")
      localStorage.setItem("Authorization",token!)
      this.service.getLogUser(username).subscribe(data =>{
        this.service.current = data
        if(this.service.current.rol == "ADMIN"){
          this.service.admin = true
        }
      })
      this.service.logged = true
      this.service.ir_login = false
    }, err => {
      alert("Usuario o contraseña mal ingresado/s")
      return})
    
  }
}
