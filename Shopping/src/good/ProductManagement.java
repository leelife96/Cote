package good;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class ProductManagement {
	private static List<Product> products = new ArrayList<>();
	private static Scanner scanner = new Scanner(System.in);
	
	public void pmmethod() {
		 boolean isRunning = true;
	        
	        Main mm = new Main();
	        
	        while (isRunning) {
	        	System.out.println();
	            System.out.println("*** 제품 관리 ***");
	            System.out.println("1. 추가");
	            System.out.println("2. 삭제");
	            System.out.println("3. 조회");	
	            System.out.println("4. 종료");
	            System.out.print("메뉴를 선택하세요: ");
	        
	            int choice = scanner.nextInt();
	            scanner.nextLine(); // 개행 문자 제거

	            switch (choice) {
	                case 1:
	                    addProduct();
	                    break;
	                case 2:
	                	deleteProduct();
	                    break;
	                case 3:
	                	viewProducts();
	                    break;
	                case 4:
	                	mm.start();
	                	break;
	             
	                  
	            }
	        }
	        scanner.close();
	}
	 private static void addProduct() {
	        System.out.print("제품 명: ");
	        String productname = scanner.nextLine();
	        System.out.print("가격: ");
	        String price = scanner.nextLine();

	        Product product = new Product(productname, price);
	        products.add(product);
	        System.out.println("고객이 추가되었습니다.");
	        
	        String filePath = "C:\\Program Files\\Javaling\\ProductDB.txt";
	        
	        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
	            for (Product product2 : products) {
	                writer.write(product2.getProductName() + "," + product2.getPrice());
	                writer.newLine();
	            }
	            System.out.println("데이터가 파일에 저장되었습니다.");
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    }
	 
	 
	 private static void deleteProduct() {
	        System.out.print("삭제할 제품명: ");
	        String targetProductName = scanner.nextLine();

	        Product targetProduct = findProduct(targetProductName);
	        if (targetProduct == null) {
	            System.out.println("고객을 찾을 수 없습니다.");
	            return;
	        }

	        products.remove(targetProduct);
	        System.out.println("고객이 삭제되었습니다.");
	        
	        String filePath = "C:\\Program Files\\Javaling\\ProductDB.txt"; // 실제 파일 경로로 변경해야 합니다.
	        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
	            for (Product product : products) {
	                writer.write(product.getProductName() + "," + product.getPrice());
	                writer.newLine();
	            }
	            System.out.println("데이터가 파일에서 삭제되었습니다.");
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    }
	 
	 private static void viewProducts() {
	        if (products.isEmpty()) {
	            System.out.println("등록된 제품이 없습니다.");
	        } else {
	            System.out.println("*** 등록된 제품 목록 ***");
	            for (Product product : products) {
	                System.out.println("제품명: " + product.getProductName());
	                System.out.println("가격: " + product.getPrice());
	                System.out.println();
	            }
	        }
	    }
	 
	 private static Product findProduct(String name) {
	        for (Product product : products) {
	            if (product.getProductName().equals(name)) {
	                return product;
	            }
	        }
	        return null;
	    }
}
