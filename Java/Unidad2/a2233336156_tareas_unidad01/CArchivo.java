package a2233336156_tareas_unidad01;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;
import java.nio.channels.FileChannel;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class CArchivo<T> {
    private List<T> lista;
    private Class<T> tipo;

    public CArchivo(List<T> lista, Class<T> tipo) {
        this.lista = lista;
        this.tipo = tipo;
    }

    // Verificar si el archivo existe
    public boolean existeArchivo(String nombreArchivo) {
        return new File(nombreArchivo).exists();
    }

    // Verificar si el archivo está en uso por otro proceso
    public boolean archivoEnUso(String nombreArchivo, int tiempoEspera) {
        File file = new File(nombreArchivo);
        for (int i = 0; i < tiempoEspera; i++) {
            try (FileChannel channel = new FileInputStream(file).getChannel()) {
                return false;
            } catch (IOException e) {
                try {
                    Thread.sleep(1000); 
                } catch (InterruptedException ignored) {
                }
            }
        }
        return true;
    }

    // Guardar como JSON
    public void guardarJSON(String nombreArchivo) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.writeValue(new File(nombreArchivo), lista);
    }

    // Leer desde JSON
    public void leerJSON(String nombreArchivo) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        lista = objectMapper.readValue(new File(nombreArchivo), objectMapper.getTypeFactory().constructCollectionType(List.class, tipo));//corregi aqui pq no agarraba el redvalues
    }

    // Guardar como XML
    public void guardarXML(String nombreArchivo) throws IOException {
        XmlMapper xmlMapper = new XmlMapper();
        xmlMapper.writeValue(new File(nombreArchivo), lista);
    }

    // Leer desde XML
    public void leerXML(String nombreArchivo) throws IOException {
        XmlMapper xmlMapper = new XmlMapper();
        lista = xmlMapper.readValue(new File(nombreArchivo), xmlMapper.getTypeFactory().constructCollectionType(List.class, tipo));
    }

    // Guardar como Excel
    public void guardarExcel(String nombreArchivo) throws IOException {
        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("Datos");
        int rowNum = 0;
        for (T item : lista) {
            Row row = sheet.createRow(rowNum++);
            String[] valores = item.toString().split(", ");
            for (int i = 0; i < valores.length; i++) {
                row.createCell(i).setCellValue(valores[i]);
            }
        }
        FileOutputStream fileOut = new FileOutputStream(nombreArchivo);
        workbook.write(fileOut);
        fileOut.close();
        workbook.close();
    }

    // Leer desde Excel
    public void leerExcel(String nombreArchivo) throws IOException {
        FileInputStream file = new FileInputStream(nombreArchivo);
        Workbook workbook = new XSSFWorkbook(file);
        Sheet sheet = workbook.getSheetAt(0);
        lista.clear();
        for (Row row : sheet) {
            StringBuilder sb = new StringBuilder();
            for (Cell cell : row) {
                sb.append(cell.getStringCellValue()).append(", ");
            }
            if (sb.length() > 0) {
                sb.setLength(sb.length() - 1); // Eliminar la última coma
                try {
                    lista.add(tipo.getConstructor(String.class).newInstance(sb.toString()));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        workbook.close();
        file.close();
    }
}
