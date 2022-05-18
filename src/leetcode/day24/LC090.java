package leetcode.day24;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;

public class LC090 {
	public List<List<Integer>> subsetsWithDup(int[] nums) {
		Arrays.sort(nums);
		List<List<Integer>> res=new ArrayList<>();
		Deque<Integer> deque=new ArrayDeque<Integer>();
		res.add(new ArrayList<>());
	    boolean[] used=new boolean[nums.length];
		dfs(res, nums, deque, 0,used);
		return res;
    }
	public void dfs(List<List<Integer>> res,int[] nums,Deque<Integer> deque,int begin,boolean[] used) {
		 if(begin==nums.length)return;
	   for (int i = begin; i < nums.length; i++) {
		 if(i>0&&nums[i]==nums[i-1]&&!used[i-1])continue;
		deque.addLast(nums[i]);
		used[i]=true;
       res.add(new ArrayList<Integer>(deque));
       dfs(res, nums, deque, i+1,used);
       used[i]=false;
       deque.removeLast();
	}
	}
}

