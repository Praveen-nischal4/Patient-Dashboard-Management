package pack1;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.sql.*;
import DBConnection.DatabaseConfig;


@WebServlet("/getAppo")
public class GetAppointmentStatus extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		
		HttpSession hs = request.getSession();
	     hs.getAttribute("NAME");
		int session_pid = (int)hs.getAttribute("PID");
		
		int pid = Integer.parseInt(request.getParameter("PId"));
	
	
	
		if(hs.getId()!=null && hs.getAttribute("NAME")!=null)
		{
			if((session_pid==pid))
			{
				try
				{
					DatabaseConfig db = new DatabaseConfig();
					Connection con = db.getCon();
					
					PreparedStatement ps = con.prepareStatement("select * from appointment where patient_id=?");
					ps.setInt(1, session_pid);
				 ResultSet rs =	ps.executeQuery();
				response.setContentType("text/html");
				 out.println("<h2 class='text-center'> Appointment  by MR."+hs.getAttribute("NAME")+"</h2>");
					out.println("<table class='table text-center' border='2px solid black'>");
					
				 while(rs.next())
				 {
					 out.println("<tr> <td>"+rs.getInt(1)+"<td>"+rs.getInt(2)+"<td>"+rs.getDate(3)+"<td>"+rs.getTime(4)+"<td>"+rs.getString(5)+"<td>"+rs.getString(6));
				 }
					out.println("</table>");
				}catch(SQLException e)
				{
					e.printStackTrace();
					
				}				
				
			}else {
				out.println("You can view your appointment only not else");
			}
			
		}else
		{
			response.sendRedirect("Login.html");
		
		}
	}

}
