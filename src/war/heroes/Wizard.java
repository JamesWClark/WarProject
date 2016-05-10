package war.heroes;
import war.engine.RNG;

public class Wizard extends AbstractHero {

	public Wizard(String name) {
		this.name = name;
		this.hp = 80;
		this.xp = 0;
		this.level = 1;
	}

	@Override
	public void autoAttack(AbstractHero target) {
		target.hp -= 5 + RNG.nextInt(31); // 5 - 35
	}
}
