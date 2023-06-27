package good;

import java.util.*;

import java.io.FileReader;
import java.io.IOException;


 class CustomerItem {
	    private int id;
	    private String name;
	    private String phoneNumber;
	    private String address;

	    public CustomerItem(int id, String name, String phoneNumber, String address) {
	        this.id = id;
	        this.name = name;
	        this.phoneNumber = phoneNumber;
	        this.address = address;
	    }

	    // 필요한 getter, setter 및 기타 메서드 정의

	    @Override
	    public String toString() {
	        return "ID: " + id + ", Name: " + name + ", Phone Number: " + phoneNumber + ", Address: " + address;
	    }
	}

class CustomerManagement {
	    private List<CustomerItem> customerList;

	    public CustomerManagement() {
	        customerList = new ArrayList<>();
	    }

	    public void addCustomer(CustomerItem customer) {
	        customerList.add(customer);
	        System.out.println("고객이 추가되었습니다.");
	    }

	    public void modifyCustomer(int index, CustomerItem newCustomer) {
	        if (index >= 0 && index < customerList.size()) {
	            customerList.set(index, newCustomer);
	            System.out.println("고객 정보가 수정되었습니다.");
	        } else {
	            System.out.println("유효하지 않은 인덱스입니다.");
	        }
	    }

	    public void deleteCustomer(int index) {
	        if (index >= 0 && index < customerList.size()) {
	            customerList.remove(index);
	            System.out.println("고객이 삭제되었습니다.");
	        } else {
	            System.out.println("유효하지 않은 인덱스입니다.");
	        }
	    }

	    public void displayCustomers() {
	        if (customerList.isEmpty()) {
	            System.out.println("고객이 없습니다.");
	        } else {
	            System.out.println("고객 목록:");
	            for (CustomerItem customer : customerList) {
	                System.out.println(customer.toString());
	            }
	        }
	    }

	    public static void main(String[] args) {
	        Scanner scanner = new Scanner(System.in);
	        CustomerManagement customerManagement = new CustomerManagement();

	        boolean isRunning = true;
	        while (isRunning) {
	            System.out.println();
	            System.out.println("*** 고객 관리 ***");
	            System.out.println("1. 입력");
	            System.out.println("2. 수정");
	            System.out.println("3. 삭제");
	            System.out.println("0. 종료");
	            System.out.print("어떤 메뉴를 선택하시겠습니까? ");

	            int choice = scanner.nextInt();
	            scanner.nextLine(); // 입력 버퍼 비우기

	            switch (choice) {
	                case 1:
	                    System.out.println("고객 정보를 입력하세요.");
	                    System.out.print("ID: ");
	                    int id = scanner.nextInt();
	                    scanner.nextLine(); // 입력 버퍼 비우기
	                    System.out.print("이름: ");
	                    String name = scanner.nextLine();
	                    System.out.print("전화번호: ");
	                    String phoneNumber = scanner.nextLine();
	                    System.out.print("주소: ");
	                    String address = scanner.nextLine();

	                    CustomerItem customer = new CustomerItem(id, name, phoneNumber, address);
	                    customerManagement.addCustomer(customer);
	                    break;
	 }
	
		
		
		
		
 }
	
public class Main{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		CustomerManagement cm = new CustomerManagement();
		CustomerItem ci = new CustomerItem(0, null, null, null);
		
		
		
		boolean isRunning = true;

          
          while(isRunning) {
        	  System.out.println();
        	  System.out.println("쇼핑몰 프로그램");
              System.out.println("1. 쇼핑몰");
              System.out.println("2. 고객관리");
              System.out.println("3. 제품 관리");
              System.out.println("0. 종료");
              System.out.print("어떤 메뉴를 선택하시겠습니까? ");
              int menuChoice = sc.nextInt();
              sc.nextLine();
              
              switch(menuChoice) {
              	case 1:
              		 System.out.println("고객 정보를 입력하세요.");
                     System.out.print("ID: ");
                     int id = sc.nextInt();
                     sc.nextLine();
                     System.out.print("이름: ");
                     String name = sc.nextLine();
                     System.out.print("전화번호: ");
                     String phoneNumber = sc.nextLine();
                     System.out.print("주소: ");
                     String address = sc.nextLine();

                     CustomerItem customer = new CustomerItem(id, name, phoneNumber, address);
                     cm.addCustomer(customer);
              		break;
              	case 2:
              		
              		break;
              		
              }
     	  
          }
	}
  }
}
}


