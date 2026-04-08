package control;
import java.util.List;
import entity.Combatants;

public interface TurnOrderStrategy {
	public List<Combatants> calculateTurnOrder(List<Combatants> active_combatants);
}
