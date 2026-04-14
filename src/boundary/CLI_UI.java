package boundary;

import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import entity.Combatants;
import entity.Wave;
import entity.BattleState;
import entity.TurnSummary;
import entity.Warrior;
import entity.Wizard;
import entity.Item;
import entity.Potion;
import entity.PowerStone;
import entity.SmokeBomb;

public class CLI_UI implements UserInterface {
	
	private Scanner scanner;
	
	public CLI_UI() {
		this.scanner = new Scanner(System.in);
	}
	
	@Override
	public void displayLoadingScreen() {
		System.out.println("=========================================");
		System.out.println("      TURN-BASED COMBAT ARENA            ");
		System.out.println("=========================================");
		System.out.println("Loading game assets...");
	}
	
	@Override
	public int promptDifficultySelection() {
		System.out.println("\nSelect Difficulty:");
		System.out.println("1. Easy");
		System.out.println("2. Medium");
		System.out.println("3. Hard");
		System.out.print("Enter choice (1-3): ");
		return getValidInput(1, 3); 
	}

	@Override
	public Combatants promptCharacterSelection() {
		System.out.println("\nSelect Character Class:");
		System.out.println("1. Warrior");
		System.out.println("2. Wizard");
		System.out.print("Enter choice (1-2): ");
		
		int choice = getValidInput(1, 2);
		
		if (choice == 1) {
			return new Warrior(); 
		} else {
			return new Wizard();
		}
	}

	@Override
	public List<Item> promptItemSelection() {
		List<Item> selectedItems = new ArrayList<>(); 
		System.out.println("\nSelect 2 Starting Items (Duplicates allowed):");
		System.out.println("1. Potion (Heals HP)");
		System.out.println("2. Power Stone (Boosts next attack)");
		System.out.println("3. Smoke Bomb (Dodges next attack)");
		
		for (int i = 1; i <= 2; i++) {
			System.out.print("Choose Item " + i + " (1-3): ");
			int choice = getValidInput(1, 3);
			
			if (choice == 1) selectedItems.add(new Potion());
			else if (choice == 2) selectedItems.add(new PowerStone());
			else if (choice == 3) selectedItems.add(new SmokeBomb());
		}
		return selectedItems;
	}

	@Override
	public void displayBattleState(Combatants player, List<Combatants> enemies, int roundNumber) {
		System.out.println("\n--- ROUND " + roundNumber + " ---");
		System.out.println("Player HP: " + player.getHp() + " / " + player.getMaxHp());
		System.out.println("Enemies Alive:");
		
		for (int i = 0; i < enemies.size(); i++) {
			Combatants enemy = enemies.get(i);
			if (enemy.isAlive()) {
				 System.out.println(" - Enemy " + (i+1) + " HP: " + enemy.getHp());
			}
		}
	}

	@Override
	public int promptPlayerAction() {
		System.out.println("\nChoose Action:");
		System.out.println("1. Basic Attack");
		System.out.println("2. Defend");
		System.out.println("3. Use Item");
		System.out.println("4. Special Skill");
		System.out.print("Enter choice (1-4): ");
		return getValidInput(1, 4);
	}
	
	@Override
	public Item promptItemUsage(List<Item> inventory) {
		if (inventory == null || inventory.isEmpty()) {
			System.out.println("\nYour inventory is empty!");
			return null;
		}
		
		System.out.println("\nSelect an item to use:");
		for (int i = 0; i < inventory.size(); i++) {
			System.out.println((i + 1) + ". " + inventory.get(i).getClass().getSimpleName());
		}
		
		int cancelOption = inventory.size() + 1;
		System.out.println(cancelOption + ". Cancel (Go back)");
		
		System.out.print("Enter choice (1-" + cancelOption + "): ");
		int choice = getValidInput(1, cancelOption);
		
		if (choice == cancelOption) {
			return null; 
		} else {
			return inventory.get(choice - 1); 
		}
	}

	@Override
	public void displayVictoryScreen(int remainingHp, int totalRounds) {
		System.out.println("\n=========================================");
		System.out.println("VICTORY! All enemies defeated.");
		System.out.println("Remaining HP: " + remainingHp + " | Rounds: " + totalRounds);
		System.out.println("=========================================");
	}

	@Override
	public void displayDefeatScreen(int enemiesRemaining, int totalRounds) {
		System.out.println("\n=========================================");
		System.out.println("DEFEAT... You have fallen in battle.");
		System.out.println("Enemies left: " + enemiesRemaining + " | Rounds: " + totalRounds);
		System.out.println("=========================================");
	}

	@Override
	public void displayMessage(String message) {
		System.out.println(message);
	}

	@Override
	public void endOfBattleReport(BattleState gameState) {
		System.out.println("\n[Battle Report] Ending game state recorded.");
	}

	@Override
	public void display(TurnSummary turnSummary) {
		String actionStr = turnSummary.getAttackerName() + " \u2192 " + 
						   turnSummary.getActionType() + " \u2192 " + 
						   turnSummary.getTargetName();
		
		String resultStr = "";
		if (turnSummary.getDamageDealt() > 0) resultStr += " (Damage: " + turnSummary.getDamageDealt() + ")";
		if (turnSummary.getHealAmount() > 0) resultStr += " (Healed: " + turnSummary.getHealAmount() + " HP)";
		if (turnSummary.isTargetStunned()) resultStr += " [*STUNNED*]";
		if (turnSummary.isTargetEliminated()) resultStr += " [*ELIMINATED*]";
		
		System.out.println("\nTurn Summary: " + actionStr + resultStr);
	}

	@Override
	public void display(Wave wave) {
		List<Combatants> waveEnemies = wave.getEnemies();
		StringBuilder enemyInfo = new StringBuilder();

		for (int i = 0; i < waveEnemies.size(); i++) {
			Combatants e = waveEnemies.get(i);
			enemyInfo.append(e.getName()).append(" (HP: ").append(e.getHp()).append(")");
			
			if (i < waveEnemies.size() - 1) {
				enemyInfo.append(" + ");
			}
		}

		System.out.println("All initial enemies eliminated \u2192 Backup Spawn triggered! " 
						   + enemyInfo.toString() + " enter simultaneously"); 
	}

	@Override
	public void display(BattleState gamestate) {
		System.out.println("\nCurrent round state updated.");
	}
	
	private int getValidInput(int min, int max) {
		while (true) {
			String input = scanner.next(); 
			try {
				int choice = Integer.parseInt(input);
				if (choice >= min && choice <= max) {
					return choice; 
				} else {
					System.out.print("Invalid choice. Please enter a number between " + min + " and " + max + ": ");
				}
			} catch (NumberFormatException e) {
				System.out.print("That's not a number! Please enter a number (" + min + "-" + max + "): ");
			}
		}
	}
}