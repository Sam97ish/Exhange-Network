package reseau;

import java.util.ArrayList;

import members.*;
import tasks.*;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Member Sam = new Normal("Sam",400);
		Member abra = new Normal("abra",400);
		
		Sam.addMoney(100);
		System.out.println("Sam's Money : " + Sam.get_wallet());
		
		Service jardinage = new Service("Jardinage", 250);
		Sam.addSkill(jardinage);
		ArrayList<Member> l_workers = new ArrayList<Member>();
		l_workers.add(Sam);
		Task mowing = new Task(jardinage,"mowing the lawn", 1, abra, 1, "jardinage", l_workers);
		
		abra.debit(mowing);
		
		System.out.println("Sam's Money : " + Sam.get_wallet());
		System.out.println("Abra's Money : " + abra.get_wallet());
		
		
	}

}
 