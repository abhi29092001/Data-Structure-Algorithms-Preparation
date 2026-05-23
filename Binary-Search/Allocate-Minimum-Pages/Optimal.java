// TC -> O(n * log m)
// SC -> O(1)

public class Optimal {
    public static void main(String[] args) {
        int[] arr = {12, 34, 67, 90};
        int k = 4;
        System.out.println(findPages(arr, k));
    }

    public static int findPages(int[] arr, int k) {
        // Logic-
        // 1. we want to minimise the max no. of pages
        // 2. if we take a guess and that guess is not correct that means all guess that lies to left are also not correct
        // 3. low will be the max element of array coz otherwise books will remain unallocated so min. starting will be max element and high will be sum of total array coz max we can allocate all books so high will be sum of array
        // 4. if mid is satisfying then we need to move to left otherwise move to right for max no. of pages
        // 5. if students are more then books return -1
        // 6. helper func will tell that whether students are enough or need more if requires more then return false so that we can move to the right to increase no. of pages
        // 7. monotonicity is there if at some point mid satisfies then all element right to mid will also satisy and at that time we have to minimise max no. of pages by moving left 

        int n = arr.length;
        
        // if students are more and books are less
        if (k > n) {
            return -1;
        }
        
        int low = 0;
        int high = 0;
        int result = -1;
        
        for (int i = 0; i < n; i++) {
            low = Math.max(arr[i], low);
            high += arr[i];
        }
        
        while (low <= high) {
            int mid = (low + high) / 2;
            
            if (helper(arr, n, mid, k)) {
                result = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        
        return result;
    }
    
    public static boolean helper(int[] arr, int n, int mid, int k) {
        int countStud = 1;
        int pagesCount = 0;
        
        for (int i = 0; i < n; i++) {
            if (pagesCount + arr[i] <= mid) {
                pagesCount += arr[i];
            } else {
                countStud++;
                pagesCount = arr[i];
                
                if (countStud > k) {
                    return false;
                }
            }
        }
        
        return true;
    }
}
