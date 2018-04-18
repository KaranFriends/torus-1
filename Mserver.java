/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication2;

/**
 *
 * @author karanraj
 */
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import static javaapplication2.StartServer.TableDisplay;
//currently i am sending enrollment no and system number from clientside
class Mserver implements Runnable {
 	public String[] data;
	Socket csocket=null;
        ServerSocket ssock;
        String h,big,data1;
        Connection con;
        PreparedStatement st;
        Date t1;
        Mserver()
        {
            
        }
    Mserver(Socket csocket)
    {
        this.csocket = csocket;
    }
    
    public synchronized void task(Socket csocket) throws IOException
    {
        h=StartServer.tablename;
	try{            
            BufferedReader input1=new BufferedReader(new InputStreamReader(csocket.getInputStream()));
            data=input1.readLine().split(",");
            System.out.println(data);
            
            try{
            con=DriverManager.getConnection( "jdbc:derby:Server","server123","password12345"); 
            System.out.println("hello i am listening "+data[0]);
           if(data[0].equals("true"))
            {
            big="insert into "+h+" values(?,?,?,?,?,?,?)";
            System.out.println("now i am into your databse");
            
            System.out.println(h);
            
            st=con.prepareStatement(big);
            System.out.println("out of db");
            st.setString(1,data[1]);
            st.setString(2,data[2]);
            st.setString(3,data[5]);
            st.setString(4,"   ");
            st.setString(5,"   ");
            st.setString(6,data[4]);
            st.setString(7,data[3]);
            st.executeUpdate();
            
            DefaultTableModel model = (DefaultTableModel) TableDisplay.getModel();
            model.addRow(new Object[]{data[1],data[2],data[5],data[4]});
            
                    System.out.println("successful");
                    PrintWriter output=new PrintWriter(csocket.getOutputStream(),true);
                    output.println("successful");
                    output.flush();
            }
           con.close();
        }
            catch(SQLException e)
            {
                System.out.println("i am refusing connection");
                System.out.println("duplicate entry");
                    PrintWriter output=new PrintWriter(csocket.getOutputStream(),true);
                    output.println("duplicate entry");
                    output.flush();
                System.out.println(e.getMessage());
                csocket.close();
                
                /*if(e.toString().equals("java.sql.SQLIntegrityConstraintViolationException: The statement was aborted because it would have caused a duplicate key value in a unique or primary key constraint or unique index identified by 'SQL180414190136121' defined on 'IUIOJHKVYUF_EWE_14_3_118'."))
                {
                    System.out.println("duplicate entry");
                    PrintWriter output=new PrintWriter(csocket.getOutputStream(),true);
                    output.println("duplicate entry");
                    output.flush();
                }*/
            }
        } 
        catch (IOException ex) {
            System.out.println("i am not getting data 1111111111");
            System.out.println(ex.getMessage());
            Logger.getLogger(Torus.class.getName()).log(Level.SEVERE, null, ex);
        }        
    
    }
    public synchronized void first() throws Exception {
        ssock = new ServerSocket(1234);
        System.out.println("Listening");// server started

        while (!ssock.isClosed())//accepting clients
	 {
                System.out.println("inside while");
                Socket sock = ssock.accept();
                try{
                    if(sock.isConnected()) 
                {   
                    System.out.println("send true");
                    PrintWriter output=new PrintWriter(sock.getOutputStream(),true);
                    output.println("true");
                    output.flush();
                    BufferedReader input1=new BufferedReader(new InputStreamReader(sock.getInputStream()));
                    data1=input1.readLine();
               }
                }
                catch(Exception e)
                {
                    System.out.println("fuck off");
                }
                if(data1.equals("true"))
                {
                    new Thread(new Mserver(sock)).start();
                    System.out.println("Connected");
                }
                
        }
    }
    public void close() throws Exception
        {
            ssock.close();
            System.out.println("Connection terminated");
        }
         @Override
    public void run() {
        try 
        {
            System.out.println("running task");
            task(csocket);
            
            System.out.println(data[1]);
            while(true)
            {
                  //  System.out.println(csocket.getInetAddress());
                try {
                if(csocket.getInputStream().read()==-1 || csocket.isClosed() || ssock.isClosed())
                {   
                       
                            System.out.println("excption is generated");
                            t1=new Date();
                            con=DriverManager.getConnection( "jdbc:derby:Server","server123","password12345");
                            big="update "+h+" set end_time=? where enrollment=?";
                            st=con.prepareStatement(big);
                            st.setString(1,t1.getHours()+":"+t1.getMinutes()+":"+t1.getSeconds());
                            st.setString(2,data[1]);
                            st.executeUpdate();
                            if(!csocket.isClosed())
                                    this.csocket.close();
                            System.out.println("breaking");
                            break;
                        }}
                        catch (SQLException ex) {
                            Logger.getLogger(Mserver.class.getName()).log(Level.SEVERE, null, ex);
                            System.out.println("hhuhufuhdfiwhuofwuoefwo");
                        }
                  
            
        }
        }
        catch (IOException e) {
            System.out.println("i am getting terminatedxx");
            System.out.println(e);
        }
    
}
}