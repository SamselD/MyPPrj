package com.ex.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ex.model.Reimbursement;
import com.ex.model.ReimbursementType;
import com.ex.model.Status;

public class ReimbursementDAOImpl implements ReimbursementDAO {
//insert into Reimbursement values ('',1,1, TO_DATE('2016-06-12', 'YYYY-MM-DD'),'Comments String',300,'Receipt String',3,TO_DATE('2016-06-14', 'YYYY-MM-DD'),300,3);

	@SuppressWarnings("null")
	public boolean save(Reimbursement reimbursement) {
		 Boolean value = null;
		 int statusid = findStatusId(reimbursement.getStatusValue());
		 int typeId = findReimbursementTypeId(reimbursement.getReimbursementTypeName());
		
		try(Connection c = com.ex.utils.JdbcDriver.connect()){
			java.sql.Date submittedDate = new java.sql.Date( reimbursement.getDateSubmitted().getTime());
			java.sql.Date resolvedDate = new java.sql.Date(reimbursement.getDateResolved().getTime());
            String sql = "insert into Reimbursement values  ('',?,?,?,?,?,?,?,?,?,?)";
			PreparedStatement s = c.prepareStatement(sql);
             //Create status is 1
            s.setInt(2,reimbursement.getEmployeeId());
            s.setDate(3, submittedDate);
            s.setString(4,reimbursement.getComments());
            s.setInt(5, reimbursement.getAmount());
            s.setString(6,reimbursement.getReceipt());
            s.setInt(7,reimbursement.getManagerId());
            s.setDate(8, resolvedDate);
            s.setInt(9,reimbursement.getResolvedAmount());
            s.setInt(10, typeId);
            s.setInt(1,statusid);
            
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
		 Boolean value = null;
		 System.out.println("hihi");
		 int statusid = findStatusId(reimbursement.getStatusValue());
		 int typeId = findReimbursementTypeId(reimbursement.getReimbursementTypeName());
			try(Connection c = com.ex.utils.JdbcDriver.connect()){
				java.sql.Date submittedDate = new java.sql.Date( reimbursement.getDateSubmitted().getTime());
				java.sql.Date resolvedDate = new java.sql.Date(reimbursement.getDateResolved().getTime());
	            String sql = "UPDATE REIMBURSEMENT  SET STATUSId = ?, EMPLOYEEID = ?, DATESUBMITTED = ?, COMMENTS = ?, AMOUNT = ?, RECEIPT = ?," + 
				" MANAGERID = ?, DATERESOLVED = ?, RESOLVEDAMOUNT = ?, REIMBURSEMENTTYPEID =? WHERE REID = ?";
				PreparedStatement s = c.prepareStatement(sql);
	            s.setInt(1,statusid); //Create status is 1
	            s.setInt(2,reimbursement.getEmployeeId());
	            s.setDate(3, submittedDate);
	            s.setString(4,reimbursement.getComments());
	            s.setInt(5, reimbursement.getAmount());
	            s.setString(6,reimbursement.getReceipt());
	            s.setInt(7,reimbursement.getManagerId());
	            s.setDate(8, resolvedDate);
	            s.setInt(9,reimbursement.getResolvedAmount());
	            s.setInt(10, typeId);
	            s.setInt(11, reimbursement.getReimbursementId());
	            
	            System.out.println("hi");
	            s.executeQuery();
	            System.out.println("hihihi");
	            
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return true;
		
	}

	@Override
	public ArrayList<Reimbursement> findReimbursementbyManagerId(int managerId) {
		ArrayList<Reimbursement> reimbursementList = new ArrayList<Reimbursement>(); 
		try(Connection c = com.ex.utils.JdbcDriver.connect()){
            String sql = "SELECT Reimbursement.REID, Reimbursement.EMPLOYEEID, Reimbursement.DATESUBMITTED, REIMBURSEMENT.COMMENTS," +
							" Reimbursement.AMOUNT, Reimbursement.RECEIPT, STATUS.STATUSVALUE, REIMBURSEMENTTYPE.TYPENAME" +
							" FROM REIMBURSEMENT" +
							" INNER JOIN status ON status.STATUSID = REIMBURSEMENT.STATUSID"+
							" Inner JOIN EMPLOYEES on EMPLOYEES.EMPLOYEEID = REIMBURSEMENT.EMPLOYEEID " +
							" INNER JOIN REIMBURSEMENTTYPE ON REIMBURSEMENTTYPE.TYPEID = REIMBURSEMENT.REIMBURSEMENTTYPEID and REIMBURSEMENT.MANAGERID =?";
			PreparedStatement s = c.prepareStatement(sql);
            s.setInt(1,managerId);
            ResultSet rs = s.executeQuery();
            while(rs.next()){
            	Reimbursement r = new Reimbursement();
            	r.setReimbursementId(rs.getInt(1));
            	r.setEmployeeId(rs.getInt(2));
            	r.setDateSubmitted(rs.getDate(3));
            	r.setComments(rs.getString(4));
            	r.setAmount(rs.getInt(5));
            	r.setReceipt(rs.getString(6));
            	r.setStatusValue(rs.getString(7));
            	r.setReimbursementTypeName(rs.getString(8));
            	reimbursementList.add(r);
            }
            
		} catch (SQLException e) {
			e.printStackTrace();
		}

	return reimbursementList;
	}
	

	@Override
	public ArrayList<Reimbursement> findReimbursementbyEmployeeId(int employeeId) {
		ArrayList<Reimbursement> reimbursementList = new ArrayList<Reimbursement>(); 
		try(Connection c = com.ex.utils.JdbcDriver.connect()){
            String sql = "SELECT Reimbursement.REID, Reimbursement.EMPLOYEEID, Reimbursement.DATESUBMITTED, REIMBURSEMENT.COMMENTS," +
							" Reimbursement.AMOUNT, Reimbursement.RECEIPT, STATUS.STATUSVALUE, REIMBURSEMENTTYPE.TYPENAME" +
							" FROM REIMBURSEMENT" +
							" INNER JOIN status ON status.STATUSID = REIMBURSEMENT.STATUSID"+
							" Inner JOIN EMPLOYEES on EMPLOYEES.EMPLOYEEID = REIMBURSEMENT.EMPLOYEEID and REIMBURSEMENT.EMPLOYEEID = ?" +
							" INNER JOIN REIMBURSEMENTTYPE ON REIMBURSEMENTTYPE.TYPEID = REIMBURSEMENT.REIMBURSEMENTTYPEID";
			PreparedStatement s = c.prepareStatement(sql);
            s.setInt(1,employeeId);
            ResultSet rs = s.executeQuery();
            while(rs.next()){
            	Reimbursement r = new Reimbursement();
            	r.setReimbursementId(rs.getInt(1));
            	r.setEmployeeId(rs.getInt(2));
            	r.setDateSubmitted(rs.getDate(3));
            	r.setComments(rs.getString(4));
            	r.setAmount(rs.getInt(5));
            	r.setReceipt(rs.getString(6));
            	r.setStatusValue(rs.getString(7));
            	r.setReimbursementTypeName(rs.getString(8));
            	reimbursementList.add(r);
            }
            
		} catch (SQLException e) {
			e.printStackTrace();
		}

	return reimbursementList;
	}

	@Override
	public ArrayList<Reimbursement> findReimbursementbyStatusId(String statusValue) {
		ArrayList<Reimbursement> reimbursementList = new ArrayList<Reimbursement>(); 
			try(Connection c = com.ex.utils.JdbcDriver.connect()){
	            String sql = "SELECT Reimbursement.REID, Reimbursement.EMPLOYEEID, Reimbursement.DATESUBMITTED, REIMBURSEMENT.COMMENTS," +
								" Reimbursement.AMOUNT, Reimbursement.RECEIPT, STATUS.STATUSVALUE, REIMBURSEMENTTYPE.TYPENAME" +
								" FROM REIMBURSEMENT" +
								" INNER JOIN status ON status.STATUSID = REIMBURSEMENT.STATUSID and status.STATUSVALUE = ?"+
								" Inner JOIN EMPLOYEES on EMPLOYEES.EMPLOYEEID = REIMBURSEMENT.EMPLOYEEID" +
								" INNER JOIN REIMBURSEMENTTYPE ON REIMBURSEMENTTYPE.TYPEID = REIMBURSEMENT.REIMBURSEMENTTYPEID";
				PreparedStatement s = c.prepareStatement(sql);
	            s.setString(1,statusValue);
	            ResultSet rs = s.executeQuery();
	            while(rs.next()){
	            	Reimbursement r = new Reimbursement();
	            	r.setReimbursementId(rs.getInt(1));
	            	r.setEmployeeId(rs.getInt(2));
	            	r.setDateSubmitted(rs.getDate(3));
	            	r.setComments(rs.getString(4));
	            	r.setAmount(rs.getInt(5));
	            	r.setReceipt(rs.getString(6));
	            	r.setStatusValue(rs.getString(7));
	            	r.setReimbursementTypeName(rs.getString(8));
	            	reimbursementList.add(r);
	            }
	            
			} catch (SQLException e) {
				e.printStackTrace();
			}

		return reimbursementList;
	}

	public List<ReimbursementType> findReimbursementValues() {
		List<ReimbursementType> reimbursementTypeList = new ArrayList();
		try(Connection c = com.ex.utils.JdbcDriver.connect()){
            String sql = "select * from REIMBURSEMENTTYPE";
			PreparedStatement s = c.prepareStatement(sql);
            ResultSet rs = s.executeQuery();
            while(rs.next()){
            	ReimbursementType reimbursementType = new ReimbursementType();
            	reimbursementType.setTypeId(rs.getInt(1));
            	reimbursementType.setTypeName(rs.getString(2));
            	reimbursementTypeList.add(reimbursementType);
            }
            
		} catch (SQLException e) {
			e.printStackTrace();
		}

	return reimbursementTypeList;
	}

	@Override
	public int findStatusId(String statustValue) {
		int id = 0;
		try(Connection c = com.ex.utils.JdbcDriver.connect()){
            String sql = "select STATUSID from Status where STATUSVALUE =?";
			PreparedStatement s = c.prepareStatement(sql);
			s.setString(1,statustValue);
            ResultSet rs = s.executeQuery();
            
            if(rs.next()){
            	id = rs.getInt(1);
            }
            
		} catch (SQLException e) {
			e.printStackTrace();
		}

	return id;
	}
	
	public int findReimbursementTypeId(String typeValue) {
		int id = 0;
		try(Connection c = com.ex.utils.JdbcDriver.connect()){
            String sql = "select TYPEID from REIMBURSEMENTTYPE where TYPENAME =?";
			PreparedStatement s = c.prepareStatement(sql);
			s.setString(1,typeValue);
            ResultSet rs = s.executeQuery();
            
            if(rs.next()){
            	id = rs.getInt(1);
            }
            
		} catch (SQLException e) {
			e.printStackTrace();
		}

	return id;
	}

	

}
