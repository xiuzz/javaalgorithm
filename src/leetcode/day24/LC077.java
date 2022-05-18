package leetcode.day24;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class LC077 {
  public List<List<Integer>> combine(int n, int k) {
	  List<List<Integer>> res=new ArrayList<>();
	  Deque<Integer> deque=new ArrayDeque<Integer>();
	  dfs(res, deque, 0, k, n, 1);
	  return res;
 	  }
  public void dfs(List<List<Integer>> res,Deque<Integer> deque,int depth,int k,int n,int begin) {
	 if(depth==k) {
		 res.add(new ArrayList<Integer>(deque));
		 return;
	 }
	for (int i = begin; i <=n; i++) {
		deque.addLast(i);
		dfs(res, deque, depth+1, k, n, i+1);
		deque.removeLast();
	} 
  }
} 
