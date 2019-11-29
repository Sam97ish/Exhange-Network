package reseau;

import java.util.ArrayList;
import members.*;
import tasks.*;

public class Network {
	private Member admin;
	private ArrayList<Member> l_members;
	private ArrayList<Task> l_tasks;
	
	//constructor with empty lists
	public Network(Member adm) {
		this.admin = adm;
		
		this.l_members = new ArrayList<Member>();
		this.l_tasks = new ArrayList<Task>();
	}
	
	//constructor with full lists given
	public Network(Member adm, ArrayList<Member> l_m, ArrayList<Task> l_t) {
		this.admin = adm;
		
		this.l_members = l_m;
		this.l_tasks = l_t;
	}
	
	//TODO : possible methods.
	public void get_members(){
		
	}
	/**
	 * Method to add a new member to the network
	 * @param m  the new member
	 */
	public void addMember(Member m) {
		this.l_members.add(m);
		System.out.println(m.get_name() + "has joined the network");
	}
	/**
	 * Method to add a new Task to the network
	 * @param t the new task
	 */
	public void addTask(Task t) {
		this.l_tasks.add(t);
		System.out.println("A new task has been added to the network");

	}
	/**
	 * Method to remove a member from the network
	 * @param m the member
	 */
	public void removeMember(Member m) {
		this.l_members.remove(m);
		System.out.println(m.get_name() + "has left the network");
	}
	
	/**
	 * Method to remove a member by name
	 * @param name  the name of the member to delete
	 */
	public void removeMember(String name) {
		int i =0;
		while(!(this.l_members.get(i).get_name().equals(name)) && i < this.l_members.size()) {
			i++;
		}
		if(i >= this.l_members.size()) {
			System.out.println("member not found");
		}else {
			this.l_members.remove(i);
		}
	}
	/**
	 * Method to remove a task
	 * @param t the task
	 */
	public void removeTask(Task t) {
		this.l_tasks.remove(t);
		System.out.println("A task has been removed from the networt");
	}
	
	/**
	 * Method that runs all the tasks
	 */
	public void runAllTasks() {
		for(int i=0 ; i < this.l_tasks.size() ; i++ ) {
			this.l_tasks.get(i).runTask();
		}
	}
}
