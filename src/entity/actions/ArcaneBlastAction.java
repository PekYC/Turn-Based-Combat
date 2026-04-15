package entity.actions;

import entity.Combatant;
import entity.TurnSummary;
import entity.ArcaneBlastEffect;

import java.util.List;

public class ArcaneBlastAction extends SpecialAbility {
    public ArcaneBlastAction() {
		super("Arcane Blast", TargetType.MULTI, 3);
	}

	@Override
    public TurnSummary performSpecialEffect(Combatant user, List<Combatant> targets) {
		int number_killed = 0;
		int damageDealt_temp = 0;
		int initialHP_temp = 0;
		int finalHP_temp = 0;
		int rawDamage_temp = 0;
		int mitigated_temp = 0;
		
		for (Combatant c: targets) {
	        int initialHP = c.getHp();
	        int rawDamage = user.getAttack();
	        int damageDealt = c.receiveDamage(rawDamage);
	        int finalHP = c.getHp();
	        int mitigated = rawDamage - damageDealt;
	        if (!c.isAlive()) {
	        	number_killed++;
	        }   
		}
		
	    for (int i = 0; i < number_killed; i++) {
	    	user.applyStatus(new ArcaneBlastEffect());
	    }
		
		

        return new TurnSummary(
            user.getName(),
            targets.get(0).getName(),
            ActionType.ARCANE_BLAST,
            damageDealt_temp,
            0,
            false,
            !targets.get(0).isAlive(),
            false,
            initialHP_temp,
            finalHP_temp,
            rawDamage_temp,
            mitigated_temp
        );
    }
}