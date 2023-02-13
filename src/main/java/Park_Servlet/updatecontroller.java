package Park_Servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Park_bo.Employee_bo;
import Park_dao.Employee;



/**
 * Servlet implementation class updatecontroller
 */
@WebServlet("/updatecontroller")
public class updatecontroller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public updatecontroller() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id=Integer.parseInt(request.getParameter("id"));
		String name=request.getParameter("name");
		String job=request.getParameter("job");
		String doj =request.getParameter("doj");
		String phone=request.getParameter("phone");
		String email=request.getParameter("email");
		String dob=request.getParameter("dob");
		String adhar=request.getParameter("adhaar");
		
		Employee_bo obj=new Employee_bo ();
		
		obj.setId(id);
		obj.setName(name);
		obj.setJob(job);
		obj.setDoj(doj);
		obj.setPhone(phone);
		obj.setEmail(email);
		obj.setDob(dob);
		obj.setAdhaar(adhar);
		
		
		if(Employee.update(obj)>0) {
			RequestDispatcher req=request.getRequestDispatcher("AllEmployeeInfo");
			req.forward(request, response);
		}
		else {
			System.out.println("Something went Wrong");
		}
	}

}
