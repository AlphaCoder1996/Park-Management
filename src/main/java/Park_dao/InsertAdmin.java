package Park_dao;

import Park_bo.Adminstrators;

import java.sql.*;
public class InsertAdmin {
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
	
	public static int add(Adminstrators ob) {
		
		int status =0;
		
		try {
			con=getConnection();
			String sql="Insert into adminstrator(email,password) values(?,?);";
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setString(1, ob.getId());
			ps.setString(2, ob.getPass());
			
			status=ps.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return status;
	}
	
	public static boolean compare(Adminstrators ob) {
		boolean status =false;
		try {
			con=getConnection();
			String sql="select * from adminstrator where email=? and password=?;";
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setString(1, ob.getId());
			ps.setString(2, ob.getPass());
			ResultSet rs=ps.executeQuery();
			
			status=rs.next();
			
		}
		catch(Exception c) {
			System.out.println(c);
		}
		
		
		return status;
	}

}
