/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package posfinal;


import java.awt.print.PrinterException;
import java.net.URL;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import javax.swing.JTable;
import static posfinal.DBConnection.getDatabaseConnection;

/**
 *
 * @author gihon
 */
public class Receipt extends javax.swing.JFrame {
    private String name= "";
    private String address= "";
    private String phone= "";
    public void getDetails(){
        getDatabaseConnection();
        try {
                PreparedStatement ps = DBConnection.con.prepareStatement("select * from shopdetails");
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    name= rs.getString("name");
                    address= rs.getString("address");
                    phone= rs.getString("phonenumber");
                }
            } catch (SQLException e) {
                System.out.println(e);
            }
    }
    /**
     * Creates new form Recipt
     */
    public Receipt() {
        initComponents();
    }
    public Receipt(String Subtotal,String NetTotal,String Balance,String Payment,JTable Table,String InvoiceNumber) throws PrinterException, InterruptedException {
        initComponents();
        getDetails();
        String Discount=String.valueOf(Double.valueOf(Subtotal)-Double.valueOf(NetTotal));
        String paymentMethod="cash";
        String y="";
        String a="";
        int itemcount=0;
        R.setContentType("text/html");
        R.setEditable(false);
        if("cash".equals(paymentMethod)){
            a="<tr style='border:0;border-bottom: 1pt solid black;'>"
                + "<td style='border: none;  text-align:left;font-size:14;font-weight: bold;'>"
                + "CASH PAYMENT :&nbsp"
                + "</td>"
                + "<td style='border: none; text-align:right;font-size:14;font-weight: bold; margin-right=10px;'>"
                + String.valueOf(Double.parseDouble(Payment))
                + "</td>"
                + "</tr>"
                +"<tr style='border:0;'>"
                + "<td style='border: none; text-align:left;font-size:14;font-weight: bold;'>"
                + "BALANCE :&nbsp"
                + "</td>"
                + "<td style='border: none; text-align:right;font-size:14;font-weight: bold; margin-right=10px;'>"
                + Balance
                + "</td>"
                + "</tr>";
        }else if("card".equals(paymentMethod)){
            a="<tr style='border:0;'>"
                + "<td style='border: none; text-align:left;font-size:14;font-weight: bold;'>"
                + "CARD PAYMENT :&nbsp"
                + "</td>"
                + "<td style='border: none; text-align:right;font-size:14;font-weight: bold; margin-right=10px;'>"
                + NetTotal
                + "</td>"
                + "</tr>";
        }
        for (int i=0;i<Table.getRowCount();i++){
            itemcount=itemcount+1;
            String z="";
            int base=(int)Table.getValueAt(i,6);
            if (base==1){
                if (((double) Table.getValueAt(i, 1)) <1){
                    z=Double.toString((double) Table.getValueAt(i, 1))+"(g)";
                }else{
                     z=Double.toString((double) Table.getValueAt(i, 1))+"(KG)";
                }
            }else if(base==2){
                if (((double) Table.getValueAt(i, 1)) <1){
                     z=Double.toString((double) Table.getValueAt(i, 1))+"(ml)";
                }else{
                     z=Double.toString((double) Table.getValueAt(i, 1))+"(L)";
                }
            }
            else{
                z=Double.toString((double) Table.getValueAt(i, 1));
                }
            y=y+"<tr style='border: none;'>"
                + "<td style=border: none;>"
                + Table.getValueAt(i, 0)
                + "</td>"
                + "<td style='border: none; text-align:right;'>"
                + Table.getValueAt(i, 2)
                + "</td>"
                + "<td style='border: none; text-align:right;'>"
                + z
                + "</td>"
                + "<td style='border: none; text-align:right;'>"
                + Table.getValueAt(i, 4)
                + "</td>"
                + "</tr>";
        }
        
        String Styles="<style>"
                + ".table1{border-collapse: collapse; border: none;font-size:13;}"
                + ".noborder{border: none;}"
                + ".table2{border-collapse: collapse; border: none;font-size:13; width:290;}"
                + ".td{border: none; text-align:left;font-size:14;font-weight: bold;}"
                + ".td2{border: none; text-align:right;font-size:14;font-weight: bold;}"
                +"body{width:290;}"
                + "</style>";  
        
        //get Time and date
        LocalTime myObj = LocalTime.now();
        LocalDateTime myObj2 = LocalDateTime.now();
        DateTimeFormatter Time = DateTimeFormatter.ofPattern("HH:mm:ss");
        DateTimeFormatter DATE = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        String FTIME = myObj.format(Time);
        String FDATE = myObj2.format(DATE);
         //End get Time and date
        String template ="<html><head><META HTTP-EQUIV=\"CACHE-CONTROL\" CONTENT=\"NO-CACHE\">%s</head><body>"
                + "<br><center><font size=5><b>**%s**</b></font><br>"
                + "%s<br>"
                + "%s<br><br>"
                + "<b><font size=3.5>**INVOICE**</font></b><br>"
                + "<table class='table1'>"
                + "<tr class='noborder'>"
                + "<td class='noborder'>"
                + "Cashier : JOHN "
                + "</td>"
                + "<td class='noborder'>"
                + "Invoice No: %s"
                + "</td>"
                + "</tr>"
                + "<tr class='noborder'>"
                + "<td class='noborder'>"
                + "Date : %s"
                + "</td>"
                + "<td class='noborder'>"
                + "Time : %S"
                + "</td>"
                + "</tr>"
                + "</table>"
                + "<table class='table2'>"
                +"<tr style='border-bottom: 1pt solid black;border-top: 1pt solid black;'>"
                + "<td class='noborder' style='text-align:left;'>"
                + "Product"
                + "</td>"
                + "<td class='noborder' style='text-align:right;'>"
                + "Price"
                + "</td>"
                + "<td class='noborder' style='text-align:right;'>"
                + "QTY"
                + "</td>"
                + "<td class='noborder' style='text-align:right;'>"
                + "Amount"
                + "</td>"
                + "</tr>" 
                + "%s"
                + "</table></center>"
                + "<hr>"
                + "<h5 style='font-size:12; padding: 0px; margin: 0px;text-align:right;margin-right: 80px;'>ITEMS : %s</h5><br>"
                + "<center>"
                + "<table class='table2' style='width:270;'>"
                +"<tr class='noborder'>"
                + "<td class='td'>"
                + "SUBTOTAL :&nbsp"
                + "</td>"
                + "<td class='td2'>"
                + "%s"
                + "</td>"
                + "</tr>" 
                +"<tr style='border:0; border-bottom: 1pt solid black;'>"
                + "<td class='td'>"
                + "DISCOUNT :&nbsp"
                + "</td>"
                + "<td class='td2'>"
                + "%s"
                + "</td>"
                + "</tr>" 
                +"<tr style='border:0;'>"
                + "<td class='td'>"
                + "NETTOTAL :&nbsp"
                + "</td>"
                + "<td class='td2'>"
                + "%s"
                + "</td>"
                + "</tr>"
                + "%s" 
                + "</table><br>"
                + "<h5 style='font-size:12; padding: 0px; margin: 0px;'>THANK YOU FOR VISITING US.<br>HAVE A NICE DAY!.</h5>"
                + "</center>"
                + "</body></html>";
        String text = String.format(template,Styles,name,address,phone,InvoiceNumber,FDATE,FTIME,y,itemcount,Subtotal,Discount,NetTotal,a);
        
        R.setText(text);
        
        R.print();
        
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jScrollPane3 = new javax.swing.JScrollPane();
        R = new javax.swing.JTextPane();

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(302, 600));
        setUndecorated(true);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jScrollPane3.setViewportView(R);

        getContentPane().add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 300, 600));

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(Receipt.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Receipt.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Receipt.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Receipt.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Receipt().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextPane R;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextArea jTextArea1;
    // End of variables declaration//GEN-END:variables
}
