import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
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

//	public void itemDetalies() {
//		item itm = new item();
//		System.out.print("Enter item ID: ");
//		int id = sc.nextInt();
//		this.setItemID(id);
//		sc.nextLine(); // consume the remaining newline character
//		itm.setItemID(id);
//
//		System.out.print("Enter item name: ");
//		String name = sc.nextLine();
//		this.setItemName(name);
//		itm.setItemName(name);
//
//		System.out.print("Enter unit price: ");
//		double price = sc.nextDouble();
//		this.setUnitPrice(price);
//		itm.setUnitPrice(price);
//
//		System.out.print("Enter quantity: ");
//		int qty = sc.nextInt();
//		this.setQuantity(qty);
//		itm.setQuantity(qty);
//
//		double total = price * qty;
//		itm.setQtyPrice(price);
//		System.out.println("qtyPrice: " + total);
//
//		itemList.add(itm);
//	}

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

			int rowsAffected = st.executeUpdate(sql);
			if (rowsAffected > 0) {
				System.out.println("created successfully: " + sql);
			} else {
				System.out.println("created failed.");
			}

			ResultSet resultSet = st.executeQuery(sql);
			con.close();
		} catch (Exception ex) {
			System.err.println(ex);
		}

	}

	public void itemDetalies() {
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

	public void DeleteItem() {
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

			System.out.println("Enter DELETE FROM Item WHERE id = ");
			String rowsDeleted = sc.next();
			String A = "DELETE FROM Item WHERE itemID = " + rowsDeleted;
			int update = st.executeUpdate(A);

			con.close();
		} catch (Exception ex) {
			System.err.println(ex);
		}
	}

	public void UpdateTable() {

	}

	public void ReportAllItems() {
		invoice in = new invoice();
		item it = new item();
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

			String reportItem = "select * from item";
			ResultSet resultSet = st.executeQuery(reportItem);
			while (resultSet.next()) {
				System.out.println("Print AllItems ");
				System.out.println(resultSet.getString("itemID"));
				System.out.println(resultSet.getString("itemName"));
				System.out.println(resultSet.getString("unitPrice"));
				System.out.println(resultSet.getString("quantity"));
				System.out.println(resultSet.getString("qtyPrice"));

			}

			con.close();
		} catch (Exception ex) {
			System.err.println(ex);
		}
	}

	public void LoadItem() {

		try {
			Connection con = null;
			Driver driver = (Driver) Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").newInstance();
			DriverManager.registerDriver(driver);
			con = DriverManager.getConnection(url, user, pass);
			Statement st = con.createStatement();
//			
			ResultSet rs = st.executeQuery("select * from item");
			ResultSetMetaData rsmd = rs.getMetaData();
			int numberOfColumns = rsmd.getColumnCount();
			int rowCount = 1;
			while (rs.next()) {
				System.out.println("Row " + rowCount + ":  ");
				for (int i = 1; i <= numberOfColumns; i++) {
					System.out.print("   Column " + i + ":  ");
					System.out.println(rs.getString(i));
				}
				System.out.println("");
				rowCount++;
			}
			st.close();
			con.close();

		} catch (Exception ex) {
			System.err.println(ex);
		}

//		for (item element :itemList) {
//			System.out.println("---------- shop Details ------------");
//			System.out.println("the itemID is " + element.getItemID());
//			System.out.println("the item name is " + element.getItemName());
//			System.out.println("the unit price is " + element.getUnitPrice());
//			System.out.println("the quantity is " + element.getQuantity());
//			System.out.println("the qtyPrice is " + element.getQtyPrice());
//
//			System.out.println("---------------<>---------------");
//
//		}

	}
}
