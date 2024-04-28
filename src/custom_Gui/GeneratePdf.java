package custom_Gui;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDType0Font;
import org.apache.pdfbox.pdmodel.graphics.image.PDImageXObject;
import org.apache.pdfbox.pdmodel.common.PDRectangle;

import java.io.IOException;

public class GeneratePdf {
    public static final String FONT_PATH = "/font/UVNBachTuyet_B.TTF";

    public static void main(String[] args) {
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
                    contentStream.setFont(font, 11);
                    contentStream.setLeading(20);
                    
                    contentStream.setFont(font, 14);
                    float centeredOffset = getCenteredOffset(page, font, 14, "Quản lý cửa hàng tiện lợi");
                    contentStream.newLineAtOffset(centeredOffset, 700);
                    contentStream.showText("Quản lý cửa hàng tiện lợi");
                    
                    contentStream.setFont(font, 10);
                    contentStream.newLineAtOffset(-100, -20);
                    String leftAlignedText = createLeftAlignedText("Text1", 123, "Text2");
                    contentStream.showText(leftAlignedText);
                    
                    contentStream.newLine();
                    float firstWordWidth = font.getStringWidth("chào bạn") / 1000 * 10;
                    contentStream.showText("chào bạn"); // Hiển thị từ đầu tiên
                    contentStream.newLineAtOffset(firstWordWidth + desiredSpacing, 0); // Di chuyển sang phía bên phải của từ đầu tiên và thêm khoảng cách mong muốn
                    contentStream.showText("tôi là trung");
                    
                    contentStream.newLineAtOffset(-145, -15);
                    contentStream.showText("_______________________________________________________________________________");
                    contentStream.endText();
                    
                    // Số hàng và cột của bảng
                    int rows = 1; // Số hàng của bảng
                    int cols = 3; // Số cột của bảng

                    // Tính toán chiều rộng và chiều cao của mỗi ô
                    float cellWidth = (page.getMediaBox().getWidth() / cols)-10;
                    float cellHeight = 50; // Chiều cao của mỗi ô

                    // Vị trí của ô đầu tiên
                    float firstCellX = 100;
                    float startY = 650;

                    // Vị trí của các ô tiếp theo
                    float secondCellX = firstCellX + cellWidth;
                    float thirdCellX = secondCellX + cellWidth;
                    
                    // Thêm văn bản vào ô đầu tiên
                    startY -=20;
                    contentStream.beginText();
                    contentStream.setFont(font, 10);
                    contentStream.newLineAtOffset(firstCellX+10, startY); // 5 là độ lệch từ mép trái của ô
                    contentStream.showText("Cell 1");
                    contentStream.endText();
                    
                    // Thêm văn bản vào ô thứ hai
                    contentStream.beginText();
                    contentStream.setFont(font, 10);
                    contentStream.newLineAtOffset(secondCellX, startY); // 5 là độ lệch từ mép trái của ô
                    contentStream.showText("Cell 2");
                    contentStream.endText();

                    // Thêm văn bản vào ô thứ ba
                    contentStream.beginText();
                    contentStream.setFont(font, 10);
                    contentStream.newLineAtOffset(thirdCellX, startY); // 5 là độ lệch từ mép trái của ô
                    contentStream.showText("Cell 3");
                    contentStream.endText();

                    contentStream.beginText();
                    startY -=20;
                    contentStream.setFont(font, 10);
                    contentStream.newLineAtOffset(firstCellX+10, startY);
                    contentStream.showText("_______________________________________________________________________________");
                    contentStream.endText();
                    
                    //ROW 1 Thêm văn bản vào ô đầu tiên
                    startY -=20;
                    contentStream.beginText();
                    contentStream.setFont(font, 10);
                    contentStream.newLineAtOffset(firstCellX+10, startY); // 5 là độ lệch từ mép trái của ô
                    contentStream.showText("Cell 1");
                    contentStream.endText();

                    contentStream.beginText();
                    contentStream.setFont(font, 10);
                    contentStream.newLineAtOffset(thirdCellX, startY); // 5 là độ lệch từ mép trái của ô
                    contentStream.showText("Cell 2");
                    contentStream.endText();
                    
                    //ROW 2 Thêm văn bản vào ô thứ hai
                    startY -=20;
                    contentStream.beginText();
                    contentStream.setFont(font, 10);
                    contentStream.newLineAtOffset(firstCellX+10, startY); // 5 là độ lệch từ mép trái của ô
                    contentStream.showText("Cell 1 ?");
                    contentStream.endText();
                    
                    contentStream.beginText();
                    contentStream.setFont(font, 10);
                    contentStream.newLineAtOffset(thirdCellX, startY); // 5 là độ lệch từ mép trái của ô
                    contentStream.showText("Cell 2");
                    contentStream.endText();
                    
                    //ROW 3 Thêm văn bản vào ô thứ hai
                    startY -=20;
                    contentStream.beginText();
                    contentStream.setFont(font, 10);
                    contentStream.newLineAtOffset(firstCellX+10, startY); // 5 là độ lệch từ mép trái của ô
                    contentStream.showText("Cell 1");
                    contentStream.endText();
                    
                    contentStream.beginText();
                    contentStream.setFont(font, 10);
                    contentStream.newLineAtOffset(thirdCellX, startY); // 5 là độ lệch từ mép trái của ô
                    contentStream.showText("Cell 2");
                    contentStream.endText();
                    
                    //ROW 4 Thêm văn bản vào ô thứ hai
                    startY -=20;
                    contentStream.beginText();
                    contentStream.setFont(font, 10);
                    contentStream.newLineAtOffset(firstCellX+10, startY); // 5 là độ lệch từ mép trái của ô
                    contentStream.showText("Cell 1");
                    contentStream.endText();
                    
                    contentStream.beginText();
                    contentStream.setFont(font, 10);
                    contentStream.newLineAtOffset(thirdCellX, startY); // 5 là độ lệch từ mép trái của ô
                    contentStream.showText("Cell 2");
                    contentStream.endText();
                    
                    //ROW 5 Thêm văn bản vào ô thứ hai
                    startY -=20;
                    contentStream.beginText();
                    contentStream.setFont(font, 10);
                    contentStream.newLineAtOffset(firstCellX+10, startY); // 5 là độ lệch từ mép trái của ô
                    contentStream.showText("Cell 1");
                    contentStream.endText();
                    
                    contentStream.beginText();
                    contentStream.setFont(font, 10);
                    contentStream.newLineAtOffset(thirdCellX, startY); // 5 là độ lệch từ mép trái của ô
                    contentStream.showText("Cell 2");
                    contentStream.endText();

                    
                    startY -= 20;
                    String[] lines = {
                    	    "Quý khách vui lòng kiểm tra hàng trước khi rời khởi cửa hàng",
                    	    "Giữ hóa đơn khi đổi trả",
                    	    "---------------------------------------------------",
                    	    "Cảm ơn quý khách hẹn gặp lại"
                    	};

                    	for (String line : lines) {
                    		contentStream.beginText();
                    	    centeredOffset = getCenteredOffset(page, font, 10, line);
                    	    contentStream.newLineAtOffset(centeredOffset, startY);
                    	    contentStream.showText(line);
                    	    contentStream.endText();
                    	    startY -= 20; // Giảm giá trị của startY để xuống dòng tiếp theo
                    	    
                    	}
                    
                    
                    
                    // Vẽ dòng ngang dưới bảng
                }
                
                // Lưu tài liệu PDF
                document.save("GeneratedPDF.pdf");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    // Phương thức để tính offset để căn giữa văn bản trên trang PDF
    private static float getCenteredOffset(PDPage page, PDType0Font font, int fontSize, String text) throws IOException {
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
}
