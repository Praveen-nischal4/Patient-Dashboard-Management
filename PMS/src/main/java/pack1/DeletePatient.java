package pack1;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/DelRecord")
public class DeletePatient extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();
		HttpSession hs = request.getSession();
		hs.getAttribute("NAME");
		
		if(hs.getId()!=null && hs.getAttribute("NAME")!=null)
		{
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
		 out.println("<body style='position:absolute;top:260px;left:560px;' class='container bg-danger'>");
			out.println("<form action='DeleteRecord' method='post'>");
			out.println("<table>");
			out.println("<tr>");
			out.println("<td class='text-light h3'> Patient Id : </td>");
			out.println("<td> <input type='text' name='pid' placeholder='PID' class='form-control' /> </td>");
			out.println("<td> <input type='submit' value='DELETE' class='btn  btn-success'/> </td>");	
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
