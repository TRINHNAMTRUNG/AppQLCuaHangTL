package custom_Gui;

import javax.swing.*;
import javax.swing.table.*;

public class SpinnerEditor extends AbstractCellEditor implements TableCellEditor {
    private final JSpinner spinner;

    public SpinnerEditor() {
        // Tạo Spinner với SpinnerNumberModel
        spinner = new JSpinner(new SpinnerNumberModel(1, 1, Integer.MAX_VALUE, 1)); // Giá trị tối thiểu là 0
    }
    public SpinnerEditor(JSpinner spinner) {
        this.spinner = spinner;
    }
    @Override
    public Object getCellEditorValue() {
        return spinner.getValue();
    }

    @Override
    public java.awt.Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
        spinner.setValue(value);
        return spinner;
    }

    // Optional: Override if you want to customize the behavior when editing is stopped.
    // For example, to save the edited value.
    @Override
    public boolean stopCellEditing() {
        // Here you can implement logic to handle the edited value
        return super.stopCellEditing();
    }
}


