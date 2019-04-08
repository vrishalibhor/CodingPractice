package recursionAndDP;

import java.util.ArrayList;

public class PowerSet {

	public static void main(String[] args) {
		ArrayList<ArrayList<Integer>> sol=getPowerSet(4);
		System.out.println(sol);
		System.out.println(sol.size());
	}
	public static ArrayList<ArrayList<Integer>> getPowerSet(int n)
	{
		ArrayList<ArrayList<Integer>> solution=new ArrayList<ArrayList<Integer>>();
		
		if(n==0)	return solution;
		
		ArrayList<Integer> setOne=new ArrayList<Integer>();
		setOne.add(1);
		solution.add(setOne);
		
		ArrayList<ArrayList<Integer>> current=null;
		for(int i=2;i<=n;i++)
		{
			current=new ArrayList<ArrayList<Integer>>();
			ArrayList<Integer> newSet=new ArrayList<Integer>();
			newSet.add(i);
			current.add(newSet);
			for(int j=0;j<solution.size();j++)
			{
				
				ArrayList<Integer> setFromSol=new ArrayList<Integer>();
				setFromSol.addAll(solution.get(j));
				setFromSol.add(i);
				current.add(setFromSol);
				
			}
			solution.addAll(current);
		}
		return solution;
	}
}
