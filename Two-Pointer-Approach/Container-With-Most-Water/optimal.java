// TC -> O(n)
// SC -> O(1)

public class optimal {
    public static void main(String[] args) {
        int[] height = {1,8,6,2,5,4,8,3,7};
        System.out.println(maxArea(height));
    } 
    
    public static int maxArea(int[] height) {
        // Logic-
        // take two pointers place at 0 and n-1 index
        // check which wall is minimum among i and j
        // coz container can hold water according to min wall
        // after finding min check capacity of container 
        // if capacity is greater than maxi, store it in maxi
        // then move pointer according to min wall height coz we want to find max wall height (greedy)

        int n = height.length;
        int maxi = -1;
        int i = 0;
        int j = n - 1;

        while (i < j) {
            int mini = Math.min(height[i], height[j]);

            int capacity = (j - i) * mini;

            if (capacity > maxi) {
                maxi = capacity;
            }

            if (height[i] < height[j]) {
                i++;
            } else {
                j--;
            }
        }

        return maxi;
    }    
}
