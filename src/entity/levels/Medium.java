package entity.levels;

import java.util.ArrayList;
import java.util.List;

import entity.Combatants;
import entity.Goblin;
import entity.Wave;
import entity.Wolf;

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
