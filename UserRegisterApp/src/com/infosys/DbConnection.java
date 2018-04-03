package com.infosys;

import java.sql.Connection;
import java.sql.DriverManager;

public class DbConnection {
public static Connection createConnection(){
		
		
		String oracledriver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:orcl";
		String username ="scott";
		String password= "cisco";
		Connection con = null;
		
		try {
			
			Class.forName(oracledriver);
			con= DriverManager.getConnection(url, username, password); 
			
			
		} catch (Exception e) {
			System.out.println(e);
		}
		
		return con;
		
		
		
	} 

}
