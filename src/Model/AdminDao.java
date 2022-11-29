package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AdminDao {
			
		Connection con;
		private Connection getConnect() throws ClassNotFoundException, SQLException 
		{
			String url="jdbc:mysql://localhost:3306/db_salon";
			String uname="root";
			String upass="root";
			
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection(url, uname, upass);
			return con;
		}
		
		public int insert(AdminPojo u) throws SQLException, ClassNotFoundException
		{
			String sql="insert into salon_admin (aname, agender, aemail, amobile, aaddress, apassword)values(?,?,?,?,?,?)";
			con=getConnect();
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setString(1, u.getAname());
			ps.setString(2, u.getAgender());
			ps.setString(3, u.getAemail());
			ps.setString(4, u.getAmobile());
			ps.setString(5, u.getAaddress());
			ps.setString(6, u.getApassword());

			int a=ps.executeUpdate();
			return a;	
		}
		
		public boolean CheckUser(String aname,String apassword) throws SQLException, ClassNotFoundException
		{
			String sql="select * from salon_admin where aname=? and apassword=?";
			con=getConnect();
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setString(1, aname);
			ps.setString(2, apassword);
			ResultSet rs=ps.executeQuery();
			boolean a=rs.absolute(1);
			return a;
		}	
		}
