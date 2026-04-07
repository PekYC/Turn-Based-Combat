package entity;

public abstract class Combatants {
	protected String name;
    protected int hp, maxHp, attack, defense, speed;
    
    // Status tracking 
    protected int stunDuration = 0;   // Unable to act for current and next turn
    protected int defendDuration = 0; // +10 DEF for current and next round 
    protected int specialCooldown = 0; // Cooldown for special skills 
    protected TurnSummary lastTurnSummary;

    public Combatants(String name, int hp, int attack, int defense, int speed) {
        this.name = name;
        this.maxHp = hp;
        this.hp = hp;
        this.attack = attack;
        this.defense = defense;
        this.speed = speed;
    }

     // Damage = max(0, Attacker Atk - Target Def) 
     // HP clamping at 0
    public int receiveDamage(int rawAtk) {
        int currentDef = this.defense;
        if (defendDuration > 0) {
            currentDef += 10; // Defend bonus 
        }

        int damageTaken = Math.max(0, rawAtk - currentDef);
        this.hp = Math.max(0, this.hp - damageTaken); 
        return damageTaken;
    }

     // New HP = min(Current + Heal, Max HP) 
    public int receiveHealing(int amount) {
        int oldHp = this.hp;
        this.hp = Math.min(this.hp + amount, this.maxHp);
        return this.hp - oldHp; 
    }

    public void updateStatus() {
        if (stunDuration > 0) stunDuration--;
        if (defendDuration > 0) defendDuration--;
        if (specialCooldown > 0) specialCooldown--;
    }

    public abstract void performTurn(BattleState state);

    public TurnSummary endTurn() {
        updateStatus(); 
        return lastTurnSummary;
    }

    // Getters & Setters
    public boolean isAlive() { return hp > 0; }
    public boolean isStunned() { return stunDuration > 0; }
    public String getName() { return name; }
    public int getSpeed() { return speed; }
    public int getAttack() { return attack; }
    public int getHp() { return hp; }
    public int getSpecialCooldown() { return specialCooldown; }
    
    public void setStunned(int duration) { this.stunDuration = duration; }
    public void setDefending(int duration) { this.defendDuration = duration; }
    public void setSpecialCooldown(int duration) { this.specialCooldown = duration; }
    public void boostAttack(int amount) { this.attack += amount; }
}

