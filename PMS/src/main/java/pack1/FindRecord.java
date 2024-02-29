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

@WebServlet("/FindRecord")
public class FindRecord extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
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
String query ="SELECT u.pid, u.pname, u.pcity, u.paddress, u.pemail,u.password,p.Mobile, p.Gender, p.Age, p.BloodGroup, p.lastvisit from user u join patient p on u.pid =p.pid where p.pid=?";
PreparedStatement ps = con.prepareStatement(query);
				ps.setInt(1, pid);
			ResultSet rs = ps.executeQuery();
			
			out.println("<!DOCTYPE html>");
	        out.println("<html>");
	        out.println("<head>");
	        out.println("<meta charset=\"UTF-8\">");
	        out.println("<title>Edit Record</title>");
	        out.println("<link href='https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css\' rel='stylesheet'>");
	   	 out.println("<script src='https://ajax.aspnetcdn.com/ajax/jQuery/jquery-3.6.4.js'></script>");
	   	 out.println("<script src='https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js'></script>");
	   	 out.println("<script src='https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.min.js'></script>");
	   	
	        out.println("</head>");
	        out.println("<body class='bg-secondary'>");
	        out.println("<h2>Edit Patient Record</h2>");
	        out.println("<form method='post' action='EditRecord'>");
			while(rs.next())
			{		
				out.println("<input type='hidden' name='pid' value='"+rs.getInt(1)+"'"+"</input>");
				out.println("<input type='text' name='name' value='"+rs.getString(2)+"'"+"</input>");
				out.println("<input type='text' name='city' value='"+rs.getString(3)+"'"+"</input>");
				out.println("<input type='text' name='add' value='"+rs.getString(4)+"'"+"</input>");
				out.println("<input type='text' name='email' value='"+rs.getString(5)+"'"+"</input>");
				out.println("<input type='password' name='pass' value='"+rs.getString(6)+"'"+"</input>");
				out.println("<input type='text' name='mobile' value='"+rs.getLong(7)+"'"+"</input>");
				out.println("<input type='text' name='gender' value='"+rs.getString(8)+"'"+"</input>");	
				out.println("<input type='text' name='age' value='"+rs.getInt(9)+"'"+"</input>");	
				out.println("<input type='text' name='blood' value='"+rs.getString(10)+"'"+"</input>");	
				out.println("<input type='text' name='visit' value='"+rs.getDate(11)+"'"+"</input>");	
				
			}
			
			out.println("<br>"+"<br>"+"<input clas='mx-5 text-center' type='submit' value='Save'/>");
			out.println("</form>");
			out.println("<br>");
			out.println("<br>");
				
			}catch(SQLException e) {
				e.printStackTrace();
			}
			
			
			
		}else
		{
			response.sendRedirect("Login.html");
		}
		
		
		
		
		}

	}


