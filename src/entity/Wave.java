package entity;

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
	
	public List<Combatant> getEnemies() {
		return enemies;
	}
}
