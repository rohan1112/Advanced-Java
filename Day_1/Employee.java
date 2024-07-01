import java.sql.*;
import java.util.Scanner;

public class Employee {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		String ss="jdbc:mysql://localhost:3306/jakarta";
		
		try(Connection con=DriverManager.getConnection(ss,"root","Rohan@123")){
			PreparedStatement pst=con.prepareStatement("select * from employee where desig=?");
			System.out.println("Enter Deisgnation to search");
			String designation=sc.next();
			pst.setString(1, designation);
			
			ResultSet rs=pst.executeQuery();
			
			while(rs.next()) {
				System.out.print(rs.getInt(1)+"\t");
				System.out.print(rs.getString(2)+"\t");
				System.out.print(rs.getString(3)+"\t");
				System.out.println();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
