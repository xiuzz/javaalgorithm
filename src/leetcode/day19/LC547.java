package leetcode.day19;

public class LC547 {
	public int findCircleNum(int[][] isConnected) {
          int len=isConnected.length;
          UnionFind unionFind=new UnionFind(len);
          for (int i = 0; i < len; i++) {
			for (int j = 0; j < i; j++) {
				if(isConnected[i][j]==1)unionFind.union(i, j);
			}
		}
          return unionFind.count;
    }
   private class UnionFind{
	   public  int count;
	   public int[] id;
	 public UnionFind(int N) {
		 id=new int[N];
		 count=N;
		 for (int i = 0; i <N; i++) {
			id[i]=i;
		}
	 }
	 public int find(int x) {
		 return id[x];
	 }
	 public void union(int x,int y) {
		 int xid=find(x);
		 int yid=find(y);
		 if(xid==yid) return;
		 for (int i = 0; i < id.length; i++) {
			if(id[i]==xid)id[i]=yid;
		}
		 count--;
	 }
   }	
}
