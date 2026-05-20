// TC -> O(log n)
// SC -> O(1)

public class Optimal {
    public static void main(String[] args) {
        int[] nums = {4,5,6,7,0,1,2};
        int target = 0;
        System.out.println(search(nums, target));
    } 
    
    public static int search(int[] nums, int target) {
        // Logic-
        // 1. There are two parts in the array
        // 2. Find mid and check if nums[mid] is equal to target
        // 3. check whether nums[mid] lies in part 1 or part 2 if not equals to target
        // 4. if it lies in part 1 then, if nums[mid] < target...move to the right, coz bigger elements will be in the right direction only
        // 5. if it lies in part 1 then, if nums[mid] > target...check if a[0] > target and if its true then move to right otherwise move to left.
        // 6. if it lies in part 2 then, if nums[mid] > target...move to the left, coz smaller elements will be in the left direction only
        // 7. if it lies in part 2 then, if nums[mid] < target...check if a[n-1] > target and if its true then move to left otherwise move to right.
        // 8. if element is not there then, return -1

        int n = nums.length;

        int low = 0;
        int high = n - 1;

        while (low <= high) {
            int mid = (low + high) / 2;

            if (nums[mid] == target) {
                return mid;
            }

            // Part 1
            if (nums[mid] > nums[n - 1]) {
                if (nums[mid] < target) {
                    low = mid + 1;
                } else {
                    if (nums[0] > target) {
                        low = mid + 1;
                    } else {
                        high = mid - 1;
                    }
                }
            } 
            // Part 2
            else {        
                if (nums[mid] > target) {
                    high = mid - 1;
                } else {
                    if (nums[n - 1] < target) {
                        high = mid - 1;
                    } else {
                        low = mid + 1;
                    }
                }
            }
        }

        return -1;
    }
}