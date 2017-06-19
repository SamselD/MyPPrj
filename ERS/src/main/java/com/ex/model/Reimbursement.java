package com.ex.model;

import java.util.Date;

/**
 * Hello world!
 *
 */
public class Reimbursement {

		private int reimbursementId;
		private int statusId;
		private int employeeId;
		private Date dateSubmitted;
		private int amount;
		private String receipt;
		private String comments;
		private int managerId;
		private Date dateResolved;
		private int resolvedAmount;
		private int reimbursementTypeId;
		
		public Reimbursement(){	
		}
		
		public Reimbursement(int reimbursementId, int statusId, int employeeId, Date dateSubmitted, int amount,
				String receipt, String comments, int managerId, Date dateResolved, int resolvedAmount,
				int reimbursementTypeId) {
			super();
			this.reimbursementId = reimbursementId;
			this.statusId = statusId;
			this.employeeId = employeeId;
			this.dateSubmitted = dateSubmitted;
			this.amount = amount;
			this.receipt = receipt;
			this.comments = comments;
			this.managerId = managerId;
			this.dateResolved = dateResolved;
			this.resolvedAmount = resolvedAmount;
			this.reimbursementTypeId = reimbursementTypeId;
		}
		
		public int getReimbursementId() {
			return reimbursementId;
		}
		public void setReimbursementId(int reimbursementId) {
			this.reimbursementId = reimbursementId;
		}
		public int getStatusId() {
			return statusId;
		}
		public void setStatusId(int statusId) {
			this.statusId = statusId;
		}
		public int getEmployeeId() {
			return employeeId;
		}
		public void setEmployeeId(int employeeId) {
			this.employeeId = employeeId;
		}
		public Date getDateSubmitted() {
			return dateSubmitted;
		}
		
		public void setDateSubmitted(Date dateSubmitted) {
			this.dateSubmitted = dateSubmitted;
		}
		public int getAmount() {
			return amount;
		}
		public void setAmount(int amount) {
			this.amount = amount;
		}
		public String getReceipt() {
			return receipt;
		}
		public void setReceipt(String receipt) {
			this.receipt = receipt;
		}
		public int getManagerId() {
			return managerId;
		}
		public void setManagerId(int managerId) {
			this.managerId = managerId;
		}
		public Date getDateResolved() {
			return dateResolved;
		}
		public void setDateResolved(Date dateResolved) {
			this.dateResolved = dateResolved;
		}
		public int getResolvedAmount() {
			return resolvedAmount;
		}
		public void setResolvedAmount(int resolvedAmount) {
			this.resolvedAmount = resolvedAmount;
		}
		public int getReimbursementTypeId() {
			return reimbursementTypeId;
		}
		public void setReimbursementTypeId(int reimbursementTypeId) {
			this.reimbursementTypeId = reimbursementTypeId;
		}
		public String getComments() {
			return comments;
		}
		public void setComments(String comments) {
			this.comments = comments;
		}
  }
