package war.engine;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import war.guilds.Guild;
import war.heroes.AbstractHero;
import war.heroes.Warrior;
import war.heroes.Wizard;

public class War {
	
	// Main class variables
	static List<AbstractHero> heroes = new ArrayList<AbstractHero>();
	static List<Guild> guilds = new ArrayList<Guild>();
	static Scanner in = new Scanner(System.in);
	
	public static void main(String[] args) {

		int selection = -1;
		
		// the main program loop
		while(selection != 0) {
			
			// this will catch all errors emitted by the program
			// not useful for debugging - better to see errors so we can fix them.
			try {
				System.out.println("\nWhat to do?");
				System.out.println("-----------");
				System.out.println("1 - Create Heroes");
				System.out.println("2 - Create a Guild");
				System.out.println("3 - Add Heroes to a Guild");
				System.out.println("4 - View a Guild Roster");
				System.out.println("0 - Exit");
				System.out.println("-----------");
				System.out.print("Your choice: ");
				selection = in.nextInt();
				handleMainRoutes(selection);
			} catch (Exception ex) { // catch all errors
				while(in.hasNext()) {
					in.next();
				}
				selection = -1;
				System.out.println("\nAn exception occurred - returning to main menu.");
			}
		}
		
		// user exits the program, print a summary
		System.out.println("Printing summary and exiting program.");
		for(int i = 0; i < heroes.size(); i++) {
			System.out.println(heroes.get(i).toString());
		}
		
		in.close();
	}
	
	// handles user routing for the main application
	public static void handleMainRoutes(int selection) {
		switch(selection) {
		case 1: 
			createHeroes();
			break;
		case 2:
			createGuilds();
			break;
		case 3:
			addHeroesToGuild();
			break;
		case 4:
			viewGuildRoster();
			break;
		default:
			break;
		}
	}
	
	// create heroes menu
	public static void createHeroes() {
		int selection = -1;
		while(selection != 0) {
			System.out.println("\nWhich hero?");
			System.out.println("-----------");
			System.out.println("1 - Warrior");
			System.out.println("2 - Wizard");
			System.out.println("0 - Back");
			System.out.println("-----------");
			System.out.print("Your choice: ");
			selection = in.nextInt();
			handleHeroCreationRoutes(selection);
		}
	}
	
	// create guild menu
	public static void createGuilds() {
		
		// only if heroes exist to lead the guild
		if(heroes.size() > 0) {
			
			// list the heroes
			System.out.println("\nWho will lead this guild?");
			System.out.println("-------------------------");
			for(int i = 0; i < heroes.size(); i++) {
				System.out.println(i + " - " + heroes.get(i).name);
			}
			System.out.print("The leader will be: ");
			
			// get a guild leader
			int choice = in.nextInt();
			AbstractHero leader = heroes.get(choice);
			
			// name the guild
			System.out.print("\nName this guild: ");
			String name = in.next();
			
			// add the hero
			guilds.add(new Guild(name, leader));
		
		} else {
			System.out.println("\nThere are no heroes to lead this guild.");
		}
	}
	
	// add heroes to a guild
	public static void addHeroesToGuild() {
		
		// only if guilds exist
		if(guilds.size() > 0) {
			
			// list all guilds
			int choice = -1;
			System.out.println("\nGuilds:");
			System.out.println("------");
			for(int i = 0; i < guilds.size(); i++) {
				System.out.println(i + " - " + guilds.get(i).name);
			}
			System.out.print("Join which guild? ");
			
			// get one guild
			choice = in.nextInt();
			Guild guild = guilds.get(choice);
			
			// keep adding heroes until user backs out
			choice = -1;
			while(choice != 0) {
				
				// list all heroes
				System.out.println("Choose heroes to join Guild " + guild.name);
				System.out.println("------------------------------------------");
				for(int i = 0; i < heroes.size(); i++) {
					if(!guild.heroes.contains(heroes.get(i))) {
						System.out.println(i + " - " + heroes.get(i).name);
					}
				}
				System.out.println("0 - Back");
				System.out.print("\nWho will you add? ");
				
				// get one hero
				choice = in.nextInt();
				AbstractHero hero = heroes.get(choice);

				// join the guild
				guild.heroes.add(hero);
				System.out.println("Hero, " + hero.name + ", successfully added.");
			}
			
		} else {
			System.out.println("\nThere are no guilds.");
		}
	}
	
	// print guild details
	public static void viewGuildRoster() {
		
		// only if guilds exist
		if(guilds.size() > 0) {
			
			// list all guilds
			System.out.println("\nWhich guild do you wish to view?");
			System.out.println("------------");
			for(int i = 0; i < guilds.size(); i++) {
				System.out.println(i + " - " + guilds.get(i).name);
			}
			
			// get one guild
			System.out.print("I choose: ");
			int choice = in.nextInt();
			Guild g = guilds.get(choice);
			
			// print the heroes
			for(int i = 0; i < g.heroes.size(); i++) {
				System.out.println(g.heroes.get(i));
			}
		} else {
			System.out.println("\nThere are no guilds.");
		}
	}
	
	// handle hero creation routes
	public static void handleHeroCreationRoutes(int selection) {
		switch(selection) {
		case 1:
			createWarrior();
			break;
		case 2:
			createWizard();
			break;
		default:
			break;
		}
	}
	
	// create warrior hero
	public static void createWarrior() {
		System.out.println("\nWarrior Creation");
		System.out.println("----------------");
		System.out.print("Enter a Name: ");
		String name = in.next();
		heroes.add(new Warrior(name));
	}
	
	// create wizard hero
	public static void createWizard() {
		System.out.println("\nWizard Creation");
		System.out.println("----------------");
		System.out.print("Enter a Name: ");
		String name = in.next();
		heroes.add(new Wizard(name));
	}
}
