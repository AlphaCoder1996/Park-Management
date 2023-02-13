package Park_dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import Park_bo.VisitorVarify;
import Park_bo.Visitor_data;

public class Visitor {
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
	/*------------------------Add Visitors---------------------------------*/
	
	public static int addvisitor(Visitor_data obj) {
	int status=0;
	Connection con=null;
		try {
		con=getConnection();
		String sql="insert into visitor(name,email,username,password) values(?,?,?,?);";
		PreparedStatement ps=con.prepareStatement(sql);
		ps.setString(1, obj.getName());
		ps.setString(2, obj.getEmail());
		ps.setString(3, obj.getUsername());
		ps.setString(4, obj.getPassword());
		
		status=ps.executeUpdate();
		}
		catch(Exception c) {
			c.printStackTrace();
		}
		
		return status;
	}
	/*------------------------------Show Visitors-----------------------------------------*/
	
	public static List showVisitor() {
		boolean status=false;
		List<Visitor_data> list=new ArrayList<Visitor_data>();
		
		Connection con=null;
		try {
			con=getConnection();
			String sql="select * from visitor;";
			PreparedStatement ps=con.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			
			while(rs.next()) {
			Visitor_data obj=new Visitor_data();
			obj.setId(rs.getInt(1));
			obj.setName(rs.getString(2));
			obj.setEmail(rs.getString(3));
			obj.setUsername(rs.getString(4));
			obj.setPassword(rs.getString(5));
			list.add(obj);
			}
		}
		catch(Exception c) {
			c.printStackTrace();
		}
		
		return list;
	}
	/*----------------------------------------Visitor Varification-----------------------------------------*/
	public static boolean varify(VisitorVarify vs){
		boolean status=false;
		
		Connection con=null;
		try {
			con=getConnection();
			String sql="select * from visitor where username=? and password=?;";
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setString(1, vs.getUsername());
			ps.setString(2, vs.getPassword());
			ResultSet rs=ps.executeQuery();
			
			status=rs.next();
			
			
			
		}
		catch(Exception c) {
			c.printStackTrace();
		}
		
		return status;
	}

}
/*-----------------------------------------------------------------------------------------------------------------*/
