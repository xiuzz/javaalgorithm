package leetcode.day21;

public class LC130 {
	public static void main(String[] args) {
		LC130 lc130=new LC130();
		char[][] board= {
				{'O','X','X','O','X'},
				{'X','O','O','X','O'},
				{'X','O','X','O','X'},
				{'O','X','O','O','O'},
				{'X','X','O','X','O'}
		};
	lc130.solve(board);	
	System.out.println(board);
	}
	public void solve(char[][] board) {
         int len=board.length;
         int width=board[0].length;
         int N=len*width;
         UnionFind unionFind=new UnionFind(N+1);
       for (int i = 0; i < len; i++) {
		 for (int j = 0; j < width; j++) {
			if(board[i][j]=='O') {
				if(i==0||j==0||i==len-1||j==width-1) {
                  unionFind.union(i*width+j, N);
			}
			if(i<len-1&&board[i][j]==board[i+1][j])unionFind.union(i*width+j, (i+1)*width+j);
			if(j<width-1&&board[i][j]==board[i][j+1])unionFind.union(i*width+j, i*width+j+1);		
		}
	}
    }
       for (int i = 0; i <len; i++) {
		for (int j = 0; j < width; j++) {
			if(unionFind.find(i*width+j)!=unionFind.find(N))board[i][j]='X';
		}
	}
	} 
	private class  UnionFind{
	    int[]  parent;
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
	public void  union(int x,int y) {
		int xRoot=find(x);
		int yRoot=find(y);
		if(xRoot!=yRoot)parent[xRoot]=yRoot;
	}
	}
}
