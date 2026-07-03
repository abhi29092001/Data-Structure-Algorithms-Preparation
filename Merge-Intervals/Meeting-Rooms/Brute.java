// TC -> (n^2 * logn)
// SC -> O(n)

import java.util.*;

public class Brute {
    public static void main(String[] args) {
        int[] start = {1, 10, 7};
        int[] end = {4, 15, 10};
        System.out.println(minMeetingRooms(start, end));
    }    

    public static int minMeetingRooms(int[] start, int[] end) {
        // Logic-
        // we have to minimise number of rooms 
        // to achieve that we have to find out the meeting with min ending time 
        // firstly, make an array of pairs of starting and ending meeting time
        // sort that pairs array by starting time
        // make an arraylist which will hold meetings, at starting insert first meeting
        // then move to next meeting and compare with rooms list and check whether that meeting is done or not if done remove it and add other one or add the meeting and sort it by ending time in desc order
        // thats how will get the meeting with lower ending time so that we can utilise that room for other meeting
        // when loop ends, return array size coz that is the min rooms we require

        int i = 0; 
        int j = 0;
        int n = start.length;
        int[][] meetings = new int[n][];
        
        while (i < n && j < n) {
            meetings[i] = new int[]{start[i], end[j]};
            i++;
            j++;
        }
        
        Arrays.sort(meetings, (a, b) -> a[0] - b[0]);
        
        List<int[]> rooms = new ArrayList<>();
        rooms.add(new int[]{meetings[0][0], meetings[0][1]});
        
        for (i = 1; i < n; i++) {
            int start = meetings[i][0];
            int end = meetings[i][1];
            
            if (rooms.get(rooms.size() - 1)[1] <= start) {
                rooms.removeLast();
            }
            
            rooms.add(new int[]{start, end});
            
            if (rooms.size() > 1) {
                Collections.sort(rooms, (a, b) -> b[1] - a[1]);
            }
        }
        
        return rooms.size();
    }
}
