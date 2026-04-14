package entity.levels;

import java.util.ArrayList;
import java.util.List;

import entity.Combatant;
import entity.Goblin;
import entity.Wave;

public class Easy extends Level {
	public Easy() {
		super("Easy");

		List<Combatant> firstWave = new ArrayList<>();
		firstWave.add(new Goblin("A"));
		firstWave.add(new Goblin("B"));
		firstWave.add(new Goblin("C"));
		
		this.waves.add(new Wave(firstWave));
	}
}
