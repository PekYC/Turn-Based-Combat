package entity;

public interface StatusEffect {
    String getName();
    void apply(Combatants target);
    void remove(Combatants target);
    boolean isExpired();
    String getDescription();
}
