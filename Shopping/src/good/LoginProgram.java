package good;

import java.util.*;
import java.io.*;

public class LoginProgram {
    private Map<String, String> users;
    Shoppingmall sm = new Shoppingmall();
    
    public LoginProgram() {
        users = new HashMap<>();
    }

    public void run() {
        Scanner scanner = new Scanner(System.in);
        boolean isRunning = true;
        Main mm = new Main();

        while (isRunning) {
        	System.out.println("**** 쇼핑몰 로그인 창 ****"); 
            System.out.println("1. 로그인");
            System.out.println("2. 회원가입");
            System.out.println("3. 종료");
            System.out.print("메뉴를 선택하세요: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    login();
                    
                    break;
                case 2:
                    register();
                    break;
                case 3:
                	mm.start();
                    break;
                default:
                    System.out.println("잘못된 입력입니다. 다시 선택해주세요.");
                    break;
            }

            System.out.println();
        }

        System.out.println("프로그램을 종료합니다.");
        scanner.close();
    }

    private void login() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("로그인을 진행합니다.");
        
        System.out.print("아이디를 입력하세요: ");
        String username = scanner.nextLine();
        System.out.print("비밀번호를 입력하세요: ");
        String password = scanner.nextLine();	

        if (users.containsKey(username) && users.get(username).equals(password)) {
            System.out.println("로그인에 성공했습니다. 환영합니다, " + username + "님!");   
            
            sm.showMainMenu();
          
        } else {
            System.out.println("아이디 또는 비밀번호가 올바르지 않습니다.");
        }
    }

    private void register() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("회원가입을 진행합니다.");
        System.out.print("아이디를 입력하세요: ");
        String username = scanner.nextLine();

        if (users.containsKey(username)) {
            System.out.println("이미 존재하는 아이디입니다. 회원가입을 진행할 수 없습니다.");
        } else {
            System.out.print("비밀번호를 입력하세요: ");
            String password = scanner.nextLine();
            users.put(username, password);
            saveUserInfoToFile(username, password);
            System.out.println("회원가입이 완료되었습니다. 로그인해주세요.");
            
            
        }
    }
    
    private static void saveUserInfoToFile(String username, String password) {
        String filePath = "C:\\Program Files\\Javaling\\LoginDB.txt"; // 파일 경로와 파일명을 적절하게 수정해주세요.

        try {
            FileWriter writer = new FileWriter(filePath, true);
            writer.write(username + "," + password + "\n");
            writer.close();
        } catch (IOException e) {
            System.out.println("파일에 회원정보를 저장하는 중 오류가 발생했습니다.");
            e.printStackTrace();
        }
    }

    
    
    
    public static void main(String[] args) {
        LoginProgram program = new LoginProgram();
        
        
        program.run();
    }
}

