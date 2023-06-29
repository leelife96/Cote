package good;

public class Product {
	  private String productname;
	    private String price;
	    

	    public Product(String productname, String price) {
	        this.productname = productname;
	        this.price = price;
	    }

	    public String getProductName() {
	        return productname;
	    }

	    public String getPrice() {
	        return price;
	    }
}
