
class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode temp0= list1;
        ListNode temp1=list2;
        ListNode ans=new ListNode(-1);
        ListNode anstemp=ans;
        
        while(temp0!=null&&temp1!=null){
            if(temp0.val<=temp1.val){
                anstemp.next=temp0;
                temp0=temp0.next;

            }
            else{
                anstemp.next=temp1;
                temp1=temp1.next;
            }
             anstemp=anstemp.next;

        }   
        anstemp.next=temp0!=null?temp0:temp1;
      
   return ans.next;
    }
}