package com.ex.servlet;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.JSONObject;
/*
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
*/

import com.ex.DAO.EmployeeDAOImpl;
import com.google.gson.Gson;

/**
 * Servlet implementation class LoginServelet
 */
public class LoginServelet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServelet() {
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
		System.out.println("------------------------\nPOST LOGIN METHOD CALLED\n------------------------");
		try {
			
			String username =request.getParameter("username");
			String password =request.getParameter("password");
			System.out.println("Username :" +username);
			System.out.println("Password :" +password);
			System.out.println("------------------------");
			
			//Call the DAO Query
			Boolean b = EmployeeDAOImpl.GetUserInfo(username,password);
			if(b.equals("TRUE")){
				System.out.println("****  USER FOUND  ****");
			}
			
			//Return from DAO will have following info NOTE: CURRENTLY HARDCODED
			Map<String,Object> rObj= new HashMap();
			rObj.put("ROLE", "Employee");
			
			String user="";
			String userid="";
			HttpSession s=request.getSession();
			s.setAttribute("username",username);
			s.setAttribute("password",password);
			s.setAttribute("user",user);
			s.setAttribute("userid",userid);
			
			String json = new Gson().toJson(rObj);
			System.out.println("RETUREn : "+json);
		    response.setContentType("application/json");
		    response.setCharacterEncoding("UTF-8");
		    response.getWriter().write(json);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
