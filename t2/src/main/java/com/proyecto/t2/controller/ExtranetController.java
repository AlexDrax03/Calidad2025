package com.proyecto.t2.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.proyecto.t2.model.entidad.Carrito;
import com.proyecto.t2.model.service.sistema.ICarritoService;

@Controller
@RequestMapping("/extranet")
public class ExtranetController {
    @Autowired
    ICarritoService iCarritoService;

    @RequestMapping("/")
    public String inicio_extranet(){
        return "cliente/extranet";
    }
    @RequestMapping("/pagot")
    public String pago_tarjeta(){
        return "cliente/extranet_pag_tarjeta";
    }
    @RequestMapping("/pagoe")
    public String pago_efectivo(){
        return "cliente/extranet_pag_efectivo";
    }
    @RequestMapping("/historial")
    public String extranet_historial(){
        return "cliente/extranet_historial";
    }
    @RequestMapping("/notificaciones")
    public String extranet_notificaciones(){
        return "cliente/extranet_notificaciones";
    }
    @RequestMapping("/reclamos")
    public String extranet_reclamos(){
        return "cliente/extranet_reclamos";
    }
    @RequestMapping("/actualizar")
    public String extranet_actu_datos(){
        return "cliente/extranet_actu_datos";
    }
    @RequestMapping("/boletas")
    public String extranet_boleta(){
        return "cliente/extranet_boleta";
    }
}
