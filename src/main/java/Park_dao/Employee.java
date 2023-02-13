package Park_dao;

import java.util.ArrayList;
import java.util.List;



import java.sql.*;
import Park_bo.Employee_bo;
public class Employee {
	
	/*-------------------------Connection-----------------------*/
		static Connection con=null;
		public static Connection getConnection() {
			
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				String url="jdbc:mysql://localhost:3306/ParkManagement";
				String user="root";
				String pas="Nirved$2021";
				con=DriverManager.getConnection(url,user,pas);
				
				
			} catch (Exception e) {
				
				e.printStackTrace();
			}
			return con;
		}
		/*------------------------Add Employee---------------------------------*/
		public static int add(Employee_bo em) {
			int Status =0;
			try {
				con=getConnection();
				String sql="insert into park_staff(name,job,Date_of_Join,Phone,Email,Date_of_Birth,Adhaar) values(?,?,?,?,?,?,?);";
				PreparedStatement ps=con.prepareStatement(sql);
				ps.setString(1,em.getName());
				ps.setString(2,em.getJob());
				ps.setString(3,em.getDoj());
				ps.setString(4,em.getPhone());
				ps.setString(5,em.getEmail());
				ps.setString(6,em.getDob());
				ps.setString(7,em.getAdhaar());
				
				Status=ps.executeUpdate();
				
				
			}
			catch(Exception c) {
				System.out.println(c);
			}
			
			return Status;
		}
		
		/*-------------------------------------display employee----------------------------------*/
		public static List getAllEmployee() {
			List <Employee_bo> emp=new ArrayList<Employee_bo>();
			try {
				Connection con =getConnection();
				String sql="select * from park_staff ";
				
				PreparedStatement ps=con.prepareStatement(sql);
				ResultSet rs=ps.executeQuery();
				
				while(rs.next()) {
					Employee_bo em=new Employee_bo();
					em.setId(rs.getInt(1));
					em.setName(rs.getString(2));
					em.setJob(rs.getString(3));
					em.setDoj(rs.getString(4));
					em.setPhone(rs.getString(5));
					em.setEmail(rs.getString(6));
					em.setDob(rs.getString(7));
					em.setAdhaar(rs.getString(8));
					emp.add(em);
				}
				
			}catch(Exception c) {
				System.out.println(c);
			}
			
			return emp;
			
		}
		/*----------------------------Display Employee By ID--------------------------------------------*/
		
		public static Employee_bo getEmployeeById(int eid) {
			Employee_bo eb=new Employee_bo();
			try {
				Connection con =getConnection();
				String sql="select * from park_staff where id=?";
				
				PreparedStatement ps=con.prepareStatement(sql);
				ps.setInt(1, eid);
				
				ResultSet rs=ps.executeQuery();
				if(rs.next()) {
					eb.setId(rs.getInt(1));
					eb.setName(rs.getString(2));
					eb.setJob(rs.getString(3));
					eb.setDoj(rs.getString(4));
					eb.setPhone(rs.getString(5));
					eb.setEmail(rs.getString(6));
					eb.setDob(rs.getString(7));
					eb.setAdhaar(rs.getString(8));
				}
			}
			catch(Exception c) {
				
			}
			return eb;
		}
		/*---------------------------------------Update Employee-----------------------------------------------*/
		public static int update(Employee_bo eb) {
			
			int status=0;
			try {
				Connection con =getConnection();
				String sql="update park_staff set Name=?,Job=?,Date_of_Join=?,Phone=?,Email=?,Date_of_Birth=?,Adhaar=? where id=?;";
				
				PreparedStatement ps=con.prepareStatement(sql);
		
				ps.setString(1,eb.getName());
				ps.setString(2, eb.getJob());
				ps.setString(3, eb.getDoj());
				ps.setString(4, eb.getPhone());
				ps.setString(5, eb.getEmail());
				ps.setString(6, eb.getDob());
				ps.setString(7, eb.getAdhaar());
				ps.setInt(8, eb.getId());
				status=ps.executeUpdate();
				
				
			}
			catch(Exception c) {
				
			}
			
			
			return status;
		}
		/*-----------------------------------------------Delete Employee--------------------------------------------*/
		public static int delete(int id) {
			int status =0;
			try {
				Connection con =getConnection();
				String sql="delete from park_staff where id=?;";
				
				PreparedStatement ps=con.prepareStatement(sql);
				ps.setInt(1,id);
				status=ps.executeUpdate();
			}
			catch(Exception c) {
				System.out.println(c);
			}
			
			
			return status;
		}
		
		
}
