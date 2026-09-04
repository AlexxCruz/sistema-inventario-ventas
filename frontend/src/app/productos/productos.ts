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

  modoEdicion: boolean = false; //bandera para saber si el modal edita o crea

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
  ];

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
    categoria: 'Electronica',
    precio: 0,
    stock: 0
  };

  //metodo para resetear el formulario antes de crear un nuevo producto
  prepararNuevoProducto(): void {
    this.modoEdicion = false;
    this.nuevoProducto = {
      codigo: '',
      nombre: '',
      categoria: 'Electronica',
      precio: 0,
      stock: 0
    };
  }

  //funcion para guardar elproducto en el arreglo
  agregarProducto(): void {
    //generamos un codigo automatico simple 
    const nuevoCodigo = `PROD-00${this.productos.length + 1}`;

    //agregamos una copia del producto al arreglo principal
    this.productos.push({
      ...this.nuevoProducto,
      codigo: nuevoCodigo
    });

    //Limpiamos el formulario para el siguiente registro
    this.prepararNuevoProducto();
  }

  //metodo editar: carga los datos seleccionados en el objeto temporal
  prepararEdicion(producto: Producto): void {
    this.modoEdicion = true;
    this.nuevoProducto = { ...producto };
  }

  //metodo para guardar los cambios del producto editado
  actualizarProducto(): void {
    const index = this.productos.findIndex(p => p.codigo === this.nuevoProducto.codigo);
    if (index !== -1) {
      this.productos[index] = { ...this.nuevoProducto };
    }

    this.prepararNuevoProducto();
  }

  //metodo eliminar producto por su codigo
  eliminarProducto(codigo: string): void {
    const confirmacion = confirm(`Estas seguro de eliminar el producto ${codigo}`);

    if (confirmacion) {
      //mantenemos en la lista solo los productos curyo codigo sea diferente al seleccionado
      this.productos = this.productos.filter(prod => prod.codigo !== codigo);
    }
  }
}