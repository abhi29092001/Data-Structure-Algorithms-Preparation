// TC -> O(log n)
// SC -> O(1)

public class Optimal {
    public static void main(String[] args) {
        int n = 19;
        System.out.println(isHappy(n));
    }

    public static boolean isHappy(int n) {
        int slow = n;
        int fast = n;

        while (fast != 1) {
            slow = findSumOfSquares(slow);
            fast = findSumOfSquares(fast);
            fast = findSumOfSquares(fast);

            if (slow == fast && slow != 1) {
                return false;
            }
        }

        return true;
    }

    public static int findSumOfSquares(int n) {
        int sum = 0;

        while (n != 0) {
            int digit = n % 10;
            n /= 10;
            sum += digit * digit;
        }

        return sum;
    }
}
