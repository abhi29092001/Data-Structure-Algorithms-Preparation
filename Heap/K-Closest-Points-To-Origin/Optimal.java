// TC -> O(n logk)
// SC -> O(k)

import java.util.*;

class Pair {
    int[] first;
    int second;

    Pair(int[] first, int second) {
        this.first = first;
        this.second = second;
    }
}

public class Optimal {
    public static void main(String[] args) {
        int[][] points = {{1,3},{-2,2}};
        int k = 1;
        System.out.println(kClosest(points, k));
    }   
    
    public static int[][] kClosest(int[][] points, int k) {
        // Logic-
        // created pair class in which first element will be arr point itself and second will be dist from that point to origin
        // created max heap in which ordering will happen according to dist
        // farthest dist remain on top
        // loop through arr to calculate dist and then put point and dist in heap, if size becomes > k then pop top element
        // loop till heap becomes empty and store result in array
        // return arr in the end

        int n = points.length;

        // O(k) - space
        PriorityQueue<Pair> maxHeap = new PriorityQueue<>(
            (a, b) -> Integer.compare(b.second, a.second)
        );

        // O(n * logk) - time
        for (int i = 0; i < n; i++) {
            int dist = (points[i][0] * points[i][0])+ (points[i][1] * points[i][1]);

            maxHeap.add(new Pair(points[i], dist));

            if (maxHeap.size() > k) {
                maxHeap.poll();
            }
        }

        // O(k) - space
        int[][] result = new int[k][2];
        int index = 0;

        // O(k * logk) - time
        while (!maxHeap.isEmpty()) {
            result[index++] = maxHeap.poll().first;
        }

        return result;
    }
}
