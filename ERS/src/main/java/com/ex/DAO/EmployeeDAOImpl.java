package com.ex.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.ex.model.Employees;
import com.ex.model.Reimbursement;

public class EmployeeDAOImpl implements EmployeeDAO {

	public boolean save(Employees emp) {
			Boolean value = null;
			try(Connection c = com.ex.utils.JdbcDriver.connect()){
	            String sql = "insert into Employees values  ('',?,?,?,?,?)";
				PreparedStatement s = c.prepareStatement(sql);
	             //Create status is 1
	            s.setInt(1,emp.getRoleId());
	            s.setString(2, emp.getFirstName());
	            s.setString(3,emp.getLastName());
	            s.setString(4,emp.getUserName());
	            s.setString(5,emp.getPassword());
	            
	            ResultSet rs = s.executeQuery();
	            if(rs.next()){
	            	 value = true;
	            }else{
	            	 value = false;
	            }
	            
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return value;
		}
		
	

	public boolean update(Employees emp) {
		Boolean value = null;
		try(Connection c = com.ex.utils.JdbcDriver.connect()){
            String sql = "update EMPLOYEES set ROLEID = ?, FIRSTNAME =?, LASTNAME =?, USERNAME=?, PASSWORD=? WHERE EMPLOYEEID=?";
			PreparedStatement s = c.prepareStatement(sql);
             //Create status is 1
            s.setInt(1,emp.getRoleId());
            s.setString(2, emp.getFirstName());
            s.setString(3,emp.getLastName());
            s.setString(4,emp.getUserName());
            s.setString(5,emp.getPassword());
            s.setInt(6, emp.getEmployeeId());
            ResultSet rs = s.executeQuery();
            if(rs.next()){
            	 value = true;
            }else{
            	 value = false;
            }
            
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return value;		
	}
	
	public Employees getUserInfo(String username, String password){
		Employees e = new Employees();
		try (Connection con= com.ex.utils.JdbcDriver.connect();){
			
			String sql = "Select * from employees where username=? AND password=?";
			PreparedStatement pStat = con.prepareCall(sql);
			pStat.setString(1,username);
			pStat.setString(2,password);
			
			ResultSet rs = pStat.executeQuery();
			
			if(rs.next()){
				
				e.setEmployeeId(rs.getInt(1));
				e.setRoleId(rs.getInt(2));
				e.setFirstName(rs.getString(3));
				e.setLastName(rs.getString(4));
				e.setUserName(rs.getString(5));
				e.setPassword(rs.getString(6));
			}
			else{
				System.out.println("NO");
			}
			
		} catch (SQLException ex) {
			// TODO Auto-generated catch block
			ex.printStackTrace();
		}
		return e;
	}

	public int findEmployeeById(int empId) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int findEmployeeRoleByRoleId(int empId) {
		// TODO Auto-generated method stub
		return 0;
	}

}
