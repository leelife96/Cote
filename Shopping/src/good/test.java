package good;

import java.util.Scanner;
import java.io.FileInputStream;

class Solution {
	static int AnswerN;
	static int N = 10;

	public static void main(String args[]) throws Exception {
		//System.setIn(new FileInputStream("C:\sample_input.txt"));
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		char[][] arr = new char[8][8];
		
		
		for(int test_case = 1; test_case <= T; test_case++) {
			N = sc.nextInt();
			
			for(int Y=0; Y<N; Y++) {
				System.out.println("L");
					
			}
			
			
			System.out.println("#"+test_case+" "+AnswerN);
		
		
		}
	}
}
