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
	
	/**
	 * constructor of a task given all it's requirements except the list of workers
	 * @param s service
	 * @param n name of task
	 * @param nbwo number of workers needed
	 * @param pa patron, the member that is offering the task
	 * @param time the time needed to finish the task
	 * @param desc the description of the task
	 */
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
	
	/**
	 *  constructor of a task given all it's requirements 
	 * @param s service
	 * @param n name of task
	 * @param nbwo number of workers needed
	 * @param pa patron, the member that is offering the task
	 * @param time the time needed to finish the task
	 * @param desc the description of the task
	 * @param l_wo list of members who are going to do the task (workers)
	 */
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
	
	/**
	 * returns the name of the task
	 * @return string
	 */
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
	 * @return member
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
	 * @param n  the network where the task is situated 
	 * @return true if the function runs without any problems or false if the task is not ready(no workers or no enough money ) 
	 */
	public boolean runTask(Network n){
		this.searchWorkers(n);
		if(this.ready) {
			return this.patreon.debit(this);
		}else {
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
			if(l_mem.get(i).get_skills().contains(this.serv) && !( l_mem.get(i).equals(this.get_patreon()) ) ) {
				this.l_workers.add(l_mem.get(i));
			}
			i++;
		}
		if(l_workers.size() == this.nbworkers) {
			
			if(this.patreon instanceof Normal) {
				
				if(this.patreon.get_wallet() >= this.cost()) {
					this.ready=true;
				}else { // if patron has not enough money
					System.out.println("The patron doesn't have enough money !");
					}
			}
			
			if(this.patreon instanceof Half ) { 
				if(this.patreon.get_wallet() >= this.cost()/2) {
					this.ready=true;
				}else { // if patron has not enough money
					System.out.println("The patron doesn't have enough money !");
					}
				
			}
			
			if(this.patreon instanceof Zero) {
				this.ready = true;
			}
			
			
			
		}else { // no enough workers
			System.out.println("There are no enough workers to do the task : " + this.name + " demanded by : " + this.patreon.get_name());
		}
	}
}
