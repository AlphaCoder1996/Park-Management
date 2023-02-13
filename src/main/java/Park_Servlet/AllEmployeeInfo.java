package Park_Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Park_bo.Employee_bo;
import Park_dao.Employee;



/**
 * Servlet implementation class AllEmployeeInfo
 */
@WebServlet("/AllEmployeeInfo")
public class AllEmployeeInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		  response.setContentType("text/html");
		   PrintWriter pw=response.getWriter();
		   
		   
		   
		   pw.print("<div style='text-align:center;'>");
		   pw.print("<table border='1px' width='100%'> ");
		    
		    pw.print("<tr> <th> Id </th> <th> Name </th> <th> Job Description </th><th> Date of Join </th> <th> Phone </th> <th> Email </th> <th>Date of Birth</th> <th>Adhaar</th><th>Edit</th><th>Delete</th></tr>");
		   
		   
		   
		  List<Employee_bo > list= Employee.getAllEmployee();
		   
		  for(Employee_bo eb:list) {
			  
			   pw.print("<tr><td>"+eb.getId()+"</td><td>"+eb.getName()+"</td><td>"+eb.getJob()+"</td><td>"+eb.getDoj()+"</td><td>"+eb.getPhone()+"</td><td>"+eb.getEmail()+"</td><td>"+eb.getDob()+"<td>"+eb.getAdhaar()+"</td><td><a href='EditServlet?id="+eb.getId()+"'> edit </a></td> <td><a href='DeleteServlet?id="+eb.getId()+"'>delete </a></td></tr>");  
		  }
		  pw.print("</div>");
		  pw.print("<a href='employee.html'>Back</a>");
	}

}
