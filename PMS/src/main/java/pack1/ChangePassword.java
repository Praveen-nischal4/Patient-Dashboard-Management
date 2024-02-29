package pack1;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/ChangPass")
public class ChangePassword extends HttpServlet {
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
	 out.println("<body style='position:absolute;top:260px;left:500px;background-color:#3D2B1F;' class='container'>");
	 
	 out.println("<form action='UpdatePass' method='post'>");	 
	 out.println("<table>");
	 out.println("<tr>");
	 out.println("<td class='text-light h4'> Current Password : </td>");
	 out.println("<td> <input type='password' name='curpass' placeholder='Current Password' class='form-control'/> </td>");
	 out.println("</tr>");
	 out.println("<tr>");
	 out.println("<td class='text-light h4'> New Password : </td>");
	 out.println("<td> <input type='password' name='newpass' placeholder='New Password' class='form-control'/> </td>");
	 out.println("</tr>");
	 out.println("<tr>");
	 out.println("<td class='text-light h4'> Retype Password : </td>");
	 out.println("<td> <input type='password' name='repass' placeholder='Current Password' class='form-control'/> </td>");
	 out.println("</tr>");
	 
	 out.println("<tr>");
	
	 out.println("<td colspan=2> <input type='submit' value='UPDATE PASSWORD' class='btn btn-lg btn-success mt-5 mx-5'/> </td>");
	 out.println("</tr>");
	 
	 out.println("</table>");
	 out.println("</form>");
	 out.println("<h5 class='text-warning text-center'>Currently you are logged in with UserName as "+hs.getAttribute("NAME") +"</h5>");
	 out.println("</body>");
	 out.println("</html>");
	 
		}else
		{
			response.sendRedirect("Login.html");
		}
	}

}
