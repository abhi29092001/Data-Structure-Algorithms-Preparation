// TC -> O(n)
// SC -> O(n)

class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 }

public class Brute {
    public static ListNode swapPairs(ListNode head) {
        // Logic is Simple-
        // 1. count len of LL
        // 2. create array of that len
        // 3. put all nodes val in that arr
        // 4. swap values with their adj indexex in arr
        // 5. create new nodes from array and link them all with their adj elements

        // if head is null or head's next is null then head is the ans
        if (head == null || head.next == null) {
            return head;
        }

        ListNode temp = head;
        int len = 0;

        // count len
        while (temp != null) {
            len++;
            temp = temp.next;
        }

        // create arr and put nodes val in arr
        int[] arr = new int[len];
        temp = head;
        int index = 0;
        while (temp != null) {
            arr[index] = temp.val;
            temp = temp.next;
            index++;
        }

        // swap adj elements in arr
        int i = 0;
        int j = i + 1;
        while (i < len && j < len) {
            int swap = arr[i];
            arr[i] = arr[j];
            arr[j] = swap;
            i += 2;
            j += 2;
        }

        // create new nodes after swapping adj elements in arr
        i = 1;
        head = new ListNode(arr[0], null);
        temp = head;
        while (i < len) {
            ListNode node = new ListNode(arr[i], null);
            temp.next = node;
            temp = temp.next;
            i++;
        }

        return head;
    }    
}
