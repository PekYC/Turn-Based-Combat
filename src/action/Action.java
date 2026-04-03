package action;

import entity.Combatants;
import java.util.List;

public interface Action {
    void execute(Combatants user, List<Combatants> targets);
}
