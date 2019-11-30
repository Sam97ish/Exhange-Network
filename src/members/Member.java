package members;

import java.util.ArrayList;
import tasks.Service;
import tasks.Task;

public abstract class Member {
	private String name;
	private double money;
	private ArrayList<Service> skills;
	
	/**
	 * constructor of member without skills
	 * @param name
	 * @param money
	 */
	public Member(String n, int m){
		this.name = n;
		this.money = m;
		this.skills = new ArrayList<Service>();
	}
	
	/**
	 * contractor of member with a list of skills
	 * @param n name
	 * @param m money
	 * @param s list of skills
	 */
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
	
	/**
	 * returns the list of skills of member
	 * @return skills
	 */
	public ArrayList<Service> get_skills(){
		return this.skills;
	}
	
	/**
	 * a method to add a Service/skill to the member
	 * @param service
	 * @return boolean
	 */
	public boolean addSkill(Service s) {
		System.out.println("Added skill : " + s.get_name() + " to : " + this.name );
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
		System.out.println("Added skill : " + s.get_name() + " to : " + this.get_name() );
		return this.skills.add(s);
	}
	
	/**
	 * adds a predefined array of skills to the member
	 * @param skills
	 */
	public void addSkillSet(ArrayList<Service> skills) {
		this.skills = skills;
	}
	
	/**
	 * a method to remove a Service/skill from a member
	 * @param service
	 * @return void, prints.
	 */
	public boolean removeSkill(Service s) {
		System.out.println("Removed skill : " + s.get_name() + " from : " + this.get_name() );
		return this.skills.remove(s);
	}
	
	/**
	 * removes a skill given it's name
	 * @param name
	 */
	public void removeSkill(String name) {
		for(int i = 0; i < this.skills.size(); i++) {
			if(this.skills.get(i).get_name().equals(name)) {
				this.skills.remove(i);
			}
		}
		System.out.println("Removed skill : " + name + " from : " + this.get_name() );
		
	}
	
	/**
	 * a method to add the amount n to the wallet of a member
	 * @param integer n
	 */
	public void addMoney(double n) {
		this.money += n;
	}
	
	/**
	 * a method that removes a given amount of money from member
	 * @param n
	 */
	public boolean substractMoney(double n) {
		this.money += n;
		return true;
	}
	
	/**
	 * A method to subtract/pay money from the member calling it. it will calculate a certain amount of money and will subtract it from the caller
	 * and then pay the workers of the task given in the parameter equally.
	 * Must behave differently depending on the social class of the member calling it.
	 * the class using this method must check if workers has the required Service/skill
	 * @param Task
	 * @return boolean
	 */
	public abstract boolean debit(Task tache);
	
	/**
	 * a method to allow any member to create a task in the network
	 * @param service
	 * @param n name
	 * @param nbWorkers
	 * @param duration
	 * @param description
	 * @param l_workers
	 * @return (Object) (Task)
	 */
	public Object createTask(Service service,String n , int nbWorkers, double duration, String description) {
		return new Task(service,n , nbWorkers, this, duration, description);
	}
	
	/**
	 * Method for changing the member name 
	 * @param n  the new name
	 */
	public void changeName(String n) {
		this.name = n;
	}
}
