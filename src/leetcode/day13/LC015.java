package leetcode.day13;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LC015 {
	public List<List<Integer>> threeSum(int[] nums) {
       List<List<Integer>> res=new ArrayList<List<Integer>>();
       int len=nums.length;
       if(len<3) return res;
       Arrays.sort(nums);
       for (int i = 0; i < len-2; i++) {
		if(nums[i]>0)break;
		if(i>0&&nums[i]==nums[i-1])continue;
		int target=-nums[i];
		int left=i+1;
		int right=len-1;
		while(left<right) {
			if(nums[left]+nums[right]>target)right--;
			else if(nums[left]+nums[right]<target)left++;
			else {
				List<Integer> list=new ArrayList<>(3);
				list.add(nums[left]);
				list.add(nums[right]);
				list.add(-target);
				res.add(list);
				while(left<right&&nums[left]==nums[left+1])left++;
				while(left<right&&nums[right]==nums[right-1])right--;
				left++;
				right--;
			}
		}
	}
		return res;
    }
}
