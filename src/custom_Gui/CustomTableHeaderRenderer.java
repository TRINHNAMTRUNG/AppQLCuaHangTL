package custom_Gui;

import javax.swing.*;
import javax.swing.table.*;
import java.awt.*;

public class CustomTableHeaderRenderer implements TableCellRenderer {
    DefaultTableCellRenderer renderer;

    public CustomTableHeaderRenderer(JTable table) {
        renderer = (DefaultTableCellRenderer) table.getTableHeader().getDefaultRenderer();
        renderer.setHorizontalAlignment(SwingConstants.CENTER); // Căn giữa nội dung của header
    }

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        Component component = renderer.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
        component.setBackground(new Color(156, 209, 150)); // Đổi màu nền của header thành màu xanh lam
        component.setForeground(Color.BLACK); // Đổi màu chữ của header thành màu trắng
        return component;
    }
}

