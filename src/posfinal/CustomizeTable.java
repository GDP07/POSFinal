package posfinal;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableCellRenderer;

public class CustomizeTable {
    
    class HorizontalAlignmentHeaderRenderer implements TableCellRenderer {

        private int horizontalAlignment = SwingConstants.LEFT;

        public HorizontalAlignmentHeaderRenderer(int horizontalAlignment) {
            this.horizontalAlignment = horizontalAlignment;
        }

        @Override
        public Component getTableCellRendererComponent(
                JTable table, Object value, boolean isSelected,
                boolean hasFocus, int row, int column) {
            TableCellRenderer r = table.getTableHeader().getDefaultRenderer();
            JLabel l = (JLabel) r.getTableCellRendererComponent(
                    table, value, isSelected, hasFocus, row, column);
            l.setHorizontalAlignment(horizontalAlignment);
            return l;
        }
    }
    
    public class HeaderColor extends DefaultTableCellRenderer {
    
    public HeaderColor() {
    
    setOpaque(false);
    CashierEnd.Cart.getTableHeader().setBackground(new java.awt.Color 	(255,69,0));
    }
    
    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean selected, boolean focused, int row, int column) {
    
    super.getTableCellRendererComponent(table, value, selected, focused, row, column);
    setForeground(Color.black);
    setBackground(new java.awt.Color(51, 51, 51));
    setFont(new Font("Segoe UI", Font.BOLD, 16));
    return this;
    
    }
    
    }

    public void changetablelayout() {
        //Cart
        JTableHeader th = CashierEnd.Cart.getTableHeader();
        th.setPreferredSize(new Dimension(300, 40));
        CashierEnd.ScrollPanePTable.setViewportBorder(null);
        CashierEnd.ScrollPanePTable.setBorder(null);
        CashierEnd.Cart.getTableHeader().setReorderingAllowed(false);
        CashierEnd.Cart.getTableHeader().setResizingAllowed(false);
        CashierEnd.Cart.setDefaultEditor(Object.class, null);
        /*CashierEnd.Cart.getColumnModel().getColumn(0).setPreferredWidth(365);
        CashierEnd.Cart.getColumnModel().getColumn(1).setPreferredWidth(25);
        CashierEnd.Cart.getColumnModel().getColumn(2).setPreferredWidth(35);
        CashierEnd.Cart.getColumnModel().getColumn(3).setPreferredWidth(35);
        CashierEnd.Cart.getColumnModel().getColumn(4).setPreferredWidth(35);*/
        CashierEnd.Cart.getTableHeader().setDefaultRenderer(new HeaderColor());
        
        CashierEnd.Cart.getColumnModel().getColumn(0).setHeaderRenderer(new HorizontalAlignmentHeaderRenderer(SwingConstants.LEFT));
        CashierEnd.Cart.getColumnModel().getColumn(1).setHeaderRenderer(new HorizontalAlignmentHeaderRenderer(SwingConstants.CENTER));
        CashierEnd.Cart.getColumnModel().getColumn(2).setHeaderRenderer(new HorizontalAlignmentHeaderRenderer(SwingConstants.CENTER));
        CashierEnd.Cart.getColumnModel().getColumn(3).setHeaderRenderer(new HorizontalAlignmentHeaderRenderer(SwingConstants.CENTER));
        CashierEnd.Cart.getColumnModel().getColumn(4).setHeaderRenderer(new HorizontalAlignmentHeaderRenderer(SwingConstants.CENTER));
        
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();centerRenderer.setHorizontalAlignment(JLabel.CENTER);
        DefaultTableCellRenderer centerRenderer2 = new DefaultTableCellRenderer();centerRenderer2.setHorizontalAlignment(JLabel.RIGHT);
        //DefaultTableCellRenderer centerRenderer3 = new DefaultTableCellRenderer();centerRenderer3.setHorizontalAlignment(JLabel.LEFT);
        CashierEnd.Cart.getColumnModel().getColumn(1).setCellRenderer(centerRenderer);
        CashierEnd.Cart.getColumnModel().getColumn(2).setCellRenderer(centerRenderer);
        CashierEnd.Cart.getColumnModel().getColumn(3).setCellRenderer(centerRenderer2);
        CashierEnd.Cart.getColumnModel().getColumn(4).setCellRenderer(centerRenderer2);
        
        
        /*CashierEnd.Cart.getColumnModel().getColumn(3).setMinWidth(0);
        CashierEnd.Cart.getColumnModel().getColumn(3).setMaxWidth(0);
        CashierEnd.Cart.getColumnModel().getColumn(3).setWidth(0);
        CashierEnd.Cart.getColumnModel().getColumn(5).setMinWidth(0);
        CashierEnd.Cart.getColumnModel().getColumn(5).setMaxWidth(0);
        CashierEnd.Cart.getColumnModel().getColumn(5).setWidth(0);
        CashierEnd.Cart.getColumnModel().getColumn(6).setMinWidth(0);
        CashierEnd.Cart.getColumnModel().getColumn(6).setMaxWidth(0);
        CashierEnd.Cart.getColumnModel().getColumn(6).setWidth(0);
        CashierEnd.Cart.getColumnModel().getColumn(7).setMinWidth(0);
        CashierEnd.Cart.getColumnModel().getColumn(7).setMaxWidth(0);
        CashierEnd.Cart.getColumnModel().getColumn(7).setWidth(0);*/
        
        
        //Search
        CashierEnd.SearchTable.setDefaultEditor(Object.class, null);
        CashierEnd.SearchTable.getColumnModel().getColumn(2).setMinWidth(0);
        CashierEnd.SearchTable.getColumnModel().getColumn(2).setMaxWidth(0);
        CashierEnd.SearchTable.getColumnModel().getColumn(2).setWidth(0);
        CashierEnd.SearchTablePanel.getColumnHeader().setVisible(false);
        
        
        CashierEnd.SearchTable.getTableHeader().setReorderingAllowed(false);
        CashierEnd.SearchTable.getTableHeader().setResizingAllowed(false);
        
        CashierEnd.SearchTablePanel.setViewportBorder(null);
        CashierEnd.SearchTablePanel.setBorder(null);
        CashierEnd.SearchTablePanel.getViewport().setOpaque(false);
        
        CashierEnd.SearchTable.getColumnModel().getColumn(1).setCellRenderer(centerRenderer2);
        CashierEnd.SearchTable.getColumnModel().getColumn(3).setCellRenderer(centerRenderer2);
        
        CashierEnd.SearchTable.getColumnModel().getColumn(0).setPreferredWidth(390);
    }
}
