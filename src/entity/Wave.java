package entity;

import java.util.ArrayList;
import java.util.List;

public class Wave {
	private List<Combatant> enemies;

	public Wave(List<Combatant> enemies) {
		this.enemies = enemies;
	}
	
	public boolean isDefeated() {
		for (Combatant c : enemies) {
			if (c.isAlive()) {
				return false;
			}
		}
		return true;
	}
	
	public List<Combatant> getEnemies(boolean active) {
		if (active) {
			List<Combatant> output = new ArrayList<>();
			for (Combatant c: enemies) {
				if (c.isAlive()) {
					output.add(c);
				}
			}
			return output;
		} else {
			return enemies;
		}
	}
}
