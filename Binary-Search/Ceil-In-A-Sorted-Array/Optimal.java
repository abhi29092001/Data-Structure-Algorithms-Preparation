// TC -> O(logn)
// SC -> O(1)

public class Optimal {
    public static void main(String[] args) {
        int[] arr = {1, 2, 8, 10, 11, 12, 19};
        int x = 5;
        System.out.println(findCeil(arr, x));
    }
    
    public static int findCeil(int[] arr, int x) {
        int n = arr.length;
        int low = 0;
        int high = n - 1;
        int index = -1;
        
        while (low <= high) {
            int mid = (low + high) / 2;
            
            if (arr[mid] >= x) {
                index = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        
        return index;
    }    
}
