/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication2;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import jxl.write.WriteException;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;



/**
 *
 * @author root
 */
public final class ServerSide extends javax.swing.JFrame implements Runnable{
    Thread t1,t2;
            int mmsec=0;
        int sec1=0;
        int min=0;
        int hrs=0;

        Thread t11=new Thread(){
            public void run()
            {
                while(true){
              
                    mmsec++;
                    if(mmsec==10000000)
                    {
                        sec1++;
                        mmsec=0;
                    }
                    if(sec1==60)
                    {
                        min++;
                        sec1=0;
                    }
                    if(min==60)
                    {
                        hrs++;
                        min=0;
                    }
                jLabel6.setText(hrs+":"+min+":"+sec1);
                
                
            }}
        };
        
    /**
     * Creates new form ServerSide
     */
    String fn1,fn2,sec,branch;
    static  String tablename;
    
    public ServerSide(){
    //initComponents();
    }
    public ServerSide(String fn1,String fn2,String sec,String branch,String table) {
        initComponents();
        this.fn1=fn1;
        this.fn2=fn2;
        this.sec=sec;
        this.branch=branch;
        this.tablename=table;
        assign();
        
        //startServer();
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        TableDisplay = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel2.setBackground(new java.awt.Color(179, 180, 188));
        jPanel2.setPreferredSize(new java.awt.Dimension(942, 559));

        jLabel1.setText("jLabel1");

        jLabel2.setText("jLabel2");

        jLabel3.setText("jLabel3");

        jLabel4.setText("jLabel4");

        jLabel6.setText("jLabel6");

        jLabel7.setText("Start Time");

        jLabel5.setText("jLabel5");

        jButton3.setText("Start Server");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton1.setText("Stop Server");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Exit Server");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        TableDisplay.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Enrollment", "Name", "Start Time", "System No"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(TableDisplay);
        if (TableDisplay.getColumnModel().getColumnCount() > 0) {
            TableDisplay.getColumnModel().getColumn(0).setResizable(false);
            TableDisplay.getColumnModel().getColumn(1).setResizable(false);
            TableDisplay.getColumnModel().getColumn(2).setResizable(false);
            TableDisplay.getColumnModel().getColumn(3).setResizable(false);
        }

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 922, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel2))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel4))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel6))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(64, 64, 64)
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton2)
                        .addGap(58, 58, 58)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7)
                    .addComponent(jLabel5))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButton1)
                        .addComponent(jButton2))
                    .addComponent(jButton3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 414, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
int i=0,option;
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try {
            if(i==1)
            {
                    option=JOptionPane.showConfirmDialog(rootPane," Are you sure you want to Stop Server");
                    if(option==0)
                    {
                        stopServer();
                        i++;
                    }
                    t11.stop();
            }
            else if(i==0)
            {
                JOptionPane.showMessageDialog(rootPane,"Server is not started yet");
            }
            else
            {
                JOptionPane.showMessageDialog(rootPane,"Server is already stopped");
            }
        } catch (Exception ex) {
            Logger.getLogger(ServerSide.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton1ActionPerformed
    
    Mserver m = new Mserver();
    
    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        if(i==0)
        {i++;
            try {              
                t11.start();
                startServer();
                jLabel5.setText(new Date().toGMTString());
            } catch (Exception ex) {
                Logger.getLogger(ServerSide.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        else if(i==2)
            {
                JOptionPane.showMessageDialog(rootPane,"Server has been stopped, you need to restart session");
            }
        else
        {
                JOptionPane.showMessageDialog(rootPane,"Server is already running");
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        
                try {
                    stopServer();
                    this.dispose();
            System.gc();
            new Torus().setVisible(true);
                } catch (Exception ex) {
                    Logger.getLogger(ServerSide.class.getName()).log(Level.SEVERE, null, ex);
            }
    }//GEN-LAST:event_jButton2ActionPerformed

      public void assign()
    {
        jLabel1.setText(fn1);
        jLabel2.setText(fn2);
        jLabel3.setText(branch);
        jLabel4.setText(sec);
        jLabel5.setText("server not started yet");
        jLabel6.setText("00:00:00");  
    }  
    
    public  void startServer()
    {
        
          try {
              t1 = new Thread(this, "firstThread");  
              t1.start();
          System.out.println(t1.getName());
            
          } 
        catch (Exception ex) 
        {
            Logger.getLogger(Torus.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void stopServer() throws Exception
    {
        if(t1.isAlive())
        {       
        t2=new Thread(this,"secondThread");
        t2.start();
        }
    }
        public void run() 
            {
                if(Thread.currentThread() == t1)
                {
              System.out.println("requested to Start Server" );
                    try {
                        m.first();
                    } catch (Exception ex) {
                        Logger.getLogger(ServerSide.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                else if(Thread.currentThread() == t2)
                {              
                    System.out.println("requested to stop Server" );
                    try {
                        m.close();
                    } catch (Exception ex) {
                        System.out.println("exception generated in closing the server");
                        Logger.getLogger(ServerSide.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        
        public static void generateExel() throws IOException, WriteException
        {
            /*
            File f = new File("C:\\Users\\karanraj\\Desktop\\jdbc\\new.xls");
            WritableWorkbook myexel=Workbook.createWorkbook(f);
            WritableSheet mysheet = myexel.createSheet("mySheet",0);
            Label l = new Label("Karan",0);
            mysheet.addCell((WritableCell) l);
            myexel.write();
            myexel.close();
            System.out.println("Saved in the files");   
            */
            XSSFWorkbook workbook = new XSSFWorkbook();
            XSSFSheet spreadsheet = workbook.createSheet("Student Info");
            XSSFRow row;
            int rowid=0,cellid=0;
            row=spreadsheet.createRow(rowid++);
            XSSFCell cell=row.createCell(cellid++);
            cell.setCellValue("karan");
            
        try (FileOutputStream out = new FileOutputStream(new File("C:\\Users\\karanraj\\Desktop\\jdbc\\new.xlsx"))) {
            workbook.write(out);
            out.close();
        }
            System.out.println("Writesheet.xlsx written successfully");
        }
        
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
            java.util.logging.Logger.getLogger(ServerSide.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ServerSide.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ServerSide.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ServerSide.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() 
            {
               //new ServerSide(" "," "," "," "," ").setVisible(true);
               /* try {
                    generateExel();
                } catch (IOException ex) {
                    Logger.getLogger(ServerSide.class.getName()).log(Level.SEVERE, null, ex);
                } catch (WriteException ex) {
                    Logger.getLogger(ServerSide.class.getName()).log(Level.SEVERE, null, ex);
                }*/
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JTable TableDisplay;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
