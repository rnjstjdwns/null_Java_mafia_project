package player;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.Scanner;

public class JobAssignmentManeger {
	
	//유저 들어옴
	ArrayList <Player> players = new ArrayList<Player>(4);
	
	//학생 ArrayList
	ArrayList <Student> students = new ArrayList<Student>(3);
	
	//교수 객체
	Professor professor = null;
	
	Random random = new Random();
	Scanner s = new Scanner(System.in);
	
	public JobAssignmentManeger() {
		
		
		//시작할 때 랜덤으로 교수 번호 뽑음(0~3)
		int professNum = random.nextInt(4);
	      
		//플레이어 게임의 역할 분배
	      for(int i=0;i<4;i++) {
	    	  //만약 교수 번호와 같으면
	    	  if(professNum == i) {
	    		  //플레이
	    		  players.add(new Professor(s.next()));
	    		  professor = (Professor)players.get(i);
	    	  } else {
	    		  players.add(new Student(s.next()));
	    		  students.add((Student)players.get(i));
	    	  }
	      }

	      System.out.println("이번 교수 : "+professor.getNickName());
	      
	      System.out.println("이번 학생 : ");
	      for(int i=0;i<students.size();i++) {
	    	  System.out.println(students.get(i).getNickName()); 
	      }
	}

}
