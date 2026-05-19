// TC -> O(log n)
// SC -> O(1)

public class Better {
    public static void main(String[] args) {
        int[] nums = {4,5,6,7,0,1,2};
        int target = 0;
        System.out.println(search(nums, target));
    }

    public static int search(int[] nums, int target) {
        // Logic-
        // 1. Find min element
        // 2. Once u got min element, traverse array two times
        // 3. First from low = 0, high = min element index - 1
        // 4. Second from low = min element index, high = n - 1
        // 5. if target is present then return index otherwise -1

        int n = nums.length;

        int low = 0;
        int high = n - 1;
        int mini = Integer.MAX_VALUE;
        int minIdx = -1;

        while (low <= high) {
            int mid = (low + high) / 2;

            if (nums[mid] == target) {
                return mid;
            }

            if (mini > nums[mid]) {
                mini = nums[mid];
                minIdx = mid;
            }

            if (nums[high] < nums[mid]) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        low = 0;
        high = minIdx - 1;

        while (low <= high) {
            int mid = (low + high) / 2;

            if (nums[mid] == target) {
                return mid;
            }

            if (nums[mid] > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        low = minIdx;
        high = n - 1;

        while (low <= high) {
            int mid = (low + high) / 2;

            if (nums[mid] == target) {
                return mid;
            }

            if (nums[mid] > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return -1;
    }
}
