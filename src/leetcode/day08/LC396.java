package leetcode.day08;

import java.util.Arrays;

public class LC396 {
	public static void main(String[] args) {
		LC396 test=new LC396();
		int[] nums= {1,2,3,4,5,6,7};
		test.rotate(nums, 3);
		System.out.println(Arrays.toString(nums));;
	}
	 public void rotate(int[] nums, int k) {
		   k=k%nums.length;
		   if(nums.length<2||k==0)return;
	       reverse(nums, 0, nums.length-1);
	       reverse(nums, 0, k-1);
	       reverse(nums, k, nums.length-1);
	    }
	 public void reverse(int[] nums,int left ,int right) {
		  while(left<right) {
			  int temp=nums[left];
			  nums[left++]=nums[right];
			  nums[right--]=temp;
		  }
	 }
}
