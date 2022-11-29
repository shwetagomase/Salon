package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AppointmentDao {
	
	static Connection con;
	private static Connection getConnect() throws ClassNotFoundException, SQLException 
	{
		String db="db_salon";
		String url="jdbc:mysql://localhost:3306/"+db;
		String uname="root";
		String upass="root";		
		Class.forName("com.mysql.jdbc.Driver");
		Connection con=DriverManager.getConnection(url, uname, upass);
		return con;
	}
	
	public int insert(AppointmentPojo s) throws SQLException, ClassNotFoundException
	{
		String sql="insert into salon_appointment (sname, spname, srate, date, time,status)values(?,?,?,?,?,?)";
		con=getConnect();
		PreparedStatement ps=con.prepareStatement(sql);
		ps.setString(1, s.getSname());
		ps.setString(2, s.getSpname());
		ps.setString(3, s.getSrate());
		ps.setString(4, s.getDate());
		ps.setString(5, s.getTime());
		ps.setString(6, s.getStatus());
		
		int a=ps.executeUpdate();
		return a;	
	}	
	
	public int updateStatus(int apid,String status) throws ClassNotFoundException, SQLException
	{
		Connection con=getConnect();
    	PreparedStatement ps=con.prepareStatement("update salon_appointment set status=? where apid=?");
		ps.setString(1, status);
		ps.setInt(2, apid);
			
		int a=ps.executeUpdate();
		con.close();
		return  a;
	}
	 
		public static  List<AppointmentPojo> ShowData()
	{
		List<AppointmentPojo> list=new ArrayList<AppointmentPojo>();
		try
		{
			String sql = "select * from salon_appointment";
			con=getConnect();		
			PreparedStatement ps=con.prepareStatement(sql);
			ResultSet rs=ps.executeQuery("select * from salon_appointment");
			while(rs.next())
			{				
				AppointmentPojo s=new AppointmentPojo();
				s.setApid(rs.getInt(1));
				s.setSname(rs.getString(2));
				s.setSpname(rs.getString(3));
				s.setSrate(rs.getString(4));
				s.setDate(rs.getString(5));
				s.setTime(rs.getString(6));
				s.setStatus(rs.getString(7));
                list.add(s);
			}		
		}
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return list;
	}
}


