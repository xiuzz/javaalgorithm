package leetcode.day24;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class LC039 {
	public List<List<Integer>> combinationSum(int[] candidates, int target) {
		List<List<Integer>> res=new ArrayList<>();
		Deque<Integer> deque=new ArrayDeque<Integer>();
		dfs(candidates, candidates.length, res, deque, target, 0);
		return res;
	}
	public void dfs(int[] candidates,int len,List<List<Integer>> res,Deque<Integer> deque,int target,int begin){
		if(begin==len)return;
		if(target==0) {
			res.add(new ArrayList<Integer>(deque));
		}	
	 dfs(candidates,len, res, deque, target, begin+1);
	 if(target-candidates[begin]>=0) {
		 deque.addLast(candidates[begin]);
		 dfs(candidates, len, res, deque, target-candidates[begin], begin);
		 deque.removeLast();
	 }
	}
}
