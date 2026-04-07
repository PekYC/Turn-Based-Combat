package control;

import java.util.List;
import java.util.Comparator;

import entity.Combatants;

public class SpeedStrategy implements TurnOrderStrategy {
	@Override
	public List<Combatants> calculateTurnOrder(List<Combatants> active_combatants) {
		active_combatants.sort(Comparator.comparingInt(Combatants::getSpeed).reversed());
		return active_combatants;
	}
}
