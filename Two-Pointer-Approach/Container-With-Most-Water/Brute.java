// TC -> O(n^2)
// SC -> O(1)

public class Brute {
    public static void main(String[] args) {
        int[] height = {1,8,6,2,5,4,8,3,7};
        System.out.println(maxArea(height));
    } 
    
    public static int maxArea(int[] height) {
        // Logic-
        // take two pointers place at 0 and 1 index
        // check which wall is minimum among i and j
        // coz container can hold water according to min wall
        // after finding min check capacity of container 
        // if capacity is greater than maxi, store it in maxi
        // finally return maxi

        int n = height.length;
        int maxi = -1;

        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                int mini = Math.min(height[i], height[j]);

                int capacity = (j - i) * mini;

                if (capacity > maxi) {
                    maxi = capacity;
                }
            }
        }

        return maxi;
    }
}
