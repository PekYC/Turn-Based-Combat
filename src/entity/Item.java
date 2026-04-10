package entity;

public interface Item {
    String getName();
    String getDescription();
    void use(Combatant user);
}
