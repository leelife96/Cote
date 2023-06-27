package Real;

import java.util.*;

 class Shoppingmall {
	
}

  class CustomerItem {
		private int id;
		private String name;
		private String phoneNumber;
		private String address;
		
		public void CustomerItem(int id, String name, String phoneNumber, String address){
			this.id = id;
			this.name = name;
			this.phoneNumber = phoneNumber;
			this.address = address;
		}
	}

 class Customermanagement {
	 public void customermenu(Scanner sc) {
		 	System.out.println();
	    	System.out.println("*** 고객 관리 *** ");
	    	System.out.println("1. 입력");
	    	System.out.println("2. 수정");
	    	System.out.println("3. 삭제");
	    	System.out.println("0. 메인메뉴로 돌아가기");
	    	System.out.print("어떤 메뉴를 선택하시겠습니까? ");
	    	
	    	int cmNumber = sc.nextInt();
	        
	        switch (cmNumber) {
	            case 1:
	            	
	                break;
	                
	            case 2:
	                           
	                break;
	                
	            case 3:
	              
	                break;
	                
	            case 0:
	                             
	        }
	 }
	
 }
	
public class Main{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		Customermanagement cm = new Customermanagement();
		CustomerItem ci = new CustomerItem();
		Shoppingmall sm = new Shoppingmall();
		
		
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
              		System.out.println("쇼핑몰 선택함");
              		break;
              	case 2:
              		cm.customermenu(sc);
              		break;
              		
              }
     	  
          }
	}
  }


