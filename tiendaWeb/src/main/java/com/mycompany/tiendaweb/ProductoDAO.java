package com.mycompany.tiendaweb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ProductoDAO {

    private static final String SQL_INSERTAR
            = "insert into Producto(Nombre, Categoria, Descripcion, Stock, Precio) values (?, ?, ?, ?, ?)";
    private static final String SQL_UPDATE
            = "update Producto set Nombre = ?, Categoria = ? ,Descripcion = ?, Stock = ?, Precio = ? where idProducto = ?";
    private static final String SQL_DELETE = "delete from Producto where idProducto =?";
    private static final String SQL_SELECT = "select * from Producto where idProducto =?";
    private static final String SQL_SELECT_ALL = "select * from Producto";

    private Connection con;
    private static final Logger LOGGER = Logger.getLogger(ProductoDAO.class.getName());

    private void obtenerConexion() {
        String usuario = "root";
        String clave = "root";
        String url = "jdbc:mysql://localhost:3308/tiendita";
        String driver = "com.mysql.cj.jdbc.Driver";
        try {
            Class.forName(driver);
            con = DriverManager.getConnection(url, usuario, clave);
        } catch (ClassNotFoundException | SQLException ex) {
            LOGGER.log(Level.SEVERE, "Error al establecer la conexión a la base de datos", ex);
        }
    }

    public void insertarProducto(Producto c) {
        PreparedStatement ps = null;
        obtenerConexion();
        try {
            ps = con.prepareStatement(SQL_INSERTAR);
            ps.setString(1, c.getNombreProducto());
            ps.setString(2, c.getCategoriaProducto());
            ps.setString(3, c.getDescripcion());
            ps.setInt(4, c.getStock());
            ps.setFloat(5, c.getPrecio());
            ps.executeUpdate();
        } catch (SQLException ex) {
            LOGGER.log(Level.SEVERE, "Error al insertar el producto", ex);
        } finally {
            cerrarRecursos(ps, con);
        }
    }

    public void actualizarProducto(Producto c) {
        PreparedStatement ps = null;
        obtenerConexion();
        try {
            ps = con.prepareStatement(SQL_UPDATE);
            ps.setString(1, c.getNombreProducto());
            ps.setString(2, c.getCategoriaProducto());
            ps.setString(3, c.getDescripcion());
            ps.setInt(4, c.getStock());
            ps.setFloat(5, c.getPrecio());
            ps.setInt(6, c.getIdProducto());
            ps.executeUpdate();
        } catch (SQLException ex) {
            LOGGER.log(Level.SEVERE, "Error al actualizar el producto", ex);
        } finally {
            cerrarRecursos(ps, con);
        }
    }

    public void eliminarProducto(Producto c) {
        PreparedStatement ps = null;
        obtenerConexion();
        try {
            ps = con.prepareStatement(SQL_DELETE);
            ps.setInt(1, c.getIdProducto());
            ps.executeUpdate();
        } catch (SQLException ex) {
            LOGGER.log(Level.SEVERE, "Error al eliminar el producto", ex);
        } finally {
            cerrarRecursos(ps, con);
        }
    }

    public List<Producto> mostrarTodo() {
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Producto> resultados = new ArrayList<>();
        obtenerConexion();
        try {
            ps = con.prepareStatement(SQL_SELECT_ALL);
            rs = ps.executeQuery();
            resultados = obtenerResultados(rs);
        } catch (SQLException ex) {
            LOGGER.log(Level.SEVERE, "Error al mostrar todos los productos", ex);
        } finally {
            cerrarRecursos(rs, ps, con);
        }
        return resultados;
    }

    public Producto mostrarUno(Producto c) {
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Producto> resultados = new ArrayList<>();
        obtenerConexion();
        try {
            ps = con.prepareStatement(SQL_SELECT);
            ps.setInt(1, c.getIdProducto());
            rs = ps.executeQuery();
            resultados = obtenerResultados(rs);
            if (!resultados.isEmpty()) {
                return resultados.get(0);
            }
        } catch (SQLException ex) {
            LOGGER.log(Level.SEVERE, "Error al mostrar el producto", ex);
        } finally {
            cerrarRecursos(rs, ps, con);
        }
        return null;
    }

    private List<Producto> obtenerResultados(ResultSet rs) throws SQLException {
        List<Producto> resultados = new ArrayList<>();
        while (rs.next()) {
            Producto c = new Producto();
            c.setIdProducto(rs.getInt("idProducto"));
            c.setNombreProducto(rs.getString("Nombre"));
            c.setCategoriaProducto(rs.getString("Categoria"));
            c.setDescripcion(rs.getString("Descripcion"));
            c.setStock(rs.getInt("Stock"));
            c.setPrecio(rs.getInt("Precio"));
            resultados.add(c);
        }
        return resultados;
    }

    private void cerrarRecursos(AutoCloseable... recursos) {
        for (AutoCloseable recurso : recursos) {
            if (recurso != null) {
                try {
                    recurso.close();
                } catch (Exception ex) {
                    LOGGER.log(Level.SEVERE, "Error al cerrar los recursos", ex);
                }
            }
        }
    }

    public static void main(String[] args) {
        ProductoDAO dao = new ProductoDAO();
        try {
            List<Producto> productos = dao.mostrarTodo();
            for (Producto producto : productos) {
                System.out.println(producto);
            }
        } catch (Exception ex) {
            LOGGER.log(Level.SEVERE, "Error en la ejecución principal", ex);
        }
    }
}
