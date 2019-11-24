package reseau;

import java.util.ArrayList;
import members.*;
import tasks.*;

public class Network {
	private Member admin;
	private ArrayList<Member> l_members;
	private ArrayList<Task> l_tasks;
	
	//constructor with empty lists
	public Network(Member adm) {
		this.admin = adm;
		
		this.l_members = new ArrayList<Member>();
		this.l_tasks = new ArrayList<Task>();
	}
	
	//constructor with full lists given
	public Network(Member adm, ArrayList<Member> l_m, ArrayList<Task> l_t) {
		this.admin = adm;
		
		this.l_members = l_m;
		this.l_tasks = l_t;
	}
	
	//TODO : possible methods.
}
