// TC -> O(nlogn)
// SC -> O(1)

import java.util.Arrays;

public class Optimal {
    public static void main(String[] args) {
        int[][] intervals = {{1,3}, {5,7}, {2,4}, {6,8}};
        System.out.println(isIntersecting(intervals));
    }

    public static boolean isIntersecting(int[][] intervals) {
        int n = intervals.length;

        // Sorting intervals wrt to start
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        int start1 = intervals[0][0];
        int end1 = intervals[0][1];
        for (int i = 1; i < n; i++) {
            int start2 = intervals[i][0];
            int end2 = intervals[i][1];

            if (end1 >= start2) {
                return true;
            }

            start1 = start2;
            end1 = end2;
        }

        return false;
    }    
}
