// TC -> O(n)
// SC -> O(1)

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

public class optimal {
    public static ListNode reverseBetween(ListNode head, int left, int right) {
        // creation of dummy Node
        ListNode dummyNode = new ListNode(0, head);

        // put curr at dummy Node
        ListNode curr = dummyNode;

        // assign prev as null
        ListNode prev = null;

        // run loop till left, so that prev stands at node prior to left and curr stands at left
        for (int i = 0; i < left; i++) {
            prev = curr;
            curr = curr.next;
        }  

        // curr will stay at left and prev will stay at left's prev node
        // curr1 and prev1 will keep track and move on
        ListNode curr1 = curr;
        ListNode prev1 = null;

        // reverse logic
        for (int i = left; i <= right; i++) {
            ListNode temp = curr1.next;
            curr1.next = prev1;
            prev1 = curr1;
            curr1 = temp;
        }     

        // once reversing is done, prev's next will be prev1 and curr's next will be curr1
        prev.next = prev1;
        curr.next = curr1;

        return dummyNode.next;
    }    
}
