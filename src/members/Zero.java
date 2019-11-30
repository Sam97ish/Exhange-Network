package members;

import java.util.ArrayList;

import tasks.Service;
import tasks.Task;

public class Zero extends Member {
	
	/**
	 * constructor of member of type zero with no skills given
	 * @param n name
	 * @param m money
	 */
	public Zero(String n, int m){
		super(n,m);
	}
	
	/**
	 * constructor of member of type zero with skills given
	 * @param n name
	 * @param m money
	 * @param s list of skills
	 */
	public Zero(String n, int m, ArrayList<Service> s){
		super(n,m,s);
	}
	
	/**
	 * constructor with nothing given used only by administrators
	 */
	public Zero() {
		super("",0);
	}

	@Override
	public boolean debit(Task tache) {
		System.out.println(this.get_name() + " is privileged enought not pay a dime ! for the job " + tache.get_name() + " , Description " + tache.get_description());
		return true;
	}
	
	
}
