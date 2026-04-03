package control;

import java.util.List;
import java.util.Comparator;

import entity.Combatant;

public class SpeedStrategy implements TurnOrderStrategy {
	@Override
	public List<Combatant> calculateTurnOrder(List<Combatant> active_combatants) {
		active_combatants.sort(Comparator.comparingInt(Combatant::getSpeed).reversed());
		return active_combatants;
	}
}
