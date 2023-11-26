package utils;

import modelo.Prestamo;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.font.PDType1Font;

import java.io.IOException;
import java.util.Date;

public class GestorPDF {

    public void generarBoleta(Prestamo prestamo) throws IOException {
        // Se crea un nuevo documento
        PDDocument documento = new PDDocument();
        // Al documento se le crea y agrega una nueva página, en este caso en formato A6
        PDPage pagina = new PDPage(PDRectangle.A6);
        documento.addPage(pagina);
        // Se genera un arreglo de líneas que va a tener el archivo PDF
        String[] lineasPdf = this.obtenerLineasPdf(prestamo);
        this.rellenarPDF(documento, pagina, lineasPdf);
        // Se guarda el documento en la ubicación descrita
        documento.save(this.generarNombrePdf(prestamo.getFechaInicio()));
        documento.close();
    }

    public void rellenarPDF(PDDocument documento, PDPage pagina, String[] lineasPrestamo) {
        // Por cada línea del arreglo, se irá agregando texto
        try (PDPageContentStream contenidoPagina = new PDPageContentStream(documento, pagina)) {
            if (lineasPrestamo != null) {  // Asegurarse de que lineasPrestamo no sea nulo
                for (int linea = 0; linea < lineasPrestamo.length; linea++) {
                    if (lineasPrestamo[linea] != null) {  // Asegurarse de que cada línea no sea nula
                        contenidoPagina.beginText();
                        // Se define en qué posición del documento estará el texto
                        contenidoPagina.newLineAtOffset(10, pagina.getMediaBox().getHeight() - (10 * linea));
                        contenidoPagina.setFont(PDType1Font.HELVETICA_BOLD, 8f);
                        // Agrega el texto al documento
                        contenidoPagina.showText(lineasPrestamo[linea]);
                        contenidoPagina.endText();
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String[] obtenerLineasPdf(Prestamo prestamo) {
        String[] lineasPdf = new String[8];
        lineasPdf[0] = "Boleta electrónica - Préstamo de Libros";
        // Puedes agregar más información relacionada con el préstamo
        // utilizando los métodos de la clase modelo.Prestamo
        lineasPdf[1] = "modelo.Bibliotecario: " + prestamo.getBibliotecario().getNombre() + ", RUT: " + prestamo.getBibliotecario().getRut() + ", Dirección: " + prestamo.getBibliotecario().getDireccion() + ", ID: " + prestamo.getBibliotecario().getId();
        lineasPdf[2] = "Fecha de inicio: " + prestamo.getFechaInicio().toString();
        lineasPdf[3] = "Fecha de término: " + prestamo.getFechaTermino().toString();
        lineasPdf[4] = "modelo.Usuario: " + prestamo.getUsuario().getNombre() + ", RUT: " + prestamo.getUsuario().getRut() + ", Número de telefono: " + prestamo.getUsuario().getNumeroTelefonico();
        lineasPdf[5] = "modelo.Libro: " + prestamo.getLibro().getNombre() + ", ISBN: " + prestamo.getLibro().getIsbn() + ", Autor: " + prestamo.getLibro().getAutor() + ", Editorial: " + prestamo.getLibro().getEditorial();

        // Puedes agregar más detalles según tus necesidades
        return lineasPdf;
    }

    private String generarNombrePdf(Date fecha) {
        String fechaArchivo = fecha.toString();
        fechaArchivo = fechaArchivo.replace(" ", "").replace(":", "");

        // Ruta a la carpeta "Downloads"
        String downloadsPath = "C:\\Users\\carlo\\Downloads\\";

        return downloadsPath + "boleta" + fechaArchivo + ".pdf";
    }

}