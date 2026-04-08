package control;

import java.util.List;
import java.util.Comparator;

import entity.Combatants;
import entity.Wave;

public class SpeedStrategy implements TurnOrderStrategy {
	@Override
	public List<Combatants> calculateTurnOrder(Wave active_combatants) {
		active_combatants.sort(Comparator.comparingInt(Combatants::getSpeed).reversed());
		return active_combatants;
	}
}
