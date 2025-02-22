using Microsoft.Maui.Networking;
using System.Diagnostics;

namespace TAREA_10_NET_MAUII
public partial class MainPage : ContentPage
{
    public MainPage()
    {
        InitializeComponent();
        CheckConnectivity(); // Llamamos la función al iniciar
        Connectivity.Current.ConnectivityChanged += Connectivity_ConnectivityChanged;
    }

    private void CheckConnectivity()
    {
        if (Connectivity.Current.NetworkAccess == NetworkAccess.None)
        {
            Debug.WriteLine("No hay conexión a Internet.");
        }
        else
        {
            Debug.WriteLine("Conectado a Internet.");
        }
    }

    private void Connectivity_ConnectivityChanged(object sender, ConnectivityChangedEventArgs e)
    {
        Debug.WriteLine($"Conectividad Cambiada: {e.IsConnected}");
    }
}

