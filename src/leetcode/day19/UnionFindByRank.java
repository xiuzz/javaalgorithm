package leetcode.day19;

import java.util.Arrays;

/*
 * 通过秩优化*/
public class UnionFindByRank {
	private int[] parent;
	   private int count;
	private int[] rank;
	   public int getCount() {
		return count;
	}
	   public UnionFindByRank(int N) {
		   parent=new int[N];
		   rank=new int[N];
		   count=N;
		   for (int i = 0; i < N; i++) {
			parent[i]=i;
		} 
		   Arrays.fill(rank, 1);
	   } 
	  public int find(int x) {
		 /* while(x!=parent[x]) {
			  parent[x]=parent[parent[x]];//将原本的爷节点，变为父节点
			  x=parent[x];
		  }*/
		 if(x!=parent[x]) {
			 parent[x]=find(parent[x]);
		 } 
		  return x;
	  }
	  public void union(int x,int y) {
		  int xRoot=find(x);
		  int yRoot=find(y);
		  if(xRoot==yRoot)return;
		  if(rank[x]==rank[y]) {
			  parent[xRoot]=yRoot;
              rank[yRoot]++;
		  }
		  else if(rank[x]<rank[y]) {
			  parent[xRoot]=yRoot;
		  }
		  else {
			  parent[yRoot]=xRoot;
		  }
		  count--;
	  }
}
