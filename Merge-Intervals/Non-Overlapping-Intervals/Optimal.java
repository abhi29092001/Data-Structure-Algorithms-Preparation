// TC -> O(nlogn)
// SC -> O(1)

import java.util.*;

public class Optimal {
    public static void main(String[] args) {
        int[][] intervals = {{1,3}, {6,9}};
        System.out.println(eraseOverlapIntervals(intervals));
    }
    
    public static int eraseOverlapIntervals(int[][] intervals) {
        // Logic-
        // we have to take as much intervals as possible, means remove minimal intervals
        // so for that we have to sort the array by end time coz if any interval is taking more time to end so it will overlap most of the elements thats why sorting wrt end time is important for this ques
        // after sorting, will loop on array and count how many overlapping intervals are there, if not then assign next interval to start and end
        // in the end return count

        int n = intervals.length;
        int count = 0;

        Arrays.sort(intervals, (a, b) -> a[1] - b[1]);

        int start = intervals[0][0];
        int end = intervals[0][1];

        for (int i = 1; i < n; i++) {
            if (end > intervals[i][0]) {
                count++;
            } else {
                start = intervals[i][0];
                end = intervals[i][1];
            }
        }

        return count;  
    }    
}
