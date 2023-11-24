package com.proyecto.t2.controller.sistema;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.proyecto.t2.model.entidad.Bebida;
import com.proyecto.t2.model.entidad.Carrito;
import com.proyecto.t2.model.entidad.Combo;
import com.proyecto.t2.model.service.sistema.ICarritoService;
import com.proyecto.t2.model.service.sistema.interfaces.IBebidaService;
import com.proyecto.t2.model.service.sistema.interfaces.IComboService;
import com.proyecto.t2.model.service.sistema.interfaces.IMenuService;
import com.proyecto.t2.model.service.sistema.interfaces.IPiqueoService;
import com.proyecto.t2.model.service.sistema.interfaces.IPolloService;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequestMapping("/extranet/carrito")
public class CarritoController {


    @Autowired
    private IBebidaService bebidaService;
    @Autowired
    private IComboService comboService;
    @Autowired
    private IMenuService iMenuService;
    @Autowired
    private IPiqueoService iPiqueoService;
    @Autowired
    private IPolloService iPolloService;
    @Autowired
    ICarritoService iCarritoService;

    @RequestMapping("/")
    public String inicio( Model model,RedirectAttributes flash){
       Carrito carrito =new Carrito();
        //LISTAR EN COMBOBOX DEL FORM
        model.addAttribute("carrito", carrito);
        model.addAttribute("listaBebidas", bebidaService.mostrBebidas());
        model.addAttribute("listaMenu", iMenuService.mostrarMenus());
        model.addAttribute("listaPiqueo", iPiqueoService.mostrarPiqueos());
        model.addAttribute("listaPollo", iPolloService.mostrarPollos());
        model.addAttribute("listaCombo", comboService.mostrarCombos());
        
    
        //LISTAR COMBOS REGISTRADOS EN LA TABLA INFERIOR
        model.addAttribute("listaCarrrito", iCarritoService.mostrCarrito());
      return "cliente/extranet_carrito";
    }
    
    @RequestMapping("/bebida")
    public String bebida(Carrito carrito, Model model,RedirectAttributes flash){
       
        //LISTAR EN COMBOBOX DEL FORM
        model.addAttribute("listaBebidas", bebidaService.mostrBebidas());
        
        
    
        //LISTAR COMBOS REGISTRADOS EN LA TABLA INFERIOR
        model.addAttribute("listaCarrrito", iCarritoService.mostrCarrito());

    
        return "cliente/extranet_carrito_be";
    
        
    }


    @RequestMapping("/menu")
    public String menu(Carrito carrito, Model model,RedirectAttributes flash){
         //LISTAR EN COMBOBOX DEL FORM
        
        model.addAttribute("listaMenu", iMenuService.mostrarMenus());

        
    
        //LISTAR COMBOS REGISTRADOS EN LA TABLA INFERIOR
        model.addAttribute("listaCarrrito", iCarritoService.mostrCarrito());

    
        return "cliente/extranet_carrito_me";
    }

     @RequestMapping("/piqueo")
    public String piqueo(Carrito carrito, Model model,RedirectAttributes flash){
         //LISTAR EN COMBOBOX DEL FORM

        model.addAttribute("listaPiqueo", iPiqueoService.mostrarPiqueos());
 
        
    
        //LISTAR COMBOS REGISTRADOS EN LA TABLA INFERIOR
        model.addAttribute("listaCarrrito", iCarritoService.mostrCarrito());

    
        return "cliente/extranet_carrito_pi";
    }

     @RequestMapping("/pollo")
    public String pollo(Carrito carrito, Model model,RedirectAttributes flash){
         //LISTAR EN COMBOBOX DEL FORM

        model.addAttribute("listaPollo", iPolloService.mostrarPollos());

        
    
        //LISTAR COMBOS REGISTRADOS EN LA TABLA INFERIOR
        model.addAttribute("listaCarrrito", iCarritoService.mostrCarrito());

    
        return "cliente/extranet_carrito_po";
    }

     @RequestMapping("/combo")
    public String combo(Carrito carrito, Model model,RedirectAttributes flash){
         //LISTAR EN COMBOBOX DEL FORM
        model.addAttribute("listaCombo", comboService.mostrarCombos());
        //LISTAR COMBOS REGISTRADOS EN LA TABLA INFERIOR
        model.addAttribute("listaCarrrito", iCarritoService.mostrCarrito());
        return "cliente/extranet_carrito_co";
    }


    @PostMapping(value="/bebida/guardarlas")
    public String guardar(Carrito carrito,RedirectAttributes flash,Bebida bebida) {
        if (carrito.getBebida() != null) {
            Long idBebida=carrito.getBebida().getId();
            String nomBebida=carrito.getBebida().getNombre();
            Double precioBebida =carrito.getBebida().getPrecio();
            if(idBebida==null && nomBebida==null && precioBebida==null){
                carrito.setBebida(null);
            }else{
                int canbebida=carrito.getCantidad();
                if(precioBebida != null){
                    
                    carrito.setNombre(carrito.getBebida().getNombre());
                    carrito.setPrecio(carrito.getBebida().getPrecio());
                    carrito.setSubtotal(precioBebida*canbebida);
                }else{
                    System.out.println("no hay");
                }
            }
        }
    String rpt = "Carrito Válido: " + carrito.getCantidad();
    flash.addFlashAttribute("mensaje", rpt);

    // Llama al servicio para guardar el carrito en la base de datos
    iCarritoService.guardarCarrito(carrito);
    
    return "redirect:/extranet/carrito/";
}

@RequestMapping("/eliminar/{id}")
public String eliminar(@PathVariable(value = "id") Long id,Carrito carrito ){
    iCarritoService.eliminarCarrito(id);
    return "redirect:/extranet/carrito/";
}
@PostMapping(value="/bebida/guardar")
    public String guardar(Carrito carrito,RedirectAttributes flash) {
        if(carrito.getBebida().getId()== null) carrito.setBebida(null);
        carrito.setNombre(carrito.getBebida().getNombre());
        carrito.setPrecio(carrito.getBebida().getPrecio());
        String rpt = "Se añádio el producto: "+carrito.getNombre();
        flash.addFlashAttribute("mensaje", rpt);
        
        iCarritoService.guardarCarrito(carrito);
        return "redirect:/extranet/carrito/";
    }
}