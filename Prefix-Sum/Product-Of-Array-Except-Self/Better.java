public class Better {
    public static void main(String[] args) {
        int[] nums = {1,2,3,4};
        System.out.println(productExceptSelf(nums));
    }    

    public static int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        int prod = 1;
        boolean isZeroPresent = false;
        int zeroesCount = 0;

        for (int i = 0; i < n; i++) {
            if (nums[i] == 0) {
                isZeroPresent = true;
                zeroesCount++;
                continue;
            }
            prod *= nums[i];
        }

        if (zeroesCount >= 2) {
            return result;
        }

        for (int i = 0; i < n; i++) {
            if (isZeroPresent && nums[i] == 0) {
                result[i] = prod;
            } else if (!isZeroPresent) {
                result[i] = prod / nums[i];
            }
        }

        return result;
    }    
}
