package good;

import java.util.*;

public class Main {
	
	public static void start() {
		
		Scanner sc = new Scanner(System.in);
		
		CustomerManagementss cm = new CustomerManagementss();
		Customer ci = new Customer(null, null);
		
		
		
		boolean isRunning = true;

          
          while(isRunning) {
        	  System.out.println("***************");        	
        	  System.out.println("쇼핑몰 프로그램");
              System.out.println("1. 쇼핑몰");
              System.out.println("2. 고객관리");
              System.out.println("3. 제품 관리");
              System.out.println("0. 종료");
              System.out.println("어떤 메뉴를 선택하시겠습니까? ");
              System.out.print("***************");
              int menuChoice = sc.nextInt();
              sc.nextLine();
              
              switch(menuChoice) {
              	case 1:
              		
              		break;
              	case 2:
              		cm.CusMan();
              		break;
              		
              }
     	  
          }
		
	}
	
	public static void main(String[] args) {
		
		start();
		
	}
}


