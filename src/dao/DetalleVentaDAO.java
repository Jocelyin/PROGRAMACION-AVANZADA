package dao;

import modelo.DetalleVenta;
import java.util.List;

public interface DetalleVentaDAO {
    /**
     * Guarda un detalle de venta en la base de datos.
     *
     * @param detalleVenta El objeto DetalleVenta a guardar.
     * @return true si se guardó correctamente, false en caso contrario.
     */
    boolean guardarDetalleVenta(DetalleVenta detalleVenta);

    /**
     * Obtiene todos los detalles de venta asociados a un ID de venta.
     *
     * @param idVenta El ID de la venta para la que se buscan los detalles.
     * @return Una lista de objetos DetalleVenta, o una lista vacía si no hay detalles.
     */
    List<DetalleVenta> obtenerDetallesPorVenta(int idVenta);


}