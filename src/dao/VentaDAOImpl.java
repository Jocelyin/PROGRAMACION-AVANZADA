package dao;

import modelo.Venta;
import sqlconexion.ConexionBD;

import java.sql.*;
import java.time.LocalDateTime; // Necesario para convertir String a LocalDateTime si quieres parsear
import java.time.format.DateTimeFormatter; // Para parsear String a LocalDateTime
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

            
            LocalDateTime fechaHoraVenta = null;
            try {
              
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
                fechaHoraVenta = LocalDateTime.parse(venta.getFecha(), formatter);
            } catch (Exception e) {
                System.err.println("Error al parsear la fecha de la venta para DAO: " + venta.getFecha());
                e.printStackTrace();
               
                fechaHoraVenta = LocalDateTime.now();
            }

            statement.setTimestamp(1, Timestamp.valueOf(fechaHoraVenta));
            statement.setTime(2, Time.valueOf(fechaHoraVenta.toLocalTime())); 
            statement.setDouble(3, venta.getTotal()); 
            statement.setDouble(4, (double) venta.getMontoPagado()); 

            
            statement.executeUpdate();

            generatedKeys = statement.getGeneratedKeys();
            if (generatedKeys.next()) {
                idVentaGenerado = generatedKeys.getInt(1);
            }

        } catch (SQLException e) {
            System.err.println("Error SQL al crear venta: " + e.getMessage());
            e.printStackTrace();
        } finally {
            // Cierre de recursos en el orden inverso a su apertura
            try {
                if (generatedKeys != null) generatedKeys.close();
                if (statement != null) statement.close();
                if (connection != null) connection.close(); 
            } catch (SQLException ex) {
                System.err.println("Error al cerrar recursos en crearVenta: " + ex.getMessage());
                ex.printStackTrace();
            }
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
           
            String sql = "SELECT id_venta, fecha_venta, hora_venta, total_venta, monto_pagado FROM Ventas WHERE id_venta = ?";
            statement = connection.prepareStatement(sql);
            statement.setInt(1, idVenta);
            resultSet = statement.executeQuery();

            if (resultSet.next()) {
                venta = new Venta();
                venta.setIdVenta(resultSet.getInt("id_venta"));
               
                Timestamp timestamp = resultSet.getTimestamp("fecha_venta");
                Time time = resultSet.getTime("hora_venta"); 

                LocalDateTime ldt = timestamp.toLocalDateTime();
                
                if (time != null) {
                    ldt = ldt.withHour(time.toLocalTime().getHour())
                             .withMinute(time.toLocalTime().getMinute())
                             .withSecond(time.toLocalTime().getSecond());
                }
                venta.setFecha(ldt.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"))); 
                venta.setTotal(resultSet.getDouble("total_venta")); 
                venta.setMontoPagado(resultSet.getDouble("monto_pagado")); 
            }

        } catch (SQLException e) {
            System.err.println("Error SQL al obtener venta: " + e.getMessage());
            e.printStackTrace();
        } finally {
            try {
                if (resultSet != null) resultSet.close();
                if (statement != null) statement.close();
                if (connection != null) connection.close(); 
            } catch (SQLException ex) {
                System.err.println("Error al cerrar recursos en obtenerVenta: " + ex.getMessage());
                ex.printStackTrace();
            }
        }
        return venta;
    }

    @Override
    public List<Venta> obtenerTodasLasVentas() {
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

                Timestamp timestamp = resultSet.getTimestamp("fecha_venta");
                Time time = resultSet.getTime("hora_venta");

                LocalDateTime ldt = timestamp.toLocalDateTime();
                if (time != null) {
                    ldt = ldt.withHour(time.toLocalTime().getHour())
                             .withMinute(time.toLocalTime().getMinute())
                             .withSecond(time.toLocalTime().getSecond());
                }
                venta.setFecha(ldt.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"))); 
                venta.setTotal(resultSet.getDouble("total_venta"));
                venta.setMontoPagado(resultSet.getDouble("monto_pagado")); 
                ventas.add(venta);
            }

        } catch (SQLException e) {
            System.err.println("Error SQL al obtener todas las ventas: " + e.getMessage());
            e.printStackTrace();
        } finally {
            try {
                if (resultSet != null) resultSet.close();
                if (statement != null) statement.close();
                if (connection != null) connection.close(); 
            } catch (SQLException ex) {
                System.err.println("Error al cerrar recursos en obtenerTodasLasVentas: " + ex.getMessage());
                ex.printStackTrace();
            }
        }
        return ventas;
    }
}