// TC -> O(n logn)
// SC -> O(n)

import java.util.*;

public class optimal {
    public static void main(String[] args) {
        int[][] courses = {{100,200},{200,1300},{1000,1250},{2000, 3200}};
        System.out.println(scheduleCourse(courses));
    }   
    
    public static int scheduleCourse(int[][] courses) {
        // Logic-
        // sort array based on deadlines, will do those courses first whose deadline is near and will keep on adding the duration taken by the courses. If at some point a course duration after adding in the total time becomes bigger than its last day then will subtract that duration from the course to get rid of maxium course to give that time to more smaller courses to increase total count of course means maximise it.
        // used heap coz heap will give us the maximum duration course which we can remove if condition doesnt satisfy

        int n = courses.length;

        // O(n) - space
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        // O(n logn) - time
        Arrays.sort(courses, (a, b) -> Integer.compare(a[1], b[1]));

        int time = 0;

        // O(n * logn) - time
        for (int i = 0; i < n; i++) {
            time += courses[i][0];
            maxHeap.add(courses[i][0]);

            if (time > courses[i][1]) {
                time -= maxHeap.poll();
            }
        }

        return maxHeap.size();
    }
}
