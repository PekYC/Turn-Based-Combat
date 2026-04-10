package app;

import boundary.UserInterface;
import boundary.CLI_UI;
import control.BattleEngine;
import control.SpeedStrategy;
import entity.BattleState;
import entity.Player;
import entity.levels.Level;
import entity.levels.Easy;
import entity.levels.Medium;
import entity.levels.Hard;

public class App {
    public static void main(String[] args) {
        // 1. Initialize the UI (Boundary)
        UserInterface ui = new CLI_UI();
        ui.displayLoadingScreen();

        // Difficulty: CLI_UI returns int, convert to Level
        int diffChoice = ui.promptDifficultySelection();
        Level difficulty = switch (diffChoice) {
            case 1 -> new Easy();
            case 2 -> new Medium();
            default -> new Hard();
        };

        // Character: CLI_UI returns the Combatant object directly
        Player characterClass = ui.promptCharacterSelection();

        // Items: CLI_UI returns List<Item> directly
        characterClass.giveItems(ui.promptItemSelection());

        // 2. Initialize the Game State (Entity)
        BattleState state = new BattleState(difficulty, characterClass);

        // 3. Initialize the Engine (Control)
        BattleEngine engine = new BattleEngine(state, ui, new SpeedStrategy());

        // 4. Start the game loop
        engine.run();
    }
}