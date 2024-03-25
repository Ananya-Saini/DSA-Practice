// A string S consisting of N characters is considered to be properly nested if any of the following conditions is true:

// S is empty;
// S has the form "(U)" or "[U]" or "{U}" where U is a properly nested string;
// S has the form "VW" where V and W are properly nested strings.
// For example, the string "{[()()]}" is properly nested but "([)()]" is not.

// Write a function:

// class Solution { public int solution(String S); }

// that, given a string S consisting of N characters, returns 1 if S is properly nested and 0 otherwise.

// For example, given S = "{[()()]}", the function should return 1 and given S = "([)()]", the function should return 0, as explained above.

// Write an efficient algorithm for the following assumptions:

// N is an integer within the range [0..200,000];
// string S is made only of the following characters: '(', '{', '[', ']', '}' and/or ')'.
import java.util.Scanner;
import java.util.Stack;
public class Brackets {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        System.out.println(solution(s));
        sc.close();
    }
    public static int solution(String s){
        Stack<Character> st = new Stack<>();
        int n = s.length();
        for(int i = 0; i < n; i++){
            char ch = s.charAt(i);
            if(ch == '{' || ch == '[' || ch == '(') st.push(ch);
            else if(st.isEmpty()) return 0;
            else if(ch == '}' && st.peek() == '{') st.pop();
            else if(ch == ')' && st.peek() == '(') st.pop();
            else if(ch == ']' && st.peek() == '[') st.pop();
            else return 0;
        }
        if(!st.isEmpty()) return 0;
        return 1;
    }
}
