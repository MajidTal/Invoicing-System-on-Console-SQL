import java.util.ArrayList;
import java.util.Scanner;

public class mainClass {

	invoice in = new invoice();
	item it = new item();

	private static void printMainMenu() {
		System.out.println("1-Shop Settings");
		System.out.println("2- Manage Shop Items");
		System.out.println("3- Create New Invoice (Invoices should be saved/serialized)");
		System.out.println("4- Report: Statistics (No Of Items, No of Invoices, Total Sales)");
		System.out.println(
				"5- Report: All Invoices (Invoice No, Invoice Date, Customer Name, No of items, Total, Balance)");
		System.out.println("6- Search (1) Invoice (Search by Invoice No and Report All Invoice details with items)");
		System.out.println("7- Program Statistics (Print each Main Menu Item with how many times selected).");
		System.out.println("8- Exit");
		System.out.println("Enter your option");
	}

	shop sh = new shop();
	ArrayList<item> itemList = new ArrayList<item>();

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		shop sh = new shop();
		boolean condition = true;
		while (condition) {
			item it = new item();
			invoice in = new invoice();
			printMainMenu();
			int option = sc.nextInt();

			switch (option) {
			case 1:
				boolean subMenu1Condition = true;
				while (subMenu1Condition) {
					System.out.println("1- Load Data (Items and invoices)");
					System.out.println("2- Set Shop Name (data should be saved)");
					System.out.println("3- Set Invoice Header (Tel / Fax / Email / Website)");
					System.out.println("4- Go Back");
					int subOption1 = sc.nextInt();

					switch (subOption1) {
					case 1:
						sh.loadshop();
						// item it = new item();
						// it.itemDetalies(); // to enter item details

						// invoice in = new invoice();
						// in.invoiceDetalies(); // to enter invoice details

						// it.getloadItemDetailes();
						// in.getloadInvoiceDetailes();

						break;
					case 2:
						System.out.println("Enter the shop name:");
						String shopName = sc.next();
						// shop.setShopName(shopName);
						break;
					case 3:
						sh.header();
						// shop.setInvoiceHeader(invoiceHeader);
						break;
					case 4:
						subMenu1Condition = false;
						break;
					default:
						System.out.println("Invalid option");
						break;
					}
				}
				break;
			case 2:
				boolean subMenu2Condition = true;
				while (subMenu2Condition) {
					System.out.println("1- Add Items (Item should be saved/serialized)");
					System.out.println("2- Delete Items");
					System.out.println("3- Change Item Price");
					System.out.println("4- Report All Items");
					System.out.println("5- Go Back");
					int subOption2 = sc.nextInt();

					switch (subOption2) {

					case 1:

						it.itemDetalies();

						break;
					case 2:

						// String itemName = sc.next();
						// shop.deleteItem(itemName);

						it.deleteItemTable();
						break;
					case 3:
						System.out.println("Change Item Price:");
						break;
					case 4:
						System.out.println("4- Report All Items");
						
						break;
					case 5:
						System.out.println("5- Go Back");
						subMenu2Condition = false;
					default:
						System.out.println("Invalid option");
						break;

					}
				}

			case 3:
				invoice inv = new invoice();

				inv.insertInvoiceData();
				break;
			case 4:

				System.out.println("NO of items: " + it.itemList.size());

				System.out.println("NO of invoices: " + in.invoiceList.size());

				break;
			case 5:

				in.ReportAllInvoices();

				break;
			case 6:

				break;
			case 7:

				break;
			case 8:

				break;

			}
		}
	}
}

// sh.createTable();

// sh.shopDetailes();
// sh.InsertTable();

// item it = new item();
// it.createTable();
// it.InsertTable();

// invoice in = new invoice();
// in.createTable();
// in.insertData();

//
//		        boolean condation= true;
//		        
//		        while(condation)
//		        {//start while
//               ma.mainMenu();
//               
//               System.out.println("Select an option");
//               int select = sc.nextInt();
//               
//               switch(select) {//start of switch
//               case 1:
//            	   
//            	   boolean con2= true;
//            	   while(con2) { //start while of submenu 1
//            		   submenu.submainMenu1();
//            		   
//            		   System.out.println("Select an option");
//                       int select1 = sc.nextInt();
//                       
//                       switch(select1) {
//                       case 1:
//                    	itm.getloadItemDetailes();
//                    	   break;
//                  //-----------------
//                       case 2:
//                    	sh.shopName();
//                    	   break;
//                   //----------------
//                       case 3:
//                    	   sh.header();
//                    	   break;
//                    	   
//                    //-----------------
//                       case 4:
//                    	   
//                    	   break;
//                       
//                       
//                       }
//            		   
//            		   
//            		   
//            	   }//end of while submenu 1
//            	   
//            	   
//            	   break;
//            	   
//          //-----------------
//               case 2:
//            	   
//            	   boolean con3= true;
//            	   while(con3) { //start while of submenu 2
//            		   submenu.submainMenu2();
//            		   
//            		   System.out.println("Select an option");
//                       int select2 = sc.nextInt();
//                       
//                       switch(select2) { 
//                       case 1:
//                    	   itm.InsertTable();
//                    	   break;
//                  //-----------------
//                       case 2:
//                    	   
//                    	   break;
//                   //----------------
//                       case 3:
//                    	   
//                    	   break;
//                    	   
//                    //-----------------
//                       case 4:
//                    	   
//                    	   break;
//                    	 //-----------------
//                       case 5:
//                    	   
//                    	   break;
//                       
//                       }
//            		   
//            		   
//            		   
//            	   }//end of while submenu 2
//            	   
//            	   
//            	   break;
//          //-----------------
//               case 3:
//            	   inv.insertInvoiceData();
//            	   break;
//           //----------------
//               case 4:
//            	   
//            	   break;
//            	   
//            //-----------------
//               case 5:
//            	   
//            	   break;
//            	   
//           //-----------------
//               case 6:
//            	   
//            	   break;
//            //-----------------
//               case 7:
//            	   
//            	   break;
//             //-----------------
//               case 8:
//            	   
//            	   break;
//            	   
//               
//               
//               
//               }// end of switch
//		        	
//		      
//		        	
//		        }//end main while
//		        }
//		
