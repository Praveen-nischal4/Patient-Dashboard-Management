package pack1;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DBConnection.DatabaseConfig;

import java.sql.*;

@WebServlet("/EditRecord")
public class EditRecord extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession hs = request.getSession();
		hs.getAttribute("NAME");
		
		PrintWriter out = response.getWriter();
		
		int pid = Integer.parseInt(request.getParameter("pid"));
		String nm = request.getParameter("name");
		String pcty = request.getParameter("city");
		String padd = request.getParameter("add");
		String pem = request.getParameter("email");
		String pass = request.getParameter("pass");
		Long mobile = Long.parseLong(request.getParameter("mobile"));
		String gen = request.getParameter("gender");
		int age = Integer.parseInt(request.getParameter("age"));
		String bld = request.getParameter("blood");
		String date = request.getParameter("visit");
		Date d = Date.valueOf(date);
		
		
		
		if(hs.getId()!=null && hs.getAttribute("NAME")!=null)
		{
			try
			{
				DatabaseConfig db = new DatabaseConfig();
				Connection con = db.getCon();
				
String query ="UPDATE user u,patient p"+" SET u.pname =? , u.pcity =? , u.paddress =? ,u.pemail =? ,u.password =?, "+"p.Mobile =?, p.Gender =?, p.Age =?, p.BloodGroup =?, p.lastvisit =?"
	    	+"WHERE u.pid = p.pid AND u.pid = ?";
				
				PreparedStatement ps = con.prepareStatement(query);
				 ps.setString(1, nm);
	                ps.setString(2, pcty);
	                ps.setString(3, padd);
	                ps.setString(4, pem);
	                ps.setString(5, pass);
	                ps.setLong(6, mobile);
	                ps.setString(7, gen);
	                ps.setInt(8, age);
	                ps.setString(9, bld);
	                ps.setDate(10, d);
	                ps.setInt(11, pid);
			
			int y=	ps.executeUpdate();
				out.println(y+"row updated");
				
			}catch(SQLException e) {
				e.printStackTrace();
			}
			
		}else
		{
			response.sendRedirect("Login.html");
		}
		
	}

	

}
