package leetcode.day20;

public class LC200 {
	public static void main(String[] args) {
		LC200 lc200=new LC200();
		System.out.println(lc200.numIslands(new char[][] {
			{'1','1','1'},
			{'1','0','1'},
			{'1','1','1'}
		}));
	}
	public int numIslands(char[][] grid) {
       int len=grid.length;
       int width=grid[0].length;
      UnionFind unionFind=new UnionFind(len*width+1);
      int vir=unionFind.parent[unionFind.parent.length-1];
      for (int i = 0; i < len; i++) {
		for (int j = 0; j < width; j++){
			if(grid[i][j]=='1') {
				if(j<width-1&&grid[i][j]==grid[i][j+1]) {
					  unionFind.union(i*width+j, i*width+j+1);
					}
					if(i<len-1&&grid[i][j]==grid[i+1][j]) {
		               unionFind.union(i*width+j, (i+1)*width+j);
					}
			}
			else unionFind.union(i*width+j,vir);
		}
	}
		return unionFind.count-1;
    }
	private class UnionFind{
	   int[] parent;
	   int count;
	   public UnionFind(int N) {
		   parent=new int[N];
		   for (int i = 0; i < parent.length; i++) {
			 parent[i]=i;
		}
		   count=N;
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
		 if(xRoot!=yRoot) {
			 parent[xRoot]=yRoot;
			 count--;
		 }
	 }
	}
}
