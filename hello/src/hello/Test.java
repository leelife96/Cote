package hello;
import java.util.ArrayList;
import java.util.Scanner;


public class Test {
	public static void getPrime(int num) {
		  boolean flag;    //소수 판별을 위한 true/false
	        int cnt = 0;     //소수의 총 개수를 확인하기 위한 변수
	        for(int i=2; i<=num; i++){    //i는 2~num 사이에 정수
	            flag = true;
	            for(int j=2; j<i; j++){   //j는 i보다 작은 정수
	                if(i%j ==0){          //i를 j로 나누었을 때, 나누어 떨어지면 소수가 아님
	                    flag = false;
	                }
	            }
	            if(flag == true){
	                cnt++;
	                System.out.printf(i+" "); //소수를 따로 배열에 저장하지 않고, 찾을 때 마다 출력
	            }        
	        }
	        System.out.println();
	        System.out.println("소수 개수 : " + cnt);		
	}
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        getPrime(N);
        
    }
	
}
