package com.ex.DAO;

import com.ex.model.Employees;

public interface EmployeeDAO {
	
	public void save(Employees emp);
	public void update(Employees emp);
	public int findEmployeeById(int empId);
	public int findEmployeeRoleByRoleId(int empId);
}
