package recursionAndDP;

import java.util.ArrayList;

public class PowerSet {

	public static void main(String[] args) {

	}
	public static ArrayList<ArrayList<Integer>> getPowerSet(int n)
	{
		ArrayList<ArrayList<Integer>> solution=new ArrayList<ArrayList<Integer>>();
		
		//if(n==0) return solution
		
		
		for(int i=1;i<=n;i++)
		{
			ArrayList<Integer> current=new ArrayList<Integer>();
			for(int j=0;j<solution.size();j++)
			{
				//current=solution.get(j);
				current.add(solution.get(j));
			}
		}
		
		return solution;
	}
}
