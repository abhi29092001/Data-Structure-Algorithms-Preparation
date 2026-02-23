// TC -> O(m*n)
// SC -> O(1)

import java.util.ArrayList;

public class Brute {
    public static void main(String[] args) {
        int[][] firstList = {{1,3}, {5,9}};
        int[][] secondList = {};
        System.out.println(intervalIntersection(firstList, secondList));
    }

    public static int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        // edge case - when either of the list is empty then there will be no intersection
        if (firstList.length == 0 || secondList.length == 0) {
            return new int[][]{};
        }

        // Data structure to store and return the answer
        ArrayList<int[]> ans = new ArrayList<>();

        for (int i = 0; i < firstList.length; i++) {
            int start1 = firstList[i][0];
            int end1 = firstList[i][1];

            for (int j = 0; j < secondList.length; j++) {
                int start2 = secondList[j][0];
                int end2 = secondList[j][1];

                // intersection means min of both starts and max of both ends(Intersection will be counted only if start is less or equal to end otherwise it will not be a valid range)
                int start = Math.max(start1, start2);
                int end = Math.min(end1, end2);

                if (start <= end) {
                    ans.add(new int[]{start, end});
                }
            }
        }

        return ans.toArray(new int[ans.size()][]);
    }
}
