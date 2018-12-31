package recursionAndDP;

import java.awt.Point;
import java.util.ArrayList;
import java.util.HashMap;

public class RobotInAGrid {

	public static void main(String[] args) {
		boolean maze[][]= {{true,true,false,false,false},
				{false,true,true,true,false},
				{false,false,false,true,false},
				{false,true,true,true,true}};
		
		/*  # 1 1 0 0 0
	        # 0 1 1 1 0 <-- dead-end corridor
	        # 0 0 0 1 0
	        # 0 1 1 1 1*/
		
		ArrayList<Point> path=getPath(maze);
		System.out.println(path.toString());
		
	}
	public static ArrayList<Point> getPath(boolean maze[][])
	{
		ArrayList<Point> path=new ArrayList<Point>();
		HashMap<Point,Boolean> cache=new HashMap<Point,Boolean>();
		int row=maze.length-1;
		int column=maze[0].length-1;
		if(getPath(maze,path,cache,row,column))
		{
			return path;
		}	
		else
			return null;
	}
	
	public static boolean getPath(boolean maze[][],ArrayList<Point> path,HashMap<Point,Boolean> cache,int row,int column)
	{
		if(row<0 || column<0 || !maze[row][column]) //Path cannot contain this point
			return false;
		
		Point p=new Point(row,column);
		
		if(cache.containsKey(p))
			return cache.get(p);
		
		boolean isAtOrigin= (row==0 && column==0);
		
		//This condition checks whether there exists a point(s) via which we can reach the current point
		if(isAtOrigin || getPath(maze,path,cache,row-1,column) || getPath(maze,path,cache,row,column-1))
		{
			path.add(p);
			cache.put(p, true);
			return true;
		}
		else
		{
			cache.put(p, false);
			return false;
		}
	}
}
