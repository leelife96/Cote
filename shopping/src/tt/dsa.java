package tt;

import java.util.Scanner;

public class dsa {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("쇼핑몰 프로그램");
            System.out.println("1. 쇼핑몰");
            System.out.println("2. 고객관리");
            System.out.println("3. 제품관리");
            System.out.println("0. 종료");
            System.out.print("메뉴를 선택하세요: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    // 쇼핑몰 기능 실행 코드 작성
                    System.out.println("쇼핑몰 기능을 실행합니다.");
                    break;
                case 2:
                    // 고객관리 기능 실행 코드 작성
                    System.out.println("고객관리 기능을 실행합니다.");
                    break;
                case 3:
                    // 제품관리 기능 실행 코드 작성
                    System.out.println("제품관리 기능을 실행합니다.");
                    break;
                case 0:
                    System.out.println("프로그램을 종료합니다.");
                    break;
                default:
                    System.out.println("잘못된 메뉴 선택입니다. 다시 선택하세요.");
                    break;
            }
            System.out.println();
        } while (choice != 0);

        scanner.close();
    }
}
