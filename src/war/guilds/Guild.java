package war.guilds;

import java.util.ArrayList;
import java.util.List;

import war.heroes.AbstractHero;

public class Guild {
	
	// a list of heroes in this guild
	public List<AbstractHero> heroes = new ArrayList<AbstractHero>();
	public String name; // name of the guild
	public AbstractHero leader; // the guild leader
	
	// constructor
	public Guild(String name, AbstractHero leader) {
		this.name = name;
		this.leader = leader;
		this.heroes.add(leader);
	}
}
