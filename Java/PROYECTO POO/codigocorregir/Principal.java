package codigocorregir;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Principal {
    
    static String[][] productos;
    static String ventas[][];
    static int tamventas = 100;
    static String fecha;

    public static String MostrarMenu(String[] opciones) {
        String cadena = "";
        for (String info : opciones) {
            cadena = cadena + info + "\n";
        }
        return cadena;
    }

    public static boolean EsNumeroEntero(String dato) {
        for (char c : dato.toCharArray()) {
            if (!Character.isDigit(c)) {
                return false;
            }
        }
        return true;
    }

    public static boolean EsNumeroDouble(String dato) {
        boolean valido = false;
        for (char c : dato.toCharArray()) {
            if (!Character.isDigit(c)) {
                if (c == '.' && !valido) {
                    valido = true;
                } else {
                    return false;
                }
            }
        }
        return valido;
    }

    public static boolean EvaluarNumerico(String dato, int tipo) {
        boolean valido = false;
        switch (tipo) {
            case 1:
                valido = EsNumeroEntero(dato);
                break;
            case 2:
                valido = EsNumeroDouble(dato);
                break;
        }
        return valido;
    }

    public static String Dialogo(String texto) throws IOException {
        String cadena;
        System.out.println(texto + " : ");
        BufferedReader lectura = new BufferedReader(new InputStreamReader(System.in));
        cadena = lectura.readLine();
        return cadena;
    }

    public static String Leer(String texto) throws IOException {
        String cadena = "";
        cadena = Dialogo(texto);
        if (cadena != null) {
            cadena = cadena.trim();
            if (cadena.isEmpty()) {
                cadena = null;
            }
        } else {
            cadena = null;
        }
        return cadena;
    }

    public static String DesplegarMenu(String Titulo1, String[] menu) throws IOException {
        String cadena;
        cadena = Titulo1 + "\n" + "\n";
        cadena = cadena + MostrarMenu(menu);
        cadena = cadena + "\n Que opcion deseas ";
        return cadena = Dialogo(cadena);
    }

    public static String RellenarEspacios(String dato, int tamano) {
        return String.format("%1$-" + tamano + "s", dato);
    }

    public static String Fecha() {
        Date fecha = new Date();
        SimpleDateFormat formatodia = new SimpleDateFormat("dd-MM-yyyy");
        return formatodia.format(fecha);
    }

    public static String IdTicketSiguiente(String idticket) {
        String idticketnext = "";
        int num = Integer.parseInt(idticket) + 1;
        if (num < 10) {
            idticketnext = "00" + String.valueOf(num).trim();
        } else if ((num > 9) && (num < 100)) {
            idticketnext = "0" + String.valueOf(num).trim();
        } else {
            idticketnext = String.valueOf(num).trim();
        }
        return idticketnext;
    }

    public static int ObtenerUltimaPosicion(String[][] matriz) {
        int ultimaPosicion = -1;
        for (int i = 0; i < matriz.length; i++) {
            if (matriz[i][0] != null && !matriz[i][0].isEmpty()) {
                ultimaPosicion = i;
            }
        }
        return ultimaPosicion;
    }

    public static String[][] CargarProductos() {
        String[][] producto = {
            {"001", "Arroz 1kg", "35", "10"},
            {"002", "Azúcar 1kg", "25", "10"},
            {"003", "Harina 1kg", "28", "10"},
            {"004", "Aceite 1L", "50", "10"},
            {"005", "Leche 1L", "35", "10"},
            {"006", "Huevos 12 unidades", "45", "10"},
            {"007", "Fideos 500g", "20", "10"},
            {"008", "Sal 1kg", "15", "10"},
            {"009", "Pasta de tomate 400g", "25", "10"},
            {"010", "Atún lata 170g", "35", "10"}
        };
        return producto;
    }

    public static String MostrarProducto(String[] vproducto) {
        String codigo = RellenarEspacios(vproducto[0], 5);
        String producto = RellenarEspacios(vproducto[1], 30);
        String precio = RellenarEspacios(vproducto[2], 10);
        String cantidad = RellenarEspacios(vproducto[3], 10);
        String cadena = codigo.concat(producto + precio + cantidad);
        return cadena;
    }

    public static String MostrarLista(String[][] vproductos) {
        String salida = "";
        for (int ciclo = 0; ciclo < 10; ciclo++) {
            String[] vproducto = {vproductos[ciclo][0], vproductos[ciclo][1], vproductos[ciclo][2], vproductos[ciclo][3]};
            String cadena = MostrarProducto(vproducto);
            salida = salida.concat(cadena + "\n");
        }
        return salida;
    }

    public static int ExisteProducto(String codigo, String[][] vproductos) {
        int enc = -1;
        int pos = 0;
        int tam = vproductos.length;
        for (int ciclo = 0; ciclo < tam; ciclo++) {
            if (vproductos[ciclo][0].compareTo(codigo.trim()) == 0) {
                enc = pos;
                break;
            }
            pos++;
        }
        return enc;
    }

    public static void ModificarProducto(String[][] vproductos) throws IOException {
        String codigo, precio;
        int posicion;
        String info = MostrarLista(vproductos);
        codigo = Leer(info + "\nIntroduce el codigo del producto a modificar");
        if (codigo != null) {
            posicion = ExisteProducto(codigo, vproductos);
            if (posicion > -1) {
                String[] vproducto = {vproductos[posicion][0], vproductos[posicion][1], vproductos[posicion][2], vproductos[posicion][3]};
                precio = Leer("\nIntroduce el precio de " + MostrarProducto(vproducto) + " ");
                if (precio != null) {
                    if (EvaluarNumerico(precio, 2) || EvaluarNumerico(precio, 1)) {
                        vproductos[posicion][2] = precio;
                    } else {
                        System.out.println("no es un valor numerico");
                    }
                } else {
                    System.out.println("dato nulo");
                }
            } else {
                System.out.println("no existe el codigo");
            }
        } else {
            System.out.println("dato nulo");
        }
    }

    public static void MenuProductos(String[][] vproductos) throws IOException {
        String[] datosmenuproductos = {"1. - Modificar ", "2. - Listado ", "3. - Salida "};
        String opcion = "0";
        do {
            opcion = DesplegarMenu("Opciones de Productos", datosmenuproductos);
            if (opcion == null) {
                System.out.println("opcion incorrecta ");
            } else {
                switch (opcion) {
                    case "1":
                        ModificarProducto(vproductos);
                        break;
                    case "2":
                        System.out.println(MostrarLista(vproductos));
                        break;
                    case "3":
                        System.out.println("Salida del Sistema ");
                        break;
                    default:
                        System.out.println("No existe esta opcion ");
                        break;
                }
            }
        } while (opcion.compareTo("3") != 0);
    }

    public static String[][] CrearVenta() {
        return new String[tamventas][5];
    }

    public static String UltimoTicket(int pos, String[][] mventa) {
        String idticket = "000";
        if (pos > -1) {
            idticket = mventa[pos][0];
        }
        return idticket;
    }

    public static String[][] CrearTicket() {
        return new String[20][4];
    }

    public static int ExisteTicketCodigo(String[][] mticket, String codigo) {
        int enc = -1;
        int pos = ObtenerUltimaPosicion(mticket);
        System.out.println(" buscando " + codigo + " tamaño arreglo " + pos);
        for (int ciclo = 0; ciclo <= pos; ciclo++) {
            if (mticket[ciclo][0].compareTo(codigo.trim()) == 0) {
                enc = ciclo;
                return enc;
            }
        }
        return enc;
    }

    public static boolean InsertarProductoTicket(String[][] mticket, String[] datos, int tamticket) {
        boolean sucedio = true;
        int posticket = ObtenerUltimaPosicion(mticket);
        int enc = ExisteTicketCodigo(mticket, datos[0]);
        if (posticket < tamticket) {
            if (enc > -1) {
                System.out.println("ya existe el producto en el ticket lo incrementare");
                int cantidadactual = Integer.parseInt(mticket[enc][3]);
                mticket[enc][3] = String.valueOf(cantidadactual + 1);
            } else {
                posticket++;
                mticket
                posticket++;
                mticket[posticket][0] = datos[0];
                mticket[posticket][1] = datos[1];
                mticket[posticket][2] = datos[2];
                mticket[posticket][3] = datos[3];
                System.out.println("Insertarndo No existe el producto en el ticket ");
            }
        } else {
            sucedio = false;
        }
        return sucedio;
    }

    public static String TotalProducto(String precio, String cantidad) {
        double total = Double.parseDouble(precio) * Double.parseDouble(cantidad);
        return String.format("%.2f", total);
    }

    public static String MostrarProductoTicket(String[][] mticket, int pos) {
        String codigo = RellenarEspacios(mticket[pos][0], 5);
        String producto = RellenarEspacios(mticket[pos][1], 30);
        String precio = RellenarEspacios(mticket[pos][2], 10);
        String cantidad = RellenarEspacios(mticket[pos][3], 5);
        String totalproducto = RellenarEspacios(TotalProducto(mticket[pos][2], mticket[pos][3]), 10);
        String cadena = codigo.concat(producto + precio + cantidad + totalproducto);
        return cadena;
    }

    public static String MostrarTicket(String[][] mticket) {
        String salida = "";
        int pos = ObtenerUltimaPosicion(mticket);
        for (int ciclo = 0; ciclo <= pos; ciclo++) {
            salida = salida.concat(MostrarProductoTicket(mticket, ciclo) + "\n");
        }
        return salida;
    }

    public static double SubTotalTicket(String[][] mticket) {
        double subtotal = 0;
        int pos = ObtenerUltimaPosicion(mticket);
        for (int ciclo = 0; ciclo <= pos; ciclo++) {
            subtotal = subtotal + Double.parseDouble(TotalProducto(mticket[ciclo][2], mticket[ciclo][3]));
        }
        return subtotal;
    }

    public static double IvaTicket(String[][] mticket) {
        double subtotal = SubTotalTicket(mticket);
        if (subtotal > 0) {
            subtotal = 0.16 * subtotal;
        } else {
            subtotal = -1;
        }
        return subtotal;
    }

    public static double TotalTicket(String[][] mticket) {
        double total = SubTotalTicket(mticket);
        if (total > 0) {
            total = IvaTicket(mticket) + total;
        }
        return total;
    }

    public static String MostrarTicketVenta(String[][] mticket, String idticket, String fecha) {
        String salida = "";
        String subtotal = String.format("%.2f", SubTotalTicket(mticket));
        String iva = String.format("%.2f", IvaTicket(mticket));
        String total = String.format("%.2f", TotalTicket(mticket));
        salida = "Fecha " + fecha + " Ticket No." + idticket;
        salida = salida + "\n" + MostrarTicket(mticket);
        salida = salida + "\n \n El total sin iva " + subtotal;
        salida = salida + "\n el iva total es " + iva;
        salida = salida + "\n el total de la venta fue " + total;
        return salida;
    }

    public static String MostrarListaProductosVenta(String[][] vproductos) {
        String salida = "";
        for (int ciclo = 0; ciclo < 10; ciclo++) {
            int existencia = Integer.parseInt(vproductos[ciclo][3]);
            if (existencia > 0) {
                String[] vproducto = vproductos[ciclo].clone();
                String cadena = MostrarProducto(vproducto);
                salida = salida.concat(cadena + "\n");
            }
        }
        return salida;
    }

    public static void CapturaVentaProducto(String[][] mticket, String[][] mproductos, String idticket, int tamticket) throws IOException {
        String codigo, info;
        info = MostrarListaProductosVenta(mproductos);
        codigo = Leer(info + "\nIntroduce el codigo del producto");
        if (codigo != null) {
            int posp = ExisteProducto(codigo.trim(), mproductos);
            if (posp > -1) {
                if (Integer.parseInt(mproductos[posp][3]) > 0) {
                    String[] producto = mproductos[posp].clone();
                    System.out.println(MostrarProducto(producto));
                    String[] venta = new String[4];
                    venta[0] = productos[posp][0];
                    venta[1] = productos[posp][1];
                    venta[2] = productos[posp][2];
                    venta[3] = "1";
                    if (!InsertarProductoTicket(mticket, venta, tamticket)) {
                        System.out.println("el Arreglo esta lleno \n");
                    }
                } else {
                    System.out.println("no hay productos para venta");
                }
            } else {
                System.out.println("el codigo no existe no se puede agregar\n");
            }
        } else {
            System.out.println("dato nulo\n");
        }
    }

    public static void RemoverProductoTicket(String[][] mticket, int pos) {
        int tam = ObtenerUltimaPosicion(mticket);
        if (tam > pos) {
            for (int i = pos; i < tam + 1; i++) {
                mticket[i] = mticket[i + 1];
            }
            mticket[tam][0] = null;
        } else {
            mticket[pos][0] = null;
        }
    }

    public static void EliminarProductoTicket(String[][] mticket, int pos) {
        int cantidad = Integer.parseInt(mticket[pos][3]);
        if (cantidad > 1) {
            mticket[pos][3] = String.valueOf(cantidad - 1);
        } else {
            RemoverProductoTicket(mticket, pos);
        }
    }

    public static void Eliminar(String[][] mticket, int tamt) throws IOException {
        String codigo, info;
        info = MostrarTicket(mticket);
        codigo = Leer(info + "\nIntroduce el codigo del producto");
        if (codigo != null) {
            int pos = ExisteTicketCodigo(mticket, codigo);
            if (pos > -1) {
                EliminarProductoTicket(mticket, pos);
            }
        } else {
            System.out.println("dato nulo");
        }
    }

    public static void MenuPuntoVenta(String[][] ventas, String idticket, String[][] productos) throws IOException {
        String opcion, membrete;
        Boolean pago = false;
        int tamticket = 50;
        String[][] Vticket = new String[tamticket][4];

        idticket = IdTicketSiguiente(idticket);
        String fechadia = Fecha();
        opcion = "";

        do {
            membrete = "Fecha del Dia " + fechadia + " Ticket No " + idticket;
            membrete = membrete + "\n-----\n";
            String Tickettexto = MostrarTicket(Vticket).trim();
            if (!Tickettexto.trim().isEmpty()) {
                membrete = membrete + "\n" + Tickettexto + "\n";
            }

            String[] datosmenu = {"1. - Agregar ", "2. - Eliminar ", "3. - Listado ", "4. - Pagar ", "5. - Salida "};
            opcion = DesplegarMenu(membrete + "\n Menu de Punto de Venta", datosmenu);

            if (opcion == null) {
                System.out.println("dato incorrecto introducido");
            } else {
                switch (opcion) {
                    case "1":
                        CapturaVentaProducto(Vticket, productos, idticket, tamticket);
                        break;
                    case "2":
                        Eliminar(Vticket, tamticket);
                        break;
                    case "3":
                        if (ObtenerUltimaPosicion(Vticket) > -1) {
                            System.out.println(MostrarTicket(Vticket));
                        }
                        break;
                    case "4":
                        System.out.println(MostrarTicketVenta(Vticket, idticket, fechadia).trim());
                        Pagar(idticket, ventas, Vticket);
                        pago = true;
                        opcion = "5";
                        break;
                    case "5":
                        System.out.println("Salida del Ventas ");
                        if (!pago) {
                            System.out.println("No pago el ticket ");
                            System.out.println("eliminando tickte" + idticket);
                            // EliminarFilasVentas(idticket);
                        }
                        break;
                    default:
                        System.out.println("No existe esta opcion");
                        break;
                }
            }
        } while (opcion.compareTo("5") != 0);
    }
    
    private static void Pagar(String idticket, String[][] ventas2, String[][] vticket) {
		// TODO Auto-generated method stub
		
	}

	public static void main(String[] args) throws IOException {
        productos = CargarProductos();
        ventas = CrearVenta();
        MenuPrincipal(productos, ventas);
    }

	private static void MenuPrincipal(String[][] productos2, String[][] ventas2) {
		// TODO Auto-generated method stub
		
	}
}
