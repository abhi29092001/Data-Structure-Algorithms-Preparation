// TC -> O(n)
// SC -> O(1)

public class Iterative {
    public static void main(String[] args) {
        int[] arr = {10, 20, 30, 40, 50};
        System.out.println(isSorted(arr));
    }    

    public static boolean isSorted(int[] arr) {
        // code here
        int n = arr.length;
        
        if (n == 1) {
            return true;
        }
        
        for (int i = 1; i < n; i++) {
            if (arr[i] < arr[i - 1]) {
                return false;
            }
        }
        
        return true;
    }
}
