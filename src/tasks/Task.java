package tasks;

import java.util.ArrayList;
import members.*;

public class Task {
	private Service serv;
	private int nbworkers;
	private Member patreon;
	private double duration;
	private ArrayList<Member> l_workers;
	private String description;
	private boolean ready;
	
	//constructor with an empty array
	public Task(Service s, int nbwo, Member pa, double time, String desc) {
		this.serv = s;
		this.nbworkers = nbwo;
		this.patreon = pa;
		this.duration = time;
		this.description = desc;
		
		this.l_workers = new ArrayList<Member>();
		this.ready = false;
	}
	
	//constructor with list of workers given
	public Task(Service s, int nbwo, Member pa, double time, String desc, ArrayList<Member> l_wo) {
		this.serv = s;
		this.nbworkers = nbwo;
		this.patreon = pa;
		this.duration = time;
		this.description = desc;
		
		this.l_workers = l_wo;
		this.ready = false;
	}
	
	//TODO : accessers
	public Service get_serv() {
		return this.serv;
	}
	
	public int get_nbworkers() {
		return this.nbworkers;
	}
	
	public Member get_patreon() {
		return this.patreon;
	}
	
	public double get_duration() {
		return this.duration;
	}
	
	public String get_description() {
		return this.description;
	}
	
	public double cost() {
		Service s = this.get_serv();
		return this.get_duration() * this.get_nbworkers() * s.get_cost();
	}
	/**
	 * Method that runs a task by calling the method debit in the member (patreon) 
	 * @return true if the runs without any problems or false if the task is not ready(no workers or no enough money ) 
	 */
	public boolean runTask() {
		if(this.ready) {
			System.out.println("Running the task");
			return this.patreon.debit(this);
		}else {
			System.out.println("The method can't be run");
			return false;
		}
	}
	//TODO : method to search for suitable workers 
	//TODO : method to start doing the task
	
}