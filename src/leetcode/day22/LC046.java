package leetcode.day22;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class LC046 {
	 public List<List<Integer>> permute(int[] nums) {
         int len=nums.length;
         int depth=0;
         boolean[]	used=new boolean[len];
         Deque<Integer> stack=new ArrayDeque<>();
         List<List<Integer>> res=new ArrayList<>();
         dfs(res, nums, used, stack, len, depth);
         return res;
       }
	 public void dfs(List<List<Integer>> res,int[] nums,boolean[] used,Deque<Integer> stack,int len,int depth) {
		if(depth==len) {
		   res.add(new ArrayList<Integer>(stack));
			return;
		}
		for (int i = 0; i < used.length; i++) {
			if(!used[i]) {
				stack.addLast(nums[i]);
				used[i]=true;
				dfs(res,nums, used, stack, len, depth+1);
				used[i]=false;
				stack.removeLast();
			}
		}
	 }
}
