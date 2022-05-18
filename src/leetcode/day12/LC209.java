package leetcode.day12;

public class LC209 {
	public static void main(String[] args) {
		int[] nums={2,3,1,2,4,3};
		System.out.println(minSubArrayLen(7, nums));
	}
	public static int minSubArrayLen(int target, int[] nums) {
       int min=nums.length+1;
       int right=0;
       int left=0;
       int cur=0;
       while(right<nums.length) {
    	   cur+=nums[right];
    	   		while(cur>=target) {
    	   			if(right-left+1<min) {
    	   				min=right-left+1;
    	   			}
    	   		    cur-=nums[left++];
    	   		}
    	   		right++;
    	   	}
       return min==nums.length+1?0:min;
    }
}
