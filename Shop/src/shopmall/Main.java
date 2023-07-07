package shopmall;

import java.util.*;
import java.io.*;

	public class Main {
		
		public static final String CUSTOMER_FILE_PATH = "C:\\Program Files\\Javaling\\CustomerDB.txt"; // 모든 영역에서 고정된 값으로 사용하는 상수인 CUSTOMER_FILE_PATH에 
																									   // "CustomerDB.txt" 텍스트 파일을 대입한다.
		
	
		
		public static Map<Integer, Customer> customerMap = new HashMap<>(); // 초기값 지정
		 																	// Map<Integer, Customer>는 Integer를 키(key)로 가지고 Customer 객체를 값(value)으로 가지는 맵을 나타냅니다
		
		
		public static void start() {
			
				customerManagementMenu cmm = new  customerManagementMenu(); // customerManagementMenu의 객체 cmm을 생성
			 	productManagementMenu pmm = new productManagementMenu(); // productManagementMenu의 객체 pmm을 생성
			 	Login login = new Login(); // Login의 객체 login을 생성
		        Scanner scanner = new Scanner(System.in);  // 입력
	
		        while (true) {
		            System.out.println("====== 쇼핑몰 프로그램 ======");
		            System.out.println("1. 쇼핑몰");
		            System.out.println("2. 고객관리");
		            System.out.println("3. d제품관리");
		           
		            System.out.print("메뉴를 선택 하시오.: ");
		            int choice = scanner.nextInt();
	
		            switch (choice) {
		                case 1:
		                    login.login(); // login() 호출
		                    break;
		                case 2:
		                	
		                    cmm.cusman();
		                    break;
		                case 3:
		                    pmm.proman();
		                    break;
		               
		                default:
		                    System.out.println("Invalid choice. Please try again.");
		                    break;
		            }
		        }
		    }
			
	
	



	public static void main(String[] args) {
		
		 	start();
	}
}
