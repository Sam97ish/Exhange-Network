package tasks;

import java.util.ArrayList;
import members.*;
import reseau.Network;

public class Task {
	private String name;
	private Service serv;
	private int nbworkers;
	private Member patreon;
	private double duration;
	private ArrayList<Member> l_workers;
	private String description;
	private boolean ready;
	
	//constructor with an empty array
	public Task(Service s,String n , int nbwo, Member pa, double time, String desc) {
		this.serv = s;
		this.nbworkers = nbwo;
		this.patreon = pa;
		this.duration = time;
		this.description = desc;
		this.name =n;
		
		this.l_workers = new ArrayList<Member>();
		this.ready = false;
	}
	
	//constructor with list of workers given
	public Task(Service s,String n , int nbwo, Member pa, double time, String desc, ArrayList<Member> l_wo) {
		this.serv = s;
		this.nbworkers = nbwo;
		this.patreon = pa;
		this.duration = time;
		this.description = desc;
		this.name = n;
		
		this.l_workers = l_wo;
		this.ready = false;
	}
	
	public String get_name() {
		return this.name;
	}
	/**
	 * return the service or the job of the task
	 * @return Service
	 */
	public Service get_serv() {
		return this.serv;
	}
	 /**
	  * return the number of workers needed to do the task
	  * @return nbWorkers 
	  */
	public int get_nbworkers() {
		return this.nbworkers;
	}
	/**
	 * returns the list of workers that will do the task
	 * @return l_workers
	 */
	public ArrayList<Member> get_l_worker(){
		return this.l_workers;
	}
	
	/**
	 * returns the patron of task
	 * 
	 * @return patreon
	 */
	public Member get_patreon() {
		return this.patreon;
	}
	/**
	 * returns the duration of the task
	 * @return duration
	 */
	public double get_duration() {
		return this.duration;
	}
	/**
	 * returns the description of the task
	 * @return description
	 */
	public String get_description() {
		return this.description;
	}
	/**
	 * returns the final cost of the task whcih is duration * nb of workers * standard cost of the service/job
	 * @return
	 */
	public double cost() {
		Service s = this.get_serv();
		return this.get_duration() * this.get_nbworkers() * s.get_cost();
	}
	/**
	 * Method that runs a task by calling the method debit in the member (patreon) 
	 * @return true if the function runs without any problems or false if the task is not ready(no workers or no enough money ) 
	 */
	public boolean runTask(){
		if(this.ready) {
			return this.patreon.debit(this);
		}else {
			System.out.println("there are no enough workers or the patron has not enough money !");
			return false;
		}
	}
	/**
	 * method that search and add workers that can provide the service needed and verifies whether the task is ready or not
	 * @param n refers to the network
	 */
	public void searchWorkers(Network n) {
		ArrayList<Member> l_mem = n.get_members();
		int i=0;
		while(i < l_mem.size() && this.l_workers.size() <= this.nbworkers) {
			if(l_mem.get(i).get_skills().contains(this.serv)) {
				this.l_workers.add(l_mem.get(i));
			}
			i++;
		}
		if(l_workers.size() == this.nbworkers) {
			if(this.patreon instanceof Normal && this.patreon.get_wallet() >= this.cost()) {  // for members of the class normal
				this.ready=true;
				
			}else if(this.patreon instanceof Half && this.patreon.get_wallet() >= this.cost()/2) {  // for members of the class half
				this.ready=true;
			}else {  // for members of the class zero
				this.ready=true;
			}
			
		}
	}
	
	
}