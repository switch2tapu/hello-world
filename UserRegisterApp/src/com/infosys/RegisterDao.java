package com.infosys;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;
import java.util.List;

public class RegisterDao {

	
public String registeruser(RegisterBean regisetrbean){
		
		String fullname = regisetrbean.getFirstname();
		String username = regisetrbean.getUsername();
		String emailid =  regisetrbean.getEmailid();
		String password = regisetrbean.getPassword();
		Connection con=null;
		
		try {
			String query= "insert into userdata values(?,?,?,?)";
			con = DbConnection.createConnection();
			PreparedStatement ps=con.prepareStatement(query);
			
			ps.setString(1, fullname);
			ps.setString(2, username);
			ps.setString(3, emailid);
			ps.setString(4, password);
			int i=ps.executeUpdate(); 
			
			if(i>=0) 
			    {
				System.out.print("You are successfully registered...");
				}
			return "SUCCESS";
			 
			
		} 
		catch (Exception e) 
		    {
			System.out.print(e);
		    }
		
		return "Failed to connect to Database";
		
		}

//Authenticating with DB 
public String Authentic(RegisterBean regisetrbean){
	 
	 String username = regisetrbean.getUsername();
	 String password = regisetrbean.getPassword();
	 Connection con=null;
	 
	 String usernameDB ="";
	 String passwordDB = "";
	 
	 try 
	 	{
		     System.out.println("Creating Database Connection");
			 String query = "select username, password from userdata";
			 con = DbConnection.createConnection();
			 PreparedStatement ps=con.prepareStatement(query); 
			 ps.executeQuery();
			 ResultSet rs =ps.getResultSet();
			 while (rs.next())
			 {
				 usernameDB = rs.getString("username");
				 passwordDB = rs.getString("password");

				 if(username.equals(usernameDB) && password.equals(passwordDB))
			   {
				System.out.println("Login Sucessful");
				return "LOGIN";
			   }
			 }
	 		}
		
	   catch (Exception e)
	    {
		   System.out.println("An Exception Occured :" +e); 
	    }
	return "Fetching records";
}

//Getting all the userdata from DB
public static List <RegisterBean> getAllRecords(){  
    List<RegisterBean> list = new ArrayList<RegisterBean>();  
      
    try{  
        Connection con= DbConnection.createConnection(); 
        PreparedStatement ps=con.prepareStatement("select * from USERDATA"); 
        ResultSet rs = ps.executeQuery();
        
        while(rs.next()){  
            RegisterBean rb = new RegisterBean();
            rb.setFirstname(rs.getString("firstname"));  
            rb.setUsername(rs.getString("username"));  
            rb.setEmailid(rs.getString("email"));
            rb.setPassword(rs.getString("password"));
            list.add(rb); 
            System.out.println("Added the values into the list");
        }  
    }
    catch(Exception e)
        {
    	System.out.println("This is an exception :"+e);
    	}  
    return list;  
}  

}

