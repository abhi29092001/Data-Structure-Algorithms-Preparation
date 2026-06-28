public class Brute {
    public static void main(String[] args) {
        int[] nums = {1,2,3,4};
        System.out.println(productExceptSelf(nums));
    }    

    public static int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];

        for (int i = 0; i < n; i++) {
            int prod = 1;

            for (int j = 0; j < n; j++) {
                if (i != j) {
                    prod *= nums[j];
                }
            }

            result[i] = prod;
        }

        return result;
    }
}
