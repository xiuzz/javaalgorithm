package leetcode.day20;

import java.util.TreeSet;

public class LC128 {
	public static void main(String[] args) {
		System.out.println(longestConsecutive(new int[]{0,3,7,2,5,8,4,6,0,1}));
	}
		public static int longestConsecutive(int[] nums) {
	          TreeSet<Integer> treeSet=new TreeSet<>();
	          for (int i = 0; i < nums.length; i++) {
				treeSet.add(nums[i]);
			}
	          int curr=0;
	          int max=0;
	          int temp=0;
	          for (Integer integer : treeSet) {
				if(curr==0) {
					temp=integer;
					max++;
					curr++;
				}
					else {
						if(integer-1==temp)curr++;
						else {
						   curr=1;
						}
						   max=Math.max(max, curr);
						temp=integer;
					}
			}
	          return max;
	    }
}
