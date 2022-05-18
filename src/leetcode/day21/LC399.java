package leetcode.day21;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LC399 {
	public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
         int equationSize = equations.size();
         UnionFind unionFind=new UnionFind(2*equationSize);
        //第一步：预处理，将变量的值与id进行映射，使得并查集的底层使用数组实现，方便编码
        Map<String, Integer> hashMap=new HashMap<>(2*equationSize);//因为一个equation里面带两个字母，最极端的情况两个字母都不同
        //及有2*size个;
        int id=0;
        for (int i = 0; i < values.length; i++) {
			List<String>  equation=equations.get(i);
			String var1=equation.get(0);
			String var2=equation.get(1);
		  if(!hashMap.containsKey(var1)) {
			  hashMap.put(var1, id);
			  id++;
		  }
		  if(!hashMap.containsKey(var2)) {
			  hashMap.put(var2, id);
			  id++;
		  }
		  unionFind.union(hashMap.get(var1), hashMap.get(var2),values[i]);		  
		}
      //第二步：做查询
        int queriesSize=queries.size();
        double[] res=new double[queriesSize];
        for (int i = 0; i < queriesSize; i++) {
			String var1=queries.get(i).get(0);
			String var2=queries.get(i).get(1);
			Integer id1=hashMap.get(var1);
			Integer id2=hashMap.get(var2);
			if(id1==null||id2==null)res[i]=-1.0d;
			else {
				res[i]=unionFind.isConnected(id1,id2); 
			}
		}
        return res;
    }
  private class UnionFind{
	  int[] parent;
	  //指向父节点的权值
	  double[] weghit;
	 public UnionFind(int N) {
		 parent=new int[N];
		 weghit=new double[N];
		 for (int i = 0; i < N; i++) {
			parent[i]=i;
			weghit[i]=1.0d;
		}
	 }
    public  void union(int x,int y,double value) {
    	int xRoot=find(x);
    	int yRoot=find(y);
    	if(xRoot!=yRoot) {
    		parent[xRoot]=yRoot;
    		weghit[xRoot]=weghit[y]*value/weghit[x];
    	}
    }
    public int find(int x) {
    	if(x!=parent[x]) {
    		int origin=parent[x];
    		parent[x]=find(parent[x]);
    		weghit[x]*=weghit[origin];
    	}
    	return parent[x];
    }
    public double isConnected(int x,int y) {
    	if(find(x)!=find(y))return -1.0d;
    	else {
    		return weghit[x]/weghit[y];
    	}
    }
  }
}
