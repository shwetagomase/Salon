package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ServicesDao {
	
	public class ShowServices {}

	static Connection con;
	private static Connection getConnect() throws ClassNotFoundException, SQLException 
	{
		String url="jdbc:mysql://localhost:3306/db_salon";
		String uname="root";
		String upass="root";
		
		Class.forName("com.mysql.jdbc.Driver");
		Connection con=DriverManager.getConnection(url, uname, upass);
		return con;
	}
	
	public int insert(ServicesPojo u) throws SQLException, ClassNotFoundException
	{
		String sql="insert into salon_services (sname, spname, srate)values(?,?,?)";
		con=getConnect();
		PreparedStatement ps=con.prepareStatement(sql);
		ps.setString(1, u.getSname());
		ps.setString(2, u.getSpname());
		ps.setString(3, u.getSrate());
		
		int a=ps.executeUpdate();
		return a;	
	}
	
	public boolean CheckUser(String sname) throws SQLException, ClassNotFoundException
	{
		String sql="select * from salon_services where sname=? ";
		con=getConnect();
		PreparedStatement ps=con.prepareStatement(sql);
		ps.setString(1, sname);
		ResultSet rs=ps.executeQuery();
		boolean a=rs.absolute(1);
		return a;
	}	
	 
		public static  List<ServicesPojo> ShowData()
	{
		List<ServicesPojo> list=new ArrayList<ServicesPojo>();
		try
		{
			String sql = "select * from salon_services";
			con=getConnect();		
			PreparedStatement ps=con.prepareStatement(sql);
			ResultSet rs=ps.executeQuery("select * from salon_services");
			while(rs.next())
			{				
				ServicesPojo s=new ServicesPojo();
				s.setSid(rs.getInt(1));
				s.setSname(rs.getString(2));
				s.setSpname(rs.getString(3));
				s.setSrate(rs.getString(4));
                list.add(s);
			}		
		}
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return list;
	}
		public boolean deleteServices(int sid) throws SQLException, ClassNotFoundException
		{
			String sql="delete from salon_services where sid=?";
			con=getConnect();
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setInt(1, sid);

			int a=ps.executeUpdate();
			con.close();
			if(a>0)
			{
				return true;
			}
		else{
			return false;
		}
		}
		public int updateServices(int sid,String sname,String spname,String srate) throws SQLException, ClassNotFoundException
		{
			String sql="update salon_services set sname=?,spname=?,srate=? where sid=?";
			con=getConnect();
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setInt(4, sid);
			ps.setString(1, sname);
			ps.setString(2, spname);
			ps.setString(3, srate);
			int c=ps.executeUpdate();
			con.close();		
			return c;	
		}		
}