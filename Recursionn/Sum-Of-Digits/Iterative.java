// TC -> O(logn)-base10
// SC -> O(1)

public class Iterative {
    public static void main(String[] args) {
        int n = 687;
        System.out.println(sumOfDigits(n));
    }    

    public static int sumOfDigits(int n) {
        // code here
        int sum = 0;
        
        while (n > 0) {
            int rem = n % 10;
            sum += rem;
            n = n / 10;
        }
        
        return sum;
    }
}
