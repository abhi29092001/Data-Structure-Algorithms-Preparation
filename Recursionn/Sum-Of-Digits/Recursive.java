// TC -> O(logn)
// SC -> O(logn)-recursive stack space

public class Recursive {
    public static void main(String[] args) {
        int n = 687;
        System.out.println(sumOfDigits(n));
    }    

    public static int sumOfDigits(int n) {
        // code here
        if (n % 10 == n) {
            return n;
        }
        
        return (n % 10 + sumOfDigits(n / 10));
    }    
}
