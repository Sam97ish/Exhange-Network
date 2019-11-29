package members;

import java.util.ArrayList;
import tasks.Service;
import tasks.Task;

public class Half extends Member {
	
	//constructor with no skills 
	public Half(String n, int m){
		super(n,m);
	}
	
	//constructor with skills given
	public Half(String n, int m, ArrayList<Service> s){
		super(n,m,s);
	}

	@Override
	public boolean debit(Task tache) {
		double finalcost = tache.cost(); // C * D * P
		finalcost = finalcost/2;
		double paycheck = finalcost / tache.get_nbworkers();
		
		
		//paying the workers for a job well done.
		ArrayList<Member> l_workers = tache.get_l_worker();
		for(int i = 0; i < l_workers.size(); i++) {
			l_workers.get(i).addMoney(paycheck);
			System.out.println("the worker : " + l_workers.get(i).get_name() + " has been payed : " + paycheck
								+ " by : " + this.get_name() + " for the job : " + tache.get_serv().get_name());
		}
		
		System.out.println(this.get_name() + " has payed half the price " + finalcost + " for job's description : " + tache.get_description());
		return this.substractMoney(-finalcost);
	}
	
	
}
