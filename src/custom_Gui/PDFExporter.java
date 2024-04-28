package custom_Gui;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDType0Font;
import org.apache.pdfbox.pdmodel.graphics.image.PDImageXObject;
import org.apache.pdfbox.pdmodel.common.PDRectangle;

import java.awt.*;
import java.io.IOException;
import java.time.format.DateTimeFormatter;
import java.util.List;
import entity.ChiTietHoaDon;
import entity.HoaDon;

public class PDFExporter {
	public static final String FONT_PATH = "/font/Roboto-Bold.ttf";
	private List<ChiTietHoaDon> listCthdPDF;
	private HoaDon hdPDF;
	private String tongGiaSPPDF;

	public PDFExporter(List<ChiTietHoaDon> listCthd, HoaDon hd, String tongGiaSP) {
		listCthdPDF = listCthd;
		hdPDF = hd;
		tongGiaSPPDF = tongGiaSP;
	}
	// Phương thức để tính offset để căn giữa văn bản trên trang PDF
	private float getCenteredOffset(PDPage page, PDType0Font font, int fontSize, String text) throws IOException {
		float pageWidth = page.getMediaBox().getWidth();
		float textWidth = font.getStringWidth(text) / 1000 * fontSize;
		return (pageWidth - textWidth) / 2;
	}

	// Phương thức để tạo chuỗi văn bản được căn lề trái
	public static String createLeftAlignedText(String str1, int num, String str2) {
		StringBuilder sb = new StringBuilder();
		sb.append(str1);          // Thêm vào chuỗi đầu tiên
		sb.append(" ");           // Thêm một khoảng trắng để ngăn cách
		sb.append(num);           // Thêm vào số nguyên
		sb.append(" ");           // Thêm một khoảng trắng để ngăn cách
		sb.append(str2);          // Thêm vào chuỗi thứ hai
		return sb.toString();     // Trả về chuỗi hoàn chỉnh
	}
	public void exportToPDF(String filePath) throws IOException {
		try {
			// Tạo một tài liệu PDF mới
			try (PDDocument document = new PDDocument()) {
				PDPage page = new PDPage(PDRectangle.A4);
				document.addPage(page);
				float desiredSpacing = 100;

				PDType0Font font = PDType0Font.load(document, GeneratePdf.class.getResourceAsStream(FONT_PATH));
				try (PDPageContentStream contentStream = new PDPageContentStream(document, page)) {
					// Thêm văn bản vào trang PDF
					PDImageXObject image = PDImageXObject.createFromFile("src/image/imagePDF1.png", document);
					// Draw the image on the page
					contentStream.drawImage(image, 150, 500, 300, 200);

					contentStream.beginText();
					contentStream.setLeading(20);

					contentStream.setFont(font, 14);
					float centeredOffset = getCenteredOffset(page, font, 14, "PHIẾU THANH TOÁN CỬA HÀNG TIỆN LỢI");
					contentStream.newLineAtOffset(centeredOffset, 700);
					contentStream.showText("PHIẾU THANH TOÁN CỬA HÀNG TIỆN LỢI");
					contentStream.endText();
					
					
					float firstInForX = 95;
					float startInForY = 670;
					float firstWordWidth = font.getStringWidth("Mã hóa đơn:") / 1000 * 10;
					contentStream.beginText();
					contentStream.setFont(font, 10);
					contentStream.newLineAtOffset(firstInForX, startInForY);
					contentStream.showText("chào bạn"); // Hiển thị từ đầu tiên
					contentStream.newLineAtOffset(firstWordWidth + desiredSpacing, 0); // Di chuyển sang phía bên phải của từ đầu tiên và thêm khoảng cách mong muốn
					contentStream.showText(hdPDF.getMaHoaDon());
					contentStream.endText();
					
					startInForY -=20;
					contentStream.beginText();
					contentStream.newLineAtOffset(firstInForX, startInForY);
					DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
					String formattedDateTime = hdPDF.getNgayLap().format(formatter);
					String idKH = "";
					if(hdPDF.getKh().getMaKH()!=null) {
						idKH = hdPDF.getKh().getMaKH();
					}
					contentStream.showText("IdKhach: "+idKH+" - Date: "+ formattedDateTime+ " - NV: "+hdPDF.getNv().getMaNhanVien());
					contentStream.endText();
					
					startInForY -=20;
					contentStream.beginText();
					contentStream.newLineAtOffset(firstInForX, startInForY);
					contentStream.showText("______________________________________________________________________________________________");
					contentStream.endText();

					// Số hàng và cột của bảng
					int rows = 1; // Số hàng của bảng
					int cols = 3; // Số cột của bảng

					// Tính toán chiều rộng và chiều cao của mỗi ô
					float cellWidth = (page.getMediaBox().getWidth() / cols)-10;
					float cellHeight = 50; // Chiều cao của mỗi ô

					// Vị trí của ô đầu tiên
//					float firstCellX = 100;
//					float startY = 650;

					// Vị trí của các ô tiếp theo
					float secondCellX = firstInForX + cellWidth -20;
					float thirdCellX = secondCellX + cellWidth -20;

					// Thêm văn bản vào ô đầu tiên
					startInForY -=20;
					contentStream.beginText();
					contentStream.setFont(font, 10);
					contentStream.newLineAtOffset(firstInForX, startInForY); // 5 là độ lệch từ mép trái của ô
					contentStream.showText("Số lượng");
					contentStream.endText();

					// Thêm văn bản vào ô thứ hai
					contentStream.beginText();
					contentStream.setFont(font, 10);
					contentStream.newLineAtOffset(secondCellX, startInForY); // 5 là độ lệch từ mép trái của ô
					contentStream.showText("Giá bán (VND)");
					contentStream.endText();

					// Thêm văn bản vào ô thứ ba
					contentStream.beginText();
					contentStream.setFont(font, 10);
					contentStream.newLineAtOffset(thirdCellX, startInForY); // 5 là độ lệch từ mép trái của ô
					contentStream.showText("Thành tiền (VAT)");
					contentStream.endText();
					for (ChiTietHoaDon chiTietHoaDon : listCthdPDF) {
						System.out.println("CTHD: "+chiTietHoaDon);
						System.out.println(chiTietHoaDon.getSp().getGiaSanPham().getDonVi().getTenDonVi());
					}
					System.out.println(" TRONG PDF");
					for (ChiTietHoaDon chiTietHoaDon : listCthdPDF) {
						System.out.println(listCthdPDF.size());
						System.out.println("CTHD: "+chiTietHoaDon);
						System.out.println(chiTietHoaDon.getSp().getGiaSanPham().getDonVi().getTenDonVi());
						startInForY -=20;
						contentStream.beginText();
						contentStream.setFont(font, 10);
						contentStream.newLineAtOffset(firstInForX, startInForY); // 5 là độ lệch từ mép trái của ô
						String s = chiTietHoaDon.getSp().getTenSanPham()  +chiTietHoaDon.getSp().getGiaSanPham().getDonVi().getTenDonVi();
						contentStream.showText(s);
						//System.out.println(chiTietHoaDon.getSp().getTenSanPham() + " ( " +chiTietHoaDon.getSp().getGiaSanPham().getDonVi().getTenDonVi()+" )");
						contentStream.endText();
						
						startInForY -=20;
						contentStream.beginText();
						contentStream.setFont(font, 10);
						contentStream.newLineAtOffset(firstInForX, startInForY); // 5 là độ lệch từ mép trái của ô
						contentStream.showText(String.valueOf(chiTietHoaDon.getSl()));
						contentStream.endText();

						// Thêm văn bản vào ô thứ hai
						contentStream.beginText();
						contentStream.setFont(font, 10);
						contentStream.newLineAtOffset(secondCellX, startInForY); // 5 là độ lệch từ mép trái của ô
						contentStream.showText(formatMoney(chiTietHoaDon.getSp().getGiaSanPham().getDonGia()));
						contentStream.endText();

						// Thêm văn bản vào ô thứ ba
						contentStream.beginText();
						contentStream.setFont(font, 10);
						contentStream.newLineAtOffset(thirdCellX, startInForY); // 5 là độ lệch từ mép trái của ô
						contentStream.showText(formatMoney(chiTietHoaDon.getThanhTien()));
						contentStream.endText();
					}

					contentStream.beginText();
					startInForY -=20;
					contentStream.setFont(font, 10);
					contentStream.newLineAtOffset(firstInForX, startInForY);
					contentStream.showText("______________________________________________________________________________________________");
					contentStream.endText();

					//ROW 1 Thêm văn bản vào ô đầu tiên
					startInForY -=20;
					contentStream.beginText();
					contentStream.setFont(font, 10);
					contentStream.newLineAtOffset(firstInForX, startInForY); // 5 là độ lệch từ mép trái của ô
					contentStream.showText("Tổng hóa đơn:");
					contentStream.endText();

					contentStream.beginText();
					contentStream.setFont(font, 10);
					contentStream.newLineAtOffset(secondCellX, startInForY); // 5 là độ lệch từ mép trái của ô
					contentStream.showText(tongGiaSPPDF);
					contentStream.endText();

					contentStream.beginText();
					contentStream.setFont(font, 10);
					contentStream.newLineAtOffset(thirdCellX, startInForY); // 5 là độ lệch từ mép trái của ô
					contentStream.showText("VND");
					contentStream.endText();

					//ROW 2 Thêm văn bản vào ô thứ hai
					startInForY -=20;
					contentStream.beginText();
					contentStream.setFont(font, 10);
					contentStream.newLineAtOffset(firstInForX, startInForY); // 5 là độ lệch từ mép trái của ô
					contentStream.showText("Điểm sử dụng:");
					contentStream.endText();

					contentStream.beginText();
					contentStream.setFont(font, 10);
					contentStream.newLineAtOffset(secondCellX, startInForY); // 5 là độ lệch từ mép trái của ô
					contentStream.showText(String.valueOf(hdPDF.getDiemSuDung()));
					contentStream.endText();

					contentStream.beginText();
					contentStream.setFont(font, 10);
					contentStream.newLineAtOffset(thirdCellX, startInForY); // 5 là độ lệch từ mép trái của ô
					contentStream.showText("Điểm");
					contentStream.endText();

					//ROW 3 Thêm văn bản vào ô thứ hai
					startInForY -=20;
					contentStream.beginText();
					contentStream.setFont(font, 10);
					contentStream.newLineAtOffset(firstInForX, startInForY); // 5 là độ lệch từ mép trái của ô
					contentStream.showText("Phải thanh toán:");
					contentStream.endText();

					contentStream.beginText();
					contentStream.setFont(font, 10);
					contentStream.newLineAtOffset(secondCellX, startInForY); // 5 là độ lệch từ mép trái của ô
					contentStream.showText(formatMoney(hdPDF.getTongTien()));
					contentStream.endText();

					contentStream.beginText();
					contentStream.setFont(font, 10);
					contentStream.newLineAtOffset(thirdCellX, startInForY); // 5 là độ lệch từ mép trái của ô
					contentStream.showText("VND");
					contentStream.endText();

					//ROW 4 Thêm văn bản vào ô thứ hai
					startInForY -=20;
					contentStream.beginText();
					contentStream.setFont(font, 10);
					contentStream.newLineAtOffset(firstInForX, startInForY); // 5 là độ lệch từ mép trái của ô
					contentStream.showText("Tiền khách:");
					contentStream.endText();

					contentStream.beginText();
					contentStream.setFont(font, 10);
					contentStream.newLineAtOffset(secondCellX, startInForY); // 5 là độ lệch từ mép trái của ô
					contentStream.showText(formatMoney(hdPDF.getTienKhach()));
					contentStream.endText();

					contentStream.beginText();
					contentStream.setFont(font, 10);
					contentStream.newLineAtOffset(thirdCellX, startInForY); // 5 là độ lệch từ mép trái của ô
					contentStream.showText("VND");
					contentStream.endText();

					//ROW 5 Thêm văn bản vào ô thứ hai
					startInForY -=20;
					contentStream.beginText();
					contentStream.setFont(font, 10);
					contentStream.newLineAtOffset(firstInForX, startInForY); // 5 là độ lệch từ mép trái của ô
					contentStream.showText("Tiền thừa");
					contentStream.endText();

					contentStream.beginText();
					contentStream.setFont(font, 10);
					contentStream.newLineAtOffset(secondCellX, startInForY); // 5 là độ lệch từ mép trái của ô
					contentStream.showText(formatMoney(hdPDF.getTienThua()));
					contentStream.endText();

					contentStream.beginText();
					contentStream.setFont(font, 10);
					contentStream.newLineAtOffset(thirdCellX, startInForY); // 5 là độ lệch từ mép trái của ô
					contentStream.showText("VND");
					contentStream.endText();


					startInForY -=33;
					String[] lines = {
							"Quý khách vui lòng kiểm tra hàng trước khi rời khởi cửa hàng",
							"Giữ hóa đơn khi đổi trả",
							"---------------------------------------------------",
							"Cảm ơn quý khách hẹn gặp lại"
					};

					for (String line : lines) {
						contentStream.beginText();
						centeredOffset = getCenteredOffset(page, font, 10, line);
						contentStream.newLineAtOffset(centeredOffset, startInForY);
						contentStream.showText(line);
						contentStream.endText();
						startInForY -=20; // Giảm giá trị của startY để xuống dòng tiếp theo

					}
					// Vẽ dòng ngang dưới bảng
				}

				// Lưu tài liệu PDF
				document.save(filePath+".pdf");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public String formatMoney(double amount) {
		return String.format("%,.0f", amount);
	}

}
