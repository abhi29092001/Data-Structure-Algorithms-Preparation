// TC -> O(nlogn)
// SC -> O(n)

import java.util.*;

public class Brute {
    public static void main(String[] args) {
        int[][] intervals = {{1,3}, {6,9}};
        int[] newInterval = {2,5};
        System.out.println(eraseOverlapIntervals(intervals, newInterval));
    }
    
    public static int eraseOverlapIntervals(int[][] intervals) {
        // Logic-
        // we have to take as much intervals as possible, means remove minimal intervals
        // so for that we have to sort the array by end time coz if any interval is taking more time to end so it will overlap most of the elements thats why sorting wrt end time is important for this ques
        // after sorting, will loop on array and keep putting intervals in arraylist and avoid overlapping element(s)
        // in the end minus arraylist length from arrays length and return
        // thats the count of overlapping elements

        int n = intervals.length;
        List<int[]> nonOverlapping = new ArrayList<>();

        Arrays.sort(intervals, (a, b) -> a[1] - b[1]);

        for (int i = 0; i < n; i++) {
            if (i == 0) {
                nonOverlapping.add(intervals[i]);
            } else {
                if (nonOverlapping.get(nonOverlapping.size() - 1)[1] <= intervals[i][0]) {
                    nonOverlapping.add(intervals[i]);
                }
            }
        }

        return intervals.length - nonOverlapping.size(); 
    }
}
