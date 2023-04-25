/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package posfinal;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

/**
 *
 * @author gihon
 */

public class Dashboard extends javax.swing.JFrame {
    Functions F = new Functions();
    CustomizeTable CT = new CustomizeTable();
    
    
    /**
     * Creates new form CashierEnd
     */
    public Dashboard() {
        initComponents();
        OpenedMenue.setVisible(false);
        Functions.Dashboard();
        jLabel2.setText("Hello ! "+F.CashierName);
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
        jPanel3 = new javax.swing.JPanel();
        NoOfSalesToday = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        TodayRevenue = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        RunningLow = new javax.swing.JTable();
        jLabel10 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        ProductCount = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TopSellingItems = new javax.swing.JTable();
        jPanel8 = new javax.swing.JPanel();
        IncomeForMonth = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        CostPerMont = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jPanel10 = new javax.swing.JPanel();
        NetProfitForMont = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();

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
        ClosedMenue.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ClosedMenueMouseClicked(evt);
            }
        });
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
        OpenedMenue.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                OpenedMenueMouseClicked(evt);
            }
        });
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
        Dashboard.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                DashboardMouseClicked(evt);
            }
        });
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

        jPanel3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, new java.awt.Color(153, 153, 153), null, null));
        jPanel3.setOpaque(false);
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        NoOfSalesToday.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        NoOfSalesToday.setForeground(new java.awt.Color(255, 255, 255));
        NoOfSalesToday.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        NoOfSalesToday.setText("0");
        jPanel3.add(NoOfSalesToday, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 90, 250, 30));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Todays No of sales");
        jPanel3.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 30, 250, 30));

        jPanel2.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(4, 4, 250, 150));

        jPanel4.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, new java.awt.Color(153, 153, 153), null, null));
        jPanel4.setOpaque(false);
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        TodayRevenue.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        TodayRevenue.setForeground(new java.awt.Color(255, 255, 255));
        TodayRevenue.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        TodayRevenue.setText("0");
        jPanel4.add(TodayRevenue, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 90, 250, 30));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Todays Sales revenue");
        jPanel4.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 30, 250, 30));

        jPanel2.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(258, 4, 250, 150));

        jPanel7.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, new java.awt.Color(153, 153, 153), null, null));
        jPanel7.setOpaque(false);
        jPanel7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jScrollPane2.setOpaque(false);

        RunningLow.setBackground(new java.awt.Color(51, 51, 51));
        RunningLow.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        RunningLow.setForeground(new java.awt.Color(255, 255, 255));
        RunningLow.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Name", "Stock", "ID"
            }
        ));
        RunningLow.setFillsViewportHeight(true);
        RunningLow.setRowHeight(30);
        RunningLow.setShowGrid(true);
        jScrollPane2.setViewportView(RunningLow);

        jPanel7.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 70, 524, 380));

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("Running Low Items");
        jPanel7.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 20, 594, 30));

        jPanel2.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(766, 4, 534, 454));

        jPanel5.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, new java.awt.Color(153, 153, 153), null, null));
        jPanel5.setOpaque(false);
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        ProductCount.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        ProductCount.setForeground(new java.awt.Color(255, 255, 255));
        ProductCount.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ProductCount.setText("0");
        jPanel5.add(ProductCount, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 90, 250, 30));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Product Count");
        jPanel5.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 30, 250, 30));

        jPanel2.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(512, 4, 250, 150));

        jPanel6.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, new java.awt.Color(153, 153, 153), null, null));
        jPanel6.setOpaque(false);
        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("Top selling Items");
        jPanel6.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 20, 760, 30));

        jScrollPane1.setOpaque(false);

        TopSellingItems.setBackground(new java.awt.Color(51, 51, 51));
        TopSellingItems.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        TopSellingItems.setForeground(new java.awt.Color(255, 255, 255));
        TopSellingItems.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Product", "ID", "Price", "Cost"
            }
        ));
        TopSellingItems.setFillsViewportHeight(true);
        TopSellingItems.setIntercellSpacing(new java.awt.Dimension(0, 0));
        TopSellingItems.setRowHeight(30);
        TopSellingItems.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        TopSellingItems.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        TopSellingItems.setShowGrid(true);
        jScrollPane1.setViewportView(TopSellingItems);

        jPanel6.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 60, 750, 236));

        jPanel2.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(4, 158, 760, 300));

        jPanel8.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, new java.awt.Color(153, 153, 153), null, null));
        jPanel8.setOpaque(false);
        jPanel8.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        IncomeForMonth.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        IncomeForMonth.setForeground(new java.awt.Color(255, 255, 255));
        IncomeForMonth.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        IncomeForMonth.setText("0");
        jPanel8.add(IncomeForMonth, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 130, 430, 40));

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setText("Income for the month");
        jPanel8.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, 430, 30));

        jPanel2.add(jPanel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(4, 462, 430, 260));

        jPanel9.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, new java.awt.Color(153, 153, 153), null, null));
        jPanel9.setOpaque(false);
        jPanel9.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        CostPerMont.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        CostPerMont.setForeground(new java.awt.Color(255, 255, 255));
        CostPerMont.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        CostPerMont.setText("0");
        jPanel9.add(CostPerMont, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 130, 430, 40));

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel13.setText("Total cost for the month");
        jPanel9.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, 430, 30));

        jPanel2.add(jPanel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(438, 462, 430, 260));

        jPanel10.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, new java.awt.Color(153, 153, 153), null, null));
        jPanel10.setOpaque(false);
        jPanel10.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        NetProfitForMont.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        NetProfitForMont.setForeground(new java.awt.Color(255, 255, 255));
        NetProfitForMont.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        NetProfitForMont.setText("0");
        jPanel10.add(NetProfitForMont, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 130, 430, 40));

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel15.setText("Net Profit for the month");
        jPanel10.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, 430, 30));

        jPanel2.add(jPanel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(872, 462, 430, 260));

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

    private void OpenedMenueMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_OpenedMenueMouseClicked
        
    }//GEN-LAST:event_OpenedMenueMouseClicked

    private void ClosedMenueMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ClosedMenueMouseClicked
        
    }//GEN-LAST:event_ClosedMenueMouseClicked

    private void MenueClosedMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MenueClosedMouseClicked
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
    }//GEN-LAST:event_MenueOpenedMouseClicked

    private void DashboardMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DashboardMouseClicked

    }//GEN-LAST:event_DashboardMouseClicked

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
            java.util.logging.Logger.getLogger(Dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Dashboard().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Cashier;
    private javax.swing.JPanel ClosedMenue;
    public static javax.swing.JLabel CostPerMont;
    private javax.swing.JButton Dashboard;
    private javax.swing.JLabel Exit;
    public static javax.swing.JLabel IncomeForMonth;
    private javax.swing.JButton Logout;
    private javax.swing.JPanel MainJpanel;
    private javax.swing.JButton ManageProducts;
    private javax.swing.JLabel MenueClosed;
    private javax.swing.JLabel MenueOpened;
    private javax.swing.JLabel Minimize;
    public static javax.swing.JLabel NetProfitForMont;
    public static javax.swing.JLabel NoOfSalesToday;
    private javax.swing.JPanel OpenedMenue;
    public static javax.swing.JLabel ProductCount;
    public static javax.swing.JTable RunningLow;
    private javax.swing.JButton Sales;
    private javax.swing.JButton Settings1;
    private javax.swing.JButton Stock;
    public static javax.swing.JLabel TodayRevenue;
    public static javax.swing.JTable TopSellingItems;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration//GEN-END:variables
    private void labelcolor(JLabel label,int x,int y,int z) {
        label.setBackground(new java.awt.Color(x, y, z));
    }

}