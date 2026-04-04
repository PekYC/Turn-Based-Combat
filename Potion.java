package com.combat.entity.item;

import com.combat.entity.combatant.Combatant;
import com.combat.entity.combatant.Player;
import com.combat.boundary.GameCLI;
import java.util.List;

/** Potion: heal 100 HP, capped at max HP. */
public class Potion implements Item {

    private static final int HEAL_AMOUNT = 100;

    @Override
    public String getName() { return "Potion"; }

    @Override
    public String getDescription() { return "Restores 100 HP (capped at max HP)"; }

    @Override
    public void use(Player user, List<Combatant> allCombatants) {
        int before = user.getCurrentHp();
        user.heal(HEAL_AMOUNT);
        int healed = user.getCurrentHp() - before;
        GameCLI.getInstance().print(user.getName() + " used Potion! HP: "
                + before + " → " + user.getCurrentHp() + " (+" + healed + ")");
    }
}
