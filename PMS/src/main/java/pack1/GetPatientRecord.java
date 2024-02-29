package pack1;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/GetRecord")
public class GetPatientRecord extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		HttpSession hs = request.getSession();
		hs.getAttribute("NAME");
		
		if(hs.getId()!=null && hs.getAttribute("NAME")!=null)
		{
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		out.println("<!DOCTYPE html>");
		out.println("<html>");
	 out.println("<head>");
	 out.println("<title> Get Record </title>");
	 out.println("<link href='https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css\' rel='stylesheet'>");
	 out.println("<script src='https://ajax.aspnetcdn.com/ajax/jQuery/jquery-3.6.4.js'></script>");
	 out.println("<script src='https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js'></script>");
	 out.println("<script src='https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.min.js'></script>");
	 out.println("</head>");
	 out.println("<body style='position:absolute;top:260px;left:560px;' class='container bg-dark'>");
		out.println("<form action='FindRecord' method='get'>");
		out.println("<table>");
		out.println("<tr>");
		out.println("<td class='text-light h3'> Patient Id : </td>");
		out.println("<td> <input type='text' name='pid' placeholder='PID' class='form-control' value='"+hs.getAttribute("PID")+"' readonly='true'/> </td>");
		out.println("<td colspan=2> <input type='submit' value='GET' class='btn  btn-success'/> </td>");
		out.println("</tr>");
		out.println("</table>");
		out.println("</form>");
		out.println("</body>");
		out.println("</html>");
	  }else
		{
			response.sendRedirect("Login.html");
		}
	}

}
