package com.combat.entity.effect;

import com.combat.entity.combatant.Combatant;

/**
 * Defend effect: +10 DEF for current round and the next round (2-turn duration).
 * Applies the bonus immediately on creation; remove() restores the original defense.
 */
public class DefendEffect implements StatusEffect {

    private static final int DEFENSE_BONUS = 10;
    private int turnsRemaining = 2;
    private boolean bonusApplied = false;

    @Override
    public String getName() { return "Defend"; }

    @Override
    public void apply(Combatant target) {
        if (!bonusApplied) {
            target.setDefense(target.getDefense() + DEFENSE_BONUS);
            bonusApplied = true;
        }
        turnsRemaining--;
    }

    @Override
    public void remove(Combatant target) {
        if (bonusApplied) {
            target.setDefense(target.getDefense() - DEFENSE_BONUS);
        }
    }

    @Override
    public boolean isExpired() { return turnsRemaining <= 0; }

    @Override
    public String getDescription() {
        return "Defending (+10 DEF, " + turnsRemaining + " turn(s) remaining)";
    }
}
