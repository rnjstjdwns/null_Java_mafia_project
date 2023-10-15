package SetPlayer;

public class Job extends Player {
	String jobname;
	Job(){
		
	}
	Job(int i){
		if(i==0) {
			Player player = new Professor();
			Professor ps = (Professor) player;
		}
		else {
			Player player = new Student();
			Student st = (Student) player;
		}
	}
}
