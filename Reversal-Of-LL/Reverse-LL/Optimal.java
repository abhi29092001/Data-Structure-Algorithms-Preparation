// TC -> O(n)
// SC -> O(1)

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

public class Optimal {
    public static ListNode reverseList(ListNode head) {
        // Logic is simple-
        // 1. we need 3 pointers - prev, curr, nextNode
        // 2. prev pointer is needed to track previous node 
        // 3. curr pointer is needed to make curr node pointing to prev
        // 4. nextNode pointer is needed to track curr's next node otherwise it'll we lost and curr will not be able to move to its next node

        // if head is null or head's next is null then return head directly
        if (head == null || head.next == null) {
            return head;
        }

        ListNode curr = head;
        ListNode prev = null;
        ListNode nextNode = curr.next;

        while (curr != null) {
            curr.next = prev;
            prev = curr;
            curr = nextNode;
            
            // it needs to be checked otherwise it will throw null ptr exception
            if (nextNode != null) {
                nextNode = nextNode.next;
            }
        }

        return prev;
    }
}
