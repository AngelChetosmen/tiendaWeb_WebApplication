/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.mycompany.tiendaweb;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Admin
 */
@WebServlet(name = "ListaProductos", value = "/ListaProductos")
public class ListaProductos extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Listado de Escuelas</title>");
            out.println("<link href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css\" rel=\"stylesheet\" integrity=\"sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65\" crossorigin=\"anonymous\">");
            out.println("<script src='https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js' ></script>");
            out.println(" <link rel=\"stylesheet\" href=\"css\\style.css\">");
            out.println("<link rel=\"stylesheet\" href=\"https://cdnjs.cloudflare.com/ajax/libs/animate.css/4.1.1/animate.min.css\"/>");
            
            out.println("</head>");
            out.println("<body>");
            out.println("<div id=\"particles-js\" class=\"animate__animated  animate__fadeIn  animate__slower\">");
            out.println("</div>");
            
            
            
            
            out.println("<div class='container'>");
            out.println("<div class='mb-4 mt-4'></div>");
            
            out.println("<div class='card'>");
            out.println("<div class='card-header text-center text-primary'>");
            out.println("<h1 class='card-title' style='color:black;'>Listado de Productos</h1>");
            out.println("</div>");
            out.println("<div class='card-body text-primary'>");
            out.println("<table class='table table-striped'>");
            out.println("<tr>");
            out.println("<th>idProducto </th>");
            out.println("<th>Nombre </th>");
            out.println("<th>Categoria </th>");
            out.println("<th>Descripcion </th>");
            out.println("<th>Stock </th>");
            out.println("<th>Precio </th>"); 
            out.println("<th>Eliminar </th>");
            out.println("</tr>");
            
            
            ProductoDAO dao = new ProductoDAO();
            //Contenido implementado
            //Contenido Agregado para saber el problema de la recepción de datos
            List lista = dao.mostrarTodo();
            System.out.println("Lista recuperada: " + lista); // Esto mostrará la lista completa en tu consola
            if (lista == null || lista.isEmpty()) {
                System.out.println("La lista está vacía o es nula");
            } else {
                System.out.println("Número de productos recuperados: " + lista.size());
            }
            for(int i = 0; i < lista.size(); i++){
                Producto c = (Producto) lista.get(i);
                out.println("<tr>");
                out.println("<td>");
                out.println("<a href='MostrarProducto?id="+ c.getIdProducto()+"' class='btn btn-info'>"
                        + c.getIdProducto()+
                        "</a>");
                out.println("</td>");
                out.println("<td>"+ c.getNombreProducto()+"</td>");
                out.println("<td>"+ c.getCategoriaProducto()+"</td>");
                out.println("<td>"+ c.getDescripcion()+"</td>");
                out.println("<td>"+ c.getStock()+"</td>");
                out.println("<td>"+ c.getPrecio()+"</td>");
                out.println("<td>");
                out.println("<a href='EliminarProducto?id="+
                        c.getIdProducto()+"' class='btn btn-danger' id='Eliminar'>Eliminar</a>");
                out.println("</td>");
                out.println("</tr>");
                
                //out.println("<a href='index.html?id="+c.getIdProducto()+"' class='btn btn-success'>Actualizar</a>");
            }
            
            
            out.println("</table>");
            out.println("</div>");
            out.println("</div>");
            out.println("<hr>");
            out.println("<div class='card mt-5 mb-5'>");
            out.println("<div class='card-header text-center text-primary'>");
            out.println("<h1 class='card-title' style='color:black;' >ACCIONES</h1>");
            out.println("</div>");
            out.println("<div class='card-body text-primary'>");
            out.println("<table class='table table-striped'>");
            out.println("<tr>");
            out.println("<th class='centerText'> <center>Insertar Producto </center></th>");
            out.println("<th class = 'centerText'> <center>Actualizar Producto</center> </th>");
            
            out.println("</tr>");
            
            out.println("<td>");
            out.println("<center>");
            out.println("<a href='insertar.html' class='btn btn-primary col-xl-6 col-lg-6 col-md-6 col-sm-6 col-6 mb-6 mt-2 '>Insertar</a>");
            out.println("</center>");
 
            out.println("</td>");
            out.println("<td>");
            out.println("<center>");
            out.println("<a href='actualizar.html' class='btn btn-success col-xl-6 col-lg-6 col-md-6 col-sm-6 col-6 mb-6 mt-2'>Actualizar</a>");
            out.println("</center>");
            out.println("</td>");
            
            
            
            out.println("</div>");
            
            out.println(" <script src=\"js/particles.min.js\">");
            out.println("</script>");
            
            out.println("<script src=\"js/app.js\">");
            out.println("</script>");
            out.println("<script src=\"js/jQuery-3.6.3.min.js\">");
            out.println("</script>");
            out.println("<script src=\"//cdn.jsdelivr.net/npm/sweetalert2@11\">");
            out.println("</script>");
            out.println("<script src=\"js/sweetAlert.js\">");
            out.println("</script>");
            
            
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}