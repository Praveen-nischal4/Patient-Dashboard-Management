package pack1;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;
import DBConnection.DatabaseConfig;


@WebServlet("/Register")
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
  
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		PrintWriter out = response.getWriter();
		int pid= Integer.parseInt(request.getParameter("pid"));
		String pname =request.getParameter("pname");
		String pcty =request.getParameter("pcity");
		String padd =request.getParameter("padd");
		String email=request.getParameter("pemail");
		String pass =request.getParameter("pass");
		
		try
		{
			DatabaseConfig d = new DatabaseConfig();
			Connection con = d.getCon();
			
			PreparedStatement ps = con.prepareStatement("insert into user values(?,?,?,?,?,?)");
			ps.setInt(1, pid);
			ps.setString(2, pname);
			ps.setString(3, pcty);
			ps.setString(4, padd);
			ps.setString(5, email);
			ps.setString(6, pass);
		int y =	ps.executeUpdate();
		
		out.println(y+"record updated successfully");
		
		response.sendRedirect("Login.html");
			
		}catch(SQLException e)
		{
			e.printStackTrace();
		}
	}

}
