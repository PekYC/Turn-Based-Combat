package entity;

import java.util.ArrayList;
import java.util.List;

public class Medium extends Level {
	public Medium() {
		super("Medium");

		List<Combatants> firstWave = new ArrayList<>();
		firstWave.add(new Goblin("A"));
		firstWave.add(new Wolf("A"));
		
		List<Combatants> secondWave = new ArrayList<>();
		secondWave.add(new Wolf("B"));
		secondWave.add(new Wolf("C"));
		
		this.waves.add(new Wave(firstWave));
		this.waves.add(new Wave(secondWave));
	}
}
