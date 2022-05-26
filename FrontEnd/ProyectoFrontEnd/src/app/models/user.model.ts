import { compra } from './compra.model';

export class user {
  
  id!: string
  username!: string
  email!: string
  celular!: string
  password!: string
  rol!: string
  compras!: compra[]

  constructor(){}

}
