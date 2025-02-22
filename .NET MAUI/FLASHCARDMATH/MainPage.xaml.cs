using System;
using System.Timers;
using Microsoft.Maui.Controls;
using Timer = System.Timers.Timer;

namespace FlashCardMathApp
{
    public partial class MainPage : ContentPage
    {
        private Label lblIntentos, lblCorrectos, lblPregunta, lblTemporizador;
        private Entry txtRespuesta;
        private Button btnIniciar, btnSalir;
        private CheckBox chkSuma, chkResta, chkMultiplicacion, chkDivision;
        private RadioButton temporizadorApagado, temporizadorArriba, temporizadorAbajo;
        private Random random = new Random();
        private int num1, num2, respuesta, intentos = 0, correctos = 0;
        private Timer temporizador;
        private int contadorTiempo = 0;

        public MainPage()
        {
            lblIntentos = new Label { Text = "Intentos: 0", BackgroundColor = Colors.Red, TextColor = Colors.White };
            lblCorrectos = new Label { Text = "Correctos: 0", BackgroundColor = Colors.Red, TextColor = Colors.White };
            lblTemporizador = new Label { Text = "Tiempo: 0s", BackgroundColor = Colors.Red, TextColor = Colors.White };
            lblPregunta = new Label { Text = "", FontSize = 24, HorizontalOptions = LayoutOptions.Center };
            txtRespuesta = new Entry { Placeholder = "Tu respuesta", Keyboard = Keyboard.Numeric };

            btnIniciar = new Button { Text = "Iniciar Práctica" };
            btnSalir = new Button { Text = "Salir" };
            EventHandler 
                iniciarPractica = IniciarPractica;
            btnIniciar.Clicked += iniciarPractica;
            btnSalir.Clicked += (s, e) => Application.Current.Quit();
            txtRespuesta.Completed += VerificarRespuesta;

            chkSuma = new CheckBox { BindingContext = "Suma", IsChecked = true };
            chkResta = new CheckBox { BindingContext = "Resta" };
            chkMultiplicacion = new CheckBox { BindingContext = "Multiplicación" };
            chkDivision = new CheckBox { BindingContext = "División" };


            temporizadorApagado = new RadioButton { Content = "Apagado", IsChecked = true };
            temporizadorArriba = new RadioButton { Content = "Contar Arriba" };
            temporizadorAbajo = new RadioButton { Content = "Contar Abajo" };

            temporizador = new Timer(1000);
            temporizador.Elapsed += (s, e) => Device.BeginInvokeOnMainThread(() => lblTemporizador.Text = $"Tiempo: {++contadorTiempo}s");

            Content = new VerticalStackLayout
            {
                Padding = 20,
                Children = {
                    new HorizontalStackLayout { Children = { lblIntentos, lblCorrectos, lblTemporizador } },
                    lblPregunta,
                    new VerticalStackLayout { Children = { chkSuma, chkResta, chkMultiplicacion, chkDivision } },
                    new VerticalStackLayout { Children = { temporizadorApagado, temporizadorArriba, temporizadorAbajo } },
                    txtRespuesta,
                    new HorizontalStackLayout { Children = { btnIniciar, btnSalir } }
                }
            };
        }

        private void IniciarPractica(object sender, EventArgs e)
        {
            num1 = random.Next(1, 11);
            num2 = random.Next(1, 11);
            if (chkSuma.IsChecked)
            {
                lblPregunta.Text = $"{num1} + {num2} = ?";
                respuesta = num1 + num2;
            }
            else if (chkResta.IsChecked)
            {
                lblPregunta.Text = $"{num1} - {num2} = ?";
                respuesta = num1 - num2;
            }
            else if (chkMultiplicacion.IsChecked)
            {
                lblPregunta.Text = $"{num1} * {num2} = ?";
                respuesta = num1 * num2;
            }
            else if (chkDivision.IsChecked)
            {
                lblPregunta.Text = $"{num1} / {num2} = ?";
                respuesta = num1 / num2;
            }
            contadorTiempo = 0;
            temporizador.Start();
        }

        private void VerificarRespuesta(object sender, EventArgs e)
        {
            if (int.TryParse(txtRespuesta.Text, out int respuestaUsuario))
            {
                intentos++;
                if (respuestaUsuario == respuesta) correctos++;
                lblIntentos.Text = $"Intentos: {intentos}";
                lblCorrectos.Text = $"Correctos: {correctos}";
                txtRespuesta.Text = "";
                IniciarPractica(null, null);
            }
        }

        private void OnCounterClicked(object sender, EventArgs e)
        {
            
            CounterBtn.Text = "Clicked!";
        }
    }
}
