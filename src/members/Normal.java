package members;

import java.util.ArrayList;
import tasks.Service;

public class Normal extends Member {
	
	//constructor with no skills 
	public Normal(String n, int m){
		super(n,m);
	}
	
	//constructor with skills given
	public Normal(String n, int m, ArrayList<Service> s){
		super(n,m,s);
	}
	
	//TODO : implementation of abstract method

}
