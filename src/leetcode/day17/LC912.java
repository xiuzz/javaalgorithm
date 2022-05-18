package leetcode.day17;
//基于堆排序
public class LC912 {
	public int[] sortArray(int[] nums) {
        heapify(nums);
        for (int i = nums.length-1; i>0; i--) {
			swap(nums, 0, i);
			siftDown(nums, 0, i-1);
		}
        return nums;
    }
	//运用堆排序的关键点就是先将数组指定部分堆化（heapify）
	private void heapify(int[] nums) {
		for (int i = (nums.length-1)/2; i>=0; i--) {
			siftDown(nums, i,nums.length-1);
		}
	}
  //而堆化的操作是自底向上的siftDown操作
	private void siftDown(int[] nums,int k ,int end) {
		while(k*2+1<=end) {
			int j=k*2+1;
			if(j+1<=end&&nums[j+1]>nums[j])j++;
			if(nums[k]<nums[j]) {
			 swap(nums, k, j);
			 k=j;
			}
			else break;
		}
	}
 //因为swap操作太多就写个方法
   private void swap(int[] nums,int a,int b) {
	   int temp=nums[a];
	   nums[a]=nums[b];
	   nums[b]=temp;
   }
}