package reseau;

import java.util.ArrayList;

import members.*;
import tasks.*;

public class main {

	public static void main(String[] args) {
		
		//creating a pool of services/skills
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
		skills.add(professor); // 2 professors
		
		//admin has every skill :)
		adminstrator Sam = new adminstrator("Sam", 5000, skills);
		
		//creating preexisting members
		Member abra = new Normal("Abrahim", 2000);
		abra.addSkill(gardener);
		abra.addSkill(builder);
		abra.addSkill(cleaner);
		abra.addSkill(delivery);
		abra.addSkill(painter);
		System.out.println(" ");
		
		Member chelsea = new Half("Chelsea", 2000);
		chelsea.addSkill(gardener);
		chelsea.addSkill(cleaner);
		chelsea.addSkill(painter);
		System.out.println(" ");
		
		Member tom = new Zero("Tom", 2000);
		tom.addSkill(gardener);
		tom.addSkill(cleaner);
		System.out.println(" ");
		
		//creating a pool of tasks
		Task mowing = new Task(gardener, "Mowing the lawn", 3, Sam, 2, "my grass is getting too high", false); // should work just fine
		Task building = new Task(builder, "Building a house", 2, chelsea, 2, "I need a summer house guys", true); //check if chelsea paid half which is = 800 she should have 200 left 
		Task cleaning = new Task(cleaner, "Cleaning", 5, Sam, 2, "I shouldn't have stopped time for 6 months..", false); //this task shouldn't be done because we are missing a cleaner
		Task deliveyT = new Task(delivery, "Delivary", 2, tom, 2, "I need my Pizza NOW", true); // check if tom paid nothing
		Task teaching = new Task(professor, "Teaching", 2, tom, 2, "I need help with homework", false); // should work because we added another professor using admin
		Task painting = new Task(painter, "Painting the fence", 2, abra, 2, "My Fence is ugly ughh !", false); // make sure that only two of our three painters do the job
		Task programming = new Task(programmer, "Programming", 1, Sam, 2, "Sam needs some help with his project", false); // only sam is a programmer so this shouldn't work
		
		ArrayList<Task> tasks = new ArrayList<Task>();
		tasks.add(mowing);
		tasks.add(building);
		tasks.add(cleaning);
		tasks.add(deliveyT);
		tasks.add(teaching);
		tasks.add(painting);
		tasks.add(programming);
		

		//creating a network called mukalla
		Sam.createNetwork("Mukalla");
		System.out.println(" ");
		
		//adding preexisting members
		Sam.addMember(abra);
		Sam.addMember(chelsea);
		Sam.addMember(tom);
		System.out.println(" ");
		
		//creating a new member "Alaa" using admin and adding to him a new skill
		Sam.createMember("Alaa", 500, new Normal());
		Sam.get_member("Alaa").addSkill(professor);
		System.out.println(" ");
		
		//adding the tasks to the network
		Sam.addTaskList(tasks);
		
		//starting the network
		Sam.runAll();
		
		//showing everyone's wallet
		System.out.println(" ");
		System.out.println("Alaa's wallet is at : " + Sam.get_member("Alaa").get_wallet());
		System.out.println("Sam's wallet is at : " + Sam.get_member("Sam").get_wallet());
		System.out.println("Abra's wallet is at : " + Sam.get_member("Abrahim").get_wallet());
		System.out.println("Chelsea's wallet is at : " + Sam.get_member("Chelsea").get_wallet());
		System.out.println("Tom's wallet is at : " + Sam.get_member("Tom").get_wallet());

	}

}
