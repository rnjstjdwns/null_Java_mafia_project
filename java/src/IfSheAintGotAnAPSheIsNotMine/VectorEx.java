package IfSheAintGotAnAPSheIsNotMine;

import java.util.*;



public class VectorEx {
	
	public static void main(String[] args) {
		
		ArrayList <Point> v = new ArrayList<>();
		
		 v.add(new Point(10,20));
		 v.add(new Point(30,40));
		 v.add(new Point(104,4530));
		 v.add(new Point(1043,240));
		 
		 Collections.shuffle(v);
		 for(int i = 0; i < v.size(); i++) {
			 Point p = v.get(i);
			 
			 System.out.println(p);
		 }
		 
	}

}

class Point {
	private int x, y;
	
	public Point (int x, int y) {
		this.x = x;
		this.y = y;
	}
		
	public String toString () {
		return "(" + x +", " + y + ")";
		}
	}

