package com.erysa.system.erysasystem.util.reportes;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.erysa.system.erysasystem.modelo.Producto;

public class ProductoExporterExcel {

	private XSSFWorkbook libro;
	private XSSFSheet hoja;
	/** importa productos modelo*/
	private List<Producto> listaProductos;

	public ProductoExporterExcel(List<Producto> listaProductos) {
		this.listaProductos = listaProductos;
		libro = new XSSFWorkbook();
		hoja = libro.createSheet("Productos");
	}
	/** cabecera de la tabla */
	private void escribirCabeceraDeTabla() {
		Row fila = hoja.createRow(0);

		CellStyle estilo = libro.createCellStyle();
		XSSFFont fuente = libro.createFont();
		fuente.setBold(true);
		fuente.setFontHeight(16);
		estilo.setFont(fuente);

		Cell celda = fila.createCell(0);
		celda.setCellValue("ID");
		celda.setCellStyle(estilo);

		celda = fila.createCell(1);
		celda.setCellValue("Descripcion");
		celda.setCellStyle(estilo);

		celda = fila.createCell(2);
		celda.setCellValue("Nombre");
		celda.setCellStyle(estilo);

		celda = fila.createCell(3);
		celda.setCellValue("Precio");
		celda.setCellStyle(estilo);

		celda = fila.createCell(4);
		celda.setCellValue("cantidad");
		celda.setCellStyle(estilo);

		celda = fila.createCell(5);
		celda.setCellValue("Imagen");
		celda.setCellStyle(estilo);

		celda = fila.createCell(6);
		celda.setCellValue("Categoria");
		celda.setCellStyle(estilo);
	}
	/** Estructura de las celdas,aqui se llaman los atributos de productos a exportar*/
	private void escribirDatosDeLaTabla() {
		int nueroFilas = 1;

		CellStyle estilo = libro.createCellStyle();
		XSSFFont fuente = libro.createFont();
		fuente.setFontHeight(14);
		estilo.setFont(fuente);

		for (Producto producto : listaProductos) {
			Row fila = hoja.createRow(nueroFilas++);

			Cell celda = fila.createCell(0);
			celda.setCellValue(producto.getId());
			hoja.autoSizeColumn(0);
			celda.setCellStyle(estilo);

			celda = fila.createCell(1);
			celda.setCellValue(producto.getDescripcion());
			hoja.autoSizeColumn(1);
			celda.setCellStyle(estilo);

			celda = fila.createCell(2);
			celda.setCellValue(producto.getNombre());
			hoja.autoSizeColumn(2);
			celda.setCellStyle(estilo);

			celda = fila.createCell(3);
			celda.setCellValue(producto.getPrecio());
			hoja.autoSizeColumn(3);
			celda.setCellStyle(estilo);

			celda = fila.createCell(4);
			celda.setCellValue(producto.getCantidad());
			hoja.autoSizeColumn(4);
			celda.setCellStyle(estilo);

			celda = fila.createCell(5);
			celda.setCellValue(producto.getImagen());
			hoja.autoSizeColumn(5);
			celda.setCellStyle(estilo);

			celda = fila.createCell(6);
			celda.setCellValue(producto.getCategoria().getNombre());
			hoja.autoSizeColumn(6);
			celda.setCellStyle(estilo);

		}
	}
	/** Accion donde se exporta el contenido*/
	public void exportar(HttpServletResponse response) throws IOException {
		escribirCabeceraDeTabla();
		escribirDatosDeLaTabla();

		ServletOutputStream outPutStream = response.getOutputStream();
		libro.write(outPutStream);

		libro.close();
		outPutStream.close();
	}

}
