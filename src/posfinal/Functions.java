package posfinal;

import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.print.PrinterException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Pattern;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

public class Functions {
    public static double Discount=0.0;
    public static double Amount=0.0;
    public static String CashierName="";
    public static int CashierID=0;
    public static int InvoiceNumber=0;
    private static double CartDiscountPercentage=0.0;
    public static double FinaleAmount=0.0;
    public static int ChangeDisType=0;
    public static int SelectedDisType=1;
    public static String ValidateDouble = "[0-9]+[\\.]?[0-9]*";
    public static String ValidateInt = "[0-9]+[0-9]*";
    private static double CartDiscountCash=0;
    public static boolean EnteredQR=false;
    public static boolean Exists=false;
    private static int row = 0;
    public static int QTYMODE=0;
    private static String Name = null;
    private static double Price = 0.0;
    private static int Base = 0;
    private static int ID = 0;
    public static int ChangeSearchType=1;
    public static String SearchTempLable="Search with Qr.....";
    //Disable Jpanels Including components
    public static void setEnableRec(Component container, boolean enable) {
        container.setEnabled(enable);
        try {
            Component[] components = ((Container) container).getComponents();
            for (int i = 0; i < components.length; i++) {
                setEnableRec(components[i], enable);
            }
        } catch (ClassCastException e) {
        }
    }
    //Select All Text in a J textfield
    public static void ST(JTextField x) {
        x.setText(x.getText());
        x.selectAll();
        x.requestFocus();
    }
    //Rounding Doubles
    public static double RoundDouble(double x){
        x=(double)Math.round(x * 10d) / 10d;
        return x;
    }
    //change Search Type
    public static  void CSearchType(int x){
        ChangeSearchType=x;
        switch (ChangeSearchType){
            case 1:
                CashierEnd.SearchQr1.setEnabled(false);
                CashierEnd.SearchTag.setEnabled(true);
                CashierEnd.SearchName.setEnabled(true);
                CashierEnd.SearchQr1.setBackground(new java.awt.Color(15, 99, 39));
                CashierEnd.SearchTag.setBackground(new java.awt.Color(51,51,51));
                CashierEnd.SearchName.setBackground(new java.awt.Color(51,51,51));
                SearchTempLable="Search with Qr.....";
                break;
            case 2:
                CashierEnd.SearchQr1.setEnabled(true);
                CashierEnd.SearchTag.setEnabled(false);
                CashierEnd.SearchName.setEnabled(true);
                CashierEnd.SearchQr1.setBackground(new java.awt.Color(51,51,51));
                CashierEnd.SearchTag.setBackground(new java.awt.Color(15, 99, 39));
                CashierEnd.SearchName.setBackground(new java.awt.Color(51,51,51));
                SearchTempLable="Search with ID.....";
                break;
            case 3:
                CashierEnd.SearchQr1.setEnabled(true);
                CashierEnd.SearchTag.setEnabled(true);
                CashierEnd.SearchName.setEnabled(false);
                CashierEnd.SearchQr1.setBackground(new java.awt.Color(51, 51, 51));
                CashierEnd.SearchTag.setBackground(new java.awt.Color(51,51,51));
                CashierEnd.SearchName.setBackground(new java.awt.Color(15, 99, 39));
                SearchTempLable="Search with Name.....";
                break; 
        }
        CashierEnd.Search.setBorder(new LineBorder(Color.white, 1));
        CashierEnd.Search.setText("");
        CashierEnd.placeholder1.setText(SearchTempLable);
    }
    //Search
    public static void Search(String Keyword,JTable x,JLabel y){
        PreparedStatement ps = null;
        ResultSet rs =null;
        DBConnection.getDatabaseConnection();
        if ((ChangeSearchType == 2 || ChangeSearchType == 3)&&EnteredQR==false) {
            DefaultTableModel dtm = (DefaultTableModel) x.getModel();
            if ("".equals(Keyword)) {
                y.setText(SearchTempLable);
                CashierEnd.SearchPanelSmall.setVisible(false);
                setEnableRec(CashierEnd.jPanel2,true);
                
                CSearchType(ChangeSearchType);
                dtm.setRowCount(0);
            }
            dtm.setRowCount(0);  
            if (!"".equals(Keyword)) {
                CashierEnd.SearchPanelSmall.setVisible(true);
                setEnableRec(CashierEnd.jPanel2,false);
                CashierEnd.Search.setEnabled(true);
                y.setText("");
                try {
                    
                    switch (ChangeSearchType) {
                        case 2 -> { 
                            ps = DBConnection.con.prepareStatement("select * from products Where ID=?");
                            if (Pattern.matches(ValidateInt, Keyword)) 
                                ps.setInt(1, Integer.parseInt(Keyword));
                            else
                                ps.setInt(1, Integer.parseInt("-1"));
                            break;
                        }
                        case 3 -> {
                            ps = DBConnection.con.prepareStatement("select * from products Where name LIKE ?");
                            ps.setString(1, "%" + Keyword + "%");
                            break;
                        }
                        case 1 -> {
                            ps = DBConnection.con.prepareStatement("select * from products Where QR=?");
                            ps.setInt(1,Integer.parseInt(Keyword));
                            break;
                        }
                        default -> {
                        }
                    }
                    rs = ps.executeQuery();
                    while (rs.next()) {
                            Name = rs.getString("name");
                            Price = rs.getDouble("price");
                            ID = rs.getInt("ID");
                            Double Stock=rs.getDouble("Stock");
                            Object TBData[] = {Name,Price,ID,"(Stock = "+Stock+")"};
                            dtm.addRow(TBData);            
                    }
                    DBConnection.con.close();
                } catch (SQLException e) {
                    System.out.println(e);
                }
            }
        
        }
        else if (EnteredQR) {
            try {
                if (ChangeSearchType == 1){ 
                    ps = DBConnection.con.prepareStatement("select * from products Where QR=?");
                    ps.setLong(1, Long.parseLong(Keyword));
                }
                else if(ChangeSearchType == 2){
                    ps = DBConnection.con.prepareStatement("select * from products Where ID=?");
                    if (Pattern.matches(ValidateInt, Keyword)) 
                        ps.setInt(1, Integer.parseInt(Keyword));
                    else
                        ps.setInt(1, Integer.parseInt("-1"));
                }
                else if(ChangeSearchType == 3){
                    ps = DBConnection.con.prepareStatement("select * from products Where name=?");
                    ps.setString(1, "%" + Keyword + "%");
                }
                rs = ps.executeQuery();
                if (!rs.isBeforeFirst() && rs.getRow() == 0){
                    CashierEnd.ErrorText.setText("No Results!");
                    //fading j panel
                    Thread th = new Thread() {
                        @Override
                        public void run() {
                            try {
                                CashierEnd.Error.setVisible(true);
                                for (int i = 1; i <=280 ; i++) {
                                    Thread.sleep(2/7);
                                    CashierEnd.Error.setSize(i, 40);
                                }
                                Thread.sleep(1500);
                                for (int i = 280; i >= 0; i--) {
                                    Thread.sleep(1/3);
                                    CashierEnd.Error.setSize(i, 40);
                                }
                                CashierEnd.Error.setVisible(false);
                            } catch (Exception e) {
                                JOptionPane.showMessageDialog(null, e);
                            }
                        }
                    };
                    th.start();
                    EnteredQR = false;
                   //end of fading j panel
                }else{
                    
                    while (rs.next()) {
                        ID = rs.getInt("ID");
                        SelectSearchedItem(ID, CashierEnd.Cart, y);
                    }
                    ST(CashierEnd.QTYEnter);  
                }
               DBConnection.con.close();
            } catch (SQLException e) {
                System.out.println(e);
            }
            EnteredQR = false;
        }
        IsCartEmpty();
    }
    public static void SelectSearchedItem(Object Key, JTable x, JLabel y) {        
        DefaultTableModel dtm = (DefaultTableModel) x.getModel();
        DBConnection.getDatabaseConnection();
        try {
            boolean TF = false;
            PreparedStatement ps = null;
            ps = DBConnection.con.prepareStatement("select * from products Where ID=?");
            ps.setObject(1, Key);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Name = rs.getString("name");
                Price = rs.getDouble("price");
                Base = rs.getInt("BaseOfMeasure");
                ID = rs.getInt("ID");
                Object TBData[] = {Name, 1.0, RoundDouble(Price), 0.0, RoundDouble(Price) + "        ", "$", Base, ID};
                if (dtm.getRowCount() > 0) {
                    for (int i = 0; i < dtm.getRowCount(); i++) {
                        if (dtm.getValueAt(i, 7) == Key) {
                            row = i;
                            TF = true;
                            break;
                        } else {
                            TF = false;
                        }
                    }
                    if (TF == true) {
                        int BOM=(int) dtm.getValueAt(row, 6);
                        switch (BOM) {
                            case 0:
                                double tempQTY = (double) dtm.getValueAt(row, 1);
                                tempQTY++;
                                dtm.setValueAt((Object) tempQTY, row, 1);
                                amountCart(row, x);
                                ChangeDisType=0;SelectedDisType=2;ApplyDiscount(CartDiscountPercentage,x);
                                setEnableRec(CashierEnd.jPanel2,true);
                                IsCartEmpty();
                                Subtot(x);
                                break;

                            default:
                                Exists=true;
                                QTYMODE=1;
                                ChangeDisType=0;SelectedDisType=2;ApplyDiscount(CartDiscountPercentage,x);
                                OpenQuantityMenue(x);
                                break;
                        }
                        
                    } else {
                        switch (Base) {
                            case 0:
                                dtm.addRow(TBData);
                                Subtot(x);
                                ChangeDisType=0;SelectedDisType=2;ApplyDiscount(CartDiscountPercentage,x);
                                setEnableRec(CashierEnd.jPanel2,true);
                                IsCartEmpty();
                                break;
                            default:
                                Exists=false;
                                QTYMODE=1;
                                ChangeDisType=0;SelectedDisType=2;ApplyDiscount(CartDiscountPercentage,x);
                                OpenQuantityMenue(x);
                                break;
                        }
                        
                    }
                } else {
                        switch (Base) {
                            case 0:
                                dtm.addRow(TBData);
                                ChangeDisType=0;SelectedDisType=2;ApplyDiscount(CartDiscountPercentage,x);
                                setEnableRec(CashierEnd.jPanel2,true);
                                IsCartEmpty();
                                Subtot(x);
                                break;
                            default:
                                Exists=false;
                                QTYMODE=1;
                                ChangeDisType=0;SelectedDisType=2;ApplyDiscount(CartDiscountPercentage,x);
                                OpenQuantityMenue(x);
                                break;
                        }
                }
            }
            CashierEnd.Search.setText("");
            CashierEnd.SearchPanelSmall.setVisible(false);  
            DBConnection.con.close();
        }
        catch (SQLException e) {
            System.out.println(e);
        }
    }
    public static void OpenQuantityMenue(JTable x){
        ST(CashierEnd.QTYEnter);
        IsCartEmpty();
        setEnableRec(CashierEnd.jPanel2,false);
        switch (QTYMODE) {
            case 1:
                if (Exists) {
                    CashierEnd.QuantityTitle.setText("Add Quantity");
                } else if (!Exists) {
                    CashierEnd.QuantityTitle.setText("Enter Quantity");
                }
                CashierEnd.QTYEnter.setText("0.0");
                break;
            case 0:
                DefaultTableModel dtm = (DefaultTableModel) x.getModel();
                int row=x.getSelectedRow();
                double QTY=(double) dtm.getValueAt(row, 1);
                CashierEnd.QuantityTitle.setText("Edit Quantity");
                CashierEnd.QTYEnter.setText(String.valueOf(QTY));
                break;
        }
        CashierEnd.QTYWindow.setVisible(true);
        ST(CashierEnd.QTYEnter);
        
    }
    public static void SetQuantitySearch(JTable x,double newQty){
        DefaultTableModel dtm = (DefaultTableModel) x.getModel();
        switch (QTYMODE) {
            case 1:
                DBConnection.getDatabaseConnection();
                if (Exists) {                     
                    double tempQTY = (double) dtm.getValueAt(row, 1);
                    tempQTY = tempQTY + newQty;
                    dtm.setValueAt((Object) tempQTY, row, 1);
                    amountCart(row,x);
                    
                } else if (!Exists) {
                    double newp = Price * newQty;
                    newp=RoundDouble(newp);
                    Object TBData[] = {Name, newQty, RoundDouble(Price), 0.0, newp + "        ", "$", Base, ID};
                    dtm.addRow(TBData);
                }
                Subtot(x);
                break;
            case 0:
                row=x.getSelectedRow();
                dtm.setValueAt(newQty, row, 1);
                amountCart(row,x);
                
                Subtot(x);
                break;

                
        }
        ChangeDisType=0;SelectedDisType=2;ApplyDiscount(CartDiscountPercentage,x);
        CashierEnd.QTYWindow.setVisible(false);
        CashierEnd.SearchPanelSmall.setVisible(false);
        setEnableRec(CashierEnd.jPanel2,true); 
        CSearchType(ChangeSearchType);
        CashierEnd.Search.requestFocus();
        IsCartEmpty();
    }
    public static void amountCart(int row,JTable x){
        DefaultTableModel dtm = (DefaultTableModel) x.getModel();
        double Amount=0;
        double Discount=(double) x.getValueAt(row, 3);
        String DiscountType=(String) x.getValueAt(row, 5);
        double price=(double) x.getValueAt(row, 2);
        double QTY=(double) x.getValueAt(row, 1);
        
        if ("$".equals(DiscountType)){
            Amount=(price*QTY)-Discount;
        }else if ("%".equals(DiscountType)){
            price=price-(price*Discount/100);
            Amount=(price*QTY);
        }
        Amount =RoundDouble(Amount);
        dtm.setValueAt((Object) Amount + "        ", row, 4);
    }
    public static void OpenDiscountPanel(JTable x){
        CashierEnd.DiscountPanel.setVisible(true);
        setEnableRec(CashierEnd.jPanel2,false);
        if (ChangeDisType==0){
            if (x.getSelectionModel().isSelectionEmpty()) {
                CashierEnd.ItemBTN.setEnabled(false);
                CashierEnd.ItemShadow.setEnabled(false);
            }else{
                CashierEnd.ItemBTN.setEnabled(true);
                CashierEnd.ItemShadow.setEnabled(true);
            }
            CashierEnd.CartBTN.setForeground(new java.awt.Color(0, 206, 209));
            CashierEnd.CartShadow.setBackground(new java.awt.Color(0, 206, 209));
            CashierEnd.CashDiscount.setBackground(new java.awt.Color(0, 206, 209));
            CashierEnd.PercentageDiscount.setBackground(new java.awt.Color(102,102,102));
            CashierEnd.jLabel38.setText("$");
            
            CashierEnd.ItemBTN.setForeground(new java.awt.Color(255, 255, 255));
            CashierEnd.ItemShadow.setBackground(new java.awt.Color(255, 255, 255));
            
            CashierEnd.DiscountName.setText("Cart");
        }
        if(ChangeDisType==1){
            if (x.getSelectionModel().isSelectionEmpty()) {
                CashierEnd.ItemBTN.setEnabled(false);
                CashierEnd.ItemShadow.setEnabled(false);
            } else {
                DefaultTableModel dtm = (DefaultTableModel) x.getModel();
                String ItemName = (String) dtm.getValueAt(x.getSelectedRow(), 0);
                CashierEnd.ItemBTN.setForeground(new java.awt.Color(0, 206, 209));
                CashierEnd.ItemShadow.setBackground(new java.awt.Color(0, 206, 209));
                String DisType=(String) dtm.getValueAt(x.getSelectedRow(), 5);
                
                switch (DisType) {
                    case "$":
                        CashierEnd.CashDiscount.setBackground(new java.awt.Color(0, 206, 209));
                        CashierEnd.PercentageDiscount.setBackground(new java.awt.Color(102, 102, 102));
                        CashierEnd.jLabel38.setText("$");
                        break;
                    case "%":
                        CashierEnd.PercentageDiscount.setBackground(new java.awt.Color(0, 206, 209));
                        CashierEnd.CashDiscount.setBackground(new java.awt.Color(102, 102, 102));
                        CashierEnd.jLabel38.setText("%");
                        break;
                }
                CashierEnd.CartBTN.setForeground(new java.awt.Color(255, 255, 255));
                CashierEnd.CartShadow.setBackground(new java.awt.Color(255, 255, 255));
                CashierEnd.DiscountName.setText(ItemName);
            }
        } 
        
        IsCartEmpty();
        CashierEnd.DisInput.setText("0.0");
        
        
        ST(CashierEnd.DisInput);
        
        
    }
    public static void ApplyDiscount(double Value,JTable x){
        switch (ChangeDisType){
            case 0:
                CartDiscountCash=0.0;
                Subtot(x);
                switch (SelectedDisType){
                    case 1:
                        CartDiscountCash=Value;
                        break;
                    case 2:
                        CartDiscountCash=Value;
                        CartDiscountPercentage=Value;
                        double tempSubtot=Double.valueOf(CashierEnd.SubTotal.getText());
                        CartDiscountCash=tempSubtot*CartDiscountCash/100;
                        break;
                }
                break;
            case 1:
                DefaultTableModel dtm = (DefaultTableModel) x.getModel();
                switch (SelectedDisType){
                    case 1:
                        dtm.setValueAt("$", x.getSelectedRow(), 5);
                        dtm.setValueAt(Value, x.getSelectedRow(), 3);
                        break;
                    case 2:
                        dtm.setValueAt("%", x.getSelectedRow(), 5);
                        dtm.setValueAt(Value, x.getSelectedRow(), 3);
                        break;
                }
                amountCart(x.getSelectedRow(),x);
                Subtot(x);
                CartDiscountCash=FinaleAmount*CartDiscountPercentage/100;
                break;
        }
        Subtot(x);
        ChangeDisType=0;SelectedDisType=1;
        CashierEnd.DiscountPanel.setVisible(false);
        setEnableRec(CashierEnd.jPanel2,true);
        CashierEnd.Search.requestFocus();
        CSearchType(ChangeSearchType);
        IsCartEmpty();
    }
    public static void Subtot(JTable x){
        DefaultTableModel dtm = (DefaultTableModel) x.getModel();
        Amount=0.0;
        Discount=0.0;
        for(int i=0;i<x.getRowCount();i++){
            Amount=Amount+((double) dtm.getValueAt(i, 1)*(double) dtm.getValueAt(i, 2));
            if(dtm.getValueAt(i, 5)=="$")
                Discount=Discount+(double)dtm.getValueAt(i,3);
            else if(dtm.getValueAt(i, 5)=="%"){
                Discount=Discount+(((double) dtm.getValueAt(i, 1)*(double) dtm.getValueAt(i, 2))*(double)dtm.getValueAt(i,3)/100);
            }
        }
        FinaleAmount=Amount-Discount;
        Discount=Discount+CartDiscountCash;
        if (Discount>0.0){
            CashierEnd.realAmnt.setText("<html><strike>"+Double.toString(Amount)+"</strike></html>");
            CashierEnd.SubTotal.setText(Double.toString(Amount-Discount));
            CashierEnd.NetTotal.setText(Double.toString(Amount-Discount));
            
            CashierEnd.NetTot.setText(Double.toString(Amount-Discount));
            CashierEnd.CashIn.setText("0.0");
            CashierEnd.Bal.setText("0.0");
        }else{
            CashierEnd.realAmnt.setText("");
            CashierEnd.SubTotal.setText(Double.toString(Amount));
            CashierEnd.NetTotal.setText(Double.toString(Amount-Discount));
            
            CashierEnd.NetTot.setText(Double.toString(Amount-Discount));
            CashierEnd.CashIn.setText("0.0");
            CashierEnd.Bal.setText("0.0");
        }
        CashierEnd.CashIn.setForeground(Color.white);
    }
    public static void RemoveItems(JTable x){
        DefaultTableModel dtm = (DefaultTableModel) x.getModel();
        dtm.setRowCount(0);     
        RemoveDiscounts(x);
        Subtot(x);
        IsCartEmpty();
    }
    public static void RemoveDiscounts(JTable x){
        for(int i=0;i<x.getRowCount();i++){
            x.setValueAt("$", i, 5);
            x.setValueAt(0.0, i, 3);
        }
        CartDiscountCash=0;
        CartDiscountPercentage=0;
        Subtot(x);
        CashierEnd.DiscountPanel.setVisible(false);
        setEnableRec(CashierEnd.jPanel2,true);
        CashierEnd.Search.requestFocus();
        IsCartEmpty();
    }
    public static void RemoveItem(JTable x){
        DefaultTableModel dtm = (DefaultTableModel) x.getModel();
        dtm.removeRow(x.getSelectedRow());
        Subtot(x);
        ChangeDisType=0;SelectedDisType=2;ApplyDiscount(CartDiscountPercentage,x);
        ChangeDisType=0;SelectedDisType=1;
        IsCartEmpty();
    }
    public static void IsCartEmpty(){
        if(CashierEnd.Cart.getModel().getRowCount()==0 ){
            CashierEnd.Remove.setEnabled(false);
            CashierEnd.Payment.setEnabled(false);
            CashierEnd.Quantity.setEnabled(false);
            CashierEnd.CashIn.setEnabled(false);
            CashierEnd.Remove.setBackground(new Color(121,121,121));
            CashierEnd.Payment.setBackground(new Color(121,121,121));
            CashierEnd.Quantity.setBackground(new Color(121,121,121));
        }else{
            if(CashierEnd.Cart.getSelectionModel().isSelectionEmpty()){
                CashierEnd.Remove.setEnabled(false);
                CashierEnd.Quantity.setEnabled(false);
                CashierEnd.Remove.setBackground(new Color(121,121,121));
                CashierEnd.Quantity.setBackground(new Color(121,121,121));
            }else{
                CashierEnd.Remove.setEnabled(true);
                CashierEnd.Quantity.setEnabled(true);
                CashierEnd.Remove.setBackground(new Color(51,51,51));
                CashierEnd.Quantity.setBackground(new Color(51,51,51));
            }
            if("".equals(CashierEnd.Search.getText())){
                CashierEnd.Payment.setEnabled(true);
            }else if(!"".equals(CashierEnd.Search.getText())){
                CashierEnd.Payment.setEnabled(false);
            }
            CashierEnd.Payment.setBackground(new Color(51,51,51));
        }
    }
    public static void ProceedPayment(){
        DefaultTableModel dtm = (DefaultTableModel) CashierEnd.Cart.getModel();
        DBConnection.getDatabaseConnection();
                                             
        if (CashierEnd.Cart.getRowCount() > 0) {
                PreparedStatement ps=null;
                ResultSet rs=null;
                int rowcdb=0;
                int id;
                try {
                    ps = DBConnection.con.prepareStatement("SELECT count(*) AS rowcount FROM sales");
                    rs = ps.executeQuery();
                    rs.next();
                    rowcdb = rs.getInt("rowcount") ;
                    rs.close() ;
                    if (rowcdb<1){
                        InvoiceNumber=1;
                    }else{
                        ps = DBConnection.con.prepareStatement("SELECT * FROM sales ORDER BY ID Desc Limit 1");
                        rs = ps.executeQuery();
                        rs.next();
                        InvoiceNumber = rs.getInt("Invoice")+1;
                        rs.close();
                    }
                    double NetTotal=Double.valueOf(CashierEnd.NetTot.getText());
                    
                    
                    
                    double cost =0.0;
                    ps = DBConnection.con.prepareStatement("SELECT cost FROM products WHERE ID=?");
                    for(int i=0;i<CashierEnd.Cart.getRowCount();i++){
                        ps.setObject(1, CashierEnd.Cart.getValueAt(i,7));
                        rs = ps.executeQuery();
                        rs.next();
                        double QTY=(double) CashierEnd.Cart.getValueAt(i,1);
                        cost=cost+(rs.getDouble("cost")*QTY);
                    }                 
                    ps = DBConnection.con.prepareStatement("INSERT INTO  sales(Invoice,Cashier,Date,Time,Amount,Discount,NetTotal,ProductCost) values(?,?,curdate(),curtime(),?,?,?,?)");
                    ps.setInt(1, InvoiceNumber);
                    ps.setString(2,CashierName);
                    ps.setDouble(3,Amount);
                    ps.setDouble(4,Discount);
                    ps.setDouble(5,NetTotal);
                    ps.setDouble(6,cost);
                    ps.executeUpdate();
                    ps = DBConnection.con.prepareStatement("SELECT * FROM sales ORDER BY ID Desc Limit 1");
                    rs = ps.executeQuery();
                    rs.next();
                    id = rs.getInt("ID");
                    rs.close();
                    for (int i=0;i<CashierEnd.Cart.getRowCount();i++){        
                        double Quantity=(double) CashierEnd.Cart.getValueAt(i,1);
                        double Price=(double) CashierEnd.Cart.getValueAt(i,2);
                        double Discount=(double) CashierEnd.Cart.getValueAt(i,3);
                        String NetAmount=(String) CashierEnd.Cart.getValueAt(i,4);
                        NetAmount=NetAmount.replaceAll("\\s+", "");
                        String DiscountType=(String) CashierEnd.Cart.getValueAt(i,5);
                        int ID=(int) CashierEnd.Cart.getValueAt(i,7);
                        ps = DBConnection.con.prepareStatement("INSERT INTO  saleproduct(SaleID,ProID,Price,Discount,QTY,DisType,NetAmount) values(?,?,?,?,?,?,?)");
                        ps.setInt(1, id);
                        ps.setInt(2, ID);
                        ps.setDouble(3,Price);
                        ps.setDouble(4,Discount);
                        ps.setDouble(5,Quantity);
                        ps.setString(6,DiscountType);
                        ps.setDouble(7,Double.valueOf(NetAmount));
                        ps.executeUpdate();
                        ps=DBConnection.con.prepareStatement("UPDATE Products SET Stock=Stock-? WHERE ID=?");
                        ps.setDouble(1,Quantity);
                        ps.setInt(2, ID);
                        ps.executeUpdate();
                    }
                    RemoveDiscounts(CashierEnd.Cart);
                    RemoveItems(CashierEnd.Cart);
                    Subtot(CashierEnd.Cart);
                    IsCartEmpty();
                    CSearchType(1);
                    Receipt Receipt = null;
                    try {
                        Receipt= new Receipt(Double.toString(Amount),Double.toString(NetTotal),CashierEnd.Bal.getText(),CashierEnd.CashIn.getText(),CashierEnd.Cart,Integer.toString(InvoiceNumber));
                    } catch (PrinterException ex) {
                        Logger.getLogger(Functions.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(Functions.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    Receipt.setVisible(true);
                    Receipt.setLocationRelativeTo(null);
                    DBConnection.con.close();
                } catch (SQLException ex) {
                    Logger.getLogger(POSFinal.class.getName()).log(Level.SEVERE, null, ex);
                }
                
        }
        
    }
    public static void SearchInputSwitch(int searchkeycode, JFrame Frame, boolean x) {
        switch (searchkeycode) {
            case 112:
                if (CashierEnd.Quantity.isEnabled()) {
                    CashierEnd.Quantity.setBackground(new java.awt.Color(51, 51, 51));
                    QTYMODE = 0;
                    OpenQuantityMenue(CashierEnd.Cart);
                }
                break;
            case 127:
                if (CashierEnd.Remove.isEnabled()) {
                    RemoveItem(CashierEnd.Cart);
                }
                break;
            case 116:
                if (CashierEnd.Payment.isEnabled()) {
                    if ("0.0".equals(CashierEnd.CashIn.getText())) {
                        ST(CashierEnd.CashIn);
                    } else {
                        int response = JOptionPane.showConfirmDialog(Frame, "End Sale ?", "Select option", JOptionPane.YES_OPTION);
                        if (response == JOptionPane.YES_OPTION) {
                            ProceedPayment();
                        }
                    }
                }
                break;
            case 113:
                if (CashierEnd.ClearItems.isEnabled()) {
                    int response = JOptionPane.showConfirmDialog(Frame, "Do you want to Empty the cart ?", "Select option", JOptionPane.YES_OPTION);
                    if (response == JOptionPane.YES_OPTION) {
                        RemoveItems(CashierEnd.Cart);
                    }
                }
                break;
            case 114:
                if (CashierEnd.Discount.isEnabled()) {
                    ChangeDisType = 0;
                    OpenDiscountPanel(CashierEnd.Cart);
                }
                break;

            default:
                CashierEnd.Search.requestFocus();
                if (ChangeSearchType == 2) {
                    if (Pattern.matches(ValidateInt, CashierEnd.Search.getText())) {
                        CashierEnd.Search.setBorder(new LineBorder(Color.white, 1));
                    } else {
                        CashierEnd.Search.setBorder(new LineBorder(Color.red, 1));
                    }
                } else if (ChangeSearchType == 1) {
                    if (!"".equals(CashierEnd.Search.getText())) {
                        CashierEnd.placeholder1.setText("");
                    } else {
                        CashierEnd.placeholder1.setText(SearchTempLable);
                    }
                }
                if (searchkeycode == 27) {
                    Search("", CashierEnd.SearchTable, CashierEnd.placeholder1);
                } else {
                    Search(CashierEnd.Search.getText(), CashierEnd.SearchTable, CashierEnd.placeholder1);
                }
                break;
        }
    }
    //Functions for Dashboard
    public static void Dashboard(){
        try {
            DBConnection.getDatabaseConnection();
            DefaultTableModel dtm;
            PreparedStatement ps=null;
            ResultSet rs=null;

            ps=DBConnection.con.prepareStatement("select ProID, COUNT(ProID) AS MOST_FREQUENT from saleproduct GROUP BY ProID ORDER BY COUNT(ProID) DESC LIMIT 10");
            rs = ps.executeQuery();
            dtm=(DefaultTableModel) Dashboard.TopSellingItems.getModel();
            while (rs.next()) {
                int ProID=rs.getInt("ProID");
                PreparedStatement tempps=DBConnection.con.prepareStatement("SELECT * FROM products WHERE ID=?");
                tempps.setInt(1, ProID);
                ResultSet temprs = tempps.executeQuery();
                while(temprs.next()){
                    String Name=temprs.getString("name");
                    int Id = temprs.getInt("ID");
                    double price = temprs.getDouble("price");
                    double cost = temprs.getDouble("cost");
                    Object TBData[] = {Name,Id,price,cost};
                    dtm.addRow(TBData);
                } 
            }
            ps=DBConnection.con.prepareStatement("SELECT * FROM products WHERE stock<10");
            rs = ps.executeQuery();
            dtm=(DefaultTableModel) Dashboard.RunningLow.getModel();
            while (rs.next()){
                String Name=rs.getString("name");
                int id=rs.getInt("ID");
                double Stock=rs.getDouble("stock");
                Object TBData[] = {Name,Stock,id};
                dtm.addRow(TBData);
            }
            ps=DBConnection.con.prepareStatement("SELECT *, COUNT(ID) AS MOST_FREQUENT FROM sales WHERE Date=CURDATE()");
            rs = ps.executeQuery();
            dtm=(DefaultTableModel) Dashboard.RunningLow.getModel();
            double revenue=0;
            while (rs.next()){
                int count=rs.getInt("MOST_FREQUENT");
                revenue=rs.getDouble("NetTotal")+revenue;
                Dashboard.NoOfSalesToday.setText(String.valueOf(count));
            }
            Dashboard.TodayRevenue.setText(String.valueOf(revenue));

            ps=DBConnection.con.prepareStatement("SELECT ID, COUNT(ID) AS ProCount FROM products ");
            rs = ps.executeQuery();
            rs.next();
            Dashboard.ProductCount.setText(String.valueOf(rs.getInt("ProCount")));
            
            
            ps=DBConnection.con.prepareStatement("SELECT * FROM sales WHERE (Month(Date) = Month(CURDATE())) AND (YEAR(Date) = YEAR(CURDATE()) )");
            rs = ps.executeQuery();
            double netProfit=0;
            double Income=0;
            double cost=0;
            double Discount=0;
            while (rs.next()){
                netProfit=netProfit+rs.getDouble("NetTotal");
                Income=Income+rs.getDouble("Amount");
                cost=cost+rs.getDouble("ProductCost");
                Discount=Discount+rs.getDouble("Discount");
            }
            cost=cost+Discount;
            netProfit=netProfit-cost;
            Dashboard.IncomeForMonth.setText("Rs. "+String.valueOf(Income));
            Dashboard.CostPerMont.setText("Rs. "+String.valueOf(cost));
            Dashboard.NetProfitForMont.setText("Rs. "+String.valueOf(netProfit));
            
            
            
        } catch (SQLException ex) {
            Logger.getLogger(Functions.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    //Function for Manage Product 
    
    public static void UpdateAddNewProducts(int UA){
        try {
            DBConnection.getDatabaseConnection();
            DefaultTableModel dtm;
            PreparedStatement ps=null;
            ResultSet rs=null;
            int nn = 1;
            switch (UA){
                case 1:
                    ps=DBConnection.con.prepareStatement("INSERT INTO products (QR,Name,Price,BaseOfMeasure,Cost,Supplier,Description) VALUES (?,?,?,?,?,?,?)");
                    ps.setInt(1, Integer.valueOf(ManageProducts.QR.getText()));
                    ps.setString(2,ManageProducts.Name.getText());
                    ps.setDouble(3,Double.valueOf(ManageProducts.Price.getText()));
                    
                    if (ManageProducts.BOM.getSelectedItem() == "Quintity") {
                        nn = 0;
                    } else if (ManageProducts.BOM.getSelectedItem() == "KG") {
                        nn = 1;
                    }else if (ManageProducts.BOM.getSelectedItem() == "L") {
                        nn = 2;
                    }
                    ps.setInt(4,nn);
                    ps.setDouble(5,Double.valueOf(ManageProducts.Cost.getText()));
                    ps.setString(6,ManageProducts.Supplier.getText());
                    ps.setString(7,ManageProducts.Description.getText());
                    ps.executeUpdate();
                    break;
                case 2:
                    ps=DBConnection.con.prepareStatement("UPDATE products SET QR=?,Name=?,Price=?,BaseOfMeasure=?,Cost=?,Supplier=?,Description=? WHERE ID=?");
                    ps.setInt(1, Integer.valueOf(ManageProducts.QR.getText()));
                    ps.setString(2,ManageProducts.Name.getText());
                    ps.setDouble(3,Double.valueOf(ManageProducts.Price.getText()));
                    if (ManageProducts.BOM.getSelectedItem() == "Quintity") {
                        nn = 0;
                    } else if (ManageProducts.BOM.getSelectedItem() == "KG") {
                        nn = 1;
                    }else if (ManageProducts.BOM.getSelectedItem() == "L") {
                        nn = 2;
                    }
                    ps.setInt(4,nn);
                    ps.setDouble(5,Double.valueOf(ManageProducts.Cost.getText()));
                    ps.setString(6,ManageProducts.Supplier.getText());
                    ps.setString(7,ManageProducts.Description.getText());
                    ps.setInt(8, ManageProducts.ID);
                    ps.executeUpdate();
            }
        } catch (SQLException ex) {
            Logger.getLogger(Functions.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public static void ClearFields(){
        ManageProducts.BOM.setSelectedIndex(0);
        ManageProducts.Name.setText("");
        ManageProducts.Cost.setText("");
        ManageProducts.Price.setText("");
        ManageProducts.Supplier.setText("");
        ManageProducts.QR.setText("");
        ManageProducts.Description.setText("");
    }
    public static void SearchManageProducts(String Keyword, JTable x) {
        PreparedStatement ps = null;
        ResultSet rs = null;
        DBConnection.getDatabaseConnection();
        DefaultTableModel dtm = (DefaultTableModel) x.getModel();
        dtm.setRowCount(0);
        try {
            if ("".equals(Keyword)) {
                ps = DBConnection.con.prepareStatement("select * from products ");
            } else {
                ps = DBConnection.con.prepareStatement("select * from products Where name LIKE ? OR ID=? OR QR=?");
                ps.setString(1, "%" + Keyword + "%");
                ps.setString(2, Keyword);
                ps.setString(3, Keyword);
            }
            rs = ps.executeQuery();
            while (rs.next()) {
                Name = rs.getString("name");
                ID = rs.getInt("ID");
                Object TBData[] = {Name, ID};
                dtm.addRow(TBData);
            }
            DBConnection.con.close();
        } catch (SQLException e) {
            System.out.println(e);
        }

    }
}
