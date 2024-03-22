package PrefixSums;
// Write a function:

// class Solution { public int solution(int A, int B, int K); }

// that, given three integers A, B and K, returns the number of integers within the range [A..B] that are divisible by K, i.e.:

// { i : A ≤ i ≤ B, i mod K = 0 }

// For example, for A = 6, B = 11 and K = 2, your function should return 3, because there are three numbers divisible by 2 within the range [6..11], namely 6, 8 and 10.

// Write an efficient algorithm for the following assumptions:

// A and B are integers within the range [0..2,000,000,000];
// K is an integer within the range [1..2,000,000,000];
// A ≤ B.
import java.util.Scanner;
public class CountDiv {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int k = sc.nextInt();
        System.out.println(solution(a, b, k));
        sc.close();
    }
    public static int solution(int a, int b, int k){
        if(k > b) return 0;
        int first = -1;
        int cnt = 0;
        for(int i = a; i <= b; i++){
            if(i % k == 0){
                first = i;
                break;
            }
        }
        while(first < b){
            cnt++;
            first += k;
        }
        return cnt;
    }
}
