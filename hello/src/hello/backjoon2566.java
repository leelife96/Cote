package hello;
import java.util.Scanner;

public class backjoon2566 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in); 
        
        int[][] array = new int[9][9];
        
        int max = 0;
        int a = 0, b = 0;
        
        for (int i = 0; i < array.length; i++) { //  array.length는 열을 의미함.
            for (int j = 0; j < array[i].length; j++) { // array[i].length는 열을 의미함.
                array[i][j] = sc.nextInt();  // array[i][j]에 입력 값들을 넣는다.
                
                if (array[i][j] > max) { // array[i][j]가 max 보다 크면 
                    max = array[i][j]; // max에 array[i][j]를 대입한다.
                    a = i; // 최대값이 어느 열에 있는지 찾기 위함
                    b = j; // 최대값이 어느 행에 있는지 찾기 위함
                }
                
            }
        }
        
      
        
        System.out.println(max); 
        System.out.println((a+1) + " " + (b+1));
        
    }
}