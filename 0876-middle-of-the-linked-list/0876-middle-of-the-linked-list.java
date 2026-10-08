
class Solution {
    public ListNode middleNode(ListNode head) {
        int size=0;
        ListNode temp=head;
        while(temp!=null){
            size++;
            temp=temp.next;
        }
        int mid =size/2;
        temp=head;
        while(mid-->0){
            temp=temp.next;
        }
        return temp;
    }
}