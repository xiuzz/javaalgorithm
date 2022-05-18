package leetcode.day14;

public class LC042 {
	public int trap(int[] height) {
	  if(height.length<3)return 0;
	  int leftMax=height[0];
	  int rightMax=height[height.length-1];
      int left=1;
      int right=height.length-2;
      int min=0;
      int res=0;
      while(left<=right) {
    	 min=Math.min(leftMax, rightMax);
    	 if(min==leftMax) {
    		int temp=leftMax-height[left];
    		if(temp>0)res+=temp;
    		leftMax=Math.max(leftMax,height[left]);
    	    left++;
    	 }
    	 else if(min==rightMax) {
    		int temp=rightMax-height[right];
    		if(temp>0)res+=temp;
    		rightMax=Math.max(rightMax, height[right]);
    		right--;
    	}
      }
      return res;
    }
}
