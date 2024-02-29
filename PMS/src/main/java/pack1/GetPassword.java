package pack1;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;

import DBConnection.DatabaseConfig;


@WebServlet("/GetPass")
public class GetPassword extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out =response.getWriter();
		int id = Integer.parseInt(request.getParameter("p_id"));
		String em = request.getParameter("pemail"); 
		String na = request.getParameter("pname");
		
		try
		{
			DatabaseConfig db = new DatabaseConfig();
			Connection con = db.getCon();
			PreparedStatement ps =con.prepareStatement("select pid,pname,pemail,password from user where pid=?");
			ps.setInt(1, id);
			ResultSet rs =  ps.executeQuery();
			
			int ID=0; String NM=null; String EM =null; String PWD=null;
			while(rs.next())
			{
				ID=rs.getInt(1);
				NM =rs.getString(2);
				EM =rs.getString(3);
				PWD =rs.getString(4);
		
			
			if((id==ID) && (NM.equals(na)) && (EM.equals(em))){
				
				
				out.println("Your password is = "+rs.getString(4));
			}
			else
			{
				out.println("Authentication Failed");
				out.println("You are not so Clever like me");
				out.println("Try Again!!!");
			}
	}
			
		}catch(SQLException e)
		{
			e.printStackTrace();
		}
	}

}
