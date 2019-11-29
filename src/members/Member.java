package members;

import java.util.ArrayList;
import tasks.Service;
import tasks.Task;

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
	
	/**
	 * return the name of member
	 * @return String
	 */
	public String get_name() {
		return this.name;
	} 
	/**
	 * returns the wallet of member
	 * @return double
	 */
	public double get_wallet() {
		return this.money;
	}
	
	public ArrayList<Service> get_skills(){
		return this.skills;
	}
	
	/**
	 * a method to add a Service/skill to the member
	 * @param service
	 * @return boolean
	 */
	public boolean addSkill(Service s) {
		System.out.println("added skill : " + s.get_name() + " to :" + this.name );
		return this.skills.add(s);
	}
	
	/**
	 * a method to add a Service/skill to the member
	 * @param name
	 * @param cost
	 * @return boolean
	 */
	public boolean addSkill(String name, double cost) {
		Service s = new Service(name,cost);
		System.out.println("added skill : " + s.get_name() + " to :" + this.get_name() );
		return this.skills.add(s);
	}
	
	/**
	 * a method to remove a Service/skill from a member
	 * @param service
	 * @return void, prints.
	 */
	public boolean removeSkill(Service s) {
		System.out.println("removed skill : " + s.get_name() + " from : " + this.get_name() );
		return this.skills.remove(s);
	}
	
	public void removeSkill(String name) {
		
		
	}
	
	/**
	 * a method to add the amount n to the wallet of a member
	 * @param integer n
	 */
	public void addMoney(double n) {
		this.money += n;
		System.out.println("added this amount of money : " + n + " to :" + this.get_name());
	}
	
	/**
	 * a method that removes a given amount of money from member
	 * @param n
	 */
	public boolean substractMoney(double n) {
		this.money += n;
		System.out.println("removed this amount of money : " + n + " from : " + this.get_name());
		return true;
	}
	
	/**
	 * a method to subtract money from a member. must behave differently depending on the sous-class.
	 * the class using this method must check if workers has the required Service/skill
	 * @return boolean
	 */
	public abstract boolean debit(Task tache);
	
	/**
	 * a method to allow any member to create a task in the network
	 * @param service
	 * @param nbWorkers
	 * @param duration
	 * @param description
	 * @param l_workers
	 * @return (Object) (Task)
	 */
	public Object createTask(Service service, int nbWorkers, double duration, String description) {
		return new Task(service, nbWorkers, this, duration, description);
	}
}
