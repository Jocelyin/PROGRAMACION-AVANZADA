package dao;

import modelo.DetalleVenta;
import sqlconexion.ConexionBD;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DetalleVentaDAOImpl implements DetalleVentaDAO {

    private final ConexionBD conexion;

    public DetalleVentaDAOImpl() {
        this.conexion = new ConexionBD();
    }

    @Override
    public boolean guardarDetalleVenta(DetalleVenta detalleVenta) {
        boolean guardado = false;
        Connection connection = null;
        PreparedStatement statement = null;

        try {
            connection = conexion.obtenerConexion();
            String sql = "INSERT INTO Detalle_Ventas (id_venta, codigo_producto, cantidad, precio_unitario) VALUES (?, ?, ?, ?)";
            statement = connection.prepareStatement(sql);
            statement.setInt(1, detalleVenta.getIdVenta());
            statement.setString(2, detalleVenta.getCodigoProducto());
            statement.setInt(3, detalleVenta.getCantidad());
            statement.setDouble(4, detalleVenta.getPrecioUnitario());
            
            int filasAfectadas = statement.executeUpdate();
            if (filasAfectadas > 0) {
                guardado = true;
            }

        } catch (SQLException e) {
            e.printStackTrace();
            // Considerar lanzar una excepción personalizada
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
            // La conexión no se cierra aquí
        }
        return guardado;
    }

    @Override
    public List<DetalleVenta> obtenerDetallesPorVenta(int idVenta) {
        List<DetalleVenta> detalles = new ArrayList<>();
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try {
            connection = conexion.obtenerConexion();
            String sql = "SELECT id_detalle, codigo_producto, cantidad, precio_unitario, precio_total FROM DetallesVenta WHERE id_venta = ?";
            statement = connection.prepareStatement(sql);
            statement.setInt(1, idVenta);
            resultSet = statement.executeQuery();

            while (resultSet.next()) {
                DetalleVenta detalle = new DetalleVenta();
                detalle.setIdDetalle(resultSet.getInt("id_detalle"));
                detalle.setIdVenta(idVenta);
                detalle.setCodigoProducto(resultSet.getString("codigo_producto"));
                detalle.setCantidad(resultSet.getInt("cantidad"));
                detalle.setPrecioUnitario(resultSet.getDouble("precio_unitario"));
                detalle.setPrecioTotal(resultSet.getDouble("precio_total"));
                detalles.add(detalle);
            }

        } catch (SQLException e) {
            e.printStackTrace();
            // Considerar lanzar una excepción personalizada
        } finally {
            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
            // La conexión no se cierra aquí
        }
        return detalles;
    }
}