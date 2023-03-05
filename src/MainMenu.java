import java.util.Scanner;

public class MainMenu {
	public static void mainMenu() {
	    int option = 0;
	    Scanner scanner = new Scanner(System.in);
	    int shopSettingsCount = 0;
	    int manageShopItemsCount = 0;
	    int createNewInvoiceCount = 0;
	    int reportStatisticsCount = 0;
	    int reportAllInvoicesCount = 0;
	    int searchInvoiceCount = 0;
	    int programStatisticsCount = 0;

	    while (option != 8) {
	        System.out.println("Please choose an option:");
	        System.out.println("1- Shop Settings");
	        System.out.println("2- Manage Shop Items");
	        System.out.println("3- Create New Invoice (Invoices should be saved/serialized)");
	        System.out.println("4- Report: Statistics (No Of Items, No of Invoices, Total Sales)");
	        System.out.println("5- Report: All Invoices (Invoice No, Invoice Date, Customer Name, No of items, Total, Balance)");
	        System.out.println("6- Search (1) Invoice (Search by Invoice No and Report All Invoice details with items)");
	        System.out.println("7- Program Statistics (Print each Main Menu Item with how many number selected).");
	        System.out.println("8- Exit");

	        option = scanner.nextInt();
	        scanner.nextLine();

	        switch (option) {
	            case 1:
	                System.out.println("Shop Settings selected");
	                shopSettingsCount++;
	                break;
	            case 2:
	                System.out.println("Manage Shop Items selected");
	                manageShopItemsCount++;
	                break;
	            case 3:
	                System.out.println("Create New Invoice selected");
	                createNewInvoiceCount++;
	                break;
	            case 4:
	                System.out.println("Report: Statistics selected");
	                reportStatisticsCount++;
	                break;
	            case 5:
	                System.out.println("Report: All Invoices selected");
	                reportAllInvoicesCount++;
	                break;
	            case 6:
	                System.out.println("Search (1) Invoice selected");
	                searchInvoiceCount++;
	                break;
	            case 7:
	                System.out.println("Program Statistics selected");
	                programStatisticsCount++;
	                break;
	            case 8:
	                System.out.println("Exiting program...");
	                break;
	            default:
	                System.out.println("Invalid option selected");
	                break;
	        }
	    }
	    scanner.close();

	}

}
