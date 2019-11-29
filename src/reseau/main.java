package reseau;

import members.*;
import tasks.*;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Member Sam = new Normal("Sam",400);
		Member abra = new Normal("abra",400);
		
		Sam.addMoney(100);
		
		
		Service jardinage = new Service("Jardinage", 250);
		Sam.addSkill(jardinage);
		
		Task mowing = (Task) abra.createTask(jardinage, 1, 1, "mowing the lawn");
		
		Sam.debit(mowing);
		
		System.out.println("Sam's Money : " + abra.get_wallet());
		System.out.println("Abra's Money : " +Sam.get_wallet());
		
		
	}

}
