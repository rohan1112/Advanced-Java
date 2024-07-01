import java.sql.*;
public class Student {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String ss="jdbc:mysql://localhost:3306/jakarta";
		try(Connection con=DriverManager.getConnection(ss,"root","Rohan@123")){
			Statement st=con.createStatement();
			int del=st.executeUpdate("delete from Student");
			int count=st.executeUpdate("insert into Student values(1,'Rohan',23),(2,'Pratik',22)");
			System.out.println(count+" rows inserted");
			
			ResultSet rs=st.executeQuery("select * from Student");
			while(rs.next()) {
				System.out.print(rs.getInt(1)+"\t");
				System.out.print(rs.getString(2)+"\t");
				System.out.print(rs.getInt(3)+"\t");
				System.out.println();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
