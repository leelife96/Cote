package hello;

import java.util.*;


public class test {
    public static void main(String[] args)  {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        
        System.out.println(calcu(N,M));
        
    

      }
    
    
    
    public static int calcu(int a, int b) {
    	
    	int result = 0;
    	if(a>b) {
    		result = a*a - b*b;
    	}
    	
    	else {
    		result = b*b - a*a;
    	}
    	
    	return result;
    			
    			
    }
  }



