// TC -> O(nlogn)
// SC -> O(n)

import java.util.ArrayList;
import java.util.Arrays;

public class Optimal {
    public static void main(String[] args) {
        int[][] intervals = {{1,3},{2,6},{8,10},{15,18}};
        System.out.println(merge(intervals));
    }

    public static int[][] merge(int[][] intervals) {
        int n = intervals.length;

        // Sorting using lamba exp - normal sorting will not work on 2D array...that's why using comparator(lambda exp)
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        ArrayList<int[]> ans = new ArrayList<>();

        int start1 = intervals[0][0];
        int end1 = intervals[0][1];

        for (int i = 1; i < n; i++) {
            int start2 = intervals[i][0];
            int end2 = intervals[i][1];

            if (end1 >= start2) {
                // start1 will remain start1 but end1 will change according to maximum value
                // will keep on mergin until we don't find any range which is not overlapping
                end1 = Math.max(end1, end2);
            } else {
                // if we not able to find any overlapping then we'll push it to ans otherwise we keep on merging and comparing with other ranges
                // after pushing, s1 will become s2 and e1 will become e2
                ans.add(new int[]{start1, end1});
                start1 = start2;
                end1 = end2;
            }
        }

        // pushing last interval into ans, either if the last interval is mergerd or not merged it will not be pushed...need to do it manually
        ans.add(new int[]{start1, end1});

        return ans.toArray(new int[ans.size()][]);
    }
}
