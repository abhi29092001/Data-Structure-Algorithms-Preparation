// TC -> O(maxPile * n)
// SC -> O(1)

public class Brute {
    public static void main(String[] args) {
        int[] piles = {3, 6, 7, 11};
        int h = 8;
        System.out.println(minEatingSpeed(piles, h));
    }

    public static int minEatingSpeed(int[] piles, int h) {
        // Logic-
        // 1. In this ques we need to find min speed of eating bananas
        // 2. min speed of eating bananas will be 1 and max will be max element in the array
        // 3. first find max element from array
        // 4. we'll check for each speed and when we find that hours <= h then capture the result and break the loop
        // 5. In the end return the result

        int n = piles.length;
        int high = findMaxPile(piles, n);
        int result = -1;

        for (int i = 1; i <= high; i++) {
            long hours = findHours(piles, n, i);

            if (hours <= h) {
                result = i;
                break;
            }
        }

        return result;
    }

    public static int findMaxPile(int[] piles, int n) {
        int maxi = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            maxi = Math.max(piles[i], maxi);
        }

        return maxi;
    }

    public static long findHours(int[] piles, int n, int speed) {
        long hours = 0;

        for (int i = 0; i < n; i++) {
            hours = hours + (piles[i] / speed);

            if (piles[i] % speed != 0) {
                hours++;
            }
        }

        return hours;
    }
}
