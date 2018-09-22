/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package otb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author Shubhashis
 */
public class DatabaseHelper {
    // JDBC driver name and database URL
   static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
   static final String DB_URL = "jdbc:mysql://localhost/OTB";

   //  Database credentials
   static final String USER = "dipta007";
   static final String PASS = "dipta007";
    
    public static boolean find(String sql)
    {
        boolean flg=false;
        Connection conn = null;
        Statement stmt = null;
        try{
           //STEP 2: Register JDBC driver
           Class.forName("com.mysql.jdbc.Driver");

           //STEP 3: Open a connection
           System.out.println("Connecting to database...");
           conn = DriverManager.getConnection(DB_URL,USER,PASS);

           //STEP 4: Execute a query
           System.out.println("Creating statement...");
           stmt = conn.createStatement();
           ResultSet rs = stmt.executeQuery(sql);

           //STEP 5: Extract data from result set
           int i=0;
           while(rs.next()){
              //Retrieve by column name
              i++;
           }
           if(i==0) flg=false;
           else flg=true;
           //STEP 6: Clean-up environment
           rs.close();
           stmt.close();
           conn.close();
        }catch(SQLException se){
           //Handle errors for JDBC
           se.printStackTrace();
        }catch(Exception e){
           //Handle errors for Class.forName
           e.printStackTrace();
        }finally{
           //finally block used to close resources
           try{
              if(stmt!=null)
                 stmt.close();
           }catch(SQLException se2){
           }// nothing we can do
           try{
              if(conn!=null)
                 conn.close();
           }catch(SQLException se){
              se.printStackTrace();
           }//end finally try
        }//end try
        return flg;
    }
    
    public static boolean insert(String sql)
    {
        boolean flg=false;
        Connection conn = null;
        Statement stmt = null;
        try{
           //STEP 2: Register JDBC driver
           Class.forName("com.mysql.jdbc.Driver");

           //STEP 3: Open a connection
           System.out.println("Connecting to database...");
           conn = DriverManager.getConnection(DB_URL,USER,PASS);

           //STEP 4: Execute a query
           System.out.println("Creating statement...");
           stmt = conn.createStatement();
           stmt.executeUpdate(sql);

           //STEP 6: Clean-up environment
           stmt.close();
           conn.close();
           flg=true;
        }catch(SQLException se){
           //Handle errors for JDBC
           se.printStackTrace();
        }catch(Exception e){
           //Handle errors for Class.forName
           e.printStackTrace();
        }finally{
           //finally block used to close resources
           try{
              if(stmt!=null)
                 stmt.close();
           }catch(SQLException se2){
           }// nothing we can do
           try{
              if(conn!=null)
                 conn.close();
           }catch(SQLException se){
              se.printStackTrace();
           }//end finally try
        }//end try
        return flg;
    }
    
    public static ArrayList fetchData(String sql,String getStringFrom)
    {
        boolean flg=false;
        Connection conn = null;
        Statement stmt = null;
        ArrayList result = new ArrayList();
        try{
           //STEP 2: Register JDBC driver
           Class.forName("com.mysql.jdbc.Driver");

           //STEP 3: Open a connection
           System.out.println("Connecting to database...");
           conn = DriverManager.getConnection(DB_URL,USER,PASS);

           //STEP 4: Execute a query
           System.out.println("Creating statement...");
           stmt = conn.createStatement();
           ResultSet rs = stmt.executeQuery(sql);

           int i=0;
           while(rs.next())
           {
               //System.err.println(rs.getString(getStringFrom));
               result.add(rs.getString(getStringFrom));
               i++;
           }
            //System.err.println(result.get(0));
           
           //STEP 6: Clean-up environment
           rs.close();
           stmt.close();
           conn.close();
           return result;
        }catch(SQLException se){
           //Handle errors for JDBC
           se.printStackTrace();
        }catch(NullPointerException e){
            return result;
        }catch(Exception e){
           //Handle errors for Class.forName
           e.printStackTrace();
        }finally{
           //finally block used to close resources
           try{
              if(stmt!=null)
                 stmt.close();
           }catch(SQLException se2){
           }// nothing we can do
           try{
              if(conn!=null)
                 conn.close();
           }catch(SQLException se){
              se.printStackTrace();
           }//end finally try
        }//end try
        return result;
    }
    
    public static boolean update(String sql)
    {
        boolean flg=false;
        Connection conn = null;
        Statement stmt = null;
        try{
           //STEP 2: Register JDBC driver
           Class.forName("com.mysql.jdbc.Driver");

           //STEP 3: Open a connection
           System.out.println("Connecting to database...");
           conn = DriverManager.getConnection(DB_URL,USER,PASS);

           //STEP 4: Execute a query
           System.out.println("Creating statement...");
           stmt = conn.createStatement();
           stmt.executeUpdate(sql);

           //STEP 5: Extract data from result set
           //as it is update function, so no data is updated
           flg=true;
           
           //STEP 6: Clean-up environment
           
           stmt.close();
           conn.close();
        }catch(SQLException se){
           //Handle errors for JDBC
           se.printStackTrace();
        }catch(Exception e){
           //Handle errors for Class.forName
           e.printStackTrace();
        }finally{
           //finally block used to close resources
           try{
              if(stmt!=null)
                 stmt.close();
           }catch(SQLException se2){
           }// nothing we can do
           try{
              if(conn!=null)
                 conn.close();
           }catch(SQLException se){
              se.printStackTrace();
           }//end finally try
        }//end try
        return flg;
    }
    
    public static int[] fetchAllData(String sql)
    {
        int arr[] = new int[40];
        Connection conn = null;
        Statement stmt = null;
        ArrayList result = new ArrayList();
        try{
           //STEP 2: Register JDBC driver
           Class.forName("com.mysql.jdbc.Driver");

           //STEP 3: Open a connection
           System.out.println("Connecting to database...");
           conn = DriverManager.getConnection(DB_URL,USER,PASS);

           //STEP 4: Execute a query
           System.out.println("Creating statement...");
           stmt = conn.createStatement();
           ResultSet rs = stmt.executeQuery(sql);

//           while(rs.next())
//           {
               //System.err.println(rs.getString(getStringFrom));
            int j=65;
            String getStringFrom = null;
            while(rs.next())
            {
            for(int i=1,k=1;i<=40;k++,i++)
            {
                getStringFrom="";

                char a = (char) j;
                char b = (char) (k+48); 
                getStringFrom=getStringFrom+a+b;
                System.err.println(getStringFrom);
                if(i%4==0)
                {
                    j++;
                }
                if(k%4==0)
                {
                    k=0;
                }
                arr[i-1]=rs.getInt(getStringFrom);
            }
            }
            for(int i=0;i<40;i++)
            {
                System.err.println(arr[i]);
            }
//               result.add(rs.getString(getStringFrom));
//           }
            //System.err.println(result.get(0));
           
           //STEP 6: Clean-up environment
           rs.close();
           stmt.close();
           conn.close();
           return arr;
        }catch(SQLException se){
           //Handle errors for JDBC
           se.printStackTrace();
        }catch(NullPointerException e){
            //return result;
        }catch(Exception e){
           //Handle errors for Class.forName
           e.printStackTrace();
        }finally{
           //finally block used to close resources
           try{
              if(stmt!=null)
                 stmt.close();
           }catch(SQLException se2){
           }// nothing we can do
           try{
              if(conn!=null)
                 conn.close();
           }catch(SQLException se){
              se.printStackTrace();
           }//end finally try
        }//end try
        return arr;
    }
    
}
