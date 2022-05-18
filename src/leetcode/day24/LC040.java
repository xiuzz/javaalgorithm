package leetcode.day24;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;

public class LC040 { 
	public List<List<Integer>> combinationSum2(int[] candidates, int target) {
		List<List<Integer>> res=new ArrayList<>();
		Deque<Integer> deque=new ArrayDeque<Integer>();
		Arrays.sort(candidates);
		boolean[] used=new boolean[candidates.length];
		dfs(res, deque, candidates, target, 0,used);
		return res;
    }
	public void dfs(List<List<Integer>> res,Deque<Integer> deque,int[] candidates,int target,int begin,boolean[] used) {
		if(target==0) {
			res.add(new ArrayList<Integer>(deque));
			return;
		}
	 for (int i = begin; i < candidates.length; i++) {
		if(i>0&&candidates[i]==candidates[i-1]&&!used[i-1])continue;
	     if(target<candidates[i])return;
	     deque.addLast(candidates[i]);
	     used[i]=true;
	     dfs(res, deque, candidates, target-candidates[i], i+1,used);
	     used[i]=false;
	     deque.removeLast();
	}	
	}
}
