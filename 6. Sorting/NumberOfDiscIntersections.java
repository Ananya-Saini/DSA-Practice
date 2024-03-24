// We draw N discs on a plane. The discs are numbered from 0 to N − 1. An array A of N non-negative integers, specifying the radiuses of the discs, is given. The J-th disc is drawn with its center at (J, 0) and radius A[J].

// We say that the J-th disc and K-th disc intersect if J ≠ K and the J-th and K-th discs have at least one common point (assuming that the discs contain their borders).

// The figure below shows discs drawn for N = 6 and A as follows:

//   A[0] = 1
//   A[1] = 5
//   A[2] = 2
//   A[3] = 1
//   A[4] = 4
//   A[5] = 0

// There are eleven (unordered) pairs of discs that intersect, namely:

// discs 1 and 4 intersect, and both intersect with all the other discs;
// disc 2 also intersects with discs 0 and 3.
// Write a function:

// class Solution { public int solution(int[] A); }

// that, given an array A describing N discs as explained above, returns the number of (unordered) pairs of intersecting discs. The function should return −1 if the number of intersecting pairs exceeds 10,000,000.

// Given array A shown above, the function should return 11, as explained above.

// Write an efficient algorithm for the following assumptions:

// N is an integer within the range [0..100,000];
// each element of array A is an integer within the range [0..2,147,483,647].
import java.util.Scanner;

public class NumberOfDiscIntersections {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int a[] = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        System.out.println(solution(a));
        sc.close();
    }
    public static int solution(int[] a){
        int n = a.length;
        int dps[] = new int[n];
        int dpe[] = new int[n];
        int res = 0;
        for(int i = 0; i < n; i++){
            int s = i - a[i] > 0? i-a[i]:0;
            int e = n-1-i > a[i]? i+a[i]:n-1;
            dps[s]++;
            dpe[e]++;
        }
        int discs = 0;
        for(int i = 0; i < n; i++){
            if(dps[i] > 0){
                res += discs * dps[i];
                res += dps[i] * (dps[i]-1)/2;
                if(res > 10000000) return -1;
                discs += dps[i];
            }
            discs -= dpe[i];
        }
        return res;
    }
}
