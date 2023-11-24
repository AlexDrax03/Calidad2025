package com.proyecto.t2.model.service.sistema;

import java.util.List;

import com.proyecto.t2.model.entidad.Carrito;

public interface ICarritoService {
    public void guardarCarrito(Carrito carrito);
    public List <Carrito> mostrCarrito();
    public Carrito buscarCarrito(Long id);
    public void eliminarCarrito(Long id);
}
