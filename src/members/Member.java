package members;

import java.util.ArrayList;
import tasks.Service;

public abstract class Member {
	private String name;
	private double money;
	ArrayList<Service> skills;
	
	//constructor with no skills 
	public Member(String n, int m){
		this.name = n;
		this.money = m;
		this.skills = new ArrayList<Service>();
	}
	//constructor with skills given
	public Member(String n, int m, ArrayList<Service> s){
		this.name = n;
		this.money = m;
		this.skills =s;
	}
	
	//TODO : method to add a skill/service
	
	//TODO : method to add money.
	
	//TODO : abstract method to take away money.
	
	//TODO : method to create a task.
}
