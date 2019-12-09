package networkExceptions;

public class ExceptionNotEnoughWorkers extends Exception{
	
	public ExceptionNotEnoughWorkers(String msg) {
		super(msg);
	}
}