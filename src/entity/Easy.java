package entity;

import java.util.ArrayList;
import java.util.List;

public class Easy extends Level {
	public Easy() {
		super("Easy");

		List<Combatants> firstWave = new ArrayList<>();
		firstWave.add(new Goblin("A"));
		firstWave.add(new Goblin("B"));
		firstWave.add(new Goblin("C"));
		
		this.waves.add(new Wave(firstWave));
	}
}
