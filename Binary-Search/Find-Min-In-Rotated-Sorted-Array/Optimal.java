// TC -> O(logn)
// SC -> O(1)

public class Optimal {
    public static void main(String[] args) {
        int[] nums = {4,5,6,7,0,1,2};
        System.out.println(findMin(nums));
    }
    
    public static int findMin(int[] nums) {
        // Logic-
        // 1. calculate mid and then check if mid is smaller than mini, if yes then assign a[mid] in mini
        // 2. now comes moving part, where to move?
        // 3. if your high pointer is smaller than mid pointer that means array is rotated...move to the right for minimum element
        // 4. if your high pointer is greater than mid that means array is not rotated...move to the left for minimum element
        // 5. finally return mini
         
        int n = nums.length;
        int mini = Integer.MAX_VALUE;
        int low = 0;
        int high = n - 1;

        while (low <= high) {
            int mid = (low + high) / 2;
            if (mini > nums[mid]) {
                mini = nums[mid];
            }

            if (nums[mid] < nums[high]) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return mini;
    }    
}
