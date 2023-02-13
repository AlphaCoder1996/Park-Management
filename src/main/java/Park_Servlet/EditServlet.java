package Park_Servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import Park_bo.Employee_bo;
import Park_dao.Employee;


@WebServlet("/EditServlet")
public class EditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		 PrintWriter pw=response.getWriter();
		
		 
	      String id=request.getParameter("id");
         
	      int eid= Integer.parseInt(id);
	    
	      Employee_bo eb=Employee.getEmployeeById(eid);
	    
		 
		pw.print("<form  action='updatecontroller' method='get'> ");
	    
		pw.print("<table>");
		
		pw.print("<tr><td>ID</td><td><input type='hidden' name='id' value='"+eb.getId()+"'/></td></tr>");  
		pw.print("<tr><td>Name: </td> <td><input type='text' name='name' value='"+eb.getName()+"'/></td></tr>");
	   	pw.print("<tr><td>Job Discription: </td> <td><input type='text' name='job' value='"+eb.getJob()+"'/></td></tr>");
	   	pw.print("<tr><td>Date of Joining:</td> <td><input type='text' name='doj' value='"+eb.getDoj()+"'/></td></tr>");
	   	pw.print("<tr><td>Contact: </td> <td><input type='text' name='phone' value='"+eb.getPhone()+"'/></td></tr>");
	   	pw.print("<tr><td>Email: </td> <td><input type='text' name='email' value='"+eb.getEmail()+"'/></td></tr>");
	   	pw.print("<tr><td>Date of Birth: </td> <td><input type='text' name='dob' value='"+eb.getDob()+"'/></td></tr>");
	   	pw.print("<tr><td>Adhar Card: </td> <td><input type='text' name='adhaar' value='"+eb.getAdhaar()+"'/></td></tr>");
		
	    pw.print("<tr><td><input type='submit' value='update'/></td></tr>"); 
	    
	   	pw.print("</table>");
		
		pw.print("</form>");
	}

}
