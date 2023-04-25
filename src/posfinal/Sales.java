/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package posfinal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author gihon
 */

public class Sales extends javax.swing.JFrame {
    Functions F = new Functions();
    CustomizeTable CT = new CustomizeTable();
    
    
    private void Monthlysales(){
        try {
        DBConnection.getDatabaseConnection();
        DefaultTableModel dtm;
        PreparedStatement ps=null;
        ResultSet rs=null;
        dtm=(DefaultTableModel) jTable2.getModel();
        ps=DBConnection.con.prepareStatement("SELECT  sum(case when Month(Date) = ?  then 1 else 0 end) ? from sales Where YEAR(Date) = YEAR(CURDATE())");
        for (int i=0;i<12;i++){
        ps.setString(1,String.valueOf(i+1) );
        ps.setString(2,String.valueOf(i) );
        rs=ps.executeQuery();
        rs.next();
        dtm.setValueAt(rs.getString(String.valueOf(i)), 0, i);
        }
        } catch (SQLException ex) {
        Logger.getLogger(Sales.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    private void MonthlyIncome(String Year){
        double TotalAmount=0;
        double TotalExpenses=0;
        double TotalNetProfit=0;
        try {
            DBConnection.getDatabaseConnection();
            DefaultTableModel dtm=(DefaultTableModel) jTable3.getModel();
            PreparedStatement ps=null;
            ResultSet rs=null;
            ps=DBConnection.con.prepareStatement("SELECT  sum(Amount) Amount,sum(NetTotal) NetTotal ,sum(ProductCost) ProductCost  from sales WHERE YEAR(Date)=? AND Month(Date) = ?");
            for (int i=1;i<13;i++){
                ps.setString(1, Year);
                ps.setString(2, String.valueOf(i));
                rs=ps.executeQuery();
                rs.next();
                dtm.setValueAt(rs.getDouble("Amount"), i-1, 1);
                dtm.setValueAt((rs.getDouble("Amount") - rs.getDouble("NetTotal"))+rs.getDouble("ProductCost"), i-1, 2);
                dtm.setValueAt(rs.getDouble("Amount")-(rs.getDouble("Amount") - rs.getDouble("NetTotal"))+rs.getDouble("ProductCost"), i-1, 3);
                TotalAmount=TotalAmount+rs.getDouble("Amount");
                TotalExpenses=TotalExpenses+((rs.getDouble("Amount") - rs.getDouble("NetTotal"))+rs.getDouble("ProductCost"));
                TotalNetProfit=TotalNetProfit+(rs.getDouble("Amount")-(rs.getDouble("Amount") - rs.getDouble("NetTotal"))+rs.getDouble("ProductCost"));
            }
            jLabel5.setText(String.valueOf(TotalAmount));
            jLabel7.setText(String.valueOf(TotalExpenses));
            jLabel9.setText(String.valueOf(TotalNetProfit));
        } catch (SQLException ex) {
            Logger.getLogger(Sales.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /**
     * Creates new form CashierEnd
     */
    public Sales() {
        initComponents();
        jLabel2.setText("Hello ! "+F.CashierName);
        OpenedMenue.setVisible(false);
        Monthlysales();
        Date d=new Date();
        int year=d.getYear()+1900;
        MonthlyIncome(String.valueOf(year));
        jLabel3.setText("Monthly Sales "+String.valueOf(year));
        jLabel4.setText("Monthly Income Analysis "+String.valueOf(year));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel34 = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
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
        jPanel4 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jYearChooser1 = new com.toedter.calendar.JYearChooser();
        jMonthChooser1 = new com.toedter.calendar.JMonthChooser();
        jComboBox2 = new javax.swing.JComboBox<>();
        jCheckBox1 = new javax.swing.JCheckBox();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable3 = new javax.swing.JTable();
        jYearChooser2 = new com.toedter.calendar.JYearChooser();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();

        jLabel34.setText("jLabel34");

        jLabel36.setText("jLabel36");

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
                "ReceiptNumber", "Date", "Amount"
            }
        ));
        jTable1.setFillsViewportHeight(true);
        jTable1.setGridColor(new java.awt.Color(255, 255, 255));
        jTable1.setIntercellSpacing(new java.awt.Dimension(0, 0));
        jTable1.setRowHeight(40);
        jTable1.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jTable1.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jTable1.setShowGrid(true);
        jScrollPane1.setViewportView(jTable1);

        jPanel2.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 250, 620, 410));

        jTextField1.setBackground(new java.awt.Color(153, 153, 153));
        jTextField1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jTextField1.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jTextField1.setCaretColor(new java.awt.Color(255, 255, 255));
        jPanel2.add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 190, 230, 50));

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setOpaque(false);
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jPanel4.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 10, -1, -1));

        jScrollPane2.setBackground(new java.awt.Color(255, 255, 255));
        jScrollPane2.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jScrollPane2.setOpaque(false);

        jTable2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"
            }
        ));
        jTable2.setEnabled(false);
        jTable2.setGridColor(new java.awt.Color(0, 0, 0));
        jTable2.setIntercellSpacing(new java.awt.Dimension(0, 0));
        jTable2.setRowHeight(40);
        jTable2.setShowGrid(true);
        jScrollPane2.setViewportView(jTable2);

        jPanel4.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, 1300, 70));

        jPanel2.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(3, 10, 1300, 130));

        jYearChooser1.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jYearChooser1.setDoubleBuffered(false);
        jYearChooser1.setOpaque(false);
        jPanel2.add(jYearChooser1, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 180, 100, 25));

        jMonthChooser1.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jMonthChooser1.setDoubleBuffered(false);
        jMonthChooser1.setOpaque(false);
        jPanel2.add(jMonthChooser1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 190, 120, 25));

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "All", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31" }));
        jComboBox2.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jComboBox2.setOpaque(false);
        jPanel2.add(jComboBox2, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 190, 70, 50));

        jCheckBox1.setForeground(new java.awt.Color(255, 255, 255));
        jCheckBox1.setText("Add Filters");
        jCheckBox1.setOpaque(false);
        jPanel2.add(jCheckBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 190, -1, 50));

        jScrollPane3.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jScrollPane3.setOpaque(false);

        jTable3.setBackground(new java.awt.Color(102, 102, 102));
        jTable3.setForeground(new java.awt.Color(255, 255, 255));
        jTable3.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"January", null, null, null},
                {"February", null, null, null},
                {"March", null, null, null},
                {"April", null, null, null},
                {"May", null, null, null},
                {"June", null, null, null},
                {"July", null, null, null},
                {"August", null, null, null},
                {"September", null, null, null},
                {"October", null, null, null},
                {"November", null, null, null},
                {"December", null, null, null}
            },
            new String [] {
                "Month", "Income", "Expenses", "NetProfit"
            }
        ));
        jTable3.setFillsViewportHeight(true);
        jTable3.setFocusable(false);
        jTable3.setGridColor(new java.awt.Color(255, 255, 255));
        jTable3.setIntercellSpacing(new java.awt.Dimension(0, 0));
        jTable3.setRowHeight(30);
        jTable3.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jTable3.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jTable3.setShowGrid(true);
        jScrollPane3.setViewportView(jTable3);

        jPanel2.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 210, 660, 390));

        jYearChooser2.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jYearChooser2.setDoubleBuffered(false);
        jYearChooser2.setOpaque(false);
        jPanel2.add(jYearChooser2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 210, 100, 25));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Monthly Income Analysis");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 140, 660, 40));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 610, 170, 30));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Income For the Year");
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 610, 170, 30));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jPanel2.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 650, 170, 30));

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Expense For the Year");
        jPanel2.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 650, 170, 30));

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jPanel2.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 690, 170, 30));

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Net Profit For the Year");
        jPanel2.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 690, 170, 30));

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setText(":");
        jPanel2.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 690, -1, 30));

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setText(":");
        jPanel2.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 610, -1, 30));

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel13.setText(":");
        jPanel2.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 650, -1, 30));

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel14.setText("Sales Details");
        jPanel2.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 140, 620, 50));

        jButton1.setBackground(new java.awt.Color(0, 102, 0));
        jButton1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("OK");
        jButton1.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 180, 70, 25));

        jButton2.setBackground(new java.awt.Color(0, 102, 0));
        jButton2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("Open");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 670, 130, 40));

        jButton3.setBackground(new java.awt.Color(153, 153, 153));
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/posfinal/Icons/SearchMiniIcon.png"))); // NOI18N
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 190, 100, 50));

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

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        MonthlyIncome(String.valueOf(jYearChooser1.getYear()));
        jLabel4.setText("Monthly Income Analysis "+String.valueOf(jYearChooser1.getYear()));
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        try {
            String Key=jTextField1.getText();
            PreparedStatement ps = null;
            ResultSet rs =null;
            DBConnection.getDatabaseConnection();
            DefaultTableModel dtm = (DefaultTableModel) jTable1.getModel();
            dtm.setRowCount(0);
            if(jCheckBox1.isSelected()){
                if(jComboBox2.getSelectedIndex()==0){
                    if("".equals(Key)){
                        ps = DBConnection.con.prepareStatement("SELECT * FROM sales WHERE (Month(Date) =?) AND (YEAR(Date) =? )");
                        ps.setString(1, String.valueOf(jMonthChooser1.getMonth()+1));
                        ps.setString(2, String.valueOf(jYearChooser1.getYear()));
                    }else{
                        ps = DBConnection.con.prepareStatement("SELECT * FROM sales WHERE (Month(Date) =?) AND (YEAR(Date) =? ) AND Invoice=?");
                        ps.setString(1, String.valueOf(jMonthChooser1.getMonth()+1));
                        ps.setString(2, String.valueOf(jYearChooser1.getYear()));
                        ps.setString(3, Key);
                    }
                    
                }else{
                    String x=String.valueOf(jYearChooser1.getYear())+"-"+String.valueOf(jMonthChooser1.getMonth() + 1)+"-"+String.valueOf(jComboBox2.getSelectedItem());
                    if("".equals(Key)){  
                        ps = DBConnection.con.prepareStatement("SELECT * FROM sales WHERE Date ='"+x+"'   ");
                    }else{
                        ps = DBConnection.con.prepareStatement("SELECT * FROM sales WHERE Date='"+x+"' AND Invoice=?");
                        ps.setString(1, Key);
                    }
                }
            }else{
                if("".equals(Key)){
                    ps = DBConnection.con.prepareStatement("SELECT * FROM sales ");
                }else{
                    ps = DBConnection.con.prepareStatement("SELECT * FROM sales WHERE Invoice=?");
                    ps.setString(1, Key);
                }
            }
            rs = ps.executeQuery();
                while(rs.next()){
                        Object TBData[] = {rs.getInt("Invoice"),rs.getString("Date"),rs.getDouble("Amount")};
                        dtm.addRow(TBData); 
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(Stock.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        if(!jTable1. getSelectionModel(). isSelectionEmpty()){
            SalesDetails LF= new SalesDetails((int) jTable1.getValueAt(jTable1.getSelectedRow(), 0));
            LF.setVisible(true);
            LF.setLocationRelativeTo(null);
        }
    }//GEN-LAST:event_jButton2ActionPerformed

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
            java.util.logging.Logger.getLogger(Sales.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Sales.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Sales.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Sales.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Sales().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Cashier;
    private javax.swing.JPanel ClosedMenue;
    private javax.swing.JButton Dashboard;
    private javax.swing.JLabel Exit;
    private javax.swing.JButton Logout;
    private javax.swing.JPanel MainJpanel;
    private javax.swing.JButton ManageProducts;
    private javax.swing.JLabel MenueClosed;
    private javax.swing.JLabel MenueOpened;
    private javax.swing.JLabel Minimize;
    private javax.swing.JPanel OpenedMenue;
    private javax.swing.JButton Sales;
    private javax.swing.JButton Settings1;
    private javax.swing.JButton Stock;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private com.toedter.calendar.JMonthChooser jMonthChooser1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTable jTable3;
    private javax.swing.JTextField jTextField1;
    private com.toedter.calendar.JYearChooser jYearChooser1;
    private com.toedter.calendar.JYearChooser jYearChooser2;
    // End of variables declaration//GEN-END:variables
    private void labelcolor(JLabel label,int x,int y,int z) {
        label.setBackground(new java.awt.Color(x, y, z));
    }

}