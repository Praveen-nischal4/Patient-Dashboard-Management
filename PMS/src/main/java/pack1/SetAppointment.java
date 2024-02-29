package pack1;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DBConnection.DatabaseConfig;


@WebServlet("/setAppo")
public class SetAppointment extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession hs = request.getSession();
	
		PrintWriter out = response.getWriter();
		
	//	int aid = Integer.parseInt(request.getParameter("aid"));
		int p_id =Integer.parseInt(request.getParameter("PId"));
		
		String adate = request.getParameter("adate");
		java.sql.Date myDate = java.sql.Date.valueOf(adate);
		
		String atime = request.getParameter("atime");
		java.sql.Time myTime = java.sql.Time.valueOf(atime);
		
		String apur = request.getParameter("apurpose");
		String astatus = request.getParameter("astatus");
		
    	
		if(hs.getId()!=null && hs.getAttribute("NAME")!=null)
		{
			try
			{
				DatabaseConfig db = new DatabaseConfig();
				Connection con = db.getCon();
				
				String sql = "INSERT INTO appointment (patient_id, appointment_date, appointment_time, appointment_purpose, appointment_status) " +
	                     "SELECT ?, ?, ?, ?, ? " +
	                     "FROM patient " +
	                     "WHERE pid = ?";
				PreparedStatement ps = con.prepareStatement(sql);
				//ps.setInt(1, aid);
				ps.setInt(1, p_id);
				ps.setDate(2, myDate);
				ps.setTime(3, myTime);
				ps.setString(4, apur);
				ps.setString(5,astatus);
				ps.setInt(6,p_id);
			int y =	ps.executeUpdate();
				out.println(y+"Appointment Set successfully");
				
				if(y==0)
				{
					out.println("You must add as a patient before creating appointment");
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
