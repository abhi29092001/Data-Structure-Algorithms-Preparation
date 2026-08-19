// TC -> O(n + m)
// SC -> O(n + m)

public class Recursive {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummyNode = new ListNode(0);
        ListNode curr = dummyNode;
        helper(list1, list2, curr);
        return dummyNode.next;
    }

    public void helper(ListNode list1, ListNode list2, ListNode curr) {
        // Logic-
        // logic is similar to iterative approach, the diff is we just write logic for 1 iteration and rest will be handled by recursion

        // base case
        if (list1 == null) {
            curr.next = list2;
            return;
        }
        if (list2 == null) {
            curr.next = list1;
            return;
        }

        if (list1.val <= list2.val) {
            curr.next = list1;
            helper(list1.next, list2, curr.next);
        } else {
            curr.next = list2;
            helper(list1, list2.next, curr.next);
        }
    }    
}
