package entity.actions;

import entity.Combatant;
import entity.TurnSummary;
import entity.effects.StunEffect;
import entity.ActionType;
import java.util.List;

public class ShieldBash extends SpecialAbility {
    public ShieldBash() {
		super("Shield Bash", TargetType.SINGLE, 3);
		// TODO Auto-generated constructor stub
	}

	@Override
    public TurnSummary performSpecialEffect(Combatant user, List<Combatant> targets) {
        Combatant target = targets.get(0);
        int initialHP = target.getHp();
        int rawDamage = user.getAttack();
        int damageDealt = target.receiveDamage(rawDamage);
        int finalHP = target.getHp();
        int mitigated = rawDamage - damageDealt;
        
        target.applyStatus(new StunEffect());

        return new TurnSummary(
            user.getName(),
            target.getName(),
            ActionType.SHIELD_BASH,
            damageDealt,
            0,
            true,
            !target.isAlive(),
            false,
            initialHP,
            finalHP,
            rawDamage,
            mitigated
        );
    }
}
	