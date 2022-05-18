package leetcode.day19;
//quick-union
/*
 * 每个数组里面不再存储id了，
 * 而是存储他的父节点，如果他为根节点存储他自己*/
public class UnionFind2 {
   private int[] parent;
   private int count;
   public int getCount() {
	return count;
}
   public UnionFind2(int N) {
	   parent=new int[N];
	   count=N;
	   for (int i = 0; i < N; i++) {
		parent[i]=i;
	}   
   } 
  public int find(int x) {
	  while(x!=parent[x]) {
		  x=parent[x];
	  }
	  return x;
  }
  public void union(int x,int y) {
	  int xRoot=find(x);
	  int yRoot=find(y);
	  if(xRoot==yRoot)return;
	  parent[xRoot]=yRoot;
	  count--;
  }
  
}
