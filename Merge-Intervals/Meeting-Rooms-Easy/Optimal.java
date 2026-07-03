// TC -> O(nlogn)
// SC -> O(1)

public class Optimal {
    public static void main(String[] args) {
        int[][] arr = {{1, 4} {10, 15}, {7, 10}};
        System.out.println();
    }    

    public static boolean canAttend(int[][] arr) {
        // Logic-
        // sort array based on starting time
        // now check one by one if some meeting is overlapping then directly return false. If not, then move to next set of interval
        // in the end if you come out of loop that means all meetings can be taken
        // return true

        int n = arr.length;
        
        Arrays.sort(arr, (a, b) -> a[0] - b[0]);
        
        int start1 = arr[0][0];
        int end1 = arr[0][1];
        
        for (int i = 1; i < n; i++) {
            int start2 = arr[i][0];
            int end2 = arr[i][1];
            
            if (end1 > start2) {
                return false;
            } else {
                start1 = start2;
                end1 = end2;
            }
        }
        
        return true;
    }
}
