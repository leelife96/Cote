package Shop2;

import java.util.*;
import java.io.*;

import java.util.Scanner;
import java.io.FileInputStream;

class Solution {
	static int AnswerN = 0;
	static int N = 10;

	public static void main(String args[]) throws Exception {
		//System.setIn(new FileInputStream("C:\sample_input.txt"));
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		String[][] arr = new String[10][10];
		boolean isRunning = true;
		

		
		
		for(int test_case = 1; test_case <= T; test_case++) {
			N = sc.nextInt();
			}
		
		
		for(int Y=0; Y<N; Y++) {
			
			for(int X=0; X<N; X++) {
				 arr[Y][X] = sc.nextLine();
				 
				 
			}
			System.out.println("");
		}
		
			
			while(T>=0) {
				
				if(arr[4][0] =="H" && arr[4][1] == "H") {
					AnswerN++;
				}
				else if(arr[4][6] == "H" && arr[4][7] == "H") {
					AnswerN++;
				}
				
				else if(arr[N][N] == "L") {
					continue;
				}
				
				else 
					System.out.printf("FAIL");
				T--;
			}
		

		
		}
		System.out.println("#"+test_case+" "+AnswerN);
	}



	

