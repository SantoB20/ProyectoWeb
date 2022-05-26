import { Component} from '@angular/core';
import { user } from '../models/user.model';
import { ServicioService } from '../services/servicio.service';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent{

  constructor(public service:ServicioService) { 

  }
  admin(){
    this.service.admin = true
    this.service.ir_signup = false
    this.service.ir_login = false
  }
  inventario()
  {
    this.service.ir_crud=true
    this.service.ir_reportes=false
  }
  reportes()
  {
    this.service.ir_crud=false
    this.service.ir_reportes=true
  }
  login()
  {
    this.service.ir_login = true
    this.service.ir_signup = false
  }
  signup()
  {
    this.service.ir_signup = true
    this.service.ir_login = false
  }
  comprar()
  {
    this.service.ir_compra=true
    this.service.ir_historial=false
  }
  historial()
  {
    this.service.ir_compra=false
    this.service.ir_historial=true
  }
  salir()
  {
    this.service.current = new user()
    this.service.logged = false
    this.service.admin = false
  }
}
