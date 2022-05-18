package leetcode.day23;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;

public class LC047 {
	public List<List<Integer>> permuteUnique(int[] nums) {
         List<List<Integer>> res=new ArrayList<>();
         int len=nums.length;
         boolean[] used=new boolean[len];
         Arrays.sort(nums);
         Deque<Integer> deque=new ArrayDeque<Integer>();
         dfs(res, nums, len, 0, deque, used);
         return res;
         
    }
	public void dfs(List<List<Integer>> res,int[] nums,int len,int depth,Deque<Integer> deque,boolean[] used) {
		if(len==depth) {
			res.add(new ArrayList<Integer>(deque));
			return;
		}
	   for (int i = 0; i < nums.length; i++) {
		if(i>0&&nums[i]==nums[i-1]&&!used[i-1]) continue;
		if(!used[i]) {
		   deque.addLast(nums[i]);
		   used[i]=true;
		   dfs(res, nums, len, depth+1, deque, used);
		   deque.removeLast();
		   used[i]=false;
		}
	}
	}
}
