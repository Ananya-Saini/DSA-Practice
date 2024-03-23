// A non-empty array A consisting of N integers is given. The product of triplet (P, Q, R) equates to A[P] * A[Q] * A[R] (0 ≤ P < Q < R < N).

// For example, array A such that:

//   A[0] = -3
//   A[1] = 1
//   A[2] = 2
//   A[3] = -2
//   A[4] = 5
//   A[5] = 6
// contains the following example triplets:

// (0, 1, 2), product is −3 * 1 * 2 = −6
// (1, 2, 4), product is 1 * 2 * 5 = 10
// (2, 4, 5), product is 2 * 5 * 6 = 60
// Your goal is to find the maximal product of any triplet.

// Write a function:

// class Solution { public int solution(int[] A); }

// that, given a non-empty array A, returns the value of the maximal product of any triplet.

// For example, given array A such that:

//   A[0] = -3
//   A[1] = 1
//   A[2] = 2
//   A[3] = -2
//   A[4] = 5
//   A[5] = 6
// the function should return 60, as the product of triplet (2, 4, 5) is maximal.

// Write an efficient algorithm for the following assumptions:

// N is an integer within the range [3..100,000];
// each element of array A is an integer within the range [−1,000..1,000].
import java.util.Scanner;
public class MaxProductOfThree {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int a[] = new int[n];
        for(int i = 0; i < n; i++){
            a[i] = sc.nextInt();
        }
        System.out.println(solution(a));
        sc.close();
    }
    public static int solution(int[] a){
        int n = a.length;
        int max = Integer.MIN_VALUE;
        int max2 = Integer.MIN_VALUE;
        int max3 = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        int min2 = Integer.MAX_VALUE;
        for(int i = 0; i < n; i++){
            if(max < a[i]){
                max3 = max2;
                max2 = max;
                max = a[i];
            }
            else if(max2 < a[i]){
                max3 = max2;
                max2 = a[i];
            }
            else if(max3 < a[i]){
                max3 = a[i];
            }
            if(min > a[i]){
                min2 = min;
                min = a[i];
            }
            else if(min2 > a[i]){
                min2 = a[i];
            }
        }
        return Math.max(max*max2*max3, min*min2*max);
    }
}
