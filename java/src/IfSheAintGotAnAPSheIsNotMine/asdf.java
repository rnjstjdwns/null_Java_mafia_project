package IfSheAintGotAnAPSheIsNotMine;

import java.util.Vector;

public class asdf {
	
	public static void main(String[] args) {

		Vector <Integer> iv = new Vector <Integer> ();
		
		iv.add(777);
		iv.add(888);
		iv.add(999);
		iv.add(3,4132);
		iv.removeAllElements();
		
		for(int i = 0; i < iv.size(); i++) {
			System.out.println(iv.get(i));
		}
		
		int a = iv.size();
		System.out.println(a);
		int b = iv.capacity();
		System.out.println(b); 
		
		}

	}


