package treesAndGraphs;

import java.util.ArrayList;
import java.util.HashMap;

public class NumberOfConnectedComponents {
	public static int countComponents(int n, int[][] edges) {
		ArrayList<HashMap<Integer,Integer>> listOfMaps=new ArrayList<HashMap<Integer,Integer>>();
		HashMap<Integer,Integer> firstEntry=new HashMap<Integer,Integer>();
		firstEntry.put(edges[0][0],0);
		firstEntry.put(edges[0][1],0);
		listOfMaps.add(firstEntry);

		for(int i=1;i<edges.length;i++)
		{ 
			boolean placed=false;
			int x=edges[i][0];
			int y=edges[i][1];
			for(int j=0;j<listOfMaps.size();j++)
			{
				HashMap<Integer,Integer> currMap=listOfMaps.get(j);
				if(currMap!=null && (currMap.containsKey(x)))
				{
					currMap.put(x,0);
					currMap.put(y,0);
					placed=true;
				}
			}
			if(!placed)
			{
				HashMap<Integer,Integer> newMap=new HashMap<Integer,Integer>();
				newMap.put(x,0);
				newMap.put(y,0);
				listOfMaps.add(newMap);
			}
		}
		return listOfMaps.size();
	}
	public static void main(String[] args) {
		int[][] edges= {{2, 3}, {1, 2}, {1, 3}};
		System.out.println(countComponents(4, edges));
	}

}
