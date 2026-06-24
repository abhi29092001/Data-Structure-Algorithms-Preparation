// TC -> O(n^2)
// SC -> O(1)

public class Brute {
    public static void main(String[] args) {
        int[] nums = {2,3,-2,4};
        System.out.println(maxProduct(nums));
    }    

    public static int maxProduct(int[] nums) {
        // Logic-
        // we are finding out prod of each and every element of array
        // we are also avoiding multiplication of same element by checking i!=j
        // we are not running inner loop from i+1 bcoz a single element can also be max prod of subarray like {-2,2}. In this 2 is the answer
        // finally returning maxProd

        int n = nums.length;
        int maxProd = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            int prod = 1 * nums[i];
            
            for (int j = i; j < n; j++) {
                if (i != j) {
                    prod *= nums[j];
                }

                if (prod > maxProd) {
                    maxProd = prod;
                }
            }
        }

        return maxProd;
    }
}
