// TC -> O(n)
// SC -> O(1)

class ListNode {
    int data;
    ListNode next;
    
    ListNode(int data) {
        this.data = data;
        this.next = null;
    }
}

public class Optimal {
    public ListNode middleNode(ListNode head) {
        // Logic -
        // to find middle of LL, take two pointers
        // slow will move 1 step and fast will move 2 step
        // run loop till fast is not null and its next is also not null
        // if either of the condition becomes false, return slow because slow is exactly standing at middle node 

        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }
}
