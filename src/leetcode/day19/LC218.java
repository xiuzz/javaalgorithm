package leetcode.day19;

import java.util.*;
public class LC218 {
	public static void main(String[] args) {
		int[][] nums= {{2,9,10},{3,7,15},{5,12,12},{15,20,10},{19,24,8}};
		System.out.println(getSkyline(nums));
	}
  public static List<List<Integer>> getSkyline(int[][] buildings) {
       List<int[]> buildingPoints=new ArrayList<int[]>();
        for(int[] b:buildings) {
        	//负号表示左边高度的转折点
        	buildingPoints.add(new int[] {b[0],-b[2]});
        	buildingPoints.add(new int[] {b[1],b[2]});
        }
        //第二步：按照横坐标排序，横坐标相同的时候，高度高的在前面
        buildingPoints.sort((a,b)->{
        	if(a[0]!=b[0]) {
        		return a[0]-b[0];
        	}
        	else {
        		//这里因为左端点传进去的时候，数值是负的，在比较的时候还按照升序排序(取绝对值时候为降序)
        		return a[1]-b[1];
        	}
        });
        //第三步：扫描一遍动态计算出结果  Collections.reverseOrder()降序排序
        PriorityQueue<Integer> maxHeap=new PriorityQueue<>(Collections.reverseOrder());
        //哈希表，记录「延迟删除」的元素，key 为元素，value 为需要删除的次数
       Map<Integer, Integer> delayed=new HashMap<Integer, Integer>();
       //最开始的时候需要产生高度差，所以需要加上一个高度为0，宽度为0的矩形
       maxHeap.offer(0);
    // 为了计算高度差，需要保存之前最高的高度
       int lastHeight=0;
       List<List<Integer>> res=new ArrayList<List<Integer>>();
       for (int[] buildingPoint : buildingPoints) {
		   if(buildingPoint[1]<0) {
			// 说明此时是「从下到上」，纵坐标参与选拔最大值，请见「规则 1」，这里其实就是左边出发的意思
			   maxHeap.offer(-buildingPoint[1]);
		   }
		   else {
			   // 不是真的删除 buildingPoint[1]，把它放进 delayed，等到堆顶元素是 buildingPoint[1] 的时候，才真的删除,这里就是计算右边下落
			   delayed.put(buildingPoint[1], delayed.getOrDefault(buildingPoint[1], 0)+1);
		   }
		 //如果堆顶元素在延迟删除集合中，才真正删除，这一步可能执行多次，所以放在while中
		 //while（true）都是可以的，因为maxHeap一定不为空
		 while(!maxHeap.isEmpty()) {
			 int curHeight=maxHeap.peek();
			 if(delayed.containsKey(curHeight)) {
				 delayed.put(curHeight, delayed.get(curHeight)-1);
			 if(delayed.get(curHeight)==0) {
				 delayed.remove(curHeight);
			 }
			 maxHeap.poll();
			 }
			 else break;
		 }  
	
    int curHeight=maxHeap.peek();
    //有高度差，才有关键点出现
    if(curHeight!=lastHeight) {
    	//正在扫过的左端点的值
    	res.add(Arrays.asList(buildingPoint[0],curHeight));
    	//当前高度成为计算高度差的标准
    	lastHeight =curHeight;
           }
	   }
       return res;
    }
}
