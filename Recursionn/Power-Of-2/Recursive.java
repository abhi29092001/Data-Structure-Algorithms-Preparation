// TC -> O(logn)
// SC -> O(logn)

public class Recursive {
    public static void main(String[] args) {
        int n = 3;
        System.out.println(isPowerOfTwo(n));
    }    

    public static boolean isPowerOfTwo(int n) {
        // 0 will never be the power of 2
        // if a number is power of 2 then it will definitely boils down to 1
        // thats why base case is for n = 1
        
        if (n == 0) return false;
        if (n == 1) return true;

        return n % 2 == 0 && isPowerOfTwo(n / 2);
    }     
}
