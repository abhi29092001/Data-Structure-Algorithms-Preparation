// TC -> O(2^n)
// SC -> O(n)

package Recursionn.Fibonaccii;
public class Recursive {
    public static void main(String[] args) {
        int n = 3;
        System.out.println(fib(n));
    } 
    
    public static int fib(int n) {
        // base case
        if (n == 1) {
            return 1;
        }
        if (n == 0) {
            return 0;
        }

        // sub-problem
        int ans = fib(n - 1) + fib(n - 2);

        return ans;
    }
}
