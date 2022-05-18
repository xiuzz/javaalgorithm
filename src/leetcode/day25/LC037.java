package leetcode.day25;

public class LC037 {
	boolean[][] len=new boolean[9][9];
	boolean[][] wid=new boolean[9][9];
	boolean[][][] box=new boolean[3][3][9];
   public void solveSudoku(char[][] board) {
          for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				if(board[i][j]!='.') {
					len[i][board[i][j]-'1']=true;
					wid[j][board[i][j]-'1']=true;
					box[i/3][j/3][board[i][j]-'1']=true;
				}
			}
		}
          dfs(board, 0, 0);
	  }
  public boolean dfs(char[][] board ,int i,int j) {
	   if(i==9)return true;
	 if(board[i][j]=='.') {
		 for (char x = '1'; x <'1'+10; x++) {
			int index=x-'1';
			if(!len[i][index]&&!wid[j][index]&&!box[i/3][j/3][index]) {
				board[i][j]=x;
				len[i][index]=true;
				wid[j][index]=true;
				box[i/3][j/3][index]=true;
				if(dfs(board, i+(j+1)/9, (j+1)%9))return true;
				board[i][j]='.';
				len[i][index]=false;
				wid[j][index]=false;
				box[i/3][j/3][index]=false;
			}
	      }
	 }
	 else {
		return dfs(board, i+(j+1)/9, (j+1)%9);	
	 }
	 return false;
  }  
}
