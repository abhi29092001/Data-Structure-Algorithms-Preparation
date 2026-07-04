// TC -> O(nlogn)
// SC -> O(n)

public class Better {
    public static void main(String[] args) {
        int[] start = {1, 10, 7};
        int[] end = {4, 15, 10};
        System.out.println(minMeetingRooms(start, end));
    }    

    public static int minMeetingRooms(int[] start, int[] end) {
        // Logic-
        // logic is same as brute the only diff is in brute we are using manual heap like adding elements and then sorting to get the min ending time at the end of rooms array
        // in this we used actual min heap, which also reduce time complexity

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
        
        PriorityQueue<int[]> rooms = new PriorityQueue<>(
            (a,b) -> a[1] - b[1]
        );
        int start1 = meetings[0][0];
        int end1 = meetings[0][1];
        rooms.add(new int[]{start1, end1});
        
        for (i = 1; i < n; i++) {
            int start2 = meetings[i][0];
            int end2 = meetings[i][1];
            
            if (rooms.peek()[1] <= start2) {
                rooms.remove();
            }
            
            rooms.add(new int[]{start2, end2});
        }
        
        return rooms.size();
    }    
}
