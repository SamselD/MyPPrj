package com.ex.DAO;

import com.ex.model.Employees;

public interface EmployeeDAO {
	
	public boolean save(Employees emp);
	public boolean update(Employees emp);
	public int findEmployeeById(int empId);
	public int findEmployeeRoleByRoleId(int empId);
	public Employees getUserInfo(String username, String password);
}
