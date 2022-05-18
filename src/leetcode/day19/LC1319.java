package leetcode.day19;

public class LC1319 {
	public static void main(String[] args) {
		LC1319 lc1319=new LC1319();
		int[][] c= {{0,1},{0,2},{1,2}};
		System.out.println(lc1319.makeConnected(4, c));
	}
	public int makeConnected(int n, int[][] connections) {
             UnionFind unionFind=new UnionFind(n);
             for (int i = 0; i < connections.length; i++) {
				unionFind.union(connections[i][0], connections[i][1]);
			}
             int count=unionFind.count;
             int connect=unionFind.connect;
             if(count>=connect)return connect;
             else return -1;
	   }
	private class UnionFind{
		int[] parent;
		int count;
		int connect;
		public UnionFind(int N) {
			parent=new int[N];
			connect=N-1;
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
		  if(xRoot==yRoot) {
			  count++;
			  return;
		  }
		 parent[xRoot]=yRoot;
		 connect--;
	  }	
	}
}
