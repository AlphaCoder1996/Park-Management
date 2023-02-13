package Park_Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Park_bo.Visitor_data;
import Park_dao.Visitor;

/**
 * Servlet implementation class ShowVisitors
 */
@WebServlet("/ShowVisitors")
public class ShowVisitors extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter pw=response.getWriter();
		
		List<Visitor_data>list=Visitor.showVisitor();
		pw.write("<table border='1px' width='100%'> ");
		pw.write("<tr><th>ID</th><th>Name</th><th>Email</th><th>Username</th><th>Password</th></tr>");
		
		for(Visitor_data itr : list) {
			pw.write("<tr><td>"+itr.getId()+"</td><td>"+itr.getName()+"</td><td>"+itr.getEmail()+"</td><td>"+itr.getUsername()+"</td><td>"+itr.getPassword()+"</td></tr>");
		}
		pw.print("<a href='AllEmployeeInfo'>Back</a>");
		
	}
	
	

	

}
