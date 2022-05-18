package leetcode.day09;

public class offer51 {
	public static void main(String[] args) {
		offer51 offer51=new offer51();
		int[] nums={7,5,6,4};
		System.out.println(offer51.reversePairs(nums));
	}
	public int reversePairs(int[] nums) {
	   int[] temp=new int[nums.length];
       return  merge(nums, 0, nums.length-1,0,temp);
    }
	public int merge(int[] nums,int left,int right,int cnt,int[] temp) {
		 if(left>=right)return 0;
		 int mid=(left+right)>>1;
	     cnt=merge(nums, left,mid,cnt,temp);
	     cnt+=merge(nums, mid+1, right, cnt,temp);
	     int pl=left,pr=mid+1,i=left;
	     while(pl<=mid&&pr<=right) {
	    	 if(nums[pl]<=nums[pr]) {
	    		 temp[i++]=nums[pl++];
	    	 }
	    	 else {
	    		 temp[i++]=nums[pr++];
	    		 cnt+=mid+1-pl;
	    	 }
	     }
	     while(pl<=mid) {
	    	 temp[i++]=nums[pl++];
	     }
	     while(pr<=right) {
	    	 temp[i++]=nums[pr++];
	     }
	     for (int j = left; j <=right; j++) {
			nums[j]=temp[j];
		}
	     return cnt;
	}
}
