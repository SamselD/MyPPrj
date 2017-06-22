package com.ex.DAO;

import java.util.ArrayList;
import java.util.List;

import com.ex.model.Reimbursement;
import com.ex.model.ReimbursementType;
import com.ex.model.Status;

public interface ReimbursementDAO {
	
	public boolean save(Reimbursement reimbursement);
	public boolean update(Reimbursement reimbursement);
	public ArrayList<Reimbursement> findReimbursementbyManagerId(int managerId);
	public ArrayList<Reimbursement> findReimbursementbyEmployeeId(int employeeId);
	public ArrayList<Reimbursement> findReimbursementbyStatusId(String statusId);
	
	public List<ReimbursementType> findReimbursementValues();
	public int findReimbursementTypeId(String typeValue);
	public int findStatusId(String statustValue);
}  
