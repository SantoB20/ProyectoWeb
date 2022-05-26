import { Detalle } from "./detalle.model";

export class compra 
{
    id: number
    comprador: string
    total: number
    productos: Detalle[]

    constructor(id: number, comprador: string, total: number, productos: Detalle[])
    {
        this.id = id
        this.comprador = comprador
        this.total = total
        this.productos= productos
    }
}