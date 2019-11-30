package members;

import java.util.ArrayList;
import tasks.Service;
import tasks.Task;

public class Normal extends Member {
	
	/**
	 * contractor of the member of type normal with no skills given
	 * @param n name
	 * @param m money 
	 */
	public Normal(String n, int m){
		super(n,m);
	}
	
	/**
	 * contractor of the member of type normal with  skills given
	 * @param n name
	 * @param m money 
	 * @param s list of skills
	 */
	public Normal(String n, int m, ArrayList<Service> s){
		super(n,m,s);
	}
	
	/**
	 * constructor with nothing given used only by administrators
	 */
	public Normal() {
		super("",0);
	}
	

	@Override
	public boolean debit(Task tache) {
		double finalcost = tache.cost(); // C * D * P
		double paycheck = finalcost / tache.get_nbworkers();
		
		//paying the workers for a job well done.
		ArrayList<Member> l_workers = tache.get_l_worker();
		for(int i = 0; i < l_workers.size(); i++) {
			l_workers.get(i).addMoney(paycheck);
			System.out.println("The worker : " + l_workers.get(i).get_name() + " has been paid : " + paycheck
								+ " by : " + this.get_name() + " for the job : " + tache.get_serv().get_name());
		}
		
		System.out.println(this.get_name() + " has paid " + finalcost + " for the job : " + tache.get_name() + ", Description : " + tache.get_description());
		return this.substractMoney(-finalcost);
	}



}

