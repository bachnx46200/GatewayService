package com.example.GatewayService.export;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.persistence.Tuple;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.example.GatewayService.DTOs.DiemDTO;

public class DiemExcel {
	private XSSFWorkbook workbook;
	private XSSFSheet sheet;
	private List<DiemDTO> listAcc;

	public DiemExcel(List<DiemDTO> listAcc) {

		this.listAcc = listAcc;
		workbook = new XSSFWorkbook();
	}

	private void writeHeaderLine() {
		sheet = workbook.createSheet("Bảng điểm");

		Row row = sheet.createRow(0);

		CellStyle style = workbook.createCellStyle();
		XSSFFont font = workbook.createFont();
		
		font.setFontHeight(20);
		font.setBold(true);
		style.setFont(font);
		

		createCell(row, 0, "Mã hoc sinh", style);
		createCell(row, 1, "Họ tên", style);
		createCell(row, 2, "Giới tính", style);
		createCell(row, 3, "Môn", style);
		createCell(row, 4, "Điểm miệng 1", style);
		createCell(row, 5, "Điểm miệng 2", style);
		createCell(row, 6, "Điểm miệng 3", style);
		createCell(row, 7, "Điểm 15 phút 1", style);
		createCell(row, 8, "Điểm 15 phút 2", style);
		createCell(row, 9, "Điểm 15 phút 3", style);
		createCell(row, 10, "Điểm 1 tiết 1", style);
		createCell(row, 11, "Điểm 1 tiết 2", style);
		createCell(row, 12, "Điểm thi", style);
		createCell(row, 13, "Điểm trung bình môn", style);

	}

	private void createCell(Row row, int columnCount, Object value, CellStyle style) {
		sheet.autoSizeColumn(columnCount);
		Cell cell = row.createCell(columnCount);
		if (value instanceof Long) {
			cell.setCellValue((Long) value);
		} else if (value instanceof String) {
			cell.setCellValue((String) value);
		} else if (value instanceof Date) {
			cell.setCellValue((Date)value);
		}else if (value instanceof Integer) {
			cell.setCellValue((Integer)value);
		}else if (value instanceof Float) {
			cell.setCellValue((Float)value);
		}else if (value instanceof Boolean) {
			cell.setCellValue((Boolean)value);
		} else {
			cell.setCellStyle(style);
		}
	}

	private void writeDataLines() {
		
		int rowCount = 1;
		CellStyle style = workbook.createCellStyle();
		XSSFFont font = workbook.createFont();
		font.setFontHeight(14);
		style.setFont(font);

		for (DiemDTO acc : listAcc) {
			Row row = sheet.createRow(rowCount++);
			int columnCount = 0;
			createCell(row, columnCount++, acc.getMahocsinh(), style);
			createCell(row, columnCount++, acc.getHoten(), style);
			if(acc.getGioitinh().equals(true)) {
				createCell(row, columnCount++, "Nam", style);
			}else {
				createCell(row, columnCount++, "Nữ", style);
			}
			createCell(row, columnCount++, acc.getMon(), style);
			createCell(row, columnCount++, acc.getDiemmieng1(), style);
			createCell(row, columnCount++, acc.getDiemmieng2(), style);
			createCell(row, columnCount++, acc.getDiemmieng3(), style);
			createCell(row, columnCount++, acc.getDiem15phut1(), style);
			createCell(row, columnCount++, acc.getDiem15phut2(), style);
			createCell(row, columnCount++, acc.getDiem15phut3(), style);
			createCell(row, columnCount++, acc.getDiem1tiet1(), style);
			createCell(row, columnCount++, acc.getDiem1tiet2(), style);
			createCell(row, columnCount++, acc.getDiemthi(), style);
			createCell(row, columnCount++, acc.getDiemTBM(), style);
		}
	}

	public void export(HttpServletResponse response) throws IOException {
		writeHeaderLine();
		writeDataLines();

		ServletOutputStream outputStream = response.getOutputStream();
		workbook.write(outputStream);
		workbook.close();

		outputStream.close();

	}
}
