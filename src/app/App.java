package app;

import boundary.UserInterface;

import java.util.List;

import boundary.CLI_UI;
import control.BattleEngine;
import control.SpeedStrategy;
import entity.BattleState;
import entity.Combatants;
import entity.levels.Level;
import entity.Item;

public class App {
    public static void main(String[] args) {
        // 1. Initialize the UI (Boundary)
        UserInterface ui = new CLI_UI();

        ui.displayLoadingScreen();
        Level difficulty = ui.promptDifficultySelection();
        Combatants characterClass = ui.promptCharacterSelection();
        List<Item> selectedItems = ui.promptItemSelection();
        
        // 2. Initialize the Game State (Entity)
        BattleState state = new BattleState(difficulty, characterClass, selectedItems);

        // 3. Initialize the Engine (Control)
        BattleEngine engine = new BattleEngine(state, ui, new SpeedStrategy());

        // 4. Start the game loop
        engine.run();
    }
}