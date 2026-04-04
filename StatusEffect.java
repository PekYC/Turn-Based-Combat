package com.combat.entity.effect;

import com.combat.entity.combatant.Combatant;

/**
 * StatusEffect interface — OCP: new effects can be added without modifying BattleEngine.
 * ISP: only the methods effects actually need are declared here.
 */
public interface StatusEffect {

    String getName();

    /**
     * Called once per turn when this effect is active.
     * The effect modifies the combatant's state as needed.
     */
    void apply(Combatant target);

    /**
     * Called when the effect expires.
     * Allows the effect to revert any stat changes it made.
     */
    void remove(Combatant target);

    /** Returns true once the effect's duration has fully elapsed. */
    boolean isExpired();

    /** Human-readable description for the UI. */
    String getDescription();
}
