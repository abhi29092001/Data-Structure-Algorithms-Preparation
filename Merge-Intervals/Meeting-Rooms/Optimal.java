// TC -> O(nlogn)
// SC -> O(1)

import java.util.Arrays;

public class Optimal {
    public static void main(String[] args) {
        int[] start = {1,10,7};
        int[] end = {4,15,10};
        System.out.println(minMeetingRooms(start, end));
    }
    
    public static int minMeetingRooms(int[] start, int[] end) {
        int n = start.length; // size of both arrays is same that's why we can take any arrays length to iterate till that length
        
        int i = 0;
        int j = 0;
        
        // Sorting array based on start time
        Arrays.sort(start);
        // Sorting array based on end time
        Arrays.sort(end);
        
        // Initially it will be zero
        int numOfMeetingRooms = 0;
        int count = 0; // This count represents how many rooms are occupied currently
        
        while (i < n && j < n) {
            if (start[i] < end[j]) {
                count++;
                i++;
                numOfMeetingRooms = Math.max(numOfMeetingRooms, count);
            } else {
                j++;
                count--;
            }
        }
        
        return numOfMeetingRooms;
    }
}
