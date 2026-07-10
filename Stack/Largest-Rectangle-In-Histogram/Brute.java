// TC -> O(n ^ 2) 
// SC -> O(1)

public class Brute {
    public static void main(String[] args) {
        int[] heights = {2,1,5,6,2,3};
        System.out.println(largestRectangleArea(heights));
    }    

    public static int largestRectangleArea(int[] heights) {
        // Logic-
        // we have to find the shorter bar in left side of the current bar and in the right side as well
        // once we get the shorter bar, calculate the index diff between left and right. index diff is the width of the rectangle
        // multiply width with the height of current bar, you'll get the area
        // find maxarea and keep repeating until loop ends

        int n = heights.length;
        int maxArea = -1;

        for (int i = 0; i < n; i++) {
            // tracking left index
            int left = i;

            // tracking right index
            int right = i;

            // finding shorter bar in right side
            for (int j = i + 1; j < n; j++) {
                if (heights[j] < heights[i]) {
                    break;
                }
                right++;
            }

            // finding shorter bar in left side
            for (int k = i - 1; k >= 0; k--) {
                if (heights[k] < heights[i]) {
                    break;
                }
                left--;
            }

            // calculating width based on left and right indexes
            int width = right - left + 1;

            // calculating area
            int area = heights[i] * width;

            // calculating max area
            maxArea = Math.max(area, maxArea);
        }

        return maxArea;
    }
}
