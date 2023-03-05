
public class InvoiceItem {
	
	    private String itemId;
	    private String itemName;
	    private double unitPrice;
	    private int quantity;
	    private double totalPrice;

	    public InvoiceItem(String itemId, String itemName, double unitPrice, int quantity) {
	        this.itemId = itemId;
	        this.itemName = itemName;
	        this.unitPrice = unitPrice;
	        this.quantity = quantity;
	        this.totalPrice = unitPrice * quantity;
	    }

	    public String getItemId() {
	        return itemId;
	    }

	    public void setItemId(String itemId) {
	        this.itemId = itemId;
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
	        this.totalPrice = unitPrice * quantity;
	    }

	    public double getTotalPrice() {
	        return totalPrice;
	    }

	    public void setTotalPrice(double totalPrice) {
	        this.totalPrice = totalPrice;
	    }
	}


