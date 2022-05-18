package leetcode.day07;

public class LC11 {
  public int maxArea(int[] height) {
	  int max=0;
	  int left=0;
	  int right=height.length-1;
	  while(left<right) {
		  int area=(right-left)*Math.min(height[left], height[right]);
		  max=Math.max(max, area);
		  if(height[left]>height[right])right--;
		  else left++;
	  }
	return max;
  }
}
