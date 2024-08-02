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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode newNode = new ListNode();
        
        if(list1 == null){
            return list2;
        } 

        if(list2 == null){
            return list1;
        }

        if(list1.val < list2.val){
            newNode = new ListNode(list1.val);
            list1 = list1.next;
        } else{
            newNode = new ListNode(list2.val);
            list2 = list2.next;
        }

        while(list1 != null && list2 != null){
            if(list1.val < list2.val){
                newNode = new ListNode(list1.val, newNode);
                list1 = list1.next;
            } else {
                newNode = new ListNode(list2.val, newNode);
                list2 = list2.next;
            }
        } 

        while(list1 != null){
            newNode = new ListNode(list1.val, newNode);
            list1 = list1.next;
        } 

        while(list2 != null){
            newNode = new ListNode(list2.val, newNode);
            list2 = list2.next;
        } 

        return sortSLL(newNode);
    }

    ListNode sortSLL(ListNode nodes){
        ArrayList<ListNode> newNode = new ArrayList<ListNode>();
        int size = 0;
        for(int i = 0; nodes != null; i++){
            newNode.add(new ListNode(nodes.val));
            nodes = nodes.next;
            size++;
        }

        ListNode n = new ListNode(newNode.get(0).val);
        for(int i = 1; i < size; i++){
            n = new ListNode(newNode.get(i).val, n);
        }

        return n;
    }
}