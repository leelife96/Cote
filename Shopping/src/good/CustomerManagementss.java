package good;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

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
            System.out.println("메뉴를 선택하세요: ");
            System.out.print("***************");
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
        System.out.print("고객 이름: ");
        String name = scanner.nextLine();
        System.out.print("전화번호: ");
        String phoneNumber = scanner.nextLine();

        Customer customer = new Customer(name, phoneNumber);
        customers.add(customer);
        System.out.println("고객이 추가되었습니다.");
    }

    private static void updateCustomer() {
        System.out.print("수정할 고객의 이름: ");
        String targetName = scanner.nextLine();

        Customer targetCustomer = findCustomer(targetName);
        if (targetCustomer == null) {
            System.out.println("고객을 찾을 수 없습니다.");
            return;
        }

        System.out.print("새로운 전화번호: ");
        String newPhoneNumber = scanner.nextLine();
        targetCustomer = new Customer(targetCustomer.getName(), newPhoneNumber);
        System.out.println("고객 정보가 수정되었습니다.");
    }

    private static void deleteCustomer() {
        System.out.print("삭제할 고객의 이름: ");
        String targetName = scanner.nextLine();

        Customer targetCustomer = findCustomer(targetName);
        if (targetCustomer == null) {
            System.out.println("고객을 찾을 수 없습니다.");
            return;
        }

        customers.remove(targetCustomer);
        System.out.println("고객이 삭제되었습니다.");
    }
    
    private static void viewCustomers() {
        if (customers.isEmpty()) {
            System.out.println("등록된 고객이 없습니다.");
        } else {
            System.out.println("*** 등록된 고객 목록 ***");
            for (Customer customer : customers) {
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

