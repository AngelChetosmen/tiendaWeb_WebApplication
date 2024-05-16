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
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author josec
 */
@WebServlet(name = "InsertarProducto", urlPatterns = {"/InsertarProducto"})
public class InsertarProducto extends HttpServlet {

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
            out.println("<title>Insertar Producto</title>");
            out.println("<link href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css\" rel=\"stylesheet\" integrity=\"sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65\" crossorigin=\"anonymous\">");
            out.println("<script src='https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js' ></script>");
             out.println(" <link rel=\"stylesheet\" href=\"css\\style.css\">");
            out.println("</head>");
            out.println("<body>");
            
            out.println("<div id=\"particles-js\" class=\"animate__animated  animate__fadeIn  animate__slower\">");
            out.println("</div>");

            ProductoDAO dao = new ProductoDAO();
            Producto c = new Producto();

            String nombre= request.getParameter("nombre");
            String categoria = request.getParameter("cat");
            String desc = request.getParameter("description");
            int stock = Integer.parseInt(request.getParameter("stock"));
            float precio = Float.parseFloat(request.getParameter("precio"));
            
            c.setNombreProducto(nombre);
            c.setCategoriaProducto(categoria);
            c.setDescripcion(desc);
            c.setStock(stock);
            c.setPrecio((int) precio); 
            
            dao.insertarProducto(c);
            
            out.println(" <script src=\"js/particles.min.js\">");
            out.println("</script>");
            
             out.println("<script src=\"js/jQuery-3.6.3.min.js\">");
            out.println("</script>");
            out.println("<script src=\"//cdn.jsdelivr.net/npm/sweetalert2@11\">");
            out.println("</script>");
            out.println("<script src=\"js/insertado.js\">");
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
