// TC -> O(n^2)
// SC -> O(1)

public class Brute {
    public static void main(String[] args) {
        int[] nums = {1,2,3,4,3};
        System.out.println(nextGreaterElements(nums));
    }

    public static int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        // To store the next greater element
        int[] resArray = new int[n];

        for (int i = 0; i < n; i++) {
            // boolean to just keep a track of whether next greater element found or not, otherwise -1 needs to be put in the result array after inner loop ends
            boolean greaterFound = false;

            // This loop will iterate in a circular manner
            for (int j = (i + 1) % n; j != i; j = (j + 1) % n) {
                if (nums[j] > nums[i]) {
                    resArray[i] = nums[j];
                    greaterFound = true;
                    break;
                }
            }

            if (!greaterFound) {
                resArray[i] = -1;
            }
        }

        return resArray;
    }
}
