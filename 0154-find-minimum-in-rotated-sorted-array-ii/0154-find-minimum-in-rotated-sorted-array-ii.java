class Solution {
    public int findMin(int[] nums) {
        int minsum=Integer.MAX_VALUE;
        for(int i=0;i<nums.length;i++){
            
            minsum=Math.min(minsum,nums[i]);
        }
        return minsum;
        
    }
}