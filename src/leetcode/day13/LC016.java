package leetcode.day13;

import java.util.Arrays;

public class LC016 {
	public static void main(String[] args) {
		int[] nums= {0,2,1,-3};
		System.out.println(threeSumClosest(nums, 1));
	}
	public static int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
         int left=0;
         int right=0;
         int min=nums[0]+nums[1]+nums[2];
         int cur=0;
         for (int i = 0; i < nums.length-2; i++) {
		 	if(i>0&&nums[i]==nums[i-1])continue;
		    left=i+1;
			right=nums.length-1;
		   while(left<right) {
				cur=nums[left]+nums[right]+nums[i];
			    if(cur==target)return target;
			   if(Math.abs(target-min)>Math.abs(target-cur))min=cur;
			   if(target>cur) {
				   while(left<right&&nums[left]==nums[left+1])left++;
				   left++;
			   }
			   if(target<cur) {
				  while(left<right&nums[right]==nums[right-1])right--;
				  right--;
			   }
			  }
				   
		}
         return min;
    }
}
