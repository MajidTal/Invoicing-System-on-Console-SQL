
public class invoice {


	    private String customerFullName;
	    private String phoneNumber;
	    private String invoiceDate;
	    private int numberOfItems;
	    private double totalAmount;
	    private double paidAmount;
	    private double balance;

	    public invoice(String customerFullName, String phoneNumber, String invoiceDate, int numberOfItems, double totalAmount, double paidAmount) {
	        this.customerFullName = customerFullName;
	        this.phoneNumber = phoneNumber;
	        this.invoiceDate = invoiceDate;
	        this.numberOfItems = numberOfItems;
	        this.totalAmount = totalAmount;
	        this.paidAmount = paidAmount;
	        this.balance = totalAmount - paidAmount;
	    }

	    public String getCustomerFullName() {
	        return customerFullName;
	    }

	    public void setCustomerFullName(String customerFullName) {
	        this.customerFullName = customerFullName;
	    }

	    public String getPhoneNumber() {
	        return phoneNumber;
	    }

	    public void setPhoneNumber(String phoneNumber) {
	        this.phoneNumber = phoneNumber;
	    }

	    public String getInvoiceDate() {
	        return invoiceDate;
	    }

	    public void setInvoiceDate(String invoiceDate) {
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
	}


