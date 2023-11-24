package com.proyecto.t2.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.proyecto.t2.model.dao.ICarritoDAO;
import com.proyecto.t2.model.entidad.Carrito;
import com.proyecto.t2.model.service.sistema.ICarritoService;



@Service
public class CarritoServiceImp implements ICarritoService {
   @Autowired
    private ICarritoDAO carritoDAO;
   
    @Override
    @Transactional
    public void guardarCarrito(Carrito carrito) {
        carritoDAO.save(carrito);
    }
    @Override
    public List<Carrito> mostrCarrito() {
       return (List<Carrito>)carritoDAO.findAll();
    }
    @Override
    public Carrito buscarCarrito(Long id) {
        return carritoDAO.findById(id).orElse(null);
    }
    @Override
    public void eliminarCarrito(Long id) {
        carritoDAO.deleteById(id);        
    }
   
        
}
