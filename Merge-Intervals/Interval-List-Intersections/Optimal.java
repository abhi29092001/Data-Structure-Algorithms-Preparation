// TC -> O(n+m)
// SC -> O(1)

import java.util.ArrayList;

public class Optimal {
    public static void main(String[] args) {
        int[][] firstList = {{1,3}, {5,9}};
        int[][] secondList = {};
        System.out.println(intervalIntersection(firstList, secondList));
    }

    public static int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        // Data structure to store answer
        ArrayList<int[]> ans = new ArrayList<>();

        int i = 0;
        int j = 0;

        while (i < firstList.length && j < secondList.length) {
            int start1 = firstList[i][0];
            int end1 = firstList[i][1];

            int start2 = secondList[j][0];
            int end2 = secondList[j][1];

            int start = Math.max(start1, start2);
            int end = Math.min(end1, end2);

            // if start > end then there is no overlapping and hence no intersection
            if (end >= start) {
                ans.add(new int[]{start, end});
            }

            // Based on ending, i and j will move
            if (end1 <= end2) {
                i++;
            } else {
                j++;
            }
        }

        return ans.toArray(new int[ans.size()][]);
    }
}
