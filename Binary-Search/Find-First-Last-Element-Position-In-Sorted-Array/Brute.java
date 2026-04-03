// TC -> O(n)
// SC -> O(1)

public class Brute {
    public static void main(String[] args) {
        int[] nums = {5,7,7,8,8,10};
        int target = 8;
        System.out.println(searchRange(nums, target));
    }
    
    public static int[] searchRange(int[] nums, int target) {
        // Logic-
        // 1. In first iteration get the starting index of the target and break
        // 2. In second iteration get the last index of the traget, if there is only one occurrence of traget then also you will get atleast starting and ending index although it will be same in that case
        // 3. if no occurrence then -1 would be returned which is initialized at starting
        
        int n = nums.length;
        int[] range = new int[2];

        // Initialize array with -1
        range[0] = -1;
        range[1] = -1;

        for (int i = 0; i < n; i++) {
            if (nums[i] == target) {
                range[0] = i;
                break;
            }
        }

        for (int i = 0; i < n; i++) {
            if (nums[i] == target) {
                range[1] = i;
            }
        }

        return range;
    }
}
