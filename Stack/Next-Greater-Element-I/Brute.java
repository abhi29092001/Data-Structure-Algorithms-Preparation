// TC -> O(n * m)
// SC -> O(1)

public class Brute {
    public static void main(String[] args) {
        int[] nums1 = {4,1,2};
        int[] nums2 = {1,3,4,2};
        System.out.println(nextGreaterElement(nums1, nums2));
    }
    
    public static int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;
        int[] resArray = new int[n];

        for (int i = 0; i < n; i++) {
            int numIndex = -1; // this var will contain index of ith element of nums1 in the nums2 array

            for (int j = 0; j < m; j++) {
                if (nums1[i] == nums2[j]) {
                    numIndex = j;
                    break;
                }
            }

            int num = nums2[numIndex];
            boolean greaterFound = false;

            for (int k = numIndex + 1; k < m; k++) {
                if (nums2[k] > num) {
                    resArray[i] = nums2[k];
                    greaterFound = true;
                    break;
                }
            }

            if (!greaterFound) {
                resArray[i] = -1;
            }
        }

        return resArray;
    }
}
