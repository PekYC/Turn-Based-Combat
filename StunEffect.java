package com.combat.entity.effect;

import com.combat.entity.combatant.Combatant;

/**
 * Stun: prevents the affected entity from taking actions for the current
 * turn and the next turn (2-turn duration).
 *
 * Applied at the start of the affected combatant's turn.
 * BattleEngine checks hasEffect("Stun") to skip that combatant's action.
 */
public class StunEffect implements StatusEffect {

    private int turnsRemaining = 2;

    @Override
    public String getName() { return "Stun"; }

    @Override
    public void apply(Combatant target) {
        // Just tick down. BattleEngine checks for stun before letting combatant act.
        turnsRemaining--;
    }

    @Override
    public void remove(Combatant target) {
        // No stat to revert for stun.
    }

    @Override
    public boolean isExpired() { return turnsRemaining <= 0; }

    @Override
    public String getDescription() {
        return "Stunned — cannot act (" + turnsRemaining + " turn(s) remaining)";
    }
}
