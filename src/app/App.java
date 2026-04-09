package app;

import boundary.UserInterface;
import boundary.CLI_UI;
import control.BattleEngine;
import control.SpeedStrategy;
import entity.BattleState;
import entity.Combatants;
import entity.Warrior;
import entity.Wizard;
import entity.Item;
import entity.Potion;
import entity.PowerStone;
import entity.SmokeBomb;
import entity.levels.Level;
import entity.levels.Easy;
import entity.levels.Medium;
import entity.levels.Hard;
import java.util.ArrayList;
import java.util.List;

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

        // Character: CLI_UI returns int, convert to Combatants
        int charChoice = ui.promptCharacterSelection();
        Combatants characterClass = charChoice == 1 ? new Warrior() : new Wizard();

        // Items: CLI_UI returns List<String>, convert to List<Item>
        List<String> itemNames = ui.promptItemSelection();
        List<Item> selectedItems = new ArrayList<>();
        for (String name : itemNames) {
            selectedItems.add(switch (name) {
                case "Potion"      -> new Potion();
                case "Power Stone" -> new PowerStone();
                default            -> new SmokeBomb();
            });
        }

        // 2. Initialize the Game State (Entity)
        BattleState state = new BattleState(difficulty, characterClass, selectedItems);

        // 3. Initialize the Engine (Control)
        BattleEngine engine = new BattleEngine(state, ui, new SpeedStrategy());

        // 4. Start the game loop
        engine.run();
    }
}