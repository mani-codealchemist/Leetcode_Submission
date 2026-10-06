class Solution {
    public int findGCD(int[] nums) {
        int a=Math.max(nums[0],nums[1]);
        int b=Math.min(nums[0],nums[1]);
        for(int i=2;i<nums.length;i++){
            a=Math.max(a,nums[i]);
            b=Math.min(b,nums[i]);
           
        }while(b!=0){
            int remainder=a%b;
            a=b;
            b=remainder;
           
        }
        
   return a;
    }
}