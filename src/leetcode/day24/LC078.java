package leetcode.day24;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class LC078 {
	public List<List<Integer>> subsets(int[] nums) {
		List<List<Integer>> res=new ArrayList<>();
		Deque<Integer> deque=new ArrayDeque<Integer>();
		res.add(new ArrayList<>());
		dfs(res, nums, deque, 0);
		return res;
    }
	public void dfs(List<List<Integer>> res,int[] nums,Deque<Integer> deque,int begin) {
		 if(begin==nums.length)return;
	   for (int i = begin; i < nums.length; i++) {
		deque.addLast(nums[i]);
        res.add(new ArrayList<Integer>(deque));
        dfs(res, nums, deque, i+1);
        deque.removeLast();
	}
	}
}
