// TC -> O(n)
// SC -> O(1)

public class Brute {
    public static void main(String[] args) {
        int[] arr = {1, 2, 8, 10, 11, 12, 19};
        int x = 5;
        System.out.println(findCeil(arr, x));
    }
    
    public static int findCeil(int[] arr, int x) {
        // code here
        int n = arr.length;
        
        for (int i = 0; i < n; i++) {
            if (arr[i] >= x) {
                return i;
            }
        }
        
        return -1;
    }
}
