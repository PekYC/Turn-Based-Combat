package entity;

public class TurnSummary {
	  private final String attackerName;
	    private final String targetName;
	    private final ActionType actionType; 
	    private final int damageDealt;
	    private final int healAmount;
	    private final boolean targetStunned;
	    private final boolean targetEliminated;
	    private final boolean isAreaEffect;

	    public TurnSummary(String attacker, String target, ActionType type, int damage, int heal, boolean stunned, boolean eliminated, boolean isAoE) {
	        this.attackerName = attacker;
	        this.targetName = target;
	        this.actionType = type;
	        this.damageDealt = damage;
	        this.healAmount = heal;
	        this.targetStunned = stunned;
	        this.targetEliminated = eliminated;
	        this.isAreaEffect = isAoE;
	    }
	    
	    public TurnSummary() {
	        this("", "", null, 0, 0, false, false, false);
	    }

	    // Getters 
	    public String getAttackerName() { return attackerName; }
	    public String getTargetName() { return targetName; }
	    public ActionType getActionType() { return actionType; }
	    public int getDamageDealt() { return damageDealt; }
	    public int getHealAmount() { return healAmount; }
	    public boolean isTargetStunned() { return targetStunned; }
	    public boolean isTargetEliminated() { return targetEliminated; }
	    public boolean isAreaEffect() { return isAreaEffect; }
	}