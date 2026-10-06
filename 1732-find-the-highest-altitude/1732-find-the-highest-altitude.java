class Solution {
    public int largestAltitude(int[] gain) {
        int n=gain.length;
        int arr[]=new int[n+1];
        int a=0;
        arr[0]=0;
        for(int i=0;i<n;i++){
            arr[i+1]=arr[i]+gain[i];
            a=Math.max(a,arr[i+1]);
        }
        
    return a;
    }
}