package leetcode.day24;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LC51NQueen {
	public static void main(String[] args) {
		LC51NQueen lc51nQueen=new LC51NQueen();
		System.out.println(lc51nQueen.solveNQueens(4));
	}
	Set<Integer> main;
	Set<Integer> sub;
	Set<Integer> wid;
	int N;
   public List<List<String>> solveNQueens(int n) {
         N=n;
         List<List<String>> res=new ArrayList<>();
         Deque<Integer> deque=new ArrayDeque<Integer>();
         main=new HashSet<>();
         sub=new HashSet<>();
         wid=new HashSet<>();
         dfs(res, 0, deque);
         return res;
	 }
   public void dfs(List<List<String>> res,int depth,Deque<Integer> deque) {
	  if(depth==N) {
		  res.add(getPhoto(deque));
		  return;
	  }; 
	   for (int i = 0; i <N; i++) {
		 if(wid.contains(i))continue;
		 if(!main.contains(depth-i)&&!sub.contains(depth+i)) {
			 deque.addLast(i);
			 wid.add(i);
			 main.add(depth-i);
			 sub.add(depth+i);
			 dfs(res, depth+1, deque);
			 deque.removeLast();
			 wid.remove(i);
			 main.remove(depth-i);
			 sub.remove(depth+i);
	  }
	}
   }
  public List<String> getPhoto(Deque<Integer> deque){
	   ArrayList<String> res=new ArrayList<>();
	  for (Integer integer : deque) {
	StringBuilder builder=new StringBuilder();
		for (int i = 0; i <N; i++) {
			if(i==integer) {
				builder.append("Q");
			}
			else builder.append(".");
	  }
		res.add(builder.toString());
	}
	  return res;
  }
}
