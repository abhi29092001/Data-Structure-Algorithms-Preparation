// TC -> O(n * logk)
// SC -> O(k)

import java.util.*;

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

public class Optimal {
     public ListNode mergeKLists(ListNode[] lists) {
        // Logic-
        // we'll use heap coz we need min Node from every sorted LL
        // we'll put first Nodes of all LL in the Heap to get started, whoseoever node is minimum will pop that node and put its next node in the heap, but make sure the next node is not null
        // we'll keep on doing this until the LL's are exhausted and finally when heap is empty
        // create a dummy node and keep on adding top node from heap to that dummy node and in the end return dummy node's next node

        int k = lists.length;

        // O(k) - space
        PriorityQueue<ListNode> minHeap = new PriorityQueue<>(
            (a, b) -> Integer.compare(a.val, b.val)
        );

        // O(k * logk) - time
        for (int i = 0; i < k; i++) {
            ListNode temp = lists[i];

            // make sure LL is not null before pushing into heap
            if (temp != null) {
                minHeap.add(temp);
            }
        }

        ListNode dummyNode = new ListNode(0);
        ListNode curr = dummyNode;

        // O(n * logk) - time
        while (!minHeap.isEmpty()) {
            ListNode top = minHeap.poll();
            curr.next = top;
            curr = curr.next;

            ListNode nextNode = top.next;

            if (nextNode != null) {
                minHeap.add(nextNode);
            }
        }

        return dummyNode.next;
    }    
}
