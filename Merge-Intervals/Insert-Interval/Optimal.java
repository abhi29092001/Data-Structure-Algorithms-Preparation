// TC -> O(n)
// SC -> O(n)

import java.util.ArrayList;

public class Optimal {
    public static void main(String[] args) {
        int[][] intervals = {{1,3}, {6,9}};
        int[] newInterval = {2,5};
        System.out.println(insert(intervals, newInterval));
    }

    public static int[][] insert(int[][] intervals, int[] newInterval) {
        int n = intervals.length;

        // first push back all the intervals and new interval in the arraylist in a sorted manner to avoid custom sorting
        ArrayList<int[]> arr = new ArrayList<>();
        boolean insert = false;

        for (int i = 0; i < n; i++) {
            int start = intervals[i][0];

            if (insert == false && start > newInterval[0]) {
                arr.add(newInterval);
                insert = true;
            }

            arr.add(intervals[i]);
        }

        // edge case - if intervals array is empty or if new interval's start is greater than every element in intervals array
        if (insert == false) {
            arr.add(newInterval);
        }
        

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
