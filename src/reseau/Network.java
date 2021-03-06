package reseau;

import java.util.ArrayList;
import members.*;
import tasks.*;

public class Network {
	private String name;
	private Member admin;
	private ArrayList<Member> l_members;
	private ArrayList<Task> l_tasks;
	
	/**
	 * constructor of the network given it's admin and the name
	 * @param adm administrator
	 * @param n name
	 */
	public Network(Member adm,String n) {
		this.admin = adm;
		this.name = n;
		
		this.l_members = new ArrayList<Member>();
		this.l_tasks = new ArrayList<Task>();
		
		this.l_members.add(adm);
	}
	
	/**
	 * constructor of the network given all it's requirements
	 * @param adm administrator
	 * @param n name of network
	 * @param l_m list of members
	 * @param l_t list of tasks
	 */
	public Network(Member adm,String n, ArrayList<Member> l_m, ArrayList<Task> l_t) {
		this.admin = adm;
		this.name = n;
		
		this.l_members = l_m;
		this.l_tasks = l_t;
		
		this.l_members.add(adm);
	}
	
	/**
	 * method returns the list of members.
	 */
	public ArrayList<Member> get_members(){
		return this.l_members;
	}
	
	/**
	 * method returns the list of tasks
	 * @return l_tasks  ArrayList<Task>
	 */
	public ArrayList<Task> get_tasks(){
		return this.l_tasks;
	}
	
	/**
	 * returns a member given his name
	 * @param name
	 * @return member or null if not found
	 */
	public Member get_member(String name) {
		for(int i=0 ; i < this.l_members.size() ; i++) {
			if(this.l_members.get(i).get_name().equalsIgnoreCase(name)) {
				return this.l_members.get(i);
			}
		}
		System.out.println("Member not found");
		return null;
	}

	/**
	 * returns the name of the network
	 * @return name 
	 */
	public String get_name() {
		return this.name;

	}
	
	/**
	 * Method to add a new member to the network
	 * @param m  the new member
	 */
	public void addMember(Member m) {
		this.l_members.add(m);
		
	}
	
	/**
	 * adds an already created list of members.
	 * caution : will overwrite the existing list of members.
	 * @param l_m
	 */
	public void addMemberList(ArrayList<Member> l_m) {
		this.l_members = l_m;
	}
	
	/**
	 * Method to add a new Task to the network
	 * @param t the new task
	 */
	public void addTask(Task t) {
		this.l_tasks.add(t);
		

	}
	
	/**
	 * Method to remove a member from the network
	 * @param m the member
	 */
	public void removeMember(Member m) {
		this.l_members.remove(m);
		
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
		
	}
	
	/**
	 * Method that runs all the tasks
	 */
	public void runAllTasks() {
		for(int i=0 ; i < this.l_tasks.size() ; i++ ) {
			this.l_tasks.get(i).runTask(this);
		}
	}
	
	/**
	 * adds a list of tasks. deletes all existing tasks in list.
	 * @param t list of tasks
	 */
	public void addTaskList(ArrayList<Task> t) {
		this.l_tasks = t;
	}
}