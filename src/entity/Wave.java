package entity;

import java.util.List;

public class Wave {
	private List<Combatants> enemies;

	public Wave(List<Combatants> enemies) {
		this.enemies = enemies;
	}
	
	public boolean isDefeated() {
		for (Combatants c : enemies) {
			if (c.isAlive()) {
				return false;
			}
		}
		return true;
	}
}
