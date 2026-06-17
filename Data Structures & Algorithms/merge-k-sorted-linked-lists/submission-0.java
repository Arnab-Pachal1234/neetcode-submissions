/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        ArrayList<Integer> list = new ArrayList<>();
        for(ListNode l : lists){
            ListNode curr  = l;
            while(curr!=null){
                list.add(curr.val);
                curr = curr.next;
            }

        }
        Collections.sort(list);
        ListNode dummy = new ListNode(-1);
        ListNode curr = dummy;
        for(int i=0;i<list.size();i++){
            curr.next = new ListNode(list.get(i));
            curr = curr.next;
        }
        return dummy.next;
    }
}
