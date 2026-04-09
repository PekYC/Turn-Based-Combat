package control;

import java.util.List;
import boundary.UserInterface;
import entity.BattleState;
import entity.BattleStatus;
import entity.Combatants;
import entity.TurnSummary;
import entity.actions.Action;

public class BattleEngine {
    private final BattleState state;
    private final UserInterface ui;
    private final TurnOrderStrategy orderStrategy;

    public BattleEngine(BattleState state, UserInterface ui, TurnOrderStrategy os) {
        this.state = state;
        this.ui = ui;
        this.orderStrategy = os;
    }

    private void endRound() {
        state.incrementRound();
        ui.display(state);
    }

    public void run() {
        while (state.getStatus() == BattleStatus.CONTINUE || state.getStatus() == BattleStatus.WAVE_CLEARED) {
            
            if (state.getStatus() == BattleStatus.WAVE_CLEARED) {
                state.spawnNextWave();
                ui.display(state.getActiveWave());
            }

            List<Combatants> turnOrder = orderStrategy.calculateTurnOrder(state.getAllCombatants());

            for (Combatants c : turnOrder) {
                if (c.isAlive() && state.getStatus() == BattleStatus.CONTINUE) {
                    
                    handleInputIfPlayer(c);
                    
                    c.performTurn(state);
                    TurnSummary summary = c.endTurn();
                    ui.display(summary);

                    if (state.getStatus() != BattleStatus.CONTINUE) {
                        break;
                    }
                }
            }

            if (state.getStatus() == BattleStatus.CONTINUE) {
                endRound();
            }
        }

        ui.endOfBattleReport(state);
    }

    private void handleInputIfPlayer(Combatants c) {
        if (c == state.getPlayer() && !c.isStunned()) {
            Action action = ui.promptAction(c, state);
            List<Combatants> targets = ui.promptTargets(action, c, state);
            c.setTurnData(action, targets);
        }
    }
}
