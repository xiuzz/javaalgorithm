package leetcode.day24;

import java.util.LinkedList;
import java.util.Queue;

public class LC733BFS {
   int rows;
   int cols;
   int[][] directions={{1,0},{0,-1},{-1,0},{0,1}};
   public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
          int oldColor=image[sr][sc];
          if(oldColor==newColor)return image;
          rows=image.length;
          cols=image[0].length;
         boolean[] used=new boolean[rows*cols];
         Queue<int[]> queue=new LinkedList<>();
         //从一个结点开始广度优先遍历
         queue.offer(new int[] {sr,sc});
         used[sr*cols+sc]=true;
         while(!queue.isEmpty()) {
        	 int[] head=queue.poll();
        	 image[head[0]][head[1]]=newColor;
        	 for (int[] dir : directions) {
				int newX=head[0]+dir[0];
				int newY=head[1]+dir[1];
				if(inArea(newX, newY, rows, cols)&&!used[newX*cols+newY]&&image[newX][newY]==oldColor){
					queue.offer(new int[] {newX,newY});
					used[newX*cols+newY]=true;
				}
			}
         }
         return image;
 	}  

   private boolean inArea(int x,int y,int rows,int cols) {
	   return x>=0&&x<rows&&y>=0&&y<cols;
}
}