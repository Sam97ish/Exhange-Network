package members;

import java.util.ArrayList;

import reseau.*;
import tasks.*;

public class adminstrator extends Normal {
	private Network nrk;
	
	/**
	 * creates an object admin with name and money
	 * @param name
	 * @param money
	 */
	public adminstrator(String name, int money){
		super(name,money);
	}
	
	/**
	 * creates an admin with his skillset given.
	 * @param name
	 * @param money
	 * @param skills
	 */
	public adminstrator(String name, int money, ArrayList<Service> skills){
		super(name,money,skills);
	}
	
	/**
	 * creates a network with empty members and tasks
	 * @param name of network
	 */
	public void createNetwork(String name) {
		this.nrk = new Network(this, name); 
		System.out.println("The Admin : " + this.get_name() + " created a new Network named " + name);
	}
	
	/**
	 * creates a network with existing members and tasks
	 * @param n is the name of the network
	 * @param l_members
	 * @param l_tasks
	 */
	public void createNetwork(String name, ArrayList<Member> l_members,  ArrayList<Task> l_tasks) {
		this.nrk = new Network(this,name,l_members,l_tasks); 
		System.out.println("The Admin : " + this.get_name() + " created a new Network named " + name);
	}
	

	public void createTask(Service s,String n , int nbwo, Member pa, double time, String desc) {
		Task t = new Task(s,n,nbwo,pa,time,desc);
		this.nrk.addTask(t);
	}
	
	/**
	 * Method to add a new Task to the network
	 * @param member
	 */
	public void addMember(Member m) {
		this.nrk.addMember(m);
		System.out.println("The Admin : " + this.get_name() + " added  the member " + m.get_name() + 
							" to the network " + this.nrk.get_name());
	}
	
	/**
	 * adds an already created list of members.
	 * caution : will overwrite the existing list of members.
	 * @param l_m
	 */
	public void addMemberList(ArrayList<Member> l_m) {
		this.nrk.addMemberList(l_m);
		System.out.println("The Admin : " + this.get_name() + " added a list of members to the network " + this.nrk.get_name());
	}

	/**
	 * creates and adds a member of a given social class in param to the network
	 * @param name of member
	 * @param money
	 * @param social class, new Half() or new Normal() or new Zero();
	 * @param skills set : the set of services
	 */
	public void createMember(String name,int money , Member m, ArrayList<Service> skills) {
		m.changeName(name);
		m.addMoney(money);
		m.addSkillSet(skills);
		this.nrk.addMember(m);
		System.out.println("The Admin : " + this.get_name() + " added  the member  : " + m.get_name() + 
				" to the network : " + this.nrk.get_name());
	}
	
	/**
	 * creates and adds a member of a given social class in param to the network
	 * @param name of member
	 * @param money
	 * @param social class, new Half() or new Normal() or new Zero();
	 */
	public void createMember(String name,int money , Member m) {
		m.changeName(name);
		m.addMoney(money);
		this.nrk.addMember(m);
		System.out.println("The Admin : " + this.get_name() + " added  the member : " + m.get_name() + 
				" to the network : " + this.nrk.get_name());
	}

	/**
	 * removes a member from the network
	 * @param m member
	 */
	public void removeMember(Member m) {
		this.nrk.removeMember(m);
		System.out.println("The Admin : " + this.get_name() + " removed the member : " + m.get_name() + " from the network : " + this.nrk.get_name() );
	}
	
	/**
	 * removes a member from the network
	 * @param s string
	 */
	public void removeMember(String s) {
		this.nrk.removeMember(s);
		System.out.println("The Admin : : " + this.get_name() + " removed the member " + s + " from the network : " + this.nrk.get_name() );
	}
	
	/**
	 * returns a member given his name
	 * @param name
	 * @return member or null if not found
	 */
	public Member get_member(String name) {
		return this.nrk.get_member(name);
	}
	
	/**
	 * runs all the tasks that are possible. two conditions must be met:
	 * 1- the patron has enough money to pay.
	 * 2- there are enough workers to do the task.
	 */
	public void runAll() {
		this.nrk.runAllTasks();
		System.out.println("The Network " + this.nrk.get_name() + " has finished all tasks");
	}
	
	/**
	 * runs a specific given task
	 * @param tache
	 */
	public void runTask(Task tache) {
		ArrayList<Task> l_tasks = this.nrk.get_tasks();
		for(int i = 0; i < l_tasks.size(); i++) {
			if(tache == l_tasks.get(i)) {
				l_tasks.get(i).runTask(this.nrk);
			}
		}
	}
	
	/**
	 * method to add a task to the network
	 * @param t
	 */
	public void addTask(Task t) {
		this.nrk.addTask(t);
		System.out.println("The Admin  : " + this.get_name() + " added the task : " + t.get_name() 
							+ " to the network : " + this.nrk.get_name());
	}
	
	/**
	 * adds a list of tasks. deletes all existing tasks in list.
	 * @param t list of tasks
	 */
	public void addTaskList(ArrayList<Task> t) {
		this.nrk.addTaskList(t);
	}
	
	/**
	 * Method to remove a task from the network
	 */
	public void removeTask(Task t) {
		this.nrk.removeTask(t);
		System.out.println("The Admin : " + this.get_name() + " removed the task : " + t.get_name()
								+ " from the network : " + this.nrk.get_name());
	}
	
}
