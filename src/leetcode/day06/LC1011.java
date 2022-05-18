package leetcode.day06;
public class LC1011 {
	public int shipWithinDays(int[] weights, int days) {
         int left=0;
         int right=0;
         for (int i : weights) {
        	 left=Math.max(left, i);
			right+=i;
		}
       while(left<right) {
    	   int mid=(left+right)>>>1;
    	   int day=getDays(weights, mid);
    	   if(day>days)left=mid+1;
    	   else right=mid;
       }
       return left;
    }
   public static int getDays(int[] weights,int mid) {
	     int sum=0;
	     int day=1;
	    for (int i : weights) {
			if(sum+i<=mid) sum+=i;
			else {
				sum=i;
				day++;
			}
		}
	    return day;
   }
}
