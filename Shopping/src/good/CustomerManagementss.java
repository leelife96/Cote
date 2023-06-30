package good;

import java.util.*;
import java.io.*;


public class CustomerManagementss {
	
    private static List<Customer> customers = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);
   
    

    public void CusMan() {
        boolean isRunning = true;
        
        Main mm = new Main();
        
        while (isRunning) {
            System.out.println("*** 고객 관리 ***");
            System.out.println("1. 입력");
            System.out.println("2. 수정");
            System.out.println("3. 삭제");
            System.out.println("4. 조회");
            System.out.println("5. 종료");
            System.out.print("메뉴를 선택하세요: ");
            
            int choice = scanner.nextInt();
            scanner.nextLine(); // 개행 문자 제거

            switch (choice) {
                case 1:
                    addCustomer();
                    break;
                case 2:
                    updateCustomer();
                    break;
                case 3:
                    deleteCustomer();
                    break;
                    
                case 4:
                	viewCustomers();
                	break;
              
                case 5:
                    mm.start();
                    break;
                default:
                    System.out.println("잘못된 입력입니다. 다시 선택해주세요.");
            }
        }
        scanner.close();
    }
    


    private static void addCustomer() {
    	 System.out.print("UID: ");
         String uid = scanner.nextLine();
        System.out.print("고객 이름: ");
        String name = scanner.nextLine();
        System.out.print("전화번호: ");
        String phoneNumber = scanner.nextLine();

        Customer customer = new Customer(uid, name, phoneNumber);
        customers.add(customer);
        System.out.println("고객이 추가되었습니다.");
        String filePath = "C:\\Program Files\\Javaling\\CustomerDB.txt"; // 실제 파일 경로로 변경해야 합니다.

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            for (Customer customer2 : customers) {
                writer.write(customer2.getUID() + "," + customer2.getName() + "," + customer2.getPhoneNumber());
                writer.newLine();
            }
            System.out.println("데이터가 파일에 저장되었습니다.");
        } catch (IOException e) {
            e.printStackTrace();
        }
        
    }

    private static void updateCustomer() {
        System.out.print("수정할 고객의 이름: ");
        String name = scanner.nextLine();

        Customer foundCustomer = null;
        for (Customer customer : customers) {
            if (customer.getName().equals(name)) {
                foundCustomer = customer;
                
                break;
            }
        }

        if (foundCustomer != null) {
            System.out.println("고객 정보를 수정합니다.");

            System.out.print("새로운 이름: ");
            String newName = scanner.nextLine();
            foundCustomer.setName(newName);

            System.out.print("새로운 전화번호: ");
            String newPhoneNumber = scanner.nextLine();
            foundCustomer.setPhoneNumber(newPhoneNumber);
            	

            System.out.println("고객 정보가 성공적으로 수정되었습니다.");
        } else {
            System.out.println("해당하는 이름의 고객이 없습니다.");
        }
        String filePath = "C:\\Program Files\\Javaling\\CustomerDB.txt"; // 실제 파일 경로로 변경해야 합니다.
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            for (Customer customer : customers) {
                writer.write(customer.getName() + "," + customer.getPhoneNumber());
                writer.newLine();
            }
            System.out.println("데이터가 파일에서 삭제되었습니다.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

   
    

    private static void deleteCustomer() {
    	System.out.print("삭제할 고객의 이름: ");
        String name = scanner.nextLine();

        Iterator<Customer> iterator = customers.iterator();
        while (iterator.hasNext()) {
            Customer customer = iterator.next();
            if (customer.getName().equals(name)) {
                iterator.remove();
                System.out.println("고객이 삭제되었습니다.");
            }
        }
        
        String filePath = "C:\\Program Files\\Javaling\\CustomerDB.txt"; // 실제 파일 경로로 변경해야 합니다.
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            for (Customer customer : customers) {
                writer.write(customer.getName() + "," + customer.getPhoneNumber());
                writer.newLine();
            }
            System.out.println("데이터가 파일에서 삭제되었습니다.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    	
    private static void viewCustomers() {
        if (customers.isEmpty()) {
            System.out.println("등록된 고객이 없습니다.");
        } else {
            System.out.println("*** 등록된 고객 목록 ***");
            for (Customer customer : customers) {
            	System.out.println("UID: " + customer.getUID());
                System.out.println("고객 이름: " + customer.getName());
                System.out.println("전화번호: " + customer.getPhoneNumber());
                
                System.out.println();
            }
        }
    }

    private static Customer findCustomer(String name) {
        for (Customer customer : customers) {
            if (customer.getName().equals(name)) {
                return customer;
            }
        }
        return null;
    }
}
