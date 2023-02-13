package Park_Servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Park_bo.VisitorVarify;
import Park_dao.Visitor;

@WebServlet("/VisitorLogin")
public class VisitorLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter pw=response.getWriter();
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		VisitorVarify obj=new VisitorVarify(username,password); 
		pw.write(username);
		pw.write(password);
		if(Visitor.varify(obj)) {
			pw.write("Succesfully Rgistered ");
			pw.write("Enter With New Username and Password");
			RequestDispatcher req=request.getRequestDispatcher("Home.html");
			req.forward(request, response);
		}
		else {
			pw.write("Something Went Wrong");
		}
		
	}

	

}

/*RequestDispatcher req=request.getRequestDispatcher("AllEmployeeInfo");
			req.forward(request, response);*/
