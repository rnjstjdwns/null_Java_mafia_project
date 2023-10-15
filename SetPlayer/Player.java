package SetPlayer;

public class Player {
	int role;
	String name;
	Job job;
	Player(){
		
	}
	public void getJob(int role){
		if(role == 0) {
			 this.job = new Job(role);
		 }
		 else if(role == 1) {
			 this.job = new Job(role);
		 }
	        System.out.println(name + "의 역할: " + (role == 0 ? "교수" : "학생"));
	}

	

	public void setName(String name) {
		this.name=name;
	}

	
//	 public void getJob(int role) {
//		 if(role == 0) {
//			 this.job = new Job(role);
//		 }
//		 else if(role == 1) {
//			 this.job = new Job(role);
//		 }
//	        System.out.println(name + "의 역할: " + (role == 0 ? "교수" : "학생"));
//	    
//	}
	
	
 }