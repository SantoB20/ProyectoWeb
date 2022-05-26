import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppComponent } from './app.component';
import { LoginComponent } from './login/login.component';
import { SignupComponent } from './signup/signup.component';
import { HeaderComponent } from './header/header.component';
import { InicioComponent } from './inicio/inicio.component';
import { ComprarComponent } from './user/comprar/comprar.component';
import { HistorialComponent } from './user/historial/historial.component';
import { CrudComponent } from './admin/crud/crud.component';
import { ReportesComponent } from './admin/reportes/reportes.component';
import { ServicioService } from './services/servicio.service';
import { HttpClientModule } from '@angular/common/http';

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    SignupComponent,
    HeaderComponent,
    InicioComponent,
    ComprarComponent,
    HistorialComponent,
    CrudComponent,
    ReportesComponent,
  ],
  imports: [
    BrowserModule,
    HttpClientModule
  ],
  providers: [ServicioService],
  bootstrap: [AppComponent]
})
export class AppModule { }
