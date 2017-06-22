package com.ex.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ex.DAO.ReimbursementDAOImpl;
import com.ex.model.Reimbursement;
import com.ex.model.ReimbursementType;
import com.google.gson.Gson;

/**
 * Servlet implementation class EmployeeServlet
 */
public class EmployeeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmployeeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		HttpSession s = request.getSession();
		Map<String,Object> rObj= new HashMap();
		
		String command =request.getParameter("command");
		System.out.println("Command : "+command);
		switch (command) {
		case "new":
			rObj.put("user", s.getAttribute("user"));
			rObj.put("userid", s.getAttribute("userid"));
			
			List<ReimbursementType> reimbursementType = new ReimbursementDAOImpl().findReimbursementValues();
			ArrayList<String> typeList = new ArrayList();
			for(ReimbursementType rType : reimbursementType ){
				typeList.add(rType.getTypeName());
			}
			
			rObj.put("rTypeList", typeList);
			break;

		case "all":
			System.out.println("** ALL METHOD ** ");
			int id = Integer.parseInt(s.getAttribute("userid").toString());
			List<Reimbursement> reimbursementObjs = new ReimbursementDAOImpl().findReimbursementbyEmployeeId(id);
			int cnt=0;
			ArrayList<Reimbursement> rImb = new ArrayList();
			for(Reimbursement r: reimbursementObjs){
				cnt++;
				rImb.add(r);
			}
			rObj.put("reimbursements", rImb);
			System.out.println("No. of Reimbursements are : "+cnt);
			break;
			
		case "user":
			break;
		}
		
		
		rObj.put("username", s.getAttribute("username"));
		rObj.put("password", s.getAttribute("password"));
		
		String json = new Gson().toJson(rObj);
		System.out.println("RETUREn : "+json);
	    response.setContentType("application/json");
	    response.setCharacterEncoding("UTF-8");
	    response.getWriter().write(json);
	}

}
