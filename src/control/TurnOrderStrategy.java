package control;
import java.util.List;
import entity.Combatants;
import entity.Wave;

public interface TurnOrderStrategy {
	public List<Combatants> calculateTurnOrder(Wave active_combatants);
}
