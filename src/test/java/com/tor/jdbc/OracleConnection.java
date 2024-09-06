package com.tor.jdbc;

import java.sql.*;

public class OracleConnection {

    //connection STRING
    String dbUrl = "jdbc:oracle:thin:@35.171.162.149:1521:XE";
    String dbUsername = "DB_userName";
    String dbPassword = "DB_PassWord";

    // Create the connection

    //DriverManagerClass getConnectionMethod will help to connect database

   // Connection conn = DriverManager.getConnection(dbUrl, dbUsername, dbPassword);



    //It will help us to execute queries
   // Statement statement = conn.createStatement();

    //ResultSet will store data after execution. It stores only data (there is no table info)
   // ResultSet rs = statement.executeQuery("select * from  LOCATIONS");


        /*
              while (rs.next()){
        System.out.println(rs.getString("STREET_ADDRESS")+" - "+ rs.getString("CITY") );
    }

    public OracleConnection() throws SQLException {
    }
         */

}
