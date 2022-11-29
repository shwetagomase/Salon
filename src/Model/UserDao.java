package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class UserDao {
	
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
	
	public int insert(UserPojo u) throws SQLException, ClassNotFoundException
	{
		String sql="insert into salon_user (uname, ugender, uemail, umobile, uaddress, upassword)values(?,?,?,?,?,?)";
		con=getConnect();
		PreparedStatement ps=con.prepareStatement(sql);
		ps.setString(1, u.getUname());
		ps.setString(2, u.getUgender());
		ps.setString(3, u.getUemail());
		ps.setString(4, u.getUmobile());
		ps.setString(5, u.getUaddress());
		ps.setString(6, u.getUpassword());

		int a=ps.executeUpdate();
		return a;	
	}
	
	public boolean CheckUser(String uname,String upassword) throws SQLException, ClassNotFoundException
	{
		String sql="select * from salon_user where uname=? and upassword=?";
		con=getConnect();
		PreparedStatement ps=con.prepareStatement(sql);
		ps.setString(1, uname);
		ps.setString(2, upassword);
		ResultSet rs=ps.executeQuery();
		boolean a=rs.absolute(1);
		return a;
	}
	public List<UserPojo> getAllUser(int pageid, int total) {
		// TODO Auto-generated method stub
		return null;
	}

	}

