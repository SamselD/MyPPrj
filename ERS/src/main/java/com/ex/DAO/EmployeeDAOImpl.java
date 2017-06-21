package com.ex.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.ex.model.Employees;
import com.ex.utils.ConnectionUtil;

public class EmployeeDAOImpl implements EmployeeDAO {

	public void save(Employees emp) {
		// TODO Auto-generated method stub
		
	}

	public void update(Employees emp) {
		// TODO Auto-generated method stub
		
	}

	public int findEmployeeById(int empId) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int findEmployeeRoleByRoleId(int empId) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	public static Boolean GetUserInfo(String username, String password){
		try (Connection con= com.ex.utils.JdbcDriver.connect();){
			
			String sql = "Select username from employees where username=? AND password=?";
			PreparedStatement pStat = con.prepareCall(sql);
			pStat.setString(1,username);
			pStat.setString(2,password);
			
			ResultSet bRet = pStat.executeQuery();
			
			if(bRet.next()){
				System.out.println("YES");
				return true;}
			else{
				System.out.println("NO");
				return false;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

}
