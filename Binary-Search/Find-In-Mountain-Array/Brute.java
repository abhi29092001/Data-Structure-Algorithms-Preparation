// TC -> O(logn)
// SC -> O(1)

interface MountainArray {
    int get(int index);
    int length();
}

public class Brute implements MountainArray {
    private int[] arr;

    public Brute(int[] arr) {
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
        MountainArray mountainArr = new Brute(new int[]{0,1,2,4,2,1});
        int target = 2;

        System.out.println(Brute.findInMountainArray(target, mountainArr));
    }   
    
    public static int findInMountainArray(int target, MountainArray mountainArr) {
        // Logic-
        // simple linear search
        // but it will not work as you can't call get method more than 100 times

        int n = mountainArr.length();
        
        for (int i = 0; i < n; i++) {
            if (mountainArr.get(i) == target) {
                return i;
            }
        }

        return -1;
    }
}
