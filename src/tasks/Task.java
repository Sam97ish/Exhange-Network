package tasks;

import java.util.ArrayList;
import members.*;
import reseau.Network;

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
	
	public ArrayList<Member> get_l_worker(){
		return this.l_workers;
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
	public boolean runTask(){
		if(this.ready) {
			System.out.println("Running the task");
			return this.patreon.debit(this);
		}else {
			System.out.println("The task can't be run");
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
				
			}else if(this.patreon instanceof Half && this.patreon.get_wallet()/2 >= this.cost()) {  // for members of the class half
				this.ready=true;
			}else {  // for members of the class zero
				this.ready=true;
			}
			
		}
	}
	
	
}