package leetcode.day19;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class LC990 {
	public static void main(String[] args) throws Exception{
		BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(System.in));
		String[] strings=bufferedReader.readLine().split(",");
		LC990 lc990=new LC990();
		System.out.println(lc990.equationsPossible(strings));
	}
	public  boolean equationsPossible(String[] equations) {
		  UnionFind unionFind=new UnionFind();
		  for (int i = 0; i < equations.length; i++) {
		        if(equations[i].charAt(1)=='=')unionFind.union(equations[i].charAt(0)-'a', equations[i].charAt(3)-'a');		        
		}
		  unionFind.ans=true;
		 for (int i = 0; i < equations.length; i++) {
			if(equations[i].charAt(1)=='!')unionFind.isConnected(equations[i].charAt(0)-'a',equations[i].charAt(3)-'a');
		    if(unionFind.ans==false)return false;
		 }
          return true;
    }
	private class UnionFind {
		boolean ans=true;
		private int[] parent=new int[26];
		public UnionFind() {
			for (int i = 0; i < parent.length; i++) {
				parent[i]=i;
			}
		}
	 public int find(int x) {
			while(x!=parent[x]) {
				parent[x]=parent[parent[x]];
				x=parent[x];
			}
			return x;
		}
	 public void union(int x,int y) {
			int xRoot=find(x);
			int yRoot=find(y);
			if(xRoot==yRoot) return;
			else {
				parent[xRoot]=yRoot; 
			}
		}
	public void isConnected(int x,int y) {
	     if(find(x)==find(y)) ans=false;  	
	} 
	}
}
