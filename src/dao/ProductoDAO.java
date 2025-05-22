package dao;

import modelo.Producto;
import java.util.List;

public interface ProductoDAO {
    // Método para agregar un nuevo producto a la base de datos
    boolean agregarProducto(Producto producto);

    // Método para obtener un producto por su código
    Producto obtenerProducto(String codigoProducto);

    // Método para actualizar la información de un producto existente
    boolean actualizarProducto(Producto producto);

    // Método para eliminar un producto por su código
    boolean eliminarProducto(String codigoProducto);

    // Método para obtener todos los productos
    List<Producto> obtenerTodosProductos();

    // Método para actualizar el stock de un producto
    boolean actualizarStock(String codigoProducto, int nuevoStock);

    // Método para actualizar el precio de venta de un producto
    boolean actualizarPrecioVenta(String codigoProducto, double nuevoPrecioVenta);

    // Método para obtener los productos con bajo stock
    List<Producto> obtenerProductosBajoStock();
}
