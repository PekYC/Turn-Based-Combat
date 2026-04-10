package entity;

import java.util.List;

import control.ActionDecider;
import entity.actions.Action;

public abstract class Combatant {
    protected String name;
    protected int hp, maxHp, attack, defense, speed;
    protected ActionDecider decider;
    
    protected int stunDuration = 0;   
    protected int defendDuration = 0; 
    protected int specialCooldown = 0; 
    protected int smokeBombDuration = 0; 
    protected List<StatusEffect> statusEffects;
    
    protected TurnSummary lastTurnSummary = new TurnSummary();

    protected Action selectedAction;
    protected List<Combatant> selectedTargets;

    public Combatant(String name, int hp, int attack, int defense, int speed, ActionDecider decider) {
        this.name = name;
        this.maxHp = hp;
        this.hp = hp;
        this.attack = attack;
        this.defense = defense;
        this.speed = speed;
        this.decider = decider;
    }
    
    
    public int receiveDamage(int rawAtk) {
        if (smokeBombDuration > 0) {
            return 0; 
        }
        
        int currentDef = this.defense;
        if (defendDuration > 0) {
            currentDef += 10; 
        }

        int damageTaken = Math.max(0, rawAtk - currentDef);
        this.hp = Math.max(0, this.hp - damageTaken); 
        return damageTaken;
    }

    public int receiveHealing(int amount) {
        int oldHp = this.hp;
        this.hp = Math.min(this.hp + amount, this.maxHp);
        return this.hp - oldHp; 
    }

    public void updateStatus() {
        if (stunDuration > 0) stunDuration--;
        if (defendDuration > 0) defendDuration--;
        if (specialCooldown > 0) specialCooldown--;
        if (smokeBombDuration > 0) smokeBombDuration--;
    }

    public abstract void performTurn(BattleState state);

    public TurnSummary endTurn() {
        updateStatus(); 
        return lastTurnSummary;
    }


    public void setTurnData(Action action, List<Combatant> targets) {
        this.selectedAction = action;
        this.selectedTargets = targets;
    }

    public boolean isAlive() { return hp > 0; }
    public boolean isStunned() { return stunDuration > 0; }
    public String getName() { return name; }
    public int getSpeed() { return speed; }
    public int getAttack() { return attack; }
    public int getHp() { return hp; }
    public int getMaxHp() { return maxHp; }
    public int getSpecialCooldown() { return specialCooldown; }
    
    public void setStunned(int duration) { this.stunDuration = duration; }
    public void setDefending(int duration) { this.defendDuration = duration; }
    public void setSpecialCooldown(int duration) { this.specialCooldown = duration; }
    public void setSmokeBombDuration(int duration) { this.smokeBombDuration = duration; }
    public void boostAttack(int amount) { this.attack += amount; }
}

