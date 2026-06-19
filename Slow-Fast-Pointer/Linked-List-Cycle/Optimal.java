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
    public boolean hasCycle(ListNode head) {
        // Logic-
        // Take two pointers, one will move one step at a time and other will move two steps at a time
        // if there's a cycle then they will surely meet at some point of time, return true
        // if not then fast will reach at the end and come out of loop, false will be returned

        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                return true;
            }
        }

        return false;
    }
}
