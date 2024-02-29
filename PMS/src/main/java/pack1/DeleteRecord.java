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

@WebServlet("/DeleteRecord")
public class DeleteRecord extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();
		
		int pid = Integer.parseInt(request.getParameter("pid"));		
		
		HttpSession hs = request.getSession();
		hs.getAttribute("NAME");
		
		
		if(hs.getId()!=null && hs.getAttribute("NAME")!=null)
		{
			
			try
			{
				DatabaseConfig db = new DatabaseConfig();
				Connection con = db.getCon();
			String query ="DELETE user, patient FROM user INNER JOIN patient ON user.pid = patient.pid WHERE user.pid = ?";
				PreparedStatement ps = con.prepareStatement(query);
				ps.setInt(1, pid);
			  int y =ps.executeUpdate();
			  out.println(y+"rows deleted successfully");
				//response.sendRedirect("http://localhost:8080/PMS/GetRecord");
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
