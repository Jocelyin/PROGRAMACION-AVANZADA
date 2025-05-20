package dao;

import modelo.Venta;
import sqlconexion.ConexionBD;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class VentaDAOImpl implements VentaDAO {

    private final ConexionBD conexion;

    public VentaDAOImpl() {
        this.conexion = new ConexionBD();
    }

    @Override
    public int crearVenta(Venta venta) {
        int idVentaGenerado = -1;
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet generatedKeys = null;

        try {
            connection = conexion.obtenerConexion();
            String sql = "INSERT INTO Ventas (fecha_venta, hora_venta, total_venta, monto_pagado) VALUES (?, ?, ?, ?)";
            statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            statement.setTimestamp(1, Timestamp.valueOf(venta.getFechaVenta()));
            statement.setTime(2, Time.valueOf(venta.getFechaVenta().toLocalTime())); // Obtiene la hora del LocalDateTime
            statement.setDouble(3, venta.getTotalVenta());
            statement.setDouble(4, venta.getMontoPagado());

            // Mueve estas líneas AQUÍ, antes de executeUpdate()
            String sqlCompleta = "INSERT INTO Ventas (fecha_venta, hora_venta, total_venta, monto_pagado) VALUES ('" +
                                   Timestamp.valueOf(venta.getFechaVenta()) + "', '" +
                                   Time.valueOf(venta.getFechaVenta().toLocalTime()) + "', " +
                                   venta.getTotalVenta() + ", " +
                                   venta.getMontoPagado() + ")";
            System.out.println("SQL Completa para depuración: " + sqlCompleta);

            statement.executeUpdate(); // Ahora se ejecuta DESPUÉS de imprimir la consulta

            generatedKeys = statement.getGeneratedKeys();
            if (generatedKeys.next()) {
                idVentaGenerado = generatedKeys.getInt(1);
            }

        } catch (SQLException e) {
            e.printStackTrace();
            // Considerar lanzar una excepción personalizada en lugar de imprimir la traza
        } finally {
            if (generatedKeys != null) {
                try {
                    generatedKeys.close();
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
        return idVentaGenerado;
    }
    


    @Override
    public Venta obtenerVenta(int idVenta) {
        Venta venta = null;
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try {
            connection = conexion.obtenerConexion();
            String sql = "SELECT id_venta, fecha_venta, total_venta FROM Ventas WHERE id_venta = ?";
            statement = connection.prepareStatement(sql);
            statement.setInt(1, idVenta);
            resultSet = statement.executeQuery();

            if (resultSet.next()) {
                venta = new Venta();
                venta.setIdVenta(resultSet.getInt("id_venta"));
                venta.setFechaVenta(resultSet.getTimestamp("fecha_venta").toLocalDateTime());
                venta.setTotalVenta(resultSet.getDouble("total_venta"));
                // Si tuvieras la columna id_usuario, la podrías obtener aquí también
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
        return venta;
    }
    
    @Override
    public List<Venta> obtenerTodasLasVentas() {// en obtenerTodasLasVentas tambien me sale error
        List<Venta> ventas = new ArrayList<>();
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try {
            connection = conexion.obtenerConexion();
            String sql = "SELECT id_venta, fecha_venta, hora_venta, total_venta, monto_pagado FROM Ventas";
            statement = connection.prepareStatement(sql);
            resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Venta venta = new Venta();
                venta.setIdVenta(resultSet.getInt("id_venta"));
                venta.setFechaVenta(resultSet.getTimestamp("fecha_venta").toLocalDateTime());
                
                venta.setTotalVenta(resultSet.getDouble("total_venta"));
                venta.setMontoPagado(resultSet.getDouble("monto_pagado"));
                ventas.add(venta);
            }

        } catch (SQLException e) {
            e.printStackTrace();
            // Considerar lanzar una excepción personalizada
        } finally {
            // Cerrar recursos (resultSet, statement, connection) en bloques finally
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
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        }
        return ventas;
    }
}