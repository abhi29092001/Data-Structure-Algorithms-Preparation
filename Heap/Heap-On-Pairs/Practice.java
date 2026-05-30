import java.util.*;

// class Pair {
//     int first;
//     int second;

//     Pair(int first, int second) {
//         this.first = first;
//         this.second = second;
//     }
// }

public class Practice {
    public static void main(String[] args) {
        // Min Heap on Pairs
        PriorityQueue<int[]> minHeap = new PriorityQueue<>(
            (a, b) -> {
                if (a[0] != b[0]) {
                    // what compare will do is - if a[0] is lesser than b[0] returns -1 that means the array is already sorted and 'a' will be going to the top. if +1 is coming that means a[0] is bigger than b[0] so 'b' will be going to the top
                    return Integer.compare(a[0], b[0]);  // min heap
                }
                return Integer.compare(a[1], b[1]); // min heap
            }
        );

        // Max Heap on Pairs
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>(
            (a, b) -> {
                if (a[0] != b[0]) {
                    // what compare will do is - if b[0] is greater than a[0] returns +1 that means the b array need to come first means 'b' will be going to the top. if -1 is coming that means a[0] is bigger than b[0] so 'a' will be going to the top
                    return Integer.compare(b[0], a[0]);  // max heap
                }
                return Integer.compare(b[1], a[1]); // max heap
            }
        );

        PriorityQueue<int[]> pq1 = new PriorityQueue<>(
            (a, b) -> {
                if (a[0] != b[0]) {
                    return Integer.compare(a[0], b[0]); // min heap
                }
                return Integer.compare(b[1], a[1]); // max heap
            }
        );

        PriorityQueue<int[]> pq2 = new PriorityQueue<>(
            (a, b) -> {
                if (a[0] != b[0]) {
                    return Integer.compare(b[0], a[0]); // max heap
                }
                return Integer.compare(a[1], b[1]); // min heap
            }
        );

        pq2.add(new int[]{1, 2});
        pq2.add(new int[]{3, 4});
        pq2.add(new int[]{1, -1});

        while (!pq2.isEmpty()) {
            int[] top = pq2.poll();
            System.out.println("Top: " + "{" + top[0] + ", " + top[1] + "}");
        }
    }
}
