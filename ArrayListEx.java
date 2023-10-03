package IfSheAintGotAnAPSheIsNotMine;

public class ArrayListEx {
	
	public static void main(String[] args) {
		GVal <String> gvp = new GVal<String>();
		
		gvp.set("어어 밀지마라");
		
		System.out.println("우끼끼우끼끼 "+ gvp.get());
		
		
	}

}

class GVal <T> {
	T value;
	
	public void set(T value) { 
		this.value = value;
	}
	
	public T get() {
		return (T) this.value;
	}
}
