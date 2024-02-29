package pack1;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DBConnection.DatabaseConfig;

import java.sql.*;

@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
	
		int pid= Integer.parseInt(request.getParameter("pid"));
		String pass =request.getParameter("pass");
		
		try
		{
			DatabaseConfig db =new DatabaseConfig();
			Connection con =db.getCon();
			
			PreparedStatement ps = con.prepareStatement("select pid,pname,password from user where pid=?");
			ps.setInt(1, pid);
            ResultSet rs = ps.executeQuery();			
			
            int ID=0; String pwd = null; String name =null;
            if(rs.next())
            {
            	ID = rs.getInt(1);
            	name = rs.getString(2);
            	pwd = rs.getString(3);
            }
            
            if((ID == pid) && (pwd!=null &&pwd.equals(pass)))
            {
            	HttpSession hs = request.getSession(true);
            	hs.setAttribute("NAME",name);
            	hs.setAttribute("PID", ID);
            	
            	//RequestDispatcher rd= request.getRequestDispatcher("DashBoard.html");
            	//rd.forward(request, response);
            	response.sendRedirect("DashBoard.html");
            	rs.close();
  	 	        ps.close();
  	 	        con.close();
            	
            }else
            {
            	  rs.close();
  	 	        ps.close();
  	 	     response.sendRedirect("Login.html");
            }
			
            
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
	}

}
