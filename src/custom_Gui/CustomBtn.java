package custom_Gui;

import java.awt.*;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.geom.RoundRectangle2D;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

public class CustomBtn extends JButton {
	private Color color;
    private int gap;
    private int thickness;
    private float alpha;

    public CustomBtn(String label, Color color, int gap, int thickness, float alpha) {
        super(label);
        this.color = color;
        this.gap = gap;
        this.thickness = thickness;
        this.alpha = alpha;
        setOpaque(false);
        setContentAreaFilled(false);
        //setBorderPainted(false);
    }
    public void setAlpha(float alpha) {
        this.alpha = alpha;
        repaint();
    }
    public void setFocusButton(Color color, int thickness) {
        this.color = color;
        this.thickness = thickness;
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g.create();
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        if (!this.isEnabled()) {
            g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, alpha));
        }
        g2d.setColor(getBackground());
        g2d.fill(new RoundRectangle2D.Double(0, 0, getWidth(), getHeight(), gap, gap));
        super.paintComponent(g2d);
        g2d.dispose();
    }

    @Override
    protected void paintBorder(Graphics g) {
        Graphics2D g2d = (Graphics2D) g.create();
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setColor(color);
        g2d.setStroke(new BasicStroke(thickness));
        g2d.draw(new RoundRectangle2D.Double(0, 0, getWidth() - 1, getHeight() - 1, gap, gap));
        g2d.dispose();
    }
}
