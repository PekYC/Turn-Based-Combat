package control;
import java.util.List;
import entity.Combatant;

public interface TurnOrderStrategy {
	public List<Combatant> calculateTurnOrder(List<Combatant> active_combatants);
}
