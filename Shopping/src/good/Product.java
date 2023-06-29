package good;

public class Product {
		private String productnum;
	  	private String productname;
	    private String price;
	    

	    public Product(String productnum, String productname, String price) {
	        this.productname = productname;
	        this.price = price;
	        this.productnum = productnum;
	    }
	    public String getProductNum() {
	        return productnum;
	    }

	    public String getProductName() {
	        return productname;
	    }

	    public String getPrice() {
	        return price;
	    }
}
