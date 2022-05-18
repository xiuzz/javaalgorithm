package leetcode.day10;

import java.util.Arrays;
import java.util.List;

public class LC315 {
	public static void main(String[] args) {
	  int[]	nums= {65,36,100,41};
	  System.out.println(new LC315().countSmaller(nums));
	}
	public List<Integer> countSmaller(int[] nums) {
        Integer[] temp=new Integer[nums.length];
           temp[nums.length-1]=0;
          Node root=new Node(nums[nums.length-1]);
       for (int i = nums.length-2; i >=0; i--) {
		   Node cur=new Node(nums[i]);
		   Node pre=root;
		while(true) {
			if(pre.value>=cur.value) {
				 pre.cont++;
				if(pre.left==null) {
					pre.left=cur;
					break;
				}
			  pre=pre.left;  	
			}
			else {
				cur.res+=pre.cont+1;
				if(pre.right==null) {
					pre.right=cur;
					break;
				}
				pre=pre.right;
			}	
		}
		temp[i]=cur.res;
	}

     return Arrays.asList(temp);
    }
   private class Node{
	   int cont;
	   int value;
	   int res;
	   Node left;
	   Node right;
	 public Node(int value) {
		 this.value=value;
	 }
   }
}
