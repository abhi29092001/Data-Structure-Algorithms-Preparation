// TC -> O(m)
// SC -> O(1)

import java.util.*;

public class Optimal {
    public static void main(String[] args) {
        char[] tasks = {'A','A','A','B','B','B'};
        int n = 2;
        System.out.println(leastInterval(tasks, n));
    }
    
    public static int leastInterval(char[] tasks, int n) {
        // Logic-
        // We have to do tasks whose freq is max to avoid idle time later bcoz we have to do all tasks in min intervals
        // so max heap fits in this ques perfectly, max heap gives max element
        // we'll store freqs in max Heap
        // max heap will run till its not empty
        // we have to run tasks in n+1 cycle, n is the cooldown period to start performing tasks again
        // if max heap dont have enough tasks then idle time will be added 
        // after taking out all tasks from heap will store remaining task freqs in list and then put them again in heap to go through them again till all tasks finishes
        // at the end of each cycle add freqs from list to heap if any, if heap is not empty that means there are still some elements left to process and idle time will be added in that case if cycle is still not full
        // if heap is empty then we dont need to do anything just add workdone and thats all

        int m = tasks.length;

        // O(26) - space
        int[] freq = new int[26];

        // O(26) - space (at max)
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        // O(m) - time
        for (int i = 0; i < m; i++) {
            freq[tasks[i] - 'A']++;
        }
        
        // O(26 * log 26) - time
        for (int i = 0; i < 26; i++) {
            if (freq[i] > 0) {
                maxHeap.add(freq[i]);
            }
        }

        int time = 0;

        // O(m * log26)
        while (!maxHeap.isEmpty()) {
            int workdone = 0;
            int cycle = n + 1;
            List<Integer> list = new ArrayList<>();

            for (int i = 0; i < cycle; i++) {
                if (!maxHeap.isEmpty()) {
                    int task = maxHeap.poll();
                    task--;
                    workdone++;

                    if (task > 0) {
                        list.add(task);
                    }
                }
            }

            for (int el : list) {
                maxHeap.add(el);
            }

            if (!maxHeap.isEmpty()) {
                time += cycle; 
            } else {
                time += workdone;
            }
        }

        return time;
    }
}
