package entity.levels;

import java.util.ArrayList;
import java.util.List;

import entity.Combatant;
import entity.Goblin;
import entity.Wave;
import entity.Wolf;

public class Hard extends Level {
	public Hard() {
		super("Hard");

		List<Combatant> firstWave = new ArrayList<>();
		firstWave.add(new Goblin("A"));
		firstWave.add(new Goblin("B"));
		
		List<Combatant> secondWave = new ArrayList<>();
		secondWave.add(new Goblin("C"));
		secondWave.add(new Wolf("A"));
		secondWave.add(new Wolf("B"));
		
		this.waves.add(new Wave(firstWave));
		this.waves.add(new Wave(secondWave));
	}
}
