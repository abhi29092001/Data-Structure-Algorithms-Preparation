// TC -> O(n^2)
// SC -> O(1)

public class Brute {
    public static void main(String[] args) {
        int[][] intervals = {{1,3}, {7,9}, {4,6}, {10,13}};
        System.out.println(isIntersecting(intervals));
    }

    public static boolean isIntersecting(int[][] intervals) {
        int n = intervals.length;

        for (int i = 0; i < n; i++) {
            int start1 = intervals[i][0];
            int end1 = intervals[i][1];

            for (int j = i + 1; j < n; j++) {
                int start2 = intervals[j][0];
                int end2 = intervals[j][1];

                // intervals are not sorted so that's why we need additional check for end2 >= start1...then only it will considered as overlapping
                if (end1 >= start2 && end2 >= start1) {
                    return true;
                }
            }
        }

        return false;
    }
}
