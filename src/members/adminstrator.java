package members;

import java.util.ArrayList;

import reseau.*;
import tasks.*;

public class adminstrator extends Normal {
	private Network nrk;
	//constructor with no skills 
	public adminstrator(String n, int m){
		super(n,m);
	}
	
	//constructor with skills given
	public adminstrator(String n, int m, ArrayList<Service> s){
		super(n,m,s);
	}
	
	/**
	 * creates a network with empty memebers and tasks
	 */
	public void createNetwork() {
		this.nrk = new Network(this); 
		System.out.println(" the admin : " + this.get_name() + " created a new Network");
	}
	
	/**
	 * creates a network with existing memebers and tasks
	 * @param l_members
	 * @param l_tasks
	 */
	public void createNetwork( ArrayList<Member> l_members,  ArrayList<Task> l_tasks) {
		this.nrk = new Network(this,l_members,l_tasks); 
		System.out.println(" the admin : " + this.get_name() + " created a new Network");
	}
	//TODO : method to add new members to network
	
	//TODO : method to remove members from network
	
	//TODO : method to verify if the tasks are done
	
	//TODO : ...
}
