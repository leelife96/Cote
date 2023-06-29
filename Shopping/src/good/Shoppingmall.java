package good;


import java.util.*;
import java.io.*;


public class Shoppingmall {
	
	private static Scanner scanner = new Scanner(System.in);
	
	public void showMainMenu() {
	    Scanner scanner = new Scanner(System.in);
	    boolean isRunning = true;
	    
	    Main mm = new Main();

	    while (isRunning) {
	        System.out.println("========== 쇼핑몰 메인 ==========");
	        System.out.println("1. 상품 목록 보기");
	        System.out.println("2. 주문하기");
	        System.out.println("3. 로그아웃");
	        System.out.println("0. 종료");
	        System.out.print("메뉴를 선택하세요: ");
	        int choice = scanner.nextInt();
	        scanner.nextLine(); // 개행 문자 제거

	        switch (choice) {
	            case 1:
	                showProductList();
	                break;
	            case 2:
	                placeOrder();
	                break;
	            case 3:
	                System.out.println("로그아웃되었습니다.");
	                isRunning = false;
	                break;
	            case 0:
	                System.out.println("프로그램을 종료합니다.");
	                isRunning = false;
	                break;
	            default:
	                System.out.println("잘못된 메뉴 선택입니다.");
	                break;
	        }
	    }
	}

	private void showProductList() {
		   System.out.println("========== 상품 목록 ==========");
	        List<String> productList = loadProductListFromFile("C:\\Program Files\\Javaling\\ProductDB.txt"); // 상품 목록이 저장된 텍스트 파일 경로
	        if (productList.isEmpty()) {
	            System.out.println("상품이 없습니다.");
	        } else {
	            for (String product : productList) {
	                System.out.println(product);
	            }
	        }
	}
	
	 private List<String> loadProductListFromFile(String filePath) {
	        List<String> productList = new ArrayList<>();

	        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
	            String line;
	            while ((line = reader.readLine()) != null) {
	                productList.add(line);
	            }
	        } catch (IOException e) {
	            System.out.println("파일에서 상품 목록을 불러오는 중 오류가 발생했습니다.");
	            e.printStackTrace();
	        }

	        return productList;
	    }
	

	private void placeOrder() {
	    Scanner scanner = new Scanner(System.in);
	    System.out.println("========== 주문하기 ==========");
	    System.out.print("상품명을 입력하세요: ");
	    String productName = scanner.nextLine();
	    System.out.print("수량을 입력하세요: ");
	    int quantity = scanner.nextInt();
	    scanner.nextLine(); // 개행 문자 제거

	    System.out.println(quantity + "개의 " + productName + "을(를) 주문하였습니다.");
	    System.out.println("주문이 완료되었습니다.");
	}

	
	public static void main(String[] args) {
		
	}
}

