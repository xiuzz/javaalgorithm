package leetcode.day27;
import java.util.*;
public class LC1143 {
	public static void main(String[] args) {
		System.out.println(lengthOfLIS(new int[] {10,9,2,5,3,7,101,18}));
	}
	 public static int lengthOfLIS(int[] nums) {
		 if(nums.length==1)return 1;
         List<Integer> dp=new ArrayList<Integer>(nums.length);
         dp.add(nums[0]);
        for (int i = 1; i < nums.length; i++) {
			if(nums[i]>dp.get(dp.size()-1)) dp.add(nums[i]);
			else if(nums[i]<dp.get(dp.size()-1)) {
				int left=0;
				int right=dp.size()-1;
				while(left<right) {
					int mid=(left+right)>>1;
				   if(dp.get(mid)<nums[i])left=mid+1;
				   else right=mid;
				}
				dp.set(right, nums[i]);
			}
		}
        return dp.size();
	   }
}
