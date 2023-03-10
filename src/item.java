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
		item itm = new item();
		System.out.print("Enter item ID: ");
		int id = sc.nextInt();
		this.setItemID(id);
		sc.nextLine(); // consume the remaining newline character
		itm.setItemID(id);

		System.out.print("Enter item name: ");
		String name = sc.nextLine();
		this.setItemName(name);
		itm.setItemName(name);

		System.out.print("Enter unit price: ");
		double price = sc.nextDouble();
		this.setUnitPrice(price);
		itm.setUnitPrice(price);

		System.out.print("Enter quantity: ");
		int qty = sc.nextInt();
		this.setQuantity(qty);
		itm.setQuantity(qty);

		double total = price * qty;
		itm.setQtyPrice(price);
		System.out.println("qtyPrice: " + total);

		itemList.add(itm);
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

			item itm = new item();

			System.out.print("Enter itemID: ");
			int itemID = sc.nextInt();
			itm.setItemID(itemID);

			System.out.print("Enter item name: ");
			String itemName = sc.next();
			itm.setItemName(itemName);

			System.out.print("Enter unit price: ");
			int unitPrice = sc.nextInt();
			itm.setUnitPrice(unitPrice);

			System.out.print("Enter quantity: ");
			int quantity = sc.nextInt();
			itm.setQuantity(quantity);

			System.out.print("Enter qtyPrice: ");
			int qtyPrice = sc.nextInt();
			itm.setQtyPrice(qtyPrice);

			itm.itemList.add(itm);

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

	public void deleteItemTable() {
		String url = "jdbc:sqlserver://localhost:1433;" + "databaseName=Invoicing system;" + "encrypt=true;"
				+ "trustServerCertificate=true";
		String user = "sa";
		String pass = "root";
		Connection con = null;
		try {
			Driver driver = (Driver) Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").newInstance();
			DriverManager.registerDriver(driver);
			con = DriverManager.getConnection(url, user, pass);
			Statement st = con.createStatement();
			System.out.println("Enter the id number of the item you want to delete ");
			int deletedItems = sc.nextInt();
			String sql = "DELETE FROM [dbo].[item]\r\n" + "      WHERE  itemID = " + deletedItems;
			Integer m = st.executeUpdate(sql);
			if (m >= 1) {
				System.out.println("inserted successfully : " + sql);
			} else {
				System.out.println("this ID is not part of the data base");
			}

			con.close();
		} catch (Exception ex) {
			System.err.println(ex);
		}
	}
		public void DeleteItem()
		{
		
				 String url = "jdbc:sqlserver://localhost:1433;" + "databaseName=InvoicingSystemDB;" + "encrypt=true;"
				 + "trustServerCertificate=true";
				 String user = "sa";
				 String pass = "root";
				 Connection con = null;
				 try {
				 Driver driver = (Driver) Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").newInstance();
				 DriverManager.registerDriver(driver);
				 con = DriverManager.getConnection(url, user, pass);
				 Statement st = con.createStatement();
				 // -------------------------------------------------------------//
				 System.out.println("Enter The item Id");
				 int id = sc.nextInt();
				 String deletItem = "\r\n"
				 + "DELETE FROM [dbo].[shop_items]\r\n"
				 + " WHERE id="+id;
				 Integer m = st.executeUpdate(deletItem);
				 if (m >= 1) {
				 System.out.println("Deleted successfully !! ");
				}
				 else
				{
				System.out.println("Deleted failed");
				
				 }
				 // -----------------------------------------------------------//
				 con.close();
				 } catch (Exception ex) {
				 System.err.println(ex);
				 }
	}

	public void UpdateTable() {

	}

	public void getloadItemDetailes() {
		for (item element : itemList) {
			System.out.println("---------- shop Details ------------");
			System.out.println("the itemID is " + element.getItemID());
			System.out.println("the item name is " + element.getItemName());
			System.out.println("the unit price is " + element.getUnitPrice());
			System.out.println("the quantity is " + element.getQuantity());
			System.out.println("the qtyPrice is " + element.getQtyPrice());

			System.out.println("---------------<>---------------");

		}

	}
}
