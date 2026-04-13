package entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;

import control.ActionDecider;
import control.EndTurnHandler;

public abstract class Combatant implements EndTurnHandler {
    protected String name;
    protected int hp, maxHp, attack, defense, speed;
    protected ActionDecider decider;
    
    protected int stunDuration = 0;  
    protected int smokeBombDuration = 0; 
    protected List<StatusEffect> statusEffects = new ArrayList<>();

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

        int damageTaken = Math.max(0, rawAtk - currentDef);
        this.hp = Math.max(0, this.hp - damageTaken); 
        return damageTaken;
    }

    public int receiveHealing(int amount) {
        int oldHp = this.hp;
        this.hp = Math.min(this.hp + amount, this.maxHp);
        return this.hp - oldHp; 
    }

    public TurnSummary performTurn(BattleState state) {
    	for (StatusEffect s: this.statusEffects) {
    		s.onStartTurn();
    	}
    	
    	
        if (isStunned()) {
        	return new TurnSummary(
                this.name,
                this.name,
                ActionType.STUNNED_SKIP,
                0,
                0,
                false,
                false,
                false,
                this.hp,
                this.hp,
                0,
                0
            );
        }
        
        return decider.decide(this, state);
    };

    public void endTurn() {
    	Iterator<StatusEffect> it = statusEffects.iterator();
    	
    	while(it.hasNext()) {
    		StatusEffect s = it.next();
    		s.endTurn();
    		
    		if (s.isExpired()) {
    			it.remove();
    		}
    	}
    }

    public boolean isAlive() { return hp > 0; }
    public boolean isStunned() { return stunDuration > 0; }
    public String getName() { return name; }
    public int getSpeed() { return speed; }
    public int getAttack() { return attack; }
    public int getHp() { return hp; }
    public int getMaxHp() { return maxHp; }
    public int getDefense() { return defense; }

    public void changeDefense(int change) { this.defense += change; }
	public void changeAttack(int change) { this.attack += change; }
    public void applyStatus(StatusEffect status) {
    	status.setTarget(this);
    	this.statusEffects.add(status);
    	status.onApply();
    }
    public void setStunned(int duration) { this.stunDuration = duration; }
    public void setSmokeBombDuration(int duration) { this.smokeBombDuration = duration; }
    public void boostAttack(int amount) { this.attack += amount; }


}

