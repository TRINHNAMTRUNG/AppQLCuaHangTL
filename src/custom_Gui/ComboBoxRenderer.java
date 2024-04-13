package custom_Gui;

import javax.swing.*;
import javax.swing.table.*;
import java.awt.*;

public class ComboBoxRenderer extends JComboBox implements TableCellRenderer {
    public ComboBoxRenderer(ComboBoxModel model) {
        super(model);
    }

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        if (isSelected) {
            setForeground(table.getSelectionForeground());
            setBackground(table.getSelectionBackground());
        } else {
            setForeground(table.getForeground());
            setBackground(table.getBackground());
        }

        // Chọn giá trị phù hợp với ô
        setSelectedItem(value);

        return this;
    }
}


