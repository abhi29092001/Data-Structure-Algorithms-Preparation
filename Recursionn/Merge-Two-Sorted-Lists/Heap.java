// TC -> O(n + m) * log2
// SC -> O(1)

import java.util.PriorityQueue;

public class Heap {
    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        // Logic-
        // used heap coz heap gives min element everytime, in this ques we need min node everytime 
        // pushed both lists head to heap
        // take out min one and pushed min node's next to the heap
        // this will continue until heap becomes empty
        // finally return dummynode's next 

        if (list1 == null && list2 == null) return null;
        else if (list1 == null && list2 != null) return list2;
        else if (list1 != null && list2 == null) return list1;

        PriorityQueue<ListNode> minHeap = new PriorityQueue<>(
            (a, b) -> a.val - b.val
        );

        minHeap.add(list1);
        minHeap.add(list2);

        ListNode dummyNode = new ListNode(0);
        ListNode curr = dummyNode;

        while(!minHeap.isEmpty()) {
            ListNode top = minHeap.poll();
            curr.next = top;
            curr = curr.next;

            if (top.next != null) {
                minHeap.add(top.next);
            }
        }

        return dummyNode.next;
    }    
}
