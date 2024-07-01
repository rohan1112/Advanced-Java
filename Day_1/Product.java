import java.sql.*;
import java.util.Scanner;

public class Product {
	private int pid,qty;
	private double cost;
	private String pname;

	public int getPid() {
		return pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

	public int getQty() {
		return qty;
	}

	public void setQty(int qty) {
		this.qty = qty;
	}

	public double getCost() {
		return cost;
	}

	public void setCost(double cost) {
		this.cost = cost;
	}

	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}
	
	

	@Override
	public String toString() {
		return "Product [pid=" + pid + ", qty=" + qty + ", cost=" + cost + ", pname=" + pname + "]";
	}

	public Product(int pid, int qty, double cost, String pname) {
		super();
		this.pid = pid;
		this.qty = qty;
		this.cost = cost;
		this.pname = pname;
	}
	public Product() {
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		String ss="jdbc:mysql://localhost:3306/jakarta";
		Product p=new Product(1,12,1200,"Headphones");
		try(Connection con=DriverManager.getConnection(ss,"root","Rohan@123")){
			PreparedStatement pst=con.prepareStatement("delete from product");
			pst.executeUpdate();
			pst=con.prepareStatement("insert into product values(?,?,?,?)");
			pst.setInt(1, p.getPid());
			pst.setInt(2, p.getQty());
			pst.setDouble(3, p.getCost());
			pst.setString(4, p.getPname());
			p=null;
			int count=pst.executeUpdate();
			System.out.println("Inserted successfully");
			
			ResultSet rs=pst.executeQuery("select * from product");
			Product newProduct=new Product();
			while(rs.next()) {
				newProduct.setPid(rs.getInt(1));
				newProduct.setQty(rs.getInt(2));
				newProduct.setCost(rs.getDouble(3));
				newProduct.setPname(rs.getString(4));
				System.out.println(newProduct);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
