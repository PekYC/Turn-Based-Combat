package entity.actions;

import entity.Combatant;
import entity.Item;
import entity.Potion;
import entity.PowerStone;
import entity.SmokeBomb;
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
		return item.use(user, targets);
	}
}