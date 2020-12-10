//package com.example.GatewayService.export;
//
//import java.awt.Color;
//import java.io.IOException;
//import java.util.List;
//
//import javax.servlet.http.HttpServletResponse;
//
//import com.example.GatewayService.DTOs.DiemDTO;
//import com.lowagie.text.Document;
//import com.lowagie.text.DocumentException;
//import com.lowagie.text.Font;
//import com.lowagie.text.FontFactory;
//import com.lowagie.text.PageSize;
//import com.lowagie.text.Paragraph;
//import com.lowagie.text.Phrase;
//import com.lowagie.text.pdf.PdfPCell;
//import com.lowagie.text.pdf.PdfPTable;
//import com.lowagie.text.pdf.PdfWriter;
//
//public class DiemPDF {
//	private List<DiemDTO> listAcc;
//
//	public DiemPDF(List<DiemDTO> listAcc2) {
//
//		this.listAcc = listAcc2;
//	}
//
//	private void writeTableHeader(PdfPTable table) {
//		PdfPCell cell = new PdfPCell();
//		cell.setBackgroundColor(Color.LIGHT_GRAY);
//		cell.setPadding(6);
//
//		Font font = FontFactory.getFont(FontFactory.HELVETICA);
//		font.setColor(Color.WHITE);
//
//		cell.setPhrase(new Phrase("Ma hoc sinh", font));
//
//		table.addCell(cell);
//
//		cell.setPhrase(new Phrase("Ho ten", font));
//		table.addCell(cell);
//
//		cell.setPhrase(new Phrase("Gioi tinh", font));
//		table.addCell(cell);
//
//		cell.setPhrase(new Phrase("Mon", font));
//		table.addCell(cell);
//
//		cell.setPhrase(new Phrase("Diem thi", font));
//		table.addCell(cell);
//
//		cell.setPhrase(new Phrase("Diem TBM", font));
//		table.addCell(cell);
//
//	}
//
//	private void writeTableData(PdfPTable table) {
//		Font font = FontFactory.getFont(FontFactory.HELVETICA);
//		font.setColor(Color.WHITE);
//		for (DiemDTO ac : listAcc) {
//			table.addCell(ac.getMahocsinh());
//			table.addCell(ac.getHoten());
//			if(ac.getGioitinh().equals(true)) {
//				table.addCell("Nam");
//			}else {
//				table.addCell("Nữ");
//			}
//			table.addCell(ac.getMon());
//			table.addCell(Float.toString(ac.getDiemthi()));
//			table.addCell(Float.toString(ac.getDiemTBM()));
//		}
//	}
//
//	public void export(HttpServletResponse response) throws DocumentException, IOException {
//		Document document = new Document(PageSize.A4);
//		PdfWriter.getInstance(document, response.getOutputStream());
//
//		document.open();
//		Font font = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
//		font.setSize(30);
//
//		font.setColor(Color.BLACK);
//
//		Paragraph p = new Paragraph("Bang diem | Truong ..", font);
//		p.setAlignment(Paragraph.ALIGN_CENTER);
//		document.add(p);
//
//		PdfPTable table = new PdfPTable(6);
//		table.setWidthPercentage(100f);
//		table.setWidths(new float[] {5.0f,5.0f, 5.0f, 5.0f, 5.0f, 5.0f });
//		table.setSpacingBefore(10);
//
//		writeTableHeader(table);
//		writeTableData(table);
//
//		document.add(table);
//
//		document.close();
//
//	}
//}
