package custom_Gui;
import javax.swing.*;
import java.awt.*;
import java.awt.geom.Point2D;

public class GradientPanel extends JPanel {
	@Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2d = (Graphics2D) g;

        int width = getWidth();
        int height = getHeight();

        Color colorStart = Color.WHITE; // Màu bắt đầu (2 bên)
        Color colorEnd = Color.WHITE;    // Màu kết thúc (trung tâm)

        // Tạo gradient từ màu xanh ở hai bên chuyển dần vào trung tâm thành màu đỏ
        LinearGradientPaint gradient = new LinearGradientPaint(
            0, 0, width, height, 
            new float[] {0.0f, 0.5f, 1.0f},
            new Color[] {colorStart, Color.decode("#FFB5B5"), colorEnd}
        );

        g2d.setPaint(gradient);
        g2d.fillRect(0, 0, width, height);
    }
}