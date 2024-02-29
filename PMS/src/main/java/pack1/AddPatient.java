package pack1;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DBConnection.DatabaseConfig;

import java.sql.*;

@WebServlet("/addPatient")
public class AddPatient extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		PrintWriter out = response.getWriter();
		HttpSession hs = request.getSession();
	       hs.getAttribute("NAME");
	       
		 int pid =  (int)hs.getAttribute("PID");
		 
		
		Long mb = Long.parseLong(request.getParameter("phn"));
		String gen = request.getParameter("pgender");
		int age = Integer.parseInt(request.getParameter("page"));
		String blood = request.getParameter("pbg");
		String mydate = request.getParameter("pvisit");
		java.sql.Date dt = java.sql.Date.valueOf(mydate);
		
		hs.setAttribute("my_visit", dt);
		
		if(hs.getId()!=null && hs.getAttribute("NAME")!=null)
		{
			try
			{
				DatabaseConfig db = new DatabaseConfig();
				Connection con = db.getCon();
				
				PreparedStatement ps = con.prepareStatement("insert into patient values(?,?,?,?,?,?)");
				ps.setInt(1, pid);
				ps.setLong(2, mb);
				ps.setString(3, gen);
				ps.setInt(4, age);
				ps.setString(5, blood);
				ps.setDate(6, dt);
			int y =	ps.executeUpdate();
			out.println(y+"record inserted successfully");
				
			}catch(SQLException e)
			{
				e.printStackTrace();
			}
		}else
		{
			response.sendRedirect("Login.html");
		}
	}

}
