// TC -> O(n)
// SC -> O(1)

public class Brute {
    private int[] nums;

    public Brute(int[] nums) {
        this.nums = nums;
    }

    public static void main(String[] agrs) {
        // Logic-
        // loop for every range and find out the sum
        // the thing is everytime we are finding sum from scratch

        Brute nums = new Brute(new int[] {-2, 0, 3, -5, 2, -1});
        System.out.println(nums.sumRange(0, 5));
        System.out.println(nums.sumRange(0, 2));
        System.out.println(nums.sumRange(2, 5));
    } 
    
    public int sumRange(int left, int right) {
        int sum = 0;
        
        for (int i = left; i <= right; i++) {
            sum += nums[i];
        }

        return sum;
    }    
}
