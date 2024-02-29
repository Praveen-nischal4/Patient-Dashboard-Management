package pack1;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/proceed")
public class Appointment extends HttpServlet {
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
			 out.println("<div style='background-color:#35374B;height:130px;' class='conatiner-fluid h1 text-warning'>");		
			 out.println("<span class='float-end mt-1 mx-2'>"+hs.getAttribute("NAME")+"</span>");
			 out.println("<span class='mt-1 mx-2'>"+"Patient  ID :  <br> &nbsp;"+""+hs.getAttribute("PID")+"</span>");
			 out.println("</div>");
			 out.println("<div class='container-fluid' style='height:400px;'> ");
			 out.println("<p class='mt-5 h4 mt-5 bg-dark text-center m-auto' style='color:#FFF67E;width:600px;'>  Here You can fix your Appointment <br>");
		
			 out.println("<h3 class='text-light font-weight-bold p-4 btn btn-lg' style='background-color:#3E3232;position:absolute;top:400px;left:300px;font-weight:400;'> "
			 		+ "Add Appointment </h3>"+"<a class='text-warning  text-decoration-none' style='font-weight:500;position:absolute;top:317px;left:540px;font-size:140px;' href='CreateAppo'> +</a>");
			
			 out.println("<h3 class='p-4 btn btn-lg text-light' style='background-color:#3E3232;position:absolute;top:400px;left:860px;font-weight:400;'> "
				 		+ "View Appointment </h3>"+"<a class='text-warning text-decoration-none btn' style='font-weight:500;position:absolute;top:317px;left:1109px;font-size:140px;' href='viewAppo'> +</a>");
				
			 
			 out.println("</div>");
			 out.println("<body>");
			 out.println("</html>"); 
			
		}else
		{
			response.sendRedirect("Login.html");
		}
	}

}
