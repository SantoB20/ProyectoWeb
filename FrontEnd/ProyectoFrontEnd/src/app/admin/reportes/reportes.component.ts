import { Component, OnInit} from '@angular/core';
import { compra } from 'src/app/models/compra.model';
import { ServicioService } from 'src/app/services/servicio.service';

@Component({
  selector: 'app-reportes',
  templateUrl: './reportes.component.html',
  styleUrls: ['./reportes.component.css']
})
export class ReportesComponent implements OnInit{

  constructor(public service : ServicioService) { }
  
  ngOnInit(): void {
  }

}
