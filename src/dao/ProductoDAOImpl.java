package dao;

import modelo.Producto;
import sqlconexion.ConexionBD;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductoDAOImpl implements ProductoDAO {

    private Connection conexion;

    public ProductoDAOImpl() {
        this.conexion = ConexionBD.obtenerConexion();
    }

    @Override
    public boolean agregarProducto(Producto producto) {
        String sql = "INSERT INTO Productos (codigo_producto, nombre, precio_venta, stock, limite_stock) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement pstmt = conexion.prepareStatement(sql)) {
            pstmt.setString(1, producto.getCodigoProducto());
            pstmt.setString(2, producto.getNombre());
            pstmt.setDouble(3, producto.getPrecioVenta());
            pstmt.setInt(4, producto.getStock());
            pstmt.setInt(5, producto.getLimiteStock());
            int filasAfectadas = pstmt.executeUpdate();
            return filasAfectadas > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public Producto obtenerProducto(String codigoProducto) {
        String sql = "SELECT nombre, precio_venta, stock, limite_stock FROM Productos WHERE codigo_producto = ?";
        try (PreparedStatement pstmt = conexion.prepareStatement(sql)) {
            pstmt.setString(1, codigoProducto);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                Producto producto = new Producto();
                producto.setCodigoProducto(codigoProducto);
                producto.setNombre(rs.getString("nombre"));
                producto.setPrecioVenta(rs.getDouble("precio_venta"));
                producto.setStock(rs.getInt("stock"));
                producto.setLimiteStock(rs.getInt("limite_stock"));
                return producto;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean actualizarProducto(Producto producto) {
        String sql = "UPDATE Productos SET nombre = ?, precio_venta = ?, stock = ?, limite_stock = ? WHERE codigo_producto = ?";
        try (PreparedStatement pstmt = conexion.prepareStatement(sql)) {
            pstmt.setString(1, producto.getNombre());
            pstmt.setDouble(2, producto.getPrecioVenta());
            pstmt.setInt(3, producto.getStock());
            pstmt.setInt(4, producto.getLimiteStock());
            pstmt.setString(5, producto.getCodigoProducto());
            int filasAfectadas = pstmt.executeUpdate();
            return filasAfectadas > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean eliminarProducto(String codigoProducto) {
        String sql = "DELETE FROM Productos WHERE codigo_producto = ?";
        try (PreparedStatement pstmt = conexion.prepareStatement(sql)) {
            pstmt.setString(1, codigoProducto);
            int filasAfectadas = pstmt.executeUpdate();
            return filasAfectadas > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public List<Producto> obtenerTodosProductos() {
        List<Producto> productos = new ArrayList<>();
        String sql = "SELECT codigo_producto, nombre, precio_venta, stock, limite_stock FROM Productos";
        try (PreparedStatement pstmt = conexion.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {
            while (rs.next()) {
                Producto producto = new Producto();
                producto.setCodigoProducto(rs.getString("codigo_producto"));
                producto.setNombre(rs.getString("nombre"));
                producto.setPrecioVenta(rs.getDouble("precio_venta"));
                producto.setStock(rs.getInt("stock"));
                producto.setLimiteStock(rs.getInt("limite_stock"));
                productos.add(producto);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return productos;
    }

    @Override
    public boolean actualizarStock(String codigoProducto, int nuevoStock) {
        String sql = "UPDATE Productos SET stock = ? WHERE codigo_producto = ?";
        try (PreparedStatement pstmt = conexion.prepareStatement(sql)) {
            pstmt.setInt(1, nuevoStock);
            pstmt.setString(2, codigoProducto);
            int filasAfectadas = pstmt.executeUpdate();
            return filasAfectadas > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean actualizarPrecioVenta(String codigoProducto, double nuevoPrecioVenta) {
        String sql = "UPDATE Productos SET precio_venta = ? WHERE codigo_producto = ?";
        try (PreparedStatement pstmt = conexion.prepareStatement(sql)) {
            pstmt.setDouble(1, nuevoPrecioVenta);
            pstmt.setString(2, codigoProducto);
            int filasAfectadas = pstmt.executeUpdate();
            return filasAfectadas > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public List<Producto> obtenerProductosBajoStock() {
        List<Producto> productosBajoStock = new ArrayList<>();
        String sql = "SELECT codigo_producto, nombre, precio_venta, stock, limite_stock FROM Productos WHERE stock <= limite_stock";
        try (PreparedStatement pstmt = conexion.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {
            while (rs.next()) {
                Producto producto = new Producto();
                producto.setCodigoProducto(rs.getString("codigo_producto"));
                producto.setNombre(rs.getString("nombre"));
                producto.setPrecioVenta(rs.getDouble("precio_venta"));
                producto.setStock(rs.getInt("stock"));
                producto.setLimiteStock(rs.getInt("limite_stock"));
                productosBajoStock.add(producto);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return productosBajoStock;
    }
}
