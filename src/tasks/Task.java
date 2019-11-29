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
	
	//constructor with an empty array
	public Task(Service s, int nbwo, Member pa, double time, String desc) {
		this.serv = s;
		this.nbworkers = nbwo;
		this.patreon = pa;
		this.duration = time;
		this.description = desc;
		
		this.l_workers = new ArrayList<Member>();
	}
	
	//constructor with list of workers given
	public Task(Service s, int nbwo, Member pa, double time, String desc, ArrayList<Member> l_wo) {
		this.serv = s;
		this.nbworkers = nbwo;
		this.patreon = pa;
		this.duration = time;
		this.description = desc;
		
		this.l_workers = l_wo;
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
	
	//TODO : method to calculate the real value (c*d*p)
	public double cost() {
		Service s = this.get_serv();
		return this.get_duration() * this.get_nbworkers() * s.get_cost();
	}
	//TODO : method to search for suitable workers 
	//TODO : method to start doing the task
	
}