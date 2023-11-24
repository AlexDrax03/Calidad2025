package com.proyecto.t2.model.entidad;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="carrito")
public class Carrito {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IDCARRO")
    private Long id;
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "precio")
    private Double precio;
    @Column(name = "cantidad")
    private int cantidad;
    @Column(name = "subtotal")
    private Double subtotal;

   
    @ManyToOne
    @JoinColumn(name = "IDCombo")
    private Combo combo;
    
    @ManyToOne
    @JoinColumn(name= "IDBebida")
     Bebida bebida;

    @ManyToOne
    @JoinColumn(name= "IDMenu")
    private Menu menu;

    @ManyToOne
    @JoinColumn(name="IDPiqueo")
    private Piqueo piqueo;

    @ManyToOne
    @JoinColumn(name="IDPollo")
    private Pollo pollo;

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public int getCantidad() {
        return cantidad;
    }
    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
    public Double getPrecio() {
        return precio;
    }
    public void setPrecio(Double precio) {
        this.precio	 = precio;
    }
    public Double getSubtotal() {
        return subtotal;
    }
    public void setSubtotal(Double subtotal) {
        this.subtotal = subtotal;
    }
    
    
    public Bebida getBebida() {
        return bebida;
    }
    public void setBebida(Bebida bebida) {
        this.bebida = bebida;
    }
    public Menu getMenu() {
        return menu;
    }
    public void setMenu(Menu menu) {
        this.menu = menu;
    }
    public Piqueo getPiqueo() {
        return piqueo;
    }
    public void setPiqueo(Piqueo piqueo) {
        this.piqueo = piqueo;
    }
    public Pollo getPollo() {
        return pollo;
    }
    public void setPollo(Pollo pollo) {
        this.pollo = pollo;
    }
    public Combo getCombo(){
        return combo;
    }
    public void setCombo(Combo combo){
        this.combo = combo;
    }
}
