package entity.actions;

import entity.Combatant;
import entity.Item;
import entity.Player;
import entity.TurnSummary;

import java.util.List;

public class UseItemAction extends Action {
	private Item item;

	public UseItemAction(Item item) {
		super("Use Item", item.getTargeting()); 
		this.item = item;
	}

	@Override
	public TurnSummary execute(Combatant user, List<Combatant> targets) {
		((Player) user).removeItem(item);
		return item.use(user, targets);
	}
}