package leetcode.day22;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;


public class LC113 {
	public class TreeNode {
		int val;
	   TreeNode left;
	   TreeNode right;
	TreeNode() {}
	TreeNode(int val) { this.val = val; }
	TreeNode(int val, TreeNode left, TreeNode right) {
		    this.val = val;
		    this.left = left;
        this.right = right;
		    }
   }
	public static void main(String[] args) {
		LC113 lc113=new LC113();
		TreeNode root10= lc113.new TreeNode(1,null,null);
		TreeNode root9= lc113.new TreeNode(5,null,null);
		TreeNode root8= lc113.new TreeNode(2,null,null);
		TreeNode root7= lc113.new TreeNode(7,null,null);
		TreeNode root6= lc113.new TreeNode(4,root9,root10);
		TreeNode root5= lc113.new TreeNode(13,null,null);
		TreeNode root3= lc113.new TreeNode(11,root7,root8);
		TreeNode root2= lc113.new TreeNode(8,root5,root6);
		TreeNode root1= lc113.new TreeNode(4,root3,null);
		TreeNode root= lc113.new TreeNode(5,root1,root2);
		System.out.println(lc113.pathSum(root, 22));
	}
	public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
          List<List<Integer>> res=new ArrayList<>();
          Deque<Integer> deque=new ArrayDeque<Integer>();
          dfs(root, targetSum, res, 0, deque);
          return res;
    }
	public void dfs(TreeNode root,int targetSum,List<List<Integer>> res,int sum,Deque<Integer> deque) {
	    if(root!=null) {
	    	sum+=root.val;
	    	deque.addLast(root.val);
	    	dfs(root.left, targetSum, res, sum, deque);
	    	dfs(root.right, targetSum, res, sum, deque);
	    	   if(root.left==null&&root.right==null) { 
	   		    if(sum==targetSum)res.add(new ArrayList<Integer>(deque));
	           }
	    	sum-=root.val;
	    	deque.removeLast();
	   } 
	}
}
