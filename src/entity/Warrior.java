package entity;

public class Warrior extends Combatants {

    public Warrior() {
        // (name, maxHp, attack, defense, speed)
        super("Warrior", 260, 40, 20, 30);
    }

    // Special Skill: Shield Bash Effect: Deal BasicAttack damage to selected enemy. 
    // Selected enemy is unable to take actions for the current turn and the next turn.
    public void ShieldBash(Combatants target) {
        System.out.println(getName() + " uses Shield Bash on " + target.getName() + "!");
        
        // Deal damage 
        target.takeDamage(this.getAttack());
        
        // Apply stun effect (Current + Next turn)
        target.applyStun(2);
        
        // Start the 3 turns cooldown
        this.startSkillCooldown();
    }
}
