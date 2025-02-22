using System;

namespace a2233336156_tareas_unidad01
{
    public partial class MainPage : ContentPage
    {
        public MainPage()
        {
            InitializeComponent();
        }

        // Método para el botón "Calcular"
        private void OnCalcularClicked(object sender, EventArgs e)
        {
            // Datos del triángulo
            double baseTriangulo = 5;
            double alturaTriangulo = 2;

            // Cálculo del área
            double area = (baseTriangulo * alturaTriangulo) / 2;

            // Mostrar resultado
            ResultadoLabel.Text = $"El área del triángulo es: {area}";
        }
    }
}
