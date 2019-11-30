package reseau;

import java.util.ArrayList;

import members.*;
import tasks.*;

public class main {

	public static void main(String[] args) {
		
		Service gardener = new Service("gardening", 50);
		Service painter = new Service("Painting", 100);
		Service cleaner = new Service("cleaning", 5);
		Service builder = new Service("building", 200);
		Service driver = new Service("driving", 50);
		Service babysitter = new Service("babysitting", 10);
		Service delivery = new Service("derlivering", 50);
		Service accountant = new Service("accounting", 300);
		Service programmer = new Service("programming", 300);
		Service professor = new Service("teaching", 300);
		
		ArrayList<Service> skills = new ArrayList<Service>();
		skills.add(gardener);  // 4 gardeners
		skills.add(builder);   // 2 builders
		skills.add(cleaner);   //4 cleaners
		skills.add(delivery);  // 2 delivery
		skills.add(painter);  // 3 painters
		skills.add(driver);  // all the rest only the admin can do so one of each
		skills.add(babysitter);
		skills.add(accountant);
		skills.add(programmer);
		skills.add(professor);
		
		Member abra = new Normal("Abrahim", 500);
		abra.addSkill(gardener);
		abra.addSkill(builder);
		abra.addSkill(cleaner);
		abra.addSkill(delivery);
		abra.addSkill(painter);
		
		Member chelsea = new Half("Chelsea", 500);
		chelsea.addSkill(gardener);
		chelsea.addSkill(cleaner);
		chelsea.addSkill(painter);
		
		Member tom = new Zero("Chelsea", 500);
		tom.addSkill(gardener);
		tom.addSkill(cleaner);
		
		
		//admin has every skill :)
		adminstrator Sam = new adminstrator("Sam",500, skills);
		
		Sam.createNetwork("Mukalla");
		
		Sam.addMember(abra);
		Sam.addMember(chelsea);
		Sam.addMember(tom);
		
		
		/*
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
		
		*/
	}

}
 