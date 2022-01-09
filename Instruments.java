package magazin;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class Instruments {
public static int save(int i_id,String name,String type,String brand,int quantity, int price){
	int status=0;
	try{
		Connection con=Database.getConnection();
		PreparedStatement ps=con.prepareStatement("insert into instruments(i_id,name,type,brand,quantity,price) values(?,?,?,?,?,?)");
		ps.setInt(1,i_id);
		ps.setString(2,name);
		ps.setString(3,type);
		ps.setString(4,brand);
		ps.setInt(5,quantity);
		ps.setInt(6,price);
		status=ps.executeUpdate();
		con.close();
	}catch(Exception e){System.out.println(e);}
	return status;
}
}
