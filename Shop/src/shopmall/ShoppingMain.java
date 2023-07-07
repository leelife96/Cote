package shopmall;


import java.util.*;

import java.io.*;


public class ShoppingMain {
    private static final String PRODUCT_FILE_PATH = "C:\\Program Files\\Javaling\\ProductDB.txt";
    
    private static final String ORDER_HISTORY_FILE_PATH = "C:\\Program Files\\Javaling\\order_history.txt";
    
    private static Map<Integer, Product> productMap = new HashMap<>();
    private static List<Product> productList = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);
    private static int loggedInCustomerNumber; // 로그인한 고객 번호 저장
   
    
    
    public static void shoppingMallMenu() {
        Scanner scanner = new Scanner(System.in);
        Main mm = new Main();

        while (true) {
            System.out.println("========== 쇼핑몰 메인 ==========");
            System.out.println("1. 주문하기");
            System.out.println("2. 상품 리스트 보기");
            System.out.println("3. 주문 내역 보기");
            System.out.println("4. 메인 메뉴로 돌아가기");
      
            System.out.print("메뉴를 선택하세요: ");
            int choice = scanner.nextInt();
          
            
            switch (choice) {
                case 1:
                 
                	showProductListAndOrder();
                    break;
                case 2:
                	ProductList();
                    break;
                case 3:		
                	showOrderHistory();
                    break;
                case 4:
                    mm.start();
                    break;
                default:
                    System.out.println("잘못된 선택입니다. 다시 시도하세요.");
                    break;
            }
        }
    }
    
    private static void ProductList() {  // 2. 상품 리스트 보기
        System.out.println("========== 상품 목록 ==========");
        System.out.println("상품ID     상품명     가격     수량");
        System.out.println("==============================");

	    List<String> productList = loadProductListFromFile("C:\\Program Files\\Javaling\\ProductDB.txt"); // 상품 목록이 저장된 텍스트 파일 경로
	    if (productList.isEmpty()) {
	        System.out.println("상품이 없습니다.");
	    } else {
	        for (String product : productList) {  
	            System.out.println(product);
	        }
	    }
    }

    private static void showProductListAndOrder() {  // 위 코드는 상품 목록을 표시하고 주문을 처리하는 기능을 제공하는 메소드입니다. 
    												// 주어진 상품 목록 파일을 로드하고 사용자로부터 상품 번호와 주문 수량을 입력받아, 
    												//주문 가능한 수량인 경우 상품 목록과 주문 내역을 업데이트합니다. 마지막으로 업데이트된 상품 정보를 파일에 저장합니다.
        System.out.println("========== 상품 목록 ==========");
        System.out.println("상품ID     상품명     가격     수량");
        System.out.println("==============================");

	    List<String> productList = loadProductListFromFile("C:\\Program Files\\Javaling\\ProductDB.txt"); // 상품 목록이 저장된 텍스트 파일 경로
	    if (productList.isEmpty()) {
	        System.out.println("상품이 없습니다.");
	    } else {
	        for (String product : productList) {
	            System.out.println(product);
	        }

	        System.out.println("----------------------------");
	        System.out.print("주문할 상품 번호를 입력하세요: ");
	        int productNumber = scanner.nextInt(); //사용자에게 주문할 상품 번호를 입력하도록 안내하고, 입력된 값을 productNumber 변수에 저장합니다.
	        scanner.nextLine(); // 개행 문자 제거

	        if (productNumber >= 1 && productNumber <= productList.size()) { // productNumber가 1부터 productList의 크기 사이에 있는지 확인합니다.
	            String selectedProduct = productList.get(productNumber - 1); // productNumber에 해당하는 상품을 productList에서 가져옵니다.
	            String[] productInfo = selectedProduct.split(","); // 선택된 상품의 정보를 쉼표(,)를 기준으로 분리하여 productInfo 배열에 저장합니다.

	            String pid = productInfo[0].trim();          
	            String productName = productInfo[1].trim();   
	            String price = productInfo[2].trim();  
	            String productCount = productInfo[3].trim();  

	            System.out.print("주문할 수량을 입력하세요: ");
	            int quantity = scanner.nextInt();
	            scanner.nextLine(); // 개행 문자 제거

	            int availableQuantity = Integer.parseInt(productCount);
	            if (quantity <= availableQuantity) {
	                // 주문 수량이 재고 수량보다 작거나 같은지 확인합니다.
	            	
	            	
	                int remainingQuantity = availableQuantity - quantity; // 주문 가능한 수량인 경우, 재고에서 주문 수량을 뺀 남은 수량을 remainingQuantity 변수에 저장합니다.

	                // 업데이트된 상품 정보를 생성
	                String updatedProductInfo = pid + ", " + productName  + ", " +  price + ", " + remainingQuantity;
	                
	                // 상품 목록 업데이트
	                productList.set(productNumber - 1, updatedProductInfo);
	                
	                
	                System.out.println(quantity + "개의 " + productName + "을(를) 주문하였습니다.");
	                System.out.println("주문이 완료되었습니다.");
	                
	            

	                
	                // 상품 정보를 파일에 업데이트
	                String filePath = "C:\\Program Files\\Javaling\\ProductDB.txt";
	                try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) { // BufferedWriter를 사용하여 "C:\Program Files\Javaling\ProductDB.txt" 파일에 각 상품을 한 줄씩 쓰고, 새로운 줄 문자를 추가합니다.
	                    for (String product : productList) {
	                        writer.write(product);
	                        writer.newLine();
	                    }
	                    System.out.println("데이터가 파일에 저장되었습니다.");
	                } catch (IOException e) {
	                    e.printStackTrace();
	                }
	                
	                
	                // 주문 내역에 추가하기 위해 주문의 총 가격을 계산하여 totalPrice 변수에 저장합니다.
                    double totalPrice = Double.parseDouble(price) * quantity;
                    String orderDetails =   // 주문 상세 내용을 문자열 형식으로 작성하여 orderDetails 변수에 저장합니다.
                            "상품번호: " + productNumber +
                            ", 상품명: " + productName +
                            ", 가격: " + price +
                            ", 수량: " + quantity +
                            ", 총액: " + totalPrice;
                    updateOrderHistory(orderDetails); // updateOrderHistory() 메소드를 호출하여 주문 내역을 업데이트합니다.
                    
                    
	              
	            } else {
	                System.out.println("주문 가능한 수량을 초과하였습니다.");
	            }
	        } else {
	            System.out.println("잘못된 상품 번호입니다.");
	        }
        }
    }

 
    
    private static List<String> loadOrderHistoryFromFile(String filePath) { // 위의 코드는 주어진 파일 경로에서 주문 내역을 읽어와서 리스트로 반환하는 기능을 제공하는 메소드입니다. 
    																		// 파일을 열고 한 줄씩 읽어서 각 줄을 orderHistory 리스트에 추가한 후, 리스트를 반환합니다.
        List<String> orderHistory = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {  // BufferedReader를 사용하여 filePath를 읽는 reader 객체를 생성합니다. 
        																			// 파일을 읽을 수 있도록 FileReader로부터 생성된 reader 객체를 초기화합니다.
            String line;
            while ((line = reader.readLine()) != null) { // reader.readLine()을 호출하여 파일에서 한 줄씩 읽습니다. 읽은 내용을 line 변수에 저장하고, line이 null이 아닐 때까지 반복합니다.
                orderHistory.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return orderHistory; // orderHistory 리스트를 반환합니다.
    }

    
    private static void updateOrderHistory(String orderDetails) { // 위의 코드는 주어진 orderDetails를 주문 내역 파일에 추가하는 기능을 제공하는 메소드입니다. BufferedWriter를 사용하여 파일을 열고 orderDetails를 파일에 씁니다.
    																// 새로운 줄 문자를 추가하여 다음 주문 내역이 새로운 줄에 작성되도록 합니다.
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(ORDER_HISTORY_FILE_PATH, true))) { //BufferedWriter를 사용하여 ORDER_HISTORY_FILE_PATH에 해당하는 파일을 쓰기 모드로 엽니다. FileWriter로부터 생성된 writer 객체를 초기화합니다. 
        																									// ORDER_HISTORY_FILE_PATH는 상수로 정의된 파일 경로입니다.
            writer.write(orderDetails); // writer.write(orderDetails)를 호출하여 orderDetails를 파일에 씁니다.
            writer.newLine(); // writer.newLine()을 호출하여 새로운 줄 문자를 파일에 추가합니다.
        } catch (IOException e) {
            e.printStackTrace(); //예외가 발생한 경우 e.printStackTrace()를 호출하여 예외의 스택 트레이스를 출력합니다.
        }
    }

    
		    private static void showOrderHistory() {  // 주문한 내역을 보여주는 메소드 입니다. 
		        System.out.println("========== 주문 내역 ==========");
		        List<String> orderHistory = loadOrderHistoryFromFile(ORDER_HISTORY_FILE_PATH);
		        if (orderHistory.isEmpty()) {
		            System.out.println("주문 내역이 없습니다.");
		        } else {
		            for (String order : orderHistory) {
		                System.out.println(order);
		            }
		        }
		    }
		    
		
		    private static List<String> loadProductListFromFile(String filePath) { // ProductList 파일을 불러오는 메소드
		        List<String> productList = new ArrayList<>();
		
		        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
		            String line;
		            while ((line = reader.readLine()) != null) {
		                productList.add(line);
		            }
		        } catch (IOException e) { 
		            e.printStackTrace(); 
		        }
		
		        return productList;
		    }

  /* private static void saveProductListToFile(String filePath, List<String> productList) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            for (String product : productList) {
                writer.write(product);
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    } */
	
   
   
   
   
		    
		    public static void main(String[] args) {
				ShoppingMain sm = new ShoppingMain();
				sm.shoppingMallMenu();
			}
		    
		    
		    
}
