package com.ex.mainimpl;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import com.ex.DAO.ReimbursementDAOImpl;
import com.ex.model.Reimbursement;

public class TestMain {

	public static void main(String[] args) {
		
		   /* Date SubmitDate = null;
		    DateFormat fmt = DateFormat.getDateInstance(DateFormat.FULL, Locale.US);
		    try {
		      SubmitDate = fmt.parse("2016-06-14");
		      System.out.println("The Date string is: " + fmt.format(SubmitDate));
		    } catch (java.text.ParseException e) {
		      System.out.println(e);
		    }*/
		 
		Date SubmitDate=null;
		String date = "2016-08-22";
		try {
			SubmitDate = new SimpleDateFormat("yyyy-MM-dd").parse(date);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// TODO Auto-generated method stub
		Reimbursement rForm = new Reimbursement(0,
												1,
												126, 
												SubmitDate,
												444,
												"Rainer",
												"Dsouza",
												128,
												SubmitDate,
												444,
												3);
		
		ReimbursementDAOImpl rDAO = new ReimbursementDAOImpl();
		rDAO.save(rForm);
		//rDAO.update(rForm);
	}

}
