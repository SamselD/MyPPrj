package com.ex.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.ex.model.Reimbursement;

public class ReimbursementDAOImpl implements ReimbursementDAO {
//insert into Reimbursement values ('',1,1, TO_DATE('2016-06-12', 'YYYY-MM-DD'),'Comments String',300,'Receipt String',3,TO_DATE('2016-06-14', 'YYYY-MM-DD'),300,3);

	@SuppressWarnings("null")
	public boolean save(Reimbursement reimbursement) {
		 Boolean value = null;
		try(Connection c = com.ex.utils.JdbcDriver.connect()){
			java.sql.Date submittedDate = new java.sql.Date( reimbursement.getDateSubmitted().getTime());
			java.sql.Date resolvedDate = new java.sql.Date(reimbursement.getDateResolved().getTime());
            String sql = "insert into Reimbursement values  ('',?,?,?,?,?,?,?,?,?,?)";
			PreparedStatement s = c.prepareStatement(sql);
            s.setInt(1,reimbursement.getStatusId()); //Create status is 1
            s.setInt(2,reimbursement.getEmployeeId());
            s.setDate(3, submittedDate);
            s.setString(4,reimbursement.getComments());
            s.setInt(5, reimbursement.getAmount());
            s.setString(6,reimbursement.getReceipt());
            s.setInt(7,reimbursement.getManagerId());
            s.setDate(8, resolvedDate);
            s.setInt(9,reimbursement.getResolvedAmount());
            s.setInt(10, reimbursement.getReimbursementTypeId());
            
            
            ResultSet rs = s.executeQuery();
            if(rs.next()){
            	return value = true;
            }else{
            	return value = false;
            }
            
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return true;
	}

	public boolean update(Reimbursement reimbursement) {
		 Boolean value = null;System.out.println("hihi");
			try(Connection c = com.ex.utils.JdbcDriver.connect()){
				java.sql.Date submittedDate = new java.sql.Date( reimbursement.getDateSubmitted().getTime());
				java.sql.Date resolvedDate = new java.sql.Date(reimbursement.getDateResolved().getTime());
	            String sql = "UPDATE REIMBURSEMENT  SET STATUSId = ?, EMPLOYEEID = ?, DATESUBMITTED = ?, COMMENTS = ?, AMOUNT = ?, RECEIPT = ?," + 
				" MANAGERID = ?, DATERESOLVED = ?, RESOLVEDAMOUNT = ?, REIMBURSEMENTTYPEID =? WHERE REID = ?";
				PreparedStatement s = c.prepareStatement(sql);
	            s.setInt(1,reimbursement.getStatusId()); //Create status is 1
	            s.setInt(2,reimbursement.getEmployeeId());
	            s.setDate(3, submittedDate);
	            s.setString(4,reimbursement.getComments());
	            s.setInt(5, reimbursement.getAmount());
	            s.setString(6,reimbursement.getReceipt());
	            s.setInt(7,reimbursement.getManagerId());
	            s.setDate(8, resolvedDate);
	            s.setInt(9,reimbursement.getResolvedAmount());
	            s.setInt(10, reimbursement.getReimbursementTypeId());
	            s.setInt(11, reimbursement.getReimbursementId());
	            
	            System.out.println("hi");
	            s.executeQuery();
	            System.out.println("hihihi");
	            
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return true;
		
	}

	public void delete(Reimbursement reimbursement) {
		// TODO Auto-generated method stub
		
	}

	public void findReimbursementbyId(int id) {
		// TODO Auto-generated method stub
		
	}

	public void findReimbursementbyManagerId(int managerId) {
		// TODO Auto-generated method stub
		
	}

	public void findReimbursementbyEmployeeId(int employeeId) {
		// TODO Auto-generated method stub
		
	}

	public void findReimbursementbyStatusId(int statusId) {
		// TODO Auto-generated method stub
		
	}

}
