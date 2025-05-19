package Librerias;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.List;
import java.util.ArrayList;

public class Larchivos {
	
	public static boolean ExisteArchivo(String narchivo) {
		File archivo = new File(narchivo);
		return archivo.exists();
	}
	
	private static Object ConvertirValor(Class<?>campotipo, String valor) {
		if (campotipo.equals(int.class)||campotipo.equals(Integer.class))
			return Integer.parseInt(valor);
		
		if (campotipo.equals(double.class)||campotipo.equals(Double.class))
			return Double.parseDouble(valor);
		    return valor;
	}
	
	
	
	public static <T> List<T> CargarCsv(String narchivo,Class<T>tipobjeto) throws FileNotFoundException, IOException{
		List<T> Lista = new ArrayList<>();
		
		try (BufferedReader lectura = new BufferedReader(new FileReader(narchivo)))
		{
			String cabecera = lectura.readLine();
			if (cabecera!=null)
			{
				String[] campos = cabecera.split(",");
				String fila;
				while ((fila = lectura.readLine()) !=null) 
				{
					String[] valores = fila.split(",");
					T objeto = tipobjeto.getDeclaredConstructor().newInstance();
					Field[] atributo = tipobjeto.getDeclaredFields();
					for (int i=0;i<atributo.length && i< valores.length;i++)
					{
						atributo[i].setAccessible(true);
						atributo[i].set(tipobjeto, ConvertirValor(atributo[i].getType(),valores[i]));	
					}
					
					Lista.add(objeto);
					
					
					
				}
		}
		
	}
	catch (Exception e)
		{
		throw ner RuntimeException 
		}
	
		return Lista;
}
	}


