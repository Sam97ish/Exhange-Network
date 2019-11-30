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
	 * creates a network with empty members and tasks
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
	
	/**
	 * Method to add a new Task to the network
	 * @param member
	 */
	public void addMember(Member m) {
		this.nrk.addMember(m);
	}
	
	/**
	 * removes a member from the network
	 * @param m member
	 */
	public void removeMember(Member m) {
		this.nrk.removeMember(m);
	}
	
	/**
	 * removes a member from the network
	 * @param s string
	 */
	public void removeMember(String s) {
		this.nrk.removeMember(s);
	}
	
	/**
	 * runs all the tasks that are possible. two conditions must be met:
	 * 1- the patron has enough money to pay.
	 * 2- there are enough workers to do the task.
	 */
	public void runAll() {
		this.nrk.runAllTasks();
	}
	
	public void runTask(Task tache) {
		ArrayList<Task> l_tasks = this.nrk.get_tasks();
		for(int i = 0; i < l_tasks.size(); i++) {
			if(tache == l_tasks.get(i)) {
				l_tasks.get(i).runTask();
			}
		}
	}
	
	/**
	 * Method to remove a task
	 */
	public void removeTask(Task t) {
		this.nrk.removeTask(t);
	}
	
	//TODO : ...
}
