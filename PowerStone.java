package com.combat.entity.item;

import com.combat.entity.combatant.Combatant;
import com.combat.entity.combatant.Player;
import com.combat.boundary.GameCLI;
import java.util.List;

/**
 * Power Stone: triggers the player's special skill effect once,
 * without starting or changing the cooldown timer.
 */
public class PowerStone implements Item {

    @Override
    public String getName() { return "Power Stone"; }

    @Override
    public String getDescription() { return "Free use of special skill (no cooldown effect)"; }

    @Override
    public void use(Player user, List<Combatant> allCombatants) {
        GameCLI.getInstance().print(user.getName() + " used Power Stone!");
        int savedCooldown = user.getSpecialCooldown();

        // Execute skill effect — SpecialSkill.execute() calls resetCooldown(),
        // so we restore the saved value immediately after.
        List<Combatant> enemies = allCombatants.stream()
                .filter(c -> c instanceof com.combat.entity.combatant.Enemy && c.isAlive())
                .collect(java.util.stream.Collectors.toList());
        Combatant target = enemies.size() == 1
                ? enemies.get(0)
                : GameCLI.getInstance().promptTarget(user, enemies);
        user.getSpecialSkill().executeSkillDirect(user, target, allCombatants);

        // Restore cooldown (Power Stone does NOT affect it)
        restoreCooldown(user, savedCooldown);
    }

    private void restoreCooldown(Player user, int savedCooldown) {
        // Use reflection-free approach: forcibly set cooldown back via a package method
        user.forceCooldown(savedCooldown);
    }
}
