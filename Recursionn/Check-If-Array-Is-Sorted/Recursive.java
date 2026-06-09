// TC -> O(n)
// SC -> O(n)-recursive stack space

public class Recursive {
    public static void main(String[] args) {
        int[] arr = {10, 20, 30, 40, 50};
        System.out.println(isSorted(arr));
    }    

    public static boolean isSorted(int[] arr) {
        // code here
        int n = arr.length;
        return helper(arr, n);
    }
    
    public static boolean helper(int[] arr, int n) {
        if (n == 1) return true;
        
        if (arr[n - 1] >= arr[n - 2] && helper(arr, n - 1)) {
            return true;
        }
        
        return false;
    }   
}
