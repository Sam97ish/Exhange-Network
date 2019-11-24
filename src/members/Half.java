package members;

import java.util.ArrayList;
import tasks.Service;

public class Half extends Member {
	
	//constructor with no skills 
	public Half(String n, int m){
		super(n,m);
	}
	
	//constructor with skills given
	public Half(String n, int m, ArrayList<Service> s){
		super(n,m,s);
	}
	
	//TODO : implementation of abstract method
}
