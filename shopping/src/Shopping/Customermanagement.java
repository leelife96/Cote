package Shopping;

import java.util.List;
import java.util.Scanner;

public class CustomerItem {
	private int id;
	private String name;
	private String phoneNumber;
	private String address;
	
	CustomerItem(int id, String name, String phoneNumber, String address){
		this.id = id;
		this.name = name;
		this.phoneNumber = phoneNumber;
		this.address = address;
	}
}
public class Customermanagement {
	private List<CustomerItem> customerList;
	
	public void addCustomer(CustomerItem item) {
		customerList.add(item);
	}


}
