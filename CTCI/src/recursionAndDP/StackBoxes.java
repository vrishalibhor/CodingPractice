package recursionAndDP;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;

class Box
{
	int width;
	int height;
	int depth;

	Box(int width, int height, int depth)
	{
		this.width=width;
		this.height=height;
		this.depth=depth;
	}

	public String toString()
	{
		return height+"-"+width+"-"+depth;
	}

	public boolean canBeAbove(Box bottomBox)
	{
		if(this.depth<bottomBox.depth && this.width<bottomBox.width)
			return true;
		else return false;
	}
}

class CompareBoxByHeight implements Comparator<Box>
{
	public int compare(Box box1, Box box2) {
		return box2.height-box1.height;
	}
}

public class StackBoxes {
	
	public static int getMaxHeight(ArrayList<Box> boxes)
	{
		Collections.sort(boxes, new CompareBoxByHeight());
		int maxHeight=0;
		HashMap<String,Integer> map=new HashMap<String,Integer>();
		for(int bottom=0;bottom<boxes.size();bottom++)
		{
			int height=createStack(boxes, bottom, map)+boxes.get(bottom).height;
			maxHeight=Math.max(height, maxHeight);
		}
		return maxHeight;
	}
	
	public static int createStack(ArrayList<Box> boxes, int bottom, HashMap<String,Integer> map)
	{
		int height=0;
		int maxHeight=0;
		for(int next=bottom+1; next<boxes.size(); next++)
		{
			if(boxes.get(next).canBeAbove(boxes.get(bottom)))
			{
				if(map.containsKey(boxes.get(next).toString()))
				{
					height=map.get(boxes.get(next).toString());
				}
				else
				{
					height=createStack(boxes,next,map)+boxes.get(next).height;
					map.put(boxes.get(next).toString(), height);
				}	
				maxHeight=Math.max(maxHeight, height);
			}
		}

		return maxHeight;

	}
	public static void main(String[] args) {
		Box[] boxList = { new Box(1, 1, 1), new Box(2,2,2), new Box(3, 3,3), new Box(2,3,1)};
		ArrayList<Box> boxes = new ArrayList<Box>();
		for (Box b : boxList) {
			boxes.add(b);
		}

		int height = getMaxHeight(boxes);
		System.out.println(height);
	}

}
