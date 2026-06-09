// TC -> O(n)
// SC -> O(1)

package Recursionn.Fibonaccii;

public class Iterative {
    public static void main(String[] args) {
        int n = 3;
        System.out.println(fib(n));
    } 
    
    public static int fib(int n) {
        if (n == 1) return 1;
        if (n == 0) return 0;

        int first = 0;
        int second = 1;
        int ans = -1;

        for (int i = 2; i <= n; i++) {
            ans = first + second;
            first = second;
            second = ans;
        } 

        return ans;
    }
}
