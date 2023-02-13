package Park_Servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Park_bo.Visitor_data;
import Park_dao.Visitor;


@WebServlet("/AddVisitor")
public class AddVisitor extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter pw=response.getWriter();
		
		String name=request.getParameter("name");
		String email=request.getParameter("email");
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		
		Visitor_data obj=new Visitor_data(name,email,username,password);
		
		if(Visitor.addvisitor(obj)>0) {
			RequestDispatcher req=request.getRequestDispatcher("TickitWindow.html");
			req.forward(request, response);
		}
		else {
			pw.write("Something Wrong");
		}
		
		
	}

}
