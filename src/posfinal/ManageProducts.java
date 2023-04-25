/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package posfinal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Pattern;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author gihon
 */

public class ManageProducts extends javax.swing.JFrame {
    Functions F = new Functions();
    CustomizeTable CT = new CustomizeTable();
    public static int ID=0;
    int x=1;
    /**
     * Creates new form CashierEnd
     */
    public ManageProducts() {
        initComponents();
        jLabel2.setText("Hello ! "+F.CashierName);
        OpenedMenue.setVisible(false);
        F.SearchManageProducts("",jTable1);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        MainJpanel = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        Minimize = new javax.swing.JLabel();
        Exit = new javax.swing.JLabel();
        ClosedMenue = new javax.swing.JPanel();
        MenueClosed = new javax.swing.JLabel();
        OpenedMenue = new javax.swing.JPanel();
        MenueOpened = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        Logout = new javax.swing.JButton();
        Dashboard = new javax.swing.JButton();
        Cashier = new javax.swing.JButton();
        Sales = new javax.swing.JButton();
        ManageProducts = new javax.swing.JButton();
        Stock = new javax.swing.JButton();
        Settings1 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jTextField1 = new javax.swing.JTextField();
        Update = new javax.swing.JButton();
        Remove = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        Name = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        QR = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        Cost = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        Price = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        Supplier = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        Description = new javax.swing.JTextArea();
        Cancel = new javax.swing.JButton();
        Submit = new javax.swing.JButton();
        BOM = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1366, 768));
        setUndecorated(true);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        MainJpanel.setBackground(new java.awt.Color(51, 51, 51));
        MainJpanel.setMaximumSize(new java.awt.Dimension(1366, 768));
        MainJpanel.setMinimumSize(new java.awt.Dimension(1366, 768));
        MainJpanel.setPreferredSize(new java.awt.Dimension(1366, 768));
        MainJpanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(102, 102, 102));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Minimize.setBackground(new java.awt.Color(102, 102, 102));
        Minimize.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Minimize.setIcon(new javax.swing.ImageIcon(getClass().getResource("/posfinal/Icons/Minimize.png"))); // NOI18N
        Minimize.setOpaque(true);
        Minimize.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                MinimizeMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                MinimizeMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                MinimizeMouseExited(evt);
            }
        });
        jPanel1.add(Minimize, new org.netbeans.lib.awtextra.AbsoluteConstraints(1260, 0, 43, 41));

        Exit.setBackground(new java.awt.Color(102, 102, 102));
        Exit.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Exit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/posfinal/Icons/Exit.png"))); // NOI18N
        Exit.setOpaque(true);
        Exit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ExitMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                ExitMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                ExitMouseExited(evt);
            }
        });
        jPanel1.add(Exit, new org.netbeans.lib.awtextra.AbsoluteConstraints(1313, 0, 43, 41));

        MainJpanel.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1366, -1));

        ClosedMenue.setBackground(new java.awt.Color(69, 69, 69));
        ClosedMenue.setForeground(new java.awt.Color(255, 255, 255));
        ClosedMenue.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        MenueClosed.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        MenueClosed.setIcon(new javax.swing.ImageIcon(getClass().getResource("/posfinal/Icons/Menue.png"))); // NOI18N
        MenueClosed.setToolTipText("");
        MenueClosed.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                MenueClosedMouseClicked(evt);
            }
        });
        ClosedMenue.add(MenueClosed, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 60, 60));

        MainJpanel.add(ClosedMenue, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 41, 60, 727));

        OpenedMenue.setBackground(new java.awt.Color(69, 69, 69));
        OpenedMenue.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED, null, java.awt.Color.lightGray));
        OpenedMenue.setForeground(new java.awt.Color(255, 255, 255));
        OpenedMenue.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        MenueOpened.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        MenueOpened.setIcon(new javax.swing.ImageIcon(getClass().getResource("/posfinal/Icons/Menue.png"))); // NOI18N
        MenueOpened.setToolTipText("");
        MenueOpened.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                MenueOpenedMouseClicked(evt);
            }
        });
        OpenedMenue.add(MenueOpened, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 0, 60, 60));

        jLabel2.setBackground(new java.awt.Color(69, 69, 69));
        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Hello ! USERNAME");
        jLabel2.setOpaque(true);
        OpenedMenue.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 2, 180, 60));

        Logout.setBackground(new java.awt.Color(0, 102, 102));
        Logout.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Logout.setForeground(new java.awt.Color(255, 255, 255));
        Logout.setText("Log-out");
        Logout.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        Logout.setFocusPainted(false);
        OpenedMenue.add(Logout, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 650, 260, 60));

        Dashboard.setBackground(new java.awt.Color(0, 102, 102));
        Dashboard.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Dashboard.setForeground(new java.awt.Color(255, 255, 255));
        Dashboard.setText("Dashboard");
        Dashboard.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        Dashboard.setFocusPainted(false);
        Dashboard.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DashboardActionPerformed(evt);
            }
        });
        OpenedMenue.add(Dashboard, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, 260, 60));

        Cashier.setBackground(new java.awt.Color(0, 102, 102));
        Cashier.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Cashier.setForeground(new java.awt.Color(255, 255, 255));
        Cashier.setText("Cashier");
        Cashier.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        Cashier.setFocusPainted(false);
        Cashier.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CashierActionPerformed(evt);
            }
        });
        OpenedMenue.add(Cashier, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 180, 260, 60));

        Sales.setBackground(new java.awt.Color(0, 102, 102));
        Sales.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Sales.setForeground(new java.awt.Color(255, 255, 255));
        Sales.setText("Sales");
        Sales.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        Sales.setFocusPainted(false);
        Sales.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SalesActionPerformed(evt);
            }
        });
        OpenedMenue.add(Sales, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 260, 260, 60));

        ManageProducts.setBackground(new java.awt.Color(0, 102, 102));
        ManageProducts.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        ManageProducts.setForeground(new java.awt.Color(255, 255, 255));
        ManageProducts.setText("Manage Products");
        ManageProducts.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        ManageProducts.setFocusPainted(false);
        ManageProducts.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ManageProductsActionPerformed(evt);
            }
        });
        OpenedMenue.add(ManageProducts, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 340, 260, 60));

        Stock.setBackground(new java.awt.Color(0, 102, 102));
        Stock.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Stock.setForeground(new java.awt.Color(255, 255, 255));
        Stock.setText("Manage Stock");
        Stock.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        Stock.setFocusPainted(false);
        Stock.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                StockActionPerformed(evt);
            }
        });
        OpenedMenue.add(Stock, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 420, 260, 60));

        Settings1.setBackground(new java.awt.Color(0, 102, 102));
        Settings1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Settings1.setForeground(new java.awt.Color(255, 255, 255));
        Settings1.setText("Settings");
        Settings1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        Settings1.setFocusPainted(false);
        Settings1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Settings1ActionPerformed(evt);
            }
        });
        OpenedMenue.add(Settings1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 500, 260, 60));

        MainJpanel.add(OpenedMenue, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 41, 300, 727));

        jPanel2.setBackground(new java.awt.Color(51, 51, 51));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jScrollPane1.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        jTable1.setBackground(new java.awt.Color(102, 102, 102));
        jTable1.setForeground(new java.awt.Color(255, 255, 255));
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Name", "ID"
            }
        ));
        jTable1.setFillsViewportHeight(true);
        jTable1.setGridColor(new java.awt.Color(255, 255, 255));
        jTable1.setIntercellSpacing(new java.awt.Dimension(0, 0));
        jTable1.setRowHeight(40);
        jTable1.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jTable1.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jTable1.setShowGrid(true);
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jPanel2.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, 670, 550));

        jTextField1.setBackground(new java.awt.Color(153, 153, 153));
        jTextField1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jTextField1.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jTextField1.setCaretColor(new java.awt.Color(255, 255, 255));
        jPanel2.add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 580, 50));

        Update.setBackground(new java.awt.Color(0, 102, 0));
        Update.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        Update.setForeground(new java.awt.Color(255, 255, 255));
        Update.setText("Update");
        Update.setFocusPainted(false);
        Update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UpdateActionPerformed(evt);
            }
        });
        jPanel2.add(Update, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 660, 320, 40));

        Remove.setBackground(new java.awt.Color(204, 0, 0));
        Remove.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        Remove.setForeground(new java.awt.Color(255, 255, 255));
        Remove.setText("Remove");
        Remove.setFocusPainted(false);
        Remove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RemoveActionPerformed(evt);
            }
        });
        jPanel2.add(Remove, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 660, 320, 40));

        jPanel3.setOpaque(false);
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Add New Products");
        jPanel3.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 20, 610, 40));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Name");
        jPanel3.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, 150, 40));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText(":");
        jPanel3.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 100, 20, 40));

        Name.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jPanel3.add(Name, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 100, 360, 40));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("QR Code");
        jPanel3.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 160, 150, 40));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText(":");
        jPanel3.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 160, 20, 40));

        QR.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jPanel3.add(QR, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 160, 360, 40));

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText(":");
        jPanel3.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 220, 20, 40));

        Cost.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jPanel3.add(Cost, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 220, 360, 40));

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Cost");
        jPanel3.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 220, 150, 40));

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText(":");
        jPanel3.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 280, 20, 40));

        Price.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jPanel3.add(Price, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 280, 360, 40));

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Price");
        jPanel3.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 280, 150, 40));

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Measuring Base");
        jPanel3.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 340, 150, 40));

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText(":");
        jPanel3.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 340, 20, 40));

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("Supplier");
        jPanel3.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 400, 150, 40));

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText(":");
        jPanel3.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 400, 20, 40));

        Supplier.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jPanel3.add(Supplier, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 400, 360, 40));

        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setText("Description");
        jPanel3.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 460, 150, 40));

        jLabel17.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setText(":");
        jPanel3.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 460, 20, 40));

        Description.setColumns(20);
        Description.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Description.setLineWrap(true);
        Description.setRows(5);
        jScrollPane2.setViewportView(Description);

        jPanel3.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 460, 360, 90));

        Cancel.setBackground(new java.awt.Color(204, 0, 0));
        Cancel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Cancel.setForeground(new java.awt.Color(255, 255, 255));
        Cancel.setText("Cancel");
        Cancel.setFocusPainted(false);
        Cancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CancelActionPerformed(evt);
            }
        });
        jPanel3.add(Cancel, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 580, 160, 50));

        Submit.setBackground(new java.awt.Color(0, 102, 0));
        Submit.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Submit.setForeground(new java.awt.Color(255, 255, 255));
        Submit.setText("Submit");
        Submit.setFocusPainted(false);
        Submit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SubmitActionPerformed(evt);
            }
        });
        jPanel3.add(Submit, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 580, 160, 50));

        BOM.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        BOM.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Quintity", "KG", "L" }));
        BOM.setBorder(null);
        jPanel3.add(BOM, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 340, 360, 40));

        jPanel2.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 10, 610, 710));

        jButton1.setBackground(new java.awt.Color(153, 153, 153));
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/posfinal/Icons/SearchMiniIcon.png"))); // NOI18N
        jButton1.setFocusPainted(false);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 40, 90, 50));

        MainJpanel.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 40, 1306, 728));

        getContentPane().add(MainJpanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1366, 768));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ExitMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ExitMouseClicked
        System.exit(0);
    }//GEN-LAST:event_ExitMouseClicked

    private void ExitMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ExitMouseEntered
        labelcolor(Exit,0,100,100);
    }//GEN-LAST:event_ExitMouseEntered

    private void ExitMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ExitMouseExited
        labelcolor(Exit,102,102,102);
    }//GEN-LAST:event_ExitMouseExited

    private void MinimizeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MinimizeMouseClicked
        this.setState(this.ICONIFIED);
    }//GEN-LAST:event_MinimizeMouseClicked

    private void MinimizeMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MinimizeMouseEntered
        labelcolor(Minimize,0,100,100);
    }//GEN-LAST:event_MinimizeMouseEntered

    private void MinimizeMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MinimizeMouseExited
        labelcolor(Minimize,102,102,102);
    }//GEN-LAST:event_MinimizeMouseExited

    private void MenueClosedMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MenueClosedMouseClicked
        F.setEnableRec(jPanel2,false);
        Thread th = new Thread() {
            @Override
            public void run() {
                try {
                    for(int i=60;i<301;i++){
                        Thread.sleep(1/9);
                        ClosedMenue.setSize(i, 727);
                    }
                    OpenedMenue.setVisible(true);
                    ClosedMenue.setVisible(false);
                    
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, e);
                }
            }
        };
        th.start();
    }//GEN-LAST:event_MenueClosedMouseClicked

    private void MenueOpenedMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MenueOpenedMouseClicked
        Thread th = new Thread() {
            @Override
            public void run() {
                try {
                    for(int i=300;i>60;i--){
                        Thread.sleep(1/9);
                        OpenedMenue.setSize(i, 727);
                        ClosedMenue.setSize(60, 727);
                    }
                    ClosedMenue.setVisible(true);
                    OpenedMenue.setVisible(false);
                   
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, e);
                }
            }
        };
        th.start();
        F.setEnableRec(jPanel2,true);
    }//GEN-LAST:event_MenueOpenedMouseClicked

    private void SubmitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SubmitActionPerformed
        if("".equals(Name.getText())||"".equals(QR.getText())||"".equals(Cost.getText())||"".equals(Price.getText())){
            JOptionPane.showMessageDialog(null, "Please Fill All Fields");
        }else{
            if (Pattern.matches(F.ValidateDouble,Cost.getText())&&Pattern.matches(F.ValidateDouble,Price.getText())&&Pattern.matches(F.ValidateInt,QR.getText())) {
                F.UpdateAddNewProducts(x);
                F.ClearFields();
                jLabel3.setText("Add New Products");
                x=1;
            }else
                JOptionPane.showMessageDialog(null, "Invalid Input");
        }
        
    }//GEN-LAST:event_SubmitActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        if(jTable1.getRowCount()>0){
            try {
                PreparedStatement ps = null;
                ResultSet rs =null;
                DBConnection.getDatabaseConnection();
                DefaultTableModel dtm = (DefaultTableModel) jTable1.getModel();
                
                ps = DBConnection.con.prepareStatement("select * from products Where  ID=?");
                ps.setInt(1, (int) dtm.getValueAt(jTable1.getSelectedRow(), 1));
                rs = ps.executeQuery();
                while (rs.next()) {
                    Name.setText(rs.getString("name"));  
                    QR.setText(rs.getString("QR"));
                    Cost.setText(rs.getString("Cost"));
                    Price.setText(rs.getString("Price"));
                    Supplier.setText(rs.getString("Supplier"));
                    Description.setText(rs.getString("Description"));
                    BOM.setSelectedIndex(rs.getInt("BaseOfMeasure"));
                    ID=rs.getInt("ID");
                }
                jLabel3.setText("Product Details");
                Submit.setEnabled(false);
            } catch (SQLException ex) {
                Logger.getLogger(ManageProducts.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
           
    }//GEN-LAST:event_jTable1MouseClicked

    private void RemoveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RemoveActionPerformed
        if(!jTable1. getSelectionModel(). isSelectionEmpty()){
            int response = JOptionPane.showConfirmDialog(this, "Do You Want To Remove This Product? ", "Select option", JOptionPane.YES_OPTION);
            if (response == JOptionPane.YES_OPTION) {
                try {
                DefaultTableModel dtm = (DefaultTableModel) jTable1.getModel();
                PreparedStatement ps = null;
                ResultSet rs =null;
                DBConnection.getDatabaseConnection();
                ps = DBConnection.con.prepareStatement("DELETE FROM products WHERE ID=?");
                ps.setInt(1, (int) dtm.getValueAt(jTable1.getSelectedRow(), 1));
                ps.executeUpdate();
                dtm.removeRow(jTable1.getSelectedRow());
                F.ClearFields();
                jLabel3.setText("Add New Products");
                x=1;
                } catch (SQLException ex) {
                    Logger.getLogger(ManageProducts.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        } 
    }//GEN-LAST:event_RemoveActionPerformed

    private void CancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CancelActionPerformed
        F.ClearFields();
        jLabel3.setText("Add New Products");
        x=1;
    }//GEN-LAST:event_CancelActionPerformed

    private void DashboardActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DashboardActionPerformed
        
        Dashboard LF= new Dashboard();
        LF.setVisible(true);
        LF.setLocationRelativeTo(null);
        this.dispose();
    }//GEN-LAST:event_DashboardActionPerformed

    private void CashierActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CashierActionPerformed
       
        CashierEnd LF= new CashierEnd();
        LF.setVisible(true);
        LF.setLocationRelativeTo(null);
        this.dispose();
    }//GEN-LAST:event_CashierActionPerformed

    private void SalesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SalesActionPerformed

        Sales LF= new Sales();
        LF.setVisible(true);
        LF.setLocationRelativeTo(null);
        this.dispose();
    }//GEN-LAST:event_SalesActionPerformed

    private void ManageProductsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ManageProductsActionPerformed

        ManageProducts LF= new ManageProducts();
        LF.setVisible(true);
        LF.setLocationRelativeTo(null);
        this.dispose();
    }//GEN-LAST:event_ManageProductsActionPerformed

    private void StockActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_StockActionPerformed

        Stock LF= new Stock();
        LF.setVisible(true);
        LF.setLocationRelativeTo(null);
        this.dispose();
    }//GEN-LAST:event_StockActionPerformed

    private void Settings1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Settings1ActionPerformed

        Settings LF= new Settings();
        LF.setVisible(true);
        LF.setLocationRelativeTo(null);
        this.dispose();
    }//GEN-LAST:event_Settings1ActionPerformed

    private void UpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UpdateActionPerformed
        if(!jTable1. getSelectionModel(). isSelectionEmpty()){
            Submit.setEnabled(true);
            x=2;
            jLabel3.setText("Update Product");
        } 
    }//GEN-LAST:event_UpdateActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        F.SearchManageProducts(jTextField1.getText(),jTable1);
    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ManageProducts.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ManageProducts.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ManageProducts.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ManageProducts.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ManageProducts().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JComboBox<String> BOM;
    private javax.swing.JButton Cancel;
    private javax.swing.JButton Cashier;
    private javax.swing.JPanel ClosedMenue;
    public static javax.swing.JTextField Cost;
    private javax.swing.JButton Dashboard;
    public static javax.swing.JTextArea Description;
    private javax.swing.JLabel Exit;
    private javax.swing.JButton Logout;
    private javax.swing.JPanel MainJpanel;
    private javax.swing.JButton ManageProducts;
    private javax.swing.JLabel MenueClosed;
    private javax.swing.JLabel MenueOpened;
    private javax.swing.JLabel Minimize;
    public static javax.swing.JTextField Name;
    private javax.swing.JPanel OpenedMenue;
    public static javax.swing.JTextField Price;
    public static javax.swing.JTextField QR;
    private javax.swing.JButton Remove;
    private javax.swing.JButton Sales;
    private javax.swing.JButton Settings1;
    private javax.swing.JButton Stock;
    private javax.swing.JButton Submit;
    public static javax.swing.JTextField Supplier;
    private javax.swing.JButton Update;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
    private void labelcolor(JLabel label,int x,int y,int z) {
        label.setBackground(new java.awt.Color(x, y, z));
    }

}
