package leetcode.day19;

public class LC684 {
	public int[] findRedundantConnection(int[][] edges) {
        int len=edges.length;
        UnionFind unionFind=new UnionFind(len+1);
        for (int i = 0; i < len; i++) {
		 int[] ans=unionFind.union(edges[i][0], edges[i][1]);
		 if(ans!=null)return ans;
		}
        return null;
    }
	private class UnionFind {
	  private int[] parent;
	  public UnionFind(int N) {
		 parent=new int[N];
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
	  public int[] union(int x,int y) {
		  int xRoot=find(x);
		  int yRoot=find(y);
		 if(xRoot==yRoot) return new int[] {x,y};
		 parent[xRoot]=yRoot;
		 return null;
	  }
	}
}
