package leetcode.day08;

public class LC283 {
	public void moveZeroes(int[] nums) {
       if(nums.length==1)return;
       int p1=1,p2=0;
       while(true) {
    	   if(p1>=nums.length)return;
    	  while(nums[p1]==0) {
    		  p1++;
    		  if(p1>=nums.length)return;
    	  }
    	 while(nums[p2]!=0&&p2<p1) {
    		 p2++;
    	 }
    	 if(nums[p2]==0) {
    		 int temp=nums[p1];
    		 nums[p1]=0;
    		 nums[p2]=temp;
    	 }
    	 else p1++;
       }
    }
}
