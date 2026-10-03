class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set=new HashSet<>();
        int longest =0;
        for(int ele:nums){
            set.add(ele);
        }
        for(int ele : set){
           
        if(!set.contains(ele -1)){
         int currentNum =ele;
         int count=1;
        
       
        while(set.contains(currentNum+1)){
            currentNum++;
            count++;
        }
        
    longest =Math.max(longest,count);
        }
        }
    
   return longest;
    }
}