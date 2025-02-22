namespace Tarea05_Relog;
using System;

public partial class MainPage : ContentPage
{
    private long tiempoInicio;
    private long tiempoDetener;
    private double tiempoSalida;

    public MainPage()
    {
        InitializeComponent();
    }

    // Evento para el botón "INICIAR"
    private void OnIniciarClicked(object sender, EventArgs e)
    {
        tiempoInicio = DateTimeOffset.Now.ToUnixTimeMilliseconds(); // Tiempo actual en milisegundos
        EntryIniciar.Text = tiempoInicio.ToString();
        EntryDetener.Text = string.Empty;
        EntrySalida.Text = string.Empty;
    }//como se inicializa el texto de mi objeto, //

    // Evento para el botón "DETENER" 
    private void OnDetenerClicked(object sender, EventArgs e) 
    {
        tiempoDetener = DateTimeOffset.Now.ToUnixTimeMilliseconds();
        EntryDetener.Text = tiempoDetener.ToString();

        tiempoSalida = (tiempoDetener - tiempoInicio) / 1000.0; // Convertir milisegundos a segundos
        EntrySalida.Text = tiempoSalida.ToString("F2"); // Formato con 2 decimales
    }

    // Evento para el botón "SALIR"
    private void OnSalirClicked(object sender, EventArgs e)
    {
        Application.Current.Quit(); // Cierra la aplicación
    }
}
