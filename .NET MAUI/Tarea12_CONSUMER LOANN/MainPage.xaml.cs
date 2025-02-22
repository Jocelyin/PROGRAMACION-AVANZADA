using Microsoft.Maui.Controls;
using System;

namespace TAREA_12_CONSUMER_LOAN
{
    public partial class MainPage : ContentPage
    {
        public MainPage()
        {
            InitializeComponent();

            // Manejo de eventos
            botonCalcular.Clicked += OnCalcularClicked;
            botonNuevoAnalisis.Clicked += OnNuevoAnalisisClicked;
            botonSalir.Clicked += OnSalirClicked;
            botonCambiarModo.Clicked += OnCambiarModoClicked;
        }

        private void OnCalcularClicked(object sender, EventArgs e)
        {
            try
            {
                double saldo = double.Parse(campoSaldoPrestamo.Text);
                double tasaInteres = double.Parse(campoTasaInteres.Text.Replace("%", "").Trim());

                if (tasaInteres == 0)
                {
                    areaAnalisis.Text = "Error: La tasa de interés no puede ser 0.";
                    return;
                }

                if (modoCalcularPago)
                {
                    int meses = int.Parse(campoNumeroPagos.Text);
                    double interesMensual = tasaInteres / 12.0;
                    double pago = saldo * (interesMensual / (1 - Math.Pow(1 + interesMensual, -meses)));
                    areaAnalisis.Text = "Pago Mensual: " + pago.ToString("F2");
                }
                else
                {
                    double pago = double.Parse(campoPagoMensual.Text);
                    double interesMensual = tasaInteres / 12.0;
                    if (pago <= saldo * interesMensual)
                    {
                        areaAnalisis.Text = "Error: El pago debe ser mayor que los intereses.";
                        return;
                    }
                    int meses = (int)(Math.Log(pago / (pago - saldo * interesMensual)) / Math.Log(1 + interesMensual));
                    areaAnalisis.Text = "Número de Pagos: " + meses;
                }
            }
            catch (Exception ex)
            {
                areaAnalisis.Text = "Error: Ingrese valores numéricos válidos.";
            }
        }

        private void OnNuevoAnalisisClicked(object sender, EventArgs e)
        {
            areaAnalisis.Text = "";
        }

        private void OnSalirClicked(object sender, EventArgs e)
        {
            System.Environment.Exit(0);
        }

        private void OnCambiarModoClicked(object sender, EventArgs e)
        {
            modoCalcularPago = !modoCalcularPago;
            botonCalcular.Text = modoCalcularPago ? "Calcular Pago Mensual" : "Calcular Número de Pagos";
            campoNumeroPagos.IsEnabled = modoCalcularPago;
            campoPagoMensual.IsEnabled = !modoCalcularPago;
        }

        private bool modoCalcularPago = true;
    }
}
