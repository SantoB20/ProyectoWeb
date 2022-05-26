import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http'
import { Licor } from '../models/licor.model';
import { user } from '../models/user.model';
import { environment } from 'src/environments/environment';
import { BehaviorSubject, Observable, tap } from 'rxjs';


@Injectable({providedIn: 'root'})
export class ServicioService {

  current: user = new user()
  logged: boolean = false
  admin:boolean = false
  ir_login: boolean = true
  ir_signup: boolean = false
  ir_compra: boolean= false
  ir_historial: boolean = false
  ir_crud: boolean = false
  ir_reportes: boolean = false
  users: user[] = []
  inventario: Licor[] = []

  headers = new HttpHeaders().set("Authorization", localStorage.getItem("Authorization")!)

  private backEnd = environment.apiBaseUrl

  private readonly TOKEN_NAME = 'Authorization'

  constructor(private http: HttpClient) {}

  public register(nuevo: user){
    return this.http.post<boolean>(this.backEnd+'/users/crear',nuevo)
  }

  public login(username: string, password: string){
    return this.http.post(this.backEnd+'/login',{username,password},{observe: "response"})
  }

  public getLogUser(username: string){
    return this.http.get<user>(this.backEnd+'/users/byusername/'+ username, {headers: this.headers})
  }
}
