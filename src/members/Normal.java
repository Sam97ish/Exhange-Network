package members;

import java.util.ArrayList;
import tasks.Service;
import tasks.Task;

public class Normal extends Member {
	
	//constructor with no skills 
	public Normal(String n, int m){
		super(n,m);
	}
	
	//constructor with skills given
	public Normal(String n, int m, ArrayList<Service> s){
		super(n,m,s);
	}

	@Override
	public boolean debit(Task tache) {
		//TODO : must add money to workers
		double finalcost = tache.cost(); // C * D * P
		System.out.println(this.get_name() + " has payed " + finalcost + " to " + tache.get_patreon().get_name() 
							+ " for job's description : " + tache.get_description());
		return this.substractMoney(-finalcost);
	}



}

