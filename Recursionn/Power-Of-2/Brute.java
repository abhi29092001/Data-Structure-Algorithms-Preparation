// TC -> O(logn)
// SC -> O(1)

public class Brute {
    public static void main(String[] args) {
        int n = 3;
        System.out.println(isPowerOfTwo(n));
    }    

    public static boolean isPowerOfTwo(int n) {
        // 0 will never be the power of 2
        // if a number is power of 2 then it will definitely boils down to 1
        
        if (n == 0) return false;

        while (n % 2 == 0) {
            n /= 2;
        }

        return n == 1;
    } 
}
