// A DNA sequence can be represented as a string consisting of the letters A, C, G and T, which correspond to the types of successive nucleotides in the sequence. Each nucleotide has an impact factor, which is an integer. Nucleotides of types A, C, G and T have impact factors of 1, 2, 3 and 4, respectively. You are going to answer several queries of the form: What is the minimal impact factor of nucleotides contained in a particular part of the given DNA sequence?

// The DNA sequence is given as a non-empty string S = S[0]S[1]...S[N-1] consisting of N characters. There are M queries, which are given in non-empty arrays P and Q, each consisting of M integers. The K-th query (0 ≤ K < M) requires you to find the minimal impact factor of nucleotides contained in the DNA sequence between positions P[K] and Q[K] (inclusive).

// For example, consider string S = CAGCCTA and arrays P, Q such that:

//     P[0] = 2    Q[0] = 4
//     P[1] = 5    Q[1] = 5
//     P[2] = 0    Q[2] = 6
// The answers to these M = 3 queries are as follows:

// The part of the DNA between positions 2 and 4 contains nucleotides G and C (twice), whose impact factors are 3 and 2 respectively, so the answer is 2.
// The part between positions 5 and 5 contains a single nucleotide T, whose impact factor is 4, so the answer is 4.
// The part between positions 0 and 6 (the whole string) contains all nucleotides, in particular nucleotide A whose impact factor is 1, so the answer is 1.
// Write a function:

// class Solution { public int[] solution(String S, int[] P, int[] Q); }

// that, given a non-empty string S consisting of N characters and two non-empty arrays P and Q consisting of M integers, returns an array consisting of M integers specifying the consecutive answers to all queries.

// Result array should be returned as an array of integers.

// For example, given the string S = CAGCCTA and arrays P, Q such that:

//     P[0] = 2    Q[0] = 4
//     P[1] = 5    Q[1] = 5
//     P[2] = 0    Q[2] = 6
// the function should return the values [2, 4, 1], as explained above.

// Write an efficient algorithm for the following assumptions:

// N is an integer within the range [1..100,000];
// M is an integer within the range [1..50,000];
// each element of arrays P and Q is an integer within the range [0..N - 1];
// P[K] ≤ Q[K], where 0 ≤ K < M;
// string S consists only of upper-case English letters A, C, G, T.

import java.util.Scanner;
public class GenomicRangeQuery {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int p[] = new int[n];
        System.out.println("Enter P: ");
        for(int i = 0; i < n; i++){
            p[i] = sc.nextInt();
        }
        sc.nextLine();
        int q[] = new int[n];
        System.out.println("Enter Q: ");
        for(int i = 0; i < n; i++){
            q[i] = sc.nextInt();
        }
        sc.nextLine();
        System.out.println("Enter String: ");
        String s = sc.nextLine();
        int ans[] = solution(s, p, q);
        for(int i = 0; i < n; i++) System.out.println(ans[i]);
        sc.close();
    }
    public static int[] solution(String s, int[] p, int[] q){
        int n = s.length();
        int m = p.length;
        int[][] genomes = new int[3][n+1];
        for(int i = 0; i < n; i++){
            int a = 0, b = 0, c = 0;
            if(s.charAt(i) == 'A') a = 1;
            if(s.charAt(i) == 'C') b = 1;
            if(s.charAt(i) == 'G') c = 1;
            genomes[0][i+1] = genomes[0][i] + a;
            genomes[1][i+1] = genomes[1][i] + b;
            genomes[2][i+1] = genomes[2][i] + c;
        }
        int ans[] = new int[m];
        for(int i = 0; i < m; i++){
            if(genomes[0][q[i]+1] - genomes[0][p[i]] > 0) ans[i] = 1;
            else if(genomes[1][q[i]+1] - genomes[1][p[i]] > 0) ans[i] = 2;
            else if(genomes[2][q[i]+1] - genomes[2][p[i]] > 0) ans[i] = 3;
            else ans[i] = 4;
        }
        return ans;
    }
}
