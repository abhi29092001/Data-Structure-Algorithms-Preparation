// TC -> O(n)
// SC -> O(1)

public class Brute {
    public static void main(String[] args) {
        int[] arr = {0,1,0};
        System.out.println(peakIndexInMountainArray(arr));
    }
    
    public static int peakIndexInMountainArray(int[] arr) {
        // Logic-
        // Simple linear search approach
        
        int n = arr.length;
        int peak = -1;
        int peakIndex = -1;

        for (int i = 0; i < n; i++) {
            if (arr[i] > peak) {
                peak = arr[i];
                peakIndex = i;
            }
        }

        return peakIndex;
    }
}
