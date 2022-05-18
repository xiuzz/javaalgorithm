package leetcode.day17;

import java.util.Arrays;

public class MaxHeap implements MaxQueue{
    private int[] data;
    private int capacity;
    private int size;
    public MaxHeap(int capacity) {
		data=new int[capacity+1];
		this.capacity=capacity;
	}
	@Override
	public boolean isEmpty() {
		return size==0;
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public void offer(int x) {
		if(size+1>capacity)
			throw new RuntimeException("heap is full");
		data[++size]=x;
		siftUp(size);
	}
	public void siftUp(int index) {
		int temp=data[index];
		while(index>1) {
		    if(data[index/2]<temp) {
		    	  data[index]=data[index/2];
		    	 data[index/2]=temp;
		    	 index/=2;
		    }
		    else break;
		}
	}
    public void replace(int val) {
    	if(isEmpty())
    		throw new RuntimeException("no element");
    	data[1]=val;
    	siftDown(1);
    }
    
	public void siftDown(int index) {
		 int j=index*2;
		while(j<=size) {
			if(j+1<=size&&data[j]<data[j+1]) {
				j++;
			}
			if(data[index]<data[j]) {
				int temp=data[index];
				data[index]=data[j];
				data[j]=temp;
				index=j;
				j*=2;
			}
			else break;
		}
		
	}
	@Override
	//取出根节点
	public int poll() {
		if(size==0)
			throw new RuntimeException("null");
		int temp=data[1];
		data[1]=data[size];
		data[size--]=0;
		siftDown(1);
		return temp;
	}
     //返回堆首元素
	@Override
	public int peek() {
		if(isEmpty())
			throw new RuntimeException("no element");
	    return data[1];
	}
   public static void main(String[] args) {
	  MaxHeap maxHeap=new MaxHeap(10);
	  for (int i =7; i >0; i--) {
		maxHeap.offer(i);
	} 
	  System.out.println(Arrays.toString(maxHeap.data));
	  System.out.println(maxHeap.poll());
	  System.out.println(Arrays.toString(maxHeap.data));
 }
} 
