// TC -> O(n)
// SC -> O(1)

public class Better {
    public static void main(String[] args) {
        int[] nums = {5,7,7,8,8,10};
        int target = 8;
        System.out.println(searchRange(nums, target));
    }
    
    public static int[] searchRange(int[] nums, int target) {
        // Logic-
        // 1. if there is -1 at 0th index of range then put ith index at 0 and 1 both
        // 2. otherwise put only at 1st index
        // 3. if no occurrence then -1 would be returned as initialized at starting

        int n = nums.length;
        int[] range = new int[2];

        // initialized range with -1
        range[0] = -1;
        range[1] = -1;

        for (int i = 0; i < n; i++) {
            if (range[0] == -1 && nums[i] == target) {
                range[0] = i;
                range[1] = i;
            } else if (nums[i] == target) {
                range[1] = i;
            }
        }

        return range;
    }    
}
