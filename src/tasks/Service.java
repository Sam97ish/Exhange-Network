package tasks;

public class Service {
	private String name;
	private double cost;
	
	public Service(String n, double c){
		this.name = n;
		this.cost = c;
	}
	
	//TODO: accesseurs
	public String get_name() {
		return this.name;
	} 
	
	public double get_cost() {
		return this.cost;
	} 
}