/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tiendaweb;

import java.io.Serializable;

/**
 *
 * @author darkdestiny
 */
public class Producto implements Serializable{
    private int idProducto;
    private String nombreProducto;
    private String categoriaProducto; 
    private String descripcion;
    private int stock;
    private int precio;
    
    
    public Producto(){
        
    }
    
    public int getIdProducto(){
        return idProducto;
    }
    
    public void setIdProducto(int idProducto){
        this.idProducto = idProducto;
    }
    
    public String getNombreProducto(){
        return nombreProducto;
    }
    
    public void setNombreProducto(String nombreProducto){
        this.nombreProducto = nombreProducto;
    }

    public void setCategoriaProducto(String categoriaProducto) {
        this.categoriaProducto = categoriaProducto;
    }

    public String getCategoriaProducto() {
        return categoriaProducto;
    }
    
    
    
    public String getDescripcion(){
        return descripcion;
    }
    
    public void setDescripcion(String descripcion){
        this.descripcion = descripcion;
    }
    
    public int getStock(){
        return stock;
    }
    
    public void setStock(int stock){
        this.stock = stock;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }
    
    
    
    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("Clave = ").append(idProducto).append("\n");
        sb.append("Nombre = ").append(getNombreProducto()).append("\n");
        sb.append("Categoria = ").append(getCategoriaProducto()).append("\n");
        sb.append("Descripción = ").append(descripcion).append("\n");
        sb.append("Stock = ").append(getStock()).append("\n");
         sb.append("Precio = ").append(getPrecio()).append("\n");
         
        return sb.toString();
    }

    void setNombre(String string) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    void setCategoria(String string) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
