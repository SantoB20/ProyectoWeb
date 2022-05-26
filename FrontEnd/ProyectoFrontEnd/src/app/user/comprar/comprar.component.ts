import { Component, OnDestroy, OnInit } from '@angular/core';
import { compra } from 'src/app/models/compra.model';
import { Licor } from 'src/app/models/licor.model';
import { ServicioService } from 'src/app/services/servicio.service';

@Component({
  selector: 'app-comprar',
  templateUrl: './comprar.component.html',
  styleUrls: ['./comprar.component.css'],
})
export class ComprarComponent{

  costo_total = 0
  productos: Licor[] = []

  constructor(public service: ServicioService) {
  }
  
}
