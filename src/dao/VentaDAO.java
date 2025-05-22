package dao;

import java.util.List;

import modelo.Venta;

public interface VentaDAO {
    /**
     * Guarda una nueva venta en la base de datos.
     *
     * @param venta El objeto Venta a guardar.
     * @return El ID de la venta generada por la base de datos, o -1 si falla.
     */
    int crearVenta(Venta venta);

    /**
     * Obtiene una venta por su ID.
     *
     * @param idVenta El ID de la venta a buscar.
     * @return El objeto Venta correspondiente, o null si no se encuentra.
     */
    Venta obtenerVenta(int idVenta);
    
    List<Venta> obtenerTodasLasVentas();

    
}