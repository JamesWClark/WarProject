package war.engine;
import java.util.Random;

public class RNG {
	static private Random rng = new Random();

	static public int nextInt(int bound) {
		return rng.nextInt(bound);
	}
}
