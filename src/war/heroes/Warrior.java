package war.heroes;
import war.engine.RNG;

public class Warrior extends AbstractHero {

	public Warrior(String name) {
		this.name = name;
		this.hp = 120;
		this.xp = 0;
		this.level = 1;
	}

	@Override
	public void autoAttack(AbstractHero target) {
		if(target instanceof Wizard) {
			target.hp -= 15 + RNG.nextInt(6); // random between 15 - 20
		} else if(target instanceof Warrior) {
			target.hp -= 10 + RNG.nextInt(6); // 10 - 15
		}
	}
}
