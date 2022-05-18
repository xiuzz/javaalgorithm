package leetcode.day24;

public class LC79 {
	int len;
	int wid;
	int[][] directions= {{1,0},{0,-1},{-1,0},{0,1}};
	private boolean inArea(int x,int y,int len,int wid) {
		return x>=0&&x<len&&y>=0&&y<wid;
	}
	public boolean exist(char[][] board, String word) {
         char[] charArray=word.toCharArray();
         len=board.length;
         wid=board[0].length;
         boolean ans=false;
         boolean[] used=new boolean[len*wid];
         for (int i = 0; i < len; i++) {
			for (int j = 0; j < wid; j++) {
				ans=dfs(i, j, used, 0, charArray, board);
				if(ans==true)return true;
			}
		}
         return false;
    } 
	public boolean dfs(int x,int y,boolean[] used,int begin,char[] charArray,char[][] board) {
		if(begin==charArray.length-1) {
			return board[x][y]==charArray[begin];
		}
		if(board[x][y]==charArray[begin]) {
			used[x*wid+y]=true;
			for (int[] dir : directions) {
				int newX=dir[0]+x;
				int newY=dir[1]+y;
				if(inArea(newX,newY,len,wid)&&!used[newX*wid+newY]) {
					if(dfs(newX, newY, used, begin+1, charArray, board)) {
						return true;
					}
				}
			}
			used[x*wid+y]=false;
		}
		return false;
	}
}
