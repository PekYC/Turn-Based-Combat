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
		super("Use Item", TargetType.SELF); 
		this.item = item;
	}

	@Override
	public TurnSummary execute(Combatant user, List<Combatant> targets) {
		int initialHp = user.getHp();
		int healAmount = 0;

		if (item instanceof Potion) {			
			healAmount = user.receiveHealing(50);
			System.out.println(user.getName() + " drank a Potion and recovered " + healAmount + " HP!");
		} 
		else if (item instanceof PowerStone) {
			user.boostAttack(10);
			System.out.println(user.getName() + " crushed a Power Stone! Attack power increased!");
		} 
		else if (item instanceof SmokeBomb) {
			user.setSmokeBombDuration(1);
			System.out.println(user.getName() + " threw a Smoke Bomb! They will dodge the next attack!");
		}

		int finalHp = user.getHp();

		return new TurnSummary(
			user.getName(), 
			user.getName(), 
			ActionType.ITEM_USE, 
			0,             // damageDealt
			healAmount,    // healAmount
			false,         // targetStunned
			false,         // targetEliminated
			false,         // isAreaEffect
			initialHp,     // initialHP
			finalHp,       // finalHP
			0,             // rawDamage
			0              // mitigatedAmount
		);
	}
}