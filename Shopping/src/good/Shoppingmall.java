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
	        System.out.println("1. 상품 보기 & 주문하기");
	        System.out.println("0. 종료");
	        System.out.print("메뉴를 선택하세요: ");
	        int choice = scanner.nextInt();
	        scanner.nextLine(); // 개행 문자 제거

	        switch (choice) {
	            case 1:
	            	showProductListAndOrder();
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

	private void showProductListAndOrder() {
	    System.out.println("========== 상품 목록 ==========");

	    List<String> productList = loadProductListFromFile("C:\\Program Files\\Javaling\\ProductDB.txt"); // 상품 목록이 저장된 텍스트 파일 경로
	    if (productList.isEmpty()) {
	        System.out.println("상품이 없습니다.");
	    } else {
	        for (String product : productList) {
	            System.out.println(product);
	        }

	        System.out.println("----------------------------");
	        System.out.print("주문할 상품 번호를 입력하세요: ");
	        int productNumber = scanner.nextInt();
	        scanner.nextLine(); // 개행 문자 제거

	        if (productNumber >= 1 && productNumber <= productList.size()) {
	            String selectedProduct = productList.get(productNumber - 1);
	            String[] productInfo = selectedProduct.split(",");

	            String pid = productInfo[0];
	            String productCount = productInfo[1];
	            String productName = productInfo[2];
	            String price = productInfo[3];

	            System.out.print("주문할 수량을 입력하세요: ");
	            int quantity = scanner.nextInt();
	            scanner.nextLine(); // 개행 문자 제거

	            int availableQuantity = Integer.parseInt(productCount);
	            if (quantity <= availableQuantity) {
	                // 주문 가능한 수량인 경우
	                int remainingQuantity = availableQuantity - quantity;

	                // 업데이트된 상품 정보를 생성
	                String updatedProductInfo = pid + "," + remainingQuantity + "," + productName + "," + price;

	                // 상품 목록 업데이트
	                productList.set(productNumber - 1, updatedProductInfo);

	                System.out.println(quantity + "개의 " + productName + "을(를) 주문하였습니다.");
	                System.out.println("주문이 완료되었습니다.");

	                // 상품 정보를 파일에 업데이트
	                String filePath = "C:\\Program Files\\Javaling\\ProductDB.txt";
	                try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
	                    for (String product : productList) {
	                        writer.write(product);
	                        writer.newLine();
	                    }
	                    System.out.println("데이터가 파일에 저장되었습니다.");
	                } catch (IOException e) {
	                    e.printStackTrace();
	                }
	            } else {
	                System.out.println("주문 가능한 수량을 초과하였습니다.");
	            }
	        } else {
	            System.out.println("잘못된 상품 번호입니다.");
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
	
	
	
	public static void main(String[] args) {
		Shoppingmall sm = new Shoppingmall();
		sm.showMainMenu();
	}
}

