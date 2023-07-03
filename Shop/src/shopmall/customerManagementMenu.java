package shopmall;
import java.util.*;
import java.io.*;
import java.nio.file.*;

public class customerManagementMenu {
	
	public static final String CUSTOMER_FILE_PATH = "C:\\Program Files\\Javaling\\CustomerDB.txt"; // 모든 영역에서 고정된 값으로 사용하는 상수인 CUSTOMER_FILE_PATH에 
	   																							   // "CustomerDB.txt" 텍스트 파일을 대입한다.
	
	public static Map<Integer, Customer> customerMap = new HashMap<>(); // 초기값 지정
																		// Map<Integer, Customer>는 Integer를 키(key)로 가지고 Customer 객체를 값(value)으로 가지는 맵을 나타냅니다
	
	private static List<Customer> customerList = new ArrayList<>(); // Customer 객체를 저장하는 리스트를 나타냅니다.
	
	private static int customerCount = 1000;	// 고객번호
	
	
	
	public static void cusman() {
    Scanner scanner = new Scanner(System.in);
    
    Main mm = new Main(); // Main 클래스의 mm 객체 생성

    while (true) { 
        System.out.println("=== 고객관리 ===");
        System.out.println("1. 고객 정보 추가");
        System.out.println("2. 고객 정보 조회");
        System.out.println("3. 고객 정보 삭제");
        System.out.println("4. 메인 메뉴로 돌아가기");
        System.out.print("원하는 메뉴를 선택하세요: ");
        
        int choice = scanner.nextInt(); // 입력을 통해 어떤 메뉴로 가기 위함.

        switch (choice) {
            case 1:
                addCustomer(); // 메소드 호출
                break;
            case 2:
            	displayCustomerRecords(); // 메소드 호출
            	break;
            	
            case 3:
            	deleteCustomer(); // 메소드 호출
            	break;
            case 4: 
            	mm.start(); // 메인 메뉴로 돌아가기
            	break;
            	
            default:
                System.out.println("잘못된 선택입니다. 다시 시도하세요.");
                break;
        }
    }
}

	
	public static void addCustomer()  {   // 고객 정보 추가
	
	    Scanner scanner = new Scanner(System.in);
	    System.out.println("=== 고객 정보 추가 ===");
	
	    System.out.print("고객 이름을 입력하세요: ");
	    String customerName = scanner.nextLine();
	
	    System.out.print("고객 전화번호를 입력하세요: ");
	    String customerPhoneNumber = scanner.nextLine();
	
	    System.out.print("고객 이메일을 입력하세요: ");
	    String customerEmail = scanner.nextLine();
	
	    
	    // 고객 정보를 저장할 문자열 생성
	    Customer customer = new Customer(++customerCount, customerName, customerPhoneNumber, customerEmail);
	
	    // HashMap에 고객 정보 추가
	    customerMap.put(customerCount, customer);
	    
	    // ArrayList에 고객 정보 추가
	    customerList.add(customer);
	    
	    // 텍스트 파일에 고객 정보 저장
	    try (PrintWriter writer = new PrintWriter(new FileWriter(CUSTOMER_FILE_PATH, true))) {
	        writer.println("고객번호 : " + customerCount + ",  " + "이름 : " + customer.getName() + ",  " + "전화번호 : " + customer.getPhoneNumber() + ",   " + "이메일 : "  + customer.getEmail());
	        
	        System.out.println("고객 정보가 성공적으로 추가되었습니다.");
	    } catch (IOException e) {
	        System.out.println("고객 정보 추가 중 오류가 발생했습니다: " + e.getMessage());
	  }
	}
	

	public static void deleteCustomer() {   // 고객 정보 삭제
	    Scanner scanner = new Scanner(System.in);
	    System.out.print("삭제할 고객 번호를 입력하세요: ");
	    
	    int customerNumberToDelete = scanner.nextInt();

	    // HashMap에서 고객 정보 삭제
	    Customer deletedCustomer = customerMap.remove(customerNumberToDelete);

	    if (deletedCustomer != null) {
	        // ArrayList에서 고객 정보 삭제
	        customerList.remove(deletedCustomer);

	        // 텍스트 파일에서 해당 고객 정보 삭제
	        try {
	            List<String> lines = Files.readAllLines(Paths.get(CUSTOMER_FILE_PATH)); // CUSTOMER_FILE_PATH 변수에 지정된 파일에서 모든 줄을 읽어와 lines 리스트에 저장합니다.
	            																		// 이를 위해 Files.readAllLines() 메서드를 사용합니다.
	            
	            List<String> updatedLines = new ArrayList<>(); // 수정된 줄을 updatedLines에 담는다.

	            for (String line : lines) {
	                // 해당 고객 번호의 정보를 제외하고 다시 작성
	                if (!line.contains("고객번호 : " + customerNumberToDelete)) {   // 삭제한 고객 정보 빼고 다시 저장하고 업데이트
	                    updatedLines.add(line);
	                }
	            }

	            
	            // 모든 줄에 대한 순회가 끝나면, 업데이트된 줄을 파일에 쓰여 기존 파일을 덮어씁니다. 이를 위해 Files.write() 메서드를 사용하며,
	            // StandardOpenOption.WRITE와 StandardOpenOption.TRUNCATE_EXISTING 옵션을 함께 사용하여 파일을 업데이트된 내용으로 덮어쓰게 됩니다.
	            Files.write(Paths.get(CUSTOMER_FILE_PATH), updatedLines, StandardOpenOption.WRITE, StandardOpenOption.TRUNCATE_EXISTING);

	            System.out.println("고객 정보가 성공적으로 삭제되었습니다.");
	        } catch (IOException e) {
	            System.out.println("고객 정보 삭제 중 오류가 발생했습니다: " + e.getMessage());
	        }
	    } else {
	        System.out.println("입력한 고객 번호에 해당하는 고객 정보가 없습니다.");
	    }
	}

 
public static void displayCustomerRecords() {
    System.out.println("=== 고객 정보 조회 ===");
    
    // 텍스트 파일에 있는 내용들 입력
    try (BufferedReader reader = new BufferedReader(new FileReader(CUSTOMER_FILE_PATH))) {
        String line;
        while ((line = reader.readLine()) != null) {
            System.out.println(line);
        }
    } catch (IOException e) {  // 예외가 있을 경우 발생함
        System.out.println("고객 정보 조회 중 오류가 발생했습니다: " + e.getMessage());
    }
}

public static void main(String[] args) {
	customerManagementMenu cmm = new customerManagementMenu();
		cmm.cusman();
	}
}
