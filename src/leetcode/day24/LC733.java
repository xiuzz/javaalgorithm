package leetcode.day24;

public class LC733 {
	int[][] direction= {{1,0},{0,-1},{-1,0},{0,1}};	
	public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
		if(image[sr][sc]==newColor)return image;
		int rows=image.length;
		int cols=image[0].length;
		dfs(sr, sc, newColor, image[sr][sc], rows, cols, image);
		image[sr][sc]=newColor;
		return image;
    }
	private void dfs(int x,int y,int newColor,int oldColor,int rows,int cols,int[][] floodFill) {
		for (int[] is : direction) {
			int newX=x+is[0];
			int newY=y+is[1];
		    if(inArea(newX, newY, rows, cols)) {
		    	if(floodFill[newX][newY]==oldColor) {
		    		floodFill[newX][newY]=newColor;
		    		dfs(newX, newY, newColor, oldColor, rows, cols, floodFill);
		    	}
		    }
		}
	}
	private boolean inArea(int x,int y,int rows,int cols) {
		return x>=0&&x<rows&&y>=0&&y<cols;
	}
	
}
