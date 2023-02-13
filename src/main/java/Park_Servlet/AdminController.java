package Park_Servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Park_bo.Adminstrators;
import Park_dao.InsertAdmin;

/**
 * Servlet implementation class AdminController
 */
@WebServlet("/AdminController")
public class AdminController extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter pw= response.getWriter();
		
		String user=request.getParameter("user");
		String pas=request.getParameter("pas");
		
		Adminstrators obj=new Adminstrators ();
		obj.setId(user);
		obj.setPass(pas);
		
		if(InsertAdmin.add(obj)>0) {
			pw.print("Data Added Succesfully");
		}
		else {
			pw.print("Something Went Wrong");
		}
	}

}
