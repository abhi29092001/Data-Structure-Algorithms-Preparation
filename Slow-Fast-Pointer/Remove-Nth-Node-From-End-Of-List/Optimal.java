// TC -> O(n) - 1 pass
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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // Logic-
        // head will run n+1 times and after that head and slow will move equally by one step only. so, basically both will kind of move len-n steps 
        // we'll keep two pointers
        // firstly, head will run n+1 times
        // +1 times bcoz we are using dummy node (if head node needs to be deleted, for that) as well so thats why
        // head will run n+1 times
        // then will check if fast is still not null and both slow and fast will move one step
        // when fast reaches null, at that time slow will be standing at prev node to delete node
        // change pointers of node at which slow is standing and remove nth node from the LL
        // finally return dummy node's next node

        ListNode dummyNode = new ListNode(0);
        dummyNode.next = head;
        
        ListNode slow = dummyNode;
        ListNode fast = dummyNode;

        for (int i = 0; i <= n; i++) {
            fast = fast.next;
        }

        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }

        slow.next = slow.next.next;

        return dummyNode.next;
    }
}
