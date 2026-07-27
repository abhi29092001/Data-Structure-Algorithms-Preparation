// TC -> O(logn)
// SC -> O(1)

interface MountainArray {
    int get(int index);
    int length();
}

public class Optimal implements MountainArray {
    private int[] arr;

    public Optimal(int[] arr) {
        this.arr = arr;
    }

    @Override
    public int length() {
        return this.arr.length;
    }

    @Override
    public int get(int index) {
        for (int i = 0; i < length(); i++) {
            if (i == index) {
                return this.arr[i];
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        MountainArray mountainArr = new Optimal(new int[]{0,1,2,4,2,1});
        int target = 3;

        System.out.println(Optimal.findInMountainArray(target, mountainArr));
    }   
    
    public static int findInMountainArray(int target, MountainArray mountainArr) {
        // Logic-
        // in this ques we need to find the target but with minimum index. If there are two elements in arr return min index element
        // element can exist in left side of peak and in right side of peak 
        // first, find peak that will behave as a boundary for left search space and right search space
        // apply BS on left search space and right search space
        // then return peak left first as we require min index, if its -1 then check for peak right and if that is also -1 return -1 


        int n = mountainArr.length();
        int low = 0;
        int high = n - 1;
        int peak = -1;

        while (low <= high) {
            int mid = (low + high) / 2;

            if (mountainArr.get(mid) < mountainArr.get(mid + 1)) {
                low = mid + 1;
            } else if (mountainArr.get(mid) < mountainArr.get(mid - 1)) {
                high = mid - 1;
            } else {
                peak = mid;
                break;
            }
        }

        low = 0;
        high = peak - 1;
        int peakLeft = -1;

        while (low <= high) {
            int mid = (low + high) / 2;

            if (mountainArr.get(mid) == target) {
                peakLeft = mid;
                break;
            } else if (mountainArr.get(mid) < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        low = peak;
        high = n - 1;
        int peakRight = -1;

        while (low <= high) {
            int mid = (low + high) / 2;

            if (mountainArr.get(mid) == target) {
                peakRight = mid;
                break;
            } else if (mountainArr.get(mid) < target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        if (peakLeft != -1) return peakLeft;
        if (peakRight != -1) return peakRight;
        return -1;
    }
}
