package hello;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class backjoon1664 {
    public static void getPrime(int num) {
        boolean[] isComposite = new boolean[num + 1]; 	//  isComposite 배열의 모든 요소가 false로 초기화되며,
        												// 	소수 판별을 위한 초기 상태로 준비됩니다.
        												//  이후 소수를 찾을 때, 해당 숫자의 인덱스를 true로 변경하여
                                                        //	소수가 아닌 것으로 표시하게 됩니다.
        
        												// isComposite 배열에 [num+1] 만큼의 배열을 만들어준다.
         												// num + 1로 설정하는 이유는 isComposite 배열의 인덱스를 0부터 시작하고,
        												// num까지의 수에 대한 소수 판별을 하기 위함입니다.
        
        
        List<Integer> primes = new ArrayList<>(); // primes 라는 배열리스트를 만든 이유는 소수값을 저장하기 위해 만듬.
        int cnt = 0; // 소수가 몇개 있는지 카운트 해주는 것.

        for (int i = 2; i <= num; i++) { // 2부터 num 까지 반복문
            if (!isComposite[i]) { // isComposite는 소수가 아닌 것을 묻는데 !<< 붙여있으면 반대의 의미가 되니까 결론적으로 "소수이냐?"를 묻는다.
                				   // 합성수(composite)는 1과 자기 자신 이외의 양의 약수를 가지는 정수를 말합니다.
            	
            	primes.add(i); // List<Integer> primes에 소수 값을 저장함
                cnt++; // 소수이면 늘어남
                System.out.printf(i + " ");

                for (int j = i * 2; j <= num; j += i) {
                    isComposite[j] = true; //소수가 아닌 부분을 표시
                }
            }
        }

        System.out.println();
        System.out.println("소수 개수: " + cnt);

        int count = 0; // 소수의 연속합 경우의 수
        int sum = 0; // start 와 end의 합
        int start = 0; // start는 절대로 end를 넘어설 순 업음
        int end = 0;

        while (true) {
            if (sum >= num) { // 합이 입력된 정수 num보다 크거나 같으면
                sum -= primes.get(start++); // 합에서 가장 작은 소수를 빼고 start를 증가시킵니다. 
            } 
            
            else if (end == primes.size()) { // 인덱스 end가 primes 리스트의 크기와 같으면
                break;                       //  종료합니다.
            } 
            
            else {
                sum += primes.get(end++); // 그렇지 않으면 합에 다음 소수를 더하고 right를 증가시킵니다.
            }

            if (sum == num) { //합이 입력된 정수 num과 같으면 
                count++; // 경우의 수를 증가시킵니다.
                         // end와 start가 같다는 게 아니므로, 헷갈리지 말 것.
            }
        }

        System.out.println("소수의 연속합 경우의 수: " + count); 
        // 53을 만들 수 있는 두 개의 소수의 연속합은 (5, 7, 11, 13, 17)와 (53)입니다. 
        // 20을 만들 수 있는 건 0
        // 3을 만들 수 있는건 3 자신 하나 뿐이므로 1개
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
 
        getPrime(N); //소수를 구하는 함수
    }
}
