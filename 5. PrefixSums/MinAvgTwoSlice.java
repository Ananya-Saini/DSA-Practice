// A non-empty array A consisting of N integers is given. A pair of integers (P, Q), such that 0 ≤ P < Q < N, is called a slice of array A (notice that the slice contains at least two elements). The average of a slice (P, Q) is the sum of A[P] + A[P + 1] + ... + A[Q] divided by the length of the slice. To be precise, the average equals (A[P] + A[P + 1] + ... + A[Q]) / (Q − P + 1).

// For example, array A such that:

//     A[0] = 4
//     A[1] = 2
//     A[2] = 2
//     A[3] = 5
//     A[4] = 1
//     A[5] = 5
//     A[6] = 8
// contains the following example slices:

// slice (1, 2), whose average is (2 + 2) / 2 = 2;
// slice (3, 4), whose average is (5 + 1) / 2 = 3;
// slice (1, 4), whose average is (2 + 2 + 5 + 1) / 4 = 2.5.
// The goal is to find the starting position of a slice whose average is minimal.

// Write a function:

// class Solution { public int solution(int[] A); }

// that, given a non-empty array A consisting of N integers, returns the starting position of the slice with the minimal average. If there is more than one slice with a minimal average, you should return the smallest starting position of such a slice.

// For example, given array A such that:

//     A[0] = 4
//     A[1] = 2
//     A[2] = 2
//     A[3] = 5
//     A[4] = 1
//     A[5] = 5
//     A[6] = 8
// the function should return 1, as explained above.

// Write an efficient algorithm for the following assumptions:

// N is an integer within the range [2..100,000];
// each element of array A is an integer within the range [−10,000..10,000].
import java.util.Scanner;
public class MinAvgTwoSlice {
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
        double twoAvg = 0;
        double threeAvg = 0;
        double minAvg = Double.MAX_VALUE;
        int index = 0;
        for(int i = 0; i < n-2; i++){
            int sum = a[i] + a[i+1];
            twoAvg = sum/2.0d;
            if(twoAvg < minAvg){
                minAvg = twoAvg;
                index = i;
            }
            threeAvg = (sum + a[i+2])/3.0d;
            if(threeAvg < minAvg){
                minAvg = threeAvg;
                index = i;
            }
        }
        twoAvg = (a[n-1] + a[n-2])/2.0d;
        if(twoAvg < minAvg){
            minAvg = twoAvg;
            index = n-2;
        }
        return index;
        // int[] pref = new int[n+1];
        // pref[0] = 0;
        // for(int i = 0; i < n; i++){
        //     pref[i+1] = pref[i] + a[i];
        // }
        // double min = Double.MAX_VALUE;
        // int minInd = 0;
        // int i = 0, j = n-1;
        // while(i < j){
        //     double avg = (double)(pref[j+1] - pref[i])/(double)(j - i + 1);
        //     // System.out.print("avg : " + avg + " ");
        //     if(min > avg){
        //         min = avg;
        //         minInd = i;
        //         // System.out.println("min : " + min + " " + "minInd : "+ minInd + " " + i + " " + j);
        //     }
        //     // System.out.println();
        //     if(a[i] > a[j]) i++;
        //     else j--;
        // }
        // return minInd;

    }
}
