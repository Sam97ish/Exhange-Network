package members;

import java.util.ArrayList;

import tasks.Service;
import tasks.Task;

public class Zero extends Member {
	
	//constructor with no skills 
	public Zero(String n, int m){
		super(n,m);
	}
	
	//constructor with skills given
	public Zero(String n, int m, ArrayList<Service> s){
		super(n,m,s);
	}

	@Override
	public boolean debit(Task tache) {
		System.out.println(" this memeber is privilege enought to not pay a dime !");
		return true;
	}
	
	
}
