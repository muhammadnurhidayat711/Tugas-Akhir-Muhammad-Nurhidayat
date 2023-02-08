
import java.awt.Component;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Acer
 */
public class ColoumnTableResize {

    public static void DinamicSize(JTable t) {
        TableColumnModel modelKolom = t.getColumnModel();

        for (int column = 0; column < modelKolom.getColumnCount(); column++) {
            int lebarKolomMax = 0;
            for (int row = 0; row < t.getRowCount(); row++) {
                TableCellRenderer rend = t.getCellRenderer(row, column);
                Object nilaiTablel = t.getValueAt(row, column);
                Component comp = rend.getTableCellRendererComponent(t, nilaiTablel, false, false, row, column);
                lebarKolomMax = Math.max(comp.getPreferredSize().width, lebarKolomMax);
            }
            TableColumn kolom = modelKolom.getColumn(column);
            kolom.setPreferredWidth(lebarKolomMax);
        }
    }

}
