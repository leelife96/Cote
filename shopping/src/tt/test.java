package tt;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Product {
    private String name;
    private int price;

    public Product(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }
}

class ShoppingCart {
    private List<Product> products;

    public ShoppingCart() {
        products = new ArrayList<>();
    }

    public void addProduct(Product product) {
        products.add(product);
    }

    public void removeProduct(Product product) {
        products.remove(product);
    }

    public void displayCart() {
        if (products.isEmpty()) {
            System.out.println("장바구니가 비어 있습니다.");
        } else {
            System.out.println("장바구니 내역:");
            for (Product product : products) {
                System.out.println("상품명: " + product.getName() + ", 가격: " + product.getPrice());
            }
        }
    }
}

public class test {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;
        ShoppingCart cart = new ShoppingCart();

        
            System.out.println("쇼핑몰 프로그램");
            System.out.println("1. 쇼핑몰");
            System.out.println("2. 고객관리");
            System.out.println("3. 제품 관리");
            System.out.println("0. 종료");
            System.out.print("어떤 메뉴를 선택하시겠습니까? ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    displayProducts();
                    break;
                case 2:
                	customermanagement(scanner, cart);
                    break;
                case 3:
                    cart.displayCart();
                    break;
                case 0:
                    System.out.println("프로그램을 종료합니다.");
                    break;
                default:
                    System.out.println("잘못된 메뉴 선택입니다. 다시 선택하세요.");
                    break;
            }
            System.out.println();
        

        scanner.close();
    }

    private static void displayProducts() {
    	System.out.println();
        System.out.println("상품 목록:");
        System.out.println("1. 휴대폰 - 100000원");
        System.out.println("2. 노트북 - 500000원");
        System.out.println("3. 티셔츠 - 20000원");
    }

    private static void customermanagement(Scanner scanner, ShoppingCart cart) {
        
    	System.out.println("*** 고객 관리 *** ");
    	System.out.println("1. 입력");
    	System.out.println("2. 수정");
    	System.out.println("3. 삭제");
    	System.out.println("0. 메인메뉴로 돌아가기");
        
        int productNumber = scanner.nextInt();
        
        
        switch (productNumber) {
            case 1:
                cart.addProduct(new Product("휴대폰", 100000));
                System.out.println("입력");
                break;
                
            case 2:
                cart.addProduct(new Product("휴대폰", 100000));
                System.out.println("수정");
                break;
                
            case 3:
                cart.addProduct(new Product("휴대폰", 100000));
                System.out.println("삭제");
                break;
                
            case 0:
                cart.addProduct(new Product("휴대폰", 100000));
                System.out.println("메인 메뉴로 돌아가기");
                break;
        }
    }
}

