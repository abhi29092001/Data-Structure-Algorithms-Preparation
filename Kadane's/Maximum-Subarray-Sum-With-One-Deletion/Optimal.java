// TC -> O(n)
// SC -> O(1)

public class Optimal {
    public static void main(String[] args) {
        int[] arr = {1,-2,0,3};
        System.out.println(maximumSum(arr));
    }
    
    public static int maximumSum(int[] arr) {
        int n = arr.length;

        // It will store normal kadane's sum
        int noDeletionSum = arr[0];

        // It will store sum of one deletion from subarray
        int oneDeletionSum = 0;
        int ans = arr[0];

        for (int i = 1; i < n; i++) {
            // It will store prev sum of normal kadane's algo for comparing with one deletion sum
            int prevNoDeletionSum = noDeletionSum;

            // doing normal kadane
            noDeletionSum = Math.max(noDeletionSum + arr[i], arr[i]);

            // comparing prev sum with one deletion sum (either we'll add the current element or we'll ignore current element based on maximum between prev sum or one deletion sum)
            oneDeletionSum = Math.max(oneDeletionSum + arr[i], prevNoDeletionSum);

            // comapring ans, kadane's sum, one deletion sum
            ans = Math.max(ans, Math.max(noDeletionSum, oneDeletionSum));
        }

        return ans;
    }
}
