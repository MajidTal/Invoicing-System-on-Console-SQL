import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;

public class invoice {
	private String customerFullName;
	private int phoneNumber;
	private int invoiceDate;
	private int numberOfItems;
	private double totalAmount;
	private double paidAmount;
	private double balance;


	ArrayList<invoice> invoiceList = new ArrayList<invoice>();
	Scanner sc = new Scanner(System.in);

	public void invoiceDetalies() {
		invoice inv = new invoice();
		System.out.print("Enter customer full name: ");
		String name = sc.nextLine();
		this.setCustomerFullName(name);

		System.out.print("Enter phone number: ");
		int phoneNumber = sc.nextInt();
		this.setPhoneNumber(phoneNumber);
		sc.nextLine(); // consume the remaining newline character

		System.out.print("Enter invoice date: ");
		int invoiceDate = sc.nextInt();
		this.setInvoiceDate(invoiceDate);

		System.out.print("Enter number of items: ");
		int numberOfItems = sc.nextInt();
		this.setNumberOfItems(numberOfItems);

		System.out.print("Enter total amount: ");
		double totalAmount = sc.nextDouble();
		this.setTotalAmount(totalAmount);

		System.out.print("Enter paid amount: ");
		double paidAmount = sc.nextDouble();
		this.setPaidAmount(paidAmount);

		System.out.println("Enter the balance");
		double balance = totalAmount - paidAmount;
		this.setBalance(balance);
	}

	public String getCustomerFullName() {
		return customerFullName;
	}

	public void setCustomerFullName(String customerFullName) {
		this.customerFullName = customerFullName;
	}

	public int getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(int phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public int getInvoiceDate() {
		return invoiceDate;
	}

	public void setInvoiceDate(int invoiceDate) {
		this.invoiceDate = invoiceDate;
	}

	public int getNumberOfItems() {
		return numberOfItems;
	}

	public void setNumberOfItems(int numberOfItems) {
		this.numberOfItems = numberOfItems;
	}

	public double getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}

	public double getPaidAmount() {
		return paidAmount;
	}

	public void setPaidAmount(double paidAmount) {
		this.paidAmount = paidAmount;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
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
	        // ------------TABLE 1:invoice -------------//
	        String sql = "CREATE TABLE invoice (" + 
	                 "customerFullName VARCHAR(255) NOT NULL," + 
	                 "phoneNumber VARCHAR(255) NOT NULL," + 
	                 "invoiceDate DATE," + 
	                 "numberOfItems INT NOT NULL," +
	                 "totalAmount INT NOT NULL," +
	                 "paidAmount INT NOT NULL," +
	                 "balance INT NOT NULL" +
	                 ")";

	        st.executeUpdate(sql);
	        con.close();
	    } catch (Exception ex) {
	        System.err.println(ex);
	    }
	}

	public void insertData() {
	    try {
	        Connection con = null;
	        Driver driver = (Driver) Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").newInstance();
	        DriverManager.registerDriver(driver);
	        con = DriverManager.getConnection(url, user, pass);
	        Statement st = con.createStatement();
	        invoice inv = new invoice();
	        System.out.print("Enter customer full name: ");
	        String fullName = sc.next();
	        inv.setCustomerFullName(fullName);

	        System.out.print("Enter phone number: ");
	        String phoneNumber = sc.next();
	        inv.setPhoneNumber(invoiceDate);
	        
	        System.out.print("Enter invoice date (YYYY-MM-DD): ");
	        String invoiceDate = sc.next();
            inv.setInvoiceDate(numberOfItems);
	        
	        System.out.print("Enter number of items: ");
	        int numberOfItems = sc.nextInt();
	        inv.setNumberOfItems(numberOfItems);

	        System.out.print("Enter total amount: ");
	        int totalAmount = sc.nextInt();
	        inv.setTotalAmount(totalAmount);
	        
	        System.out.print("Enter paid amount: ");
	        int paidAmount = sc.nextInt();
	        inv.setPaidAmount(paidAmount);
	        
	        System.out.print("Enter balance: ");
	        int balance = sc.nextInt();
	        inv.setBalance(balance);

	        String sql = "INSERT INTO invoice VALUES('" + fullName + "','" + phoneNumber + "','" + invoiceDate + "','" + numberOfItems
	                + "','" + totalAmount + "','" + paidAmount + "','" + balance + "')";

	        int rowsAffected = st.executeUpdate(sql);
	        if (rowsAffected > 0) {
	            System.out.println("Inserted successfully: " + sql);
	        } else {
	            System.out.println("Insertion failed.");
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
		
		for (invoice element : invoiceList) {
			System.out.println("---------- shop Details ------------");
			System.out.println("the customer full name is " + element.getCustomerFullName());
			System.out.println("the phone number is " + element.getPhoneNumber());
			System.out.println("the invoice date is " + element.getInvoiceDate());
			System.out.println("the total amount " + element.getTotalAmount());
			System.out.println("the paid amount " + element.getPaidAmount());
			System.out.println("the balance " + element.getBalance());


			System.out.println("---------------<>---------------");

	}
}}
