package custom_Gui;
import javax.swing.*;
import java.awt.*;
public class RoundedPanel extends JPanel{
	 private int radius;

	    public RoundedPanel(int radius) {
	        this.radius = radius;
	        setOpaque(false); // Đảm bảo nền của JPanel là trong suốt để hiển thị hình tròn
	    }

	    @Override
	    protected void paintComponent(Graphics g) {
	        super.paintComponent(g);
	        Dimension arcs = new Dimension(radius, radius);
	        int width = getWidth();
	        int height = getHeight();
	        Graphics2D graphics = (Graphics2D) g;
	        graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

	        // Vẽ hình tròn
	        graphics.setColor(getBackground());
	        graphics.fillRoundRect(0, 0, width - 1, height - 1, arcs.width, arcs.height);
	        graphics.setColor(getForeground());
	        graphics.drawRoundRect(0, 0, width - 1, height - 1, arcs.width, arcs.height);
	    }

	    // Tạo một JPanel bo tròn với bán kính đã cho
	    public static JPanel createRoundedPanel(int radius) {
	        JPanel panel = new RoundedPanel(radius);
	        panel.setLayout(new BorderLayout()); // Có thể thiết lập layout cho panel nếu cần
	        return panel;
	    }
}
