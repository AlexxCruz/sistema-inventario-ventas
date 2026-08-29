import { Component } from '@angular/core';
import { CommonModule } from '@angular/common'; //manejar utilidades visuales 
import { Producto } from './producto.model';
import { FormsModule } from '@angular/forms';


@Component({
  imports: [CommonModule, FormsModule],
  selector: 'app-productos',
  styleUrl: './productos.css',
  templateUrl: './productos.html',
})

export class Productos {
  //Arreglo de productos con datos de prueba

  textoBusqueda: string = ''; //variable que guardara lo que se escribe en el buscador

  productos: Producto[] = [
    {
      codigo: 'PROD-001',
      nombre: 'Teclado Mecanico RGB',
      categoria: 'Electronica',
      precio: 1200,
      stock: 15
    },
    {
      codigo: 'PROD-002',
      nombre: 'Monitor 24" Full HD',
      categoria: 'Electronica',
      precio: 3500,
      stock: 2
    },
    {
      codigo: 'PROD-003',
      nombre: 'Mouse Gamer Inalambrico',
      categoria: 'Electronica',
      precio: 860,
      stock: 0
    }
  ]

  get productosFiltrados(): Producto[] {

    return this.productos.filter(prod =>
      //includes: mantiene el producto en la lista
      prod.nombre.toLowerCase().includes(this.textoBusqueda.toLowerCase()) ||
      prod.codigo.toLowerCase().includes(this.textoBusqueda.toLowerCase())
    );
  }

    //objeto temporal para enlazar con el forulario del modal
  nuevoProducto: Producto = {
    codigo: '',
    nombre: '',
    categoria: ' Electronica',
    precio: 0,
    stock: 0
  };
//funcion para guardar elproducto en el arreglo
agregarProducto():void{
//generamos un codigo automatico simple 
const nuevoCodigo = `PROD-00${this.productos.length + 1}`;

//agregamos una copia del producto al arreglo principal
this.productos.push({
  ...this.nuevoProducto,
  codigo:nuevoCodigo
});

//Limpiamos el formulario para el siguiente registro
this.nuevoProducto = {
  codigo: '',
  nombre: '',
  categoria: 'Electronica',
  precio: 0,
  stock: 0
};
}


}
