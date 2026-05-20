// TC -> O(n * logm)
// SC -> O(1)

public class Optimal {
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
        // 4. then take a guess means find mid
        // 5. pass that to findhours func to calculate total hours for that speed
        // 6. then check if that hours is less than h then store it otherwise dont need to store
        // 7. in the end return min speed of koko

        int n = piles.length;
        int low = 1;
        int high = findMaxPile(piles, n);
        int result = -1;

        while (low <= high) {
            int mid = (low + high) / 2;

            long hours = findHours(piles, n, mid);

            if (hours > h) {
                low = mid + 1;
            } else {
                result = mid;
                high = mid - 1;
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

    public static long findHours(int[] piles, int n, int mid) {
        long hours = 0;

        for (int i = 0; i < n; i++) {
            hours = hours + (piles[i] / mid);

            if (piles[i] % mid != 0) {
                hours++;
            }
        }

        return hours;
    } 
}
