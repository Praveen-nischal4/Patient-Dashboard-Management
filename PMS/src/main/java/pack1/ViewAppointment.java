package pack1;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/viewAppo")
public class ViewAppointment extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		HttpSession hs = request.getSession();
	     hs.getAttribute("NAME");
		
		PrintWriter out = response.getWriter();
		if(hs.getId()!=null && hs.getAttribute("NAME")!=null)
		{
			  
			   response.setContentType("text/html");
			   out.println("<!DOCTYPE html>");
				out.println("<html>");
			 out.println("<head>");
			 out.println("<title> Set Appointment </title>");
			 out.println("<link href='https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css\' rel='stylesheet'>");
			 out.println("<script src='https://ajax.aspnetcdn.com/ajax/jQuery/jquery-3.6.4.js'></script>");
			 out.println("<script src='https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js'></script>");
			 out.println("<script src='https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.min.js'></script>");
			 out.println("</head>");
			 out.println("<body  class='container-fluid bg-success'>");
			 out.println("<form class='w-75 m-auto' method='post' action='getAppo'>");
			 out.println("<table class='margin-auto w-100 bg-success'>");
			 
			
			 out.println("<tr>");
			 out.println("<td class='text-light w-25 text-center'>  Patient ID </td>");
			 out.println("<td class='w-75'> <input class='w-75 form-control m-auto mt-2' type='text' name='PId' /> </td>");
			 out.println("</tr>");	
			 
			 out.println("<tr>");
			 out.println("<td colspan=2 class='w-75 text-center'> <input class='mt-5 mb-3 btn btn-lg btn-warning' type='submit' value='ADD APPOINTMENT' /> </td>");
			 out.println("</tr>");	
			 
			 out.println("</table>");	
			 out.println("</form>");
			 out.println("</body>");
			
		}else
		{
			response.sendRedirect("Login.html");
		}
	}

}
