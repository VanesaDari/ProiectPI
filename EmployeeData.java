package magazin;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
public class EmployeeData {

	
	public static int save(String name,String password,String email,String address,String city,String contact){
		int status=0;
		try{
			Connection con=Database.getConnection();
			PreparedStatement ps=con.prepareStatement("insert into accounts(name,password,email,address,city,contact) values(?,?,?,?,?,?)");
			ps.setString(1,name);
			ps.setString(2,password);
			ps.setString(3,email);
			ps.setString(4,address);
			ps.setString(5,city);
			ps.setString(6,contact);
			status=ps.executeUpdate();
			con.close();
		}catch(Exception e){System.out.println(e);}
		return status;
	}
	public static int delete(String name){
		int status=0;
		try{
			Connection con=Database.getConnection();
			PreparedStatement ps=con.prepareStatement("delete from accounts where name=?");
			ps.setString(1,name);
			status=ps.executeUpdate();
			con.close();
		}catch(Exception e){System.out.println(e);}
		return status;
	}

	public static boolean validate(String name,String password){
		boolean status=false;
		try{
			Connection con=Database.getConnection();
			PreparedStatement ps=con.prepareStatement("select * from accounts where name=? and password=?");
			ps.setString(1,name);
			ps.setString(2,password);
			ResultSet rs=ps.executeQuery();
			status=rs.next();
			con.close();
		}catch(Exception e){System.out.println(e);}
		return status;
	}

}
