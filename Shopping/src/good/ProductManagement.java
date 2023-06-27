package good;

import java.util.*;

public class ProductManagement {
	private static List<Product> products = new ArrayList<>();
	private static Scanner scanner = new Scanner(System.in);
	
	public void pmmethod() {
		 boolean isRunning = true;
	        
	        Main mm = new Main();
	        
	        while (isRunning) {
	            System.out.println("*** 제품 관리 ***");
	            System.out.println("1. 추가");
	            System.out.println("2. 삭제");
	            System.out.println("3. 조회");	        
	            System.out.println("메뉴를 선택하세요: ");
	            System.out.print("***************");
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
