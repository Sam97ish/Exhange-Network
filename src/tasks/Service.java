package tasks;

public class Service {
	private String name;
	private double cost;
	
	public Service(String n, double c){
		this.name = n;
		this.cost = c;
	}
	
	/**
	 * returns the name of the service
	 * @return string
	 */
	public String get_name() {
		return this.name;
	} 
	
	/**
	 * returns the standard cost of the service
	 * @return double
	 */
	public double get_cost() {
		return this.cost;
	} 
}