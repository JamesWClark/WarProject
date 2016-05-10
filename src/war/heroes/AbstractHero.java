package war.heroes;

import war.guilds.Guild;

public abstract class AbstractHero {

	public int hp;
	public int xp;
	public int level;
	public String name;
	public Guild guild;
	
	public abstract void autoAttack(AbstractHero target);
	
	@Override
	public String toString() {
		return this.getClass().getSimpleName() + ": Name = " + this.name + ", Level = " + this.level + ", HP = " + this.hp + ", XP = " + this.xp;
	}
}
