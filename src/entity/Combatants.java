package entity;

public abstract class Combatants {
	private String name;
    private int hp;
    private int maxHp;
    private int attack;
    private int defense;
    private int speed;

    // Status effects
    private boolean isStunned = false;
    private int stunDuration = 0;
    private boolean isDefending = false;
    private int skillCooldown = 0;

    public Combatants(String name, int maxHp, int attack, int defense, int speed) {
        this.name = name;
        this.maxHp = maxHp;
        this.hp = maxHp; 
        this.attack = attack;
        this.defense = defense;
        this.speed = speed;
    }

    public void takeDamage(int incomingAttack) {
        // While defending, provide boost
        int effectiveDefense = isDefending ? (this.defense + 10) : this.defense;

        // Formula: Damage = max(0, Attacker Attack - Target Defense)
        int damageDealt = Math.max(0, incomingAttack - effectiveDefense);

        this.hp -= damageDealt;

        // HP never drops below 0
        if (this.hp < 0) this.hp = 0;

        System.out.println(this.name + " takes " + damageDealt + " damage! [HP: " + this.hp + "/" + this.maxHp + "]");
    }

    // Item implementation
    public void heal(int amount) {
        this.hp += amount;
        // HP cannot exceed maximum HP
        if (this.hp > this.maxHp) this.hp = this.maxHp;
        System.out.println(this.name + " healed for " + amount + ". [HP: " + this.hp + "/" + this.maxHp + "]");
    }

    // Status management 
    public void updateTurnStatus() {
        if (stunDuration > 0) {
            stunDuration--;
            if (stunDuration == 0) isStunned = false;
        }
        if (skillCooldown > 0) {
            skillCooldown--;
        }
        isDefending = false; 
    }

    public String getName() { return name; }
    public int getHp() { return hp; }
    public int getAttack() { return attack; }
    public void setAttack(int newAtk) { this.attack = newAtk; } 
    public int getSpeed() { return speed; }
    public boolean isStunned() { return isStunned; }
    public void applyStun(int duration) { this.isStunned = true; this.stunDuration = duration; }
    public void setDefending(boolean state) { this.isDefending = state; }
    public int getSkillCooldown() { return skillCooldown; }
    public void startSkillCooldown() { this.skillCooldown = 3; } 
}

