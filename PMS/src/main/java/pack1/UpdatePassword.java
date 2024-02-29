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

@WebServlet("/UpdatePass")
public class UpdatePassword extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		

		HttpSession hs = request.getSession();
		hs.getAttribute("NAME");
		PrintWriter out= response.getWriter();
		String curpwd =request.getParameter("curpass");
		String newpwd =request.getParameter("newpass");
		String retyppwd =request.getParameter("repass");
		
		if(hs.getId()!=null && hs.getAttribute("NAME")!=null)
		{
			try
			{
				if((!curpwd.isBlank()) &&(newpwd.equals(retyppwd)))
				{
					DatabaseConfig db = new DatabaseConfig();
					Connection con = db.getCon();
					PreparedStatement ps =con.prepareStatement("update user set password =? where password =?");
					ps.setString(1, newpwd);
					ps.setString(2, curpwd);
					ps.executeUpdate();
					

					  out.println("password is updated please login again");
					  response.sendRedirect("Login.html");
				}else
				{
					out.println("All fields are mandentory");
					return;
				}
				
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
