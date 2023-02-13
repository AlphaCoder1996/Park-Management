package Park_Servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Park_bo.Employee_bo;
import Park_dao.Employee;

/**
 * Servlet implementation class AddEmployee
 */
@WebServlet("/AddEmployee")
public class AddEmployee extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter pw= response.getWriter();
		
		String name=request.getParameter("name");
		String job=request.getParameter("job");
		String jod=request.getParameter("jod");
		String phone=request.getParameter("phone");
		String email=request.getParameter("email");
		String dob=request.getParameter("dob");
		String adhaar=request.getParameter("adhaar");
		
		Employee_bo obj = new Employee_bo(name, job, jod, phone, email, dob, adhaar);
		
		if(Employee.add(obj)>0) {
			RequestDispatcher re=request.getRequestDispatcher("AllEmployeeInfo");
			re.forward(request, response);
		}
		else {
			pw.print("Something sent Wrong");
		}
		
		
		
		
	}
	
}
