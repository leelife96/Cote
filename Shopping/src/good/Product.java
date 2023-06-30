package good;

public class Product {
		private String pid;
		private String productcount;
	  	private String productname;
	    private String price;
	    

	    public Product(String pid, String productcount, String productname, String price) {
	    	this.pid = pid;
	    	this.productcount = productcount;
	        this.productname = productname;
	        this.price = price;
	        
	        
	    }
	    public String getPID() {
	        return pid;
	    }
	    public String getProductCount() {
	        return productcount;
	    }

	    public String getProductName() {
	        return productname;
	    }

	    public String getPrice() {
	        return price;
	    }
}
