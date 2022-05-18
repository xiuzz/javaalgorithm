package leetcode.day02;

public class LC153 {
	public int findMin(int[] nums) {
        if(nums.length==1) return nums[0];
        int left=0;
        int right=nums.length-1;
        int mid=0;
        while(left<right) {
        	 mid=(left+right)>>>1;
        	if(nums[mid]<nums[right]) {
        		right=mid;
        	}
        	else {
        		left=mid+1;
        	}
        }
        return nums[right];
    }
}
  