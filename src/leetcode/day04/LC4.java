package leetcode.day04;

public class LC4 {
	public static void main(String[] args) {
		int[] nums1= {3};
		int[] nums2= {-2,-1};
	System.out.println(	findMedianSortedArrays(nums1, nums2));
	}
	public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
         if(nums1.length>nums2.length) {
        	 return findMedianSortedArrays(nums2, nums1);
         }
        int m=nums1.length;
        int n=nums2.length;
        //分割区间大小
        int cut=(m+n+1)>>>1;
        //定义左右
        int left=0;
        int right=m;
         //初始化m，n的值
        int mMid=0;
        int nMid=0;
        while(left<right) {
        	mMid=(left+right+1)>>>1;
        	nMid=cut-mMid;
        	if(nums1[mMid-1]>nums2[nMid])right=mMid-1;
        	else left=mMid;
        }
        mMid=right;
        nMid=cut-mMid;
       int mleft=mMid==0?Integer.MIN_VALUE:nums1[mMid-1];
       int nleft=nMid==0?Integer.MIN_VALUE:nums2[nMid-1];
       int mright=mMid==m?Integer.MAX_VALUE:nums1[mMid];
       int nright=nMid==n?Integer.MAX_VALUE:nums2[nMid];
       int lMax=Math.max(mleft, nleft);
       int rMin=Math.min(mright,nright);
      if((m+n)%2!=0) return lMax;
      else return (double)(lMax+rMin)/2;
    }
}
