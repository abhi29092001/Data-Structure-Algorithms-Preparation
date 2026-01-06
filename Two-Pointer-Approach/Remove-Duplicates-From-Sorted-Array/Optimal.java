// TC -> O(n)
// SC -> O(1)

public class Optimal {
    public static void main(String[] args) {
        int[] nums = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        int res = solution(nums);
        System.out.println(res);
    }
    
    public static int solution (int[] nums) {
        int i = 0;
        int j = i + 1;
        int numberOfUnique = 1;

        while (j < nums.length) {
            if (nums[j] == nums[j-1]) {
                j++;
            } else {
                nums[i + 1] = nums[j];
                i++;
                j++;
                numberOfUnique++;
            }
        }
        
        return numberOfUnique;
    }
}
