package leetcode.day06;
public class LC410 {
	public static void main(String[] args) {
		int[] arr= {7,2,5,10,8};
		System.out.println(splitArray(arr, 2));
	}
	 public static  int splitArray(int[] nums, int m) {
         int left=0;
         int right=0;
        for (int i : nums) {
             left=Math.max(left,i);
			right+=i;
		}
        int k=0;
 	   int sum=0;
      while(left<right) {
    	   k=(left+right)>>>1;
    	   int M=1;
    	    sum=0;
    	   for (int i : nums) {
		     if(sum+i<=k) sum+=i;
		     else {
		    	 sum=i;
		    	 M++;
		     }
		}
    	 if(M>m)left=k+1;
    	 else right=k;
      }
      return left;
	 }
}
