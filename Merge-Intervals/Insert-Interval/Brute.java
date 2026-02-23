// TC -> O(nlogn)
// SC -> O(n)

import java.util.ArrayList;
import java.util.Collections;

public class Brute {
    public static void main(String[] args) {
        int[][] intervals = {{1,3}, {6,9}};
        int[] newInterval = {2,5};
        System.out.println(insert(intervals, newInterval));
    }

    public static int[][] insert(int[][] intervals, int[] newInterval) {
        int n = intervals.length;

        // first push back the all the intervals and new interval in the newly created arraylist
        ArrayList<int[]> arr = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            arr.add(intervals[i]);
        }
        arr.add(newInterval);

        // Custom sorting based on start values
        Collections.sort(arr, (a, b) -> a[0] - b[0]);

        // Now performing same steps as of merge intervals
        int start1 = arr.get(0)[0];
        int end1 = arr.get(0)[1];
        ArrayList<int[]> ans = new ArrayList<>();

        for (int i = 1; i < arr.size(); i++) {
            int start2 = arr.get(i)[0];
            int end2 = arr.get(i)[1];

            if (end1 >= start2) {
                end1 = Math.max(end1, end2);
            } else {
                ans.add(new int[]{start1, end1});
                start1 = start2;
                end1 = end2;
            }
        }

        ans.add(new int[]{start1, end1});

        return ans.toArray(new int[ans.size()][]);
    }
}
