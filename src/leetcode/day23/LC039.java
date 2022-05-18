package leetcode.day23;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;

public class LC039 {
	public static void main(String[] args) {
       int[] candidates= {2,3,6,7};
       LC039 lc039=new LC039();
       System.out.println(lc039.combinationSum(candidates, 7));
	} 
	public List<List<Integer>> combinationSum(int[] candidates, int target) {
		Arrays.sort(candidates);
		int len=candidates.length;
		for (int i = 0; i < candidates.length; i++) {
			if(candidates[i]>target) {
				len=i;
				break;
			}
		}
		List<List<Integer>> res =new ArrayList<>();
		Deque<Integer> deque=new ArrayDeque<Integer>();
		dfs(candidates, res,0, 0, deque, target, len);
		return res;
    }
	public void dfs(int[] nums,List<List<Integer>> res,int begin,int sum,Deque<Integer> deque,int target,int len) {
		if(target==sum) {
			res.add(new ArrayList<Integer>(deque));
			return;
		}
		for (int i = begin; i < len; i++) {
			if(nums[i]>target-sum)continue;
			sum+=nums[i];
			deque.addLast(nums[i]);
			if(sum>target) {
				sum-=nums[i];
				deque.removeLast();
				return;
			}
			dfs(nums, res,i,sum, deque, target, len);
			sum-=nums[i];
			deque.removeLast();
		}
	}
}
