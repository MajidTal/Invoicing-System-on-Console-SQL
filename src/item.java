import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;

public class item {

	private int itemID;
	private String itemName;
	private double unitPrice;
	private int quantity;
	private double qtyPrice;

	ArrayList<item> itemList = new ArrayList<item>();
	Scanner sc = new Scanner(System.in);

	public void itemDetalies() {

		System.out.print("Enter item ID: ");
		int id = sc.nextInt();
		this.setItemID(id);
		sc.nextLine(); // consume the remaining newline character

		System.out.print("Enter item name: ");
		String name = sc.nextLine();
		this.setItemName(name);

		System.out.print("Enter unit price: ");
		double price = sc.nextDouble();
		this.setUnitPrice(price);

		System.out.print("Enter quantity: ");
		int qty = sc.nextInt();
		this.setQuantity(qty);

		System.out.println("Enter qtyPrice ");
		double total = price * qty;
		this.setQtyPrice(total);
	}

	public int getItemID() {
		return itemID;
	}

	public void setItemID(int itemID) {
		this.itemID = itemID;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public double getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(double unitPrice) {
		this.unitPrice = unitPrice;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getQtyPrice() {
		return qtyPrice;
	}

	public void setQtyPrice(double qtyPrice) {
		this.qtyPrice = qtyPrice;
	}

	String url = "jdbc:sqlserver://localhost:1433;" + "databaseName=Invoicing system;" + "encrypt=true;"
			+ "trustServerCertificate=true";
	String user = "sa";
	String pass = "root";

	public void createTable() {
		try {
			Connection con = null;
			Driver driver = (Driver) Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").newInstance();
			DriverManager.registerDriver(driver);
			con = DriverManager.getConnection(url, user, pass);
			Statement st = con.createStatement();
			// ------------TABLE 1:item -------------//
			String sql = "CREATE TABLE item (" + "itemID int primary key ," + "itemName VARCHAR(255) NOT NULL,"
					+ "unitPrice int NOT NULL," + "quantity int NOT NULL," + "qtyPrice int NOT NULL," + ")";
			ResultSet resultSet = st.executeQuery(sql);

			con.close();
		} catch (Exception ex) {
			System.err.println(ex);
		}

	}

	public void InsertTable() {
	    try {
	        Connection con = null;
	        Driver driver = (Driver) Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").newInstance();
	        DriverManager.registerDriver(driver);
	        con = DriverManager.getConnection(url, user, pass);
	        Statement st = con.createStatement();

	        item it = new item();
	        System.out.print("Enter itemID: ");
	        int itemID = sc.nextInt();

	        System.out.print("Enter item name: ");
	        String itemName = sc.next();

	        System.out.print("Enter unit price: ");
	        int unitPrice = sc.nextInt();

	        System.out.print("Enter quantity: ");
	        int quantity = sc.nextInt();

	        System.out.print("Enter qtyPrice: ");
	        int qtyPrice = sc.nextInt();

	        String sql1 = "INSERT INTO item VALUES('" + itemID + "','" + itemName + "','" + unitPrice + "','" + quantity
	                + "','" + qtyPrice + "')";
	        int rowsAffected = st.executeUpdate(sql1);
	        if (rowsAffected > 0) {
	            System.out.println("inserted successfully : " + sql1);
	        } else {
	            System.out.println("insertion failed");
	        }

	        con.close();
	    } catch (Exception ex) {
	        System.err.println(ex);
	    }
	}


	public void deleteTable() {

	}

	public void UpdateTable() {

	}
	{
		
		for (item element : itemList) {
			System.out.println("---------- shop Details ------------");
			System.out.println("the itemID is " + element.getItemID());
			System.out.println("the item name is " + element.getItemName());
			System.out.println("the unit price is " + element.getUnitPrice());
			System.out.println("the quantity is " + element.getQuantity());
			System.out.println("the qtyPrice is " + element.getQtyPrice());

			System.out.println("---------------<>---------------");

	}
}}
