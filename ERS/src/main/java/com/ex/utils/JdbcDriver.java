package com.ex.utils;

import java.sql.Connection;
import java.sql.SQLException;

import com.ex.utils.ConnectionUtil;

public class JdbcDriver {
	
	public static String url = "jdbc:oracle:thin:@project1.cy3tu4xtszf9.us-east-2.rds.amazonaws.com:1521:ERS";
	public static String username = "rainerdsouza";
	public static String password = "password";
    
    
    
    public static Connection connect(){
    	Connection c = null;
    	try {
			 c = ConnectionUtil.newConnection(url, username, password);
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
    	
    	return c;
    }

}
