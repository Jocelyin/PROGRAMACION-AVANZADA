package modelo;

import java.time.LocalDateTime;

public class Venta {
    private int idVenta;
    private LocalDateTime fechaVenta;
    private double totalVenta;
    private double montoPagado; // Agrega este atributo
    private int idUsuario; // Por ahora, lo incluimos aunque no tengamos la funcionalidad de usuario

    // Constructor por defecto
    public Venta() {
        this.fechaVenta = LocalDateTime.now();
    }

    // Constructor con total y usuario (si aplica)
    public Venta(double totalVenta, double montoPagado, int idUsuario) { // Modifica el constructor
        this.fechaVenta = LocalDateTime.now();
        this.totalVenta = totalVenta;
        this.montoPagado = montoPagado; // Inicializa montoPagado
        this.idUsuario = idUsuario;
    }

    // Getters y Setters
    public int getIdVenta() {
        return idVenta;
    }

    public void setIdVenta(int idVenta) {
        this.idVenta = idVenta;
    }

    public LocalDateTime getFechaVenta() {
        return fechaVenta;
    }

    public void setFechaVenta(LocalDateTime fechaVenta) {
        this.fechaVenta = fechaVenta;
    }

    public double getTotalVenta() {
        return totalVenta;
    }

    public void setTotalVenta(double totalVenta) {
        this.totalVenta = totalVenta;
    }

    // Getter y Setter para montoPagado
    public double getMontoPagado() {
        return montoPagado;
    }

    public void setMontoPagado(double montoPagado) {
        this.montoPagado = montoPagado;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    @Override
    public String toString() {
        return "Venta{" +
               "idVenta=" + idVenta +
               ", fechaVenta=" + fechaVenta +
               ", totalVenta=" + totalVenta +
               ", montoPagado=" + montoPagado + // Incluye montoPagado en toString
               ", idUsuario=" + idUsuario +
               '}';
    }
}