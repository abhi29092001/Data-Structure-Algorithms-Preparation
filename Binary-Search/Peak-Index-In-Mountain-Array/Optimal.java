// TC -> O(logn)
// SC -> O(1)

public class Optimal {
    public static void main(String[] args) {
        int[] arr = {0,1,0};
        System.out.println(peakIndexInMountainArray(arr));
    }
    
    public static int peakIndexInMountainArray(int[] arr) {
        // Logic-
        // 1. if mid is smaller than next element that means we are still in climbing position. so, move low
        // 2. if mid is greater than next element that means we are coming downwards and there is a chance that mid can be the peak. so, keep mid and move left side by keeping high pointer mid-1
        // 3. finally return peakIndex
         
        int n = arr.length;
        int peakIndex = -1;
        int low = 0;
        int high = n - 1;

        while (low <= high) {
            int mid = (low + high) / 2;

            if (arr[mid] < arr[mid + 1]) {
                low = mid + 1;
            } else {
                peakIndex = mid;
                high = mid - 1;
            }
        }

        return peakIndex;
    }
}
