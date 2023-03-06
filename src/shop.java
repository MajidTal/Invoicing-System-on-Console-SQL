import java.sql.*;
import java.util.ArrayList;
import java.util.Scanner;

public class shop {
	private String ShopName;
	private int Tel;
	private String Fax;
	private String Email;
	private String Website;

	Scanner sc = new Scanner(System.in);
	ArrayList<shop> shopList = new ArrayList<shop>();
	
//	public void shopDetailes() {
//		shop sh = new shop();
//		System.out.print("Enter shop name: ");
//		String name = sc.nextLine();
//		sh.setShopName(name);
//
//		System.out.print("Enter telephone number: ");
//		int tel = sc.nextInt();
//		sh.setTel(tel);
//		sc.nextLine(); // consume the remaining newline character
//
//		System.out.print("Enter fax number: ");
//		String fax = sc.nextLine();
//		sh.setFax(fax);
//
//		System.out.print("Enter email address: ");
//		String email = sc.nextLine();
//		sh.setEmail(email);
//
//		System.out.print("Enter website URL: ");
//		String website = sc.nextLine();
//		sh.setWebsite(website);
//	}

	public String getShopName() {
		return ShopName;
	}

	public void setShopName(String shopName) {
		ShopName = shopName;
	}

	public int getTel() {
		return Tel;
	}

	public void setTel(int tel) {
		Tel = tel;
	}

	public String getFax() {
		return Fax;
	}

	public void setFax(String fax) {
		Fax = fax;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}

	public String getWebsite() {
		return Website;
	}

	public void setWebsite(String website) {
		Website = website;
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
			// ------------TABLE 1:shop -------------//
			String sql = "CREATE TABLE shop (" + "ShopName varchar(50) ," + "Tel VARCHAR(255) NOT NULL,"
					+ "Fax VARCHAR(255)," + "Email varchar(50) NOT NULL," + "Website varchar(50)," + ")";
			ResultSet resultSet = st.executeQuery(sql);

			con.close();
		} catch (Exception ex) {
			System.err.println(ex);
		}

		
	}

	public void shopName()
	{
		shop sh = new shop();
		System.out.print("Enter shop name: ");
		String name = sc.nextLine();
		sh.setShopName(name);
		
	
	};
	
	public void  header() {
		shop sh = new shop();
		System.out.print("Enter telephone number: ");
		int tel = sc.nextInt();
		sh.setTel(tel);

		//sc.nextLine(); // consume the remaining newline character

		System.out.print("Enter fax number: ");
		String fax = sc.next();
		sh.setFax(fax);

		System.out.print("Enter email address: ");
		String email = sc.nextLine();
        sh.setEmail(email);
		
		System.out.print("Enter website URL: ");
		String website = sc.nextLine();
		sh.setWebsite(website);
	}
	public void InsertTable() {

		try {
			Connection con = null;
			Driver driver = (Driver) Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").newInstance();
			DriverManager.registerDriver(driver);
			con = DriverManager.getConnection(url, user, pass);
			Statement st = con.createStatement();
			shop sh = new shop();
			
			System.out.print("Enter shop name: ");
			String name = sc.nextLine();
			sh.setShopName(name);
			

			System.out.print("Enter telephone number: ");
			int tel = sc.nextInt();
			sh.setTel(tel);

			//sc.nextLine(); // consume the remaining newline character

			System.out.print("Enter fax number: ");
			String fax = sc.nextLine();
			sh.setFax(fax);

			System.out.print("Enter email address: ");
			String email = sc.nextLine();
            sh.setEmail(email);
			
			System.out.print("Enter website URL: ");
			String website = sc.nextLine();
			sh.setWebsite(website);

			String sql1 = "insert into shop values('"+ name +"','" + tel + "','" + fax + "','" + email + "','" + website
					+ "')";
			Integer m = st.executeUpdate(sql1);
			if (m >= 1) {
				System.out.println("inserted successfully : " + sql1);
			} else {
				System.out.println("insertion failed");
			}

			// ResultSet resultSet = st.executeQuery(sql1);

			con.close();
		} catch (Exception ex) {
			System.err.println(ex);
		}
		
	}

	public void deleteTable()
	{
		
		
	}
	public void UpdateTable()
	{

	}

	{
	
	
	for (shop element : shopList) {
		System.out.println("---------- shop Details ------------");
		System.out.println("the shop name is " + element.getShopName());
		System.out.println("the telephone number is " + element.getTel());
		System.out.println("the fax number is " + element.getFax());
		System.out.println("the email address is " + element.getEmail());
		System.out.println("the website URL is " + element.getWebsite());

		System.out.println("---------------<>---------------");

	
	
	
	
	}	
	
	}}
