package com.ex.DAO;

import com.ex.model.Reimbursement;

public interface ReimbursementDAO {
	
	public boolean save(Reimbursement reimbursement);
	public boolean update(Reimbursement reimbursement);
	public void delete(Reimbursement reimbursement);
	public void findReimbursementbyId (int id);
	public void findReimbursementbyManagerId(int managerId);
	public void findReimbursementbyEmployeeId(int employeeId);
	public void findReimbursementbyStatusId(int statusId);

}
