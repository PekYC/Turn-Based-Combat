package boundary;

import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

import entity.BattleState;
import entity.Combatant;
import entity.Player;
import entity.TurnSummary;
import entity.Wave;
import entity.Item;
import entity.Potion;
import entity.PowerStone;
import entity.SmokeBomb;
import entity.Warrior;
import entity.Wizard;
import entity.actions.Action;
import entity.actions.BasicAttack;
import entity.actions.DefendSkill;
import entity.actions.TargetType;
import entity.actions.UseItemAction;

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
	public Player promptCharacterSelection() {
		System.out.println("\nSelect Character Class:");
		System.out.println("1. Warrior");
		System.out.println("2. Wizard");
		System.out.print("Enter choice (1-2): ");
		
		int choice = getValidInput(1, 2);
		
		if (choice == 1) {
			return new Warrior(null); 
		} else {
			return new Wizard(null);  
		}
	}

	@Override
	public List<Item> promptItemSelection(Player player) { 
		List<Item> selectedItems = new ArrayList<>(); 
		System.out.println("\nSelect 2 Starting Items for your " + player.getClass().getSimpleName() + " (Duplicates allowed):");
		System.out.println("1. Potion (Heals HP)");
		System.out.println("2. Power Stone (Boosts next attack)");
		System.out.println("3. Smoke Bomb (Dodges next attack)");
		
		for (int i = 1; i <= 2; i++) {
			System.out.print("Choose Item " + i + " (1-3): ");
			int choice = getValidInput(1, 3);
			
			if (choice == 1) selectedItems.add(new Potion());
			else if (choice == 2) selectedItems.add(new PowerStone(player.getAbility()));
			else if (choice == 3) selectedItems.add(new SmokeBomb());
		}
		return selectedItems;
	}

	@Override
	public Action promptAction(Player player, BattleState state) {
		System.out.println("\nChoose Action:");
		System.out.println("1. Basic Attack");
		System.out.println("2. Defend");
		System.out.println("3. Use Item");
		System.out.println("4. Special Skill (" + player.getAbility().getName() + ")");
		System.out.print("Enter choice (1-4): ");
		
		int choice = getValidInput(1, 4);
		
		if (choice == 1) {
			return new BasicAttack(); 
		} else if (choice == 2) {
			return new DefendSkill(); 
		} else if (choice == 3) {
			Item selected = promptItemUsageHelper(player.getItems());
			if (selected == null) return promptAction(player, state); 
			return new UseItemAction(selected); 
		} else {
			return player.getAbility(); 
		}
	}

	@Override
	public List<Combatant> promptTargets(Action action, BattleState state) {
		List<Combatant> targets = new ArrayList<>();
		
		
		if (action.getTargeting() == TargetType.SINGLE) {
			List<Combatant> enemies = state.getActiveEnemies();
			System.out.println("\nSelect a Target:");
			for (int i = 0; i < enemies.size(); i++) {
				System.out.println((i + 1) + ". " + enemies.get(i).getName() + " (HP: " + enemies.get(i).getHp() + ")");
			}
			int choice = getValidInput(1, enemies.size());
			targets.add(enemies.get(choice - 1));
		} 
		
		else if (action.getTargeting() == TargetType.MULTI) {
			List<Combatant> enemies = state.getActiveEnemies();
			System.out.println("\n[" + action.getName() + "] targets ALL active enemies!");
			for (Combatant enemy : enemies) {
				System.out.println(" \u2192 Lock-on: " + enemy.getName() + " (HP: " + enemy.getHp() + ")");
				targets.add(enemy); 
			}
		} 
		
		else if (action.getTargeting() == TargetType.SELF) {
			System.out.println("\nTarget auto-selected (Self) for " + action.getName() + ".");
		}
		
		return targets;
	}

	@Override
	public void display(BattleState state) {
		System.out.println("\n--- BATTLE STATE UPDATE ---");
	}

	@Override
	public void display(TurnSummary turnSummary) {
		String output = String.format("%s \u2192 %s \u2192 %s: HP: %d \u2192 %d (dmg: %d-%d=%d)",
			turnSummary.getAttackerName(),
			turnSummary.getActionType(),
			turnSummary.getTargetName(),
			turnSummary.getInitialHP(),
			turnSummary.getFinalHP(),
			turnSummary.getRawDamage(),
			turnSummary.getMitigatedAmount(),
			turnSummary.getDamageDealt()
		);
		
		String extraInfo = "";
		if (turnSummary.getHealAmount() > 0) extraInfo += " (Healed: " + turnSummary.getHealAmount() + " HP)";
		if (turnSummary.isTargetStunned()) extraInfo += " [*STUNNED*]";
		if (turnSummary.isTargetEliminated()) extraInfo += " [*ELIMINATED*]";
		
		System.out.println("\nTurn Summary: " + output + extraInfo);
	}

	@Override
	public void display(Wave wave) {
		
		List<Combatant> waveEnemies = wave.getEnemies(false); 
		StringBuilder enemyInfo = new StringBuilder();

		for (int i = 0; i < waveEnemies.size(); i++) {
			Combatant e = waveEnemies.get(i);
			enemyInfo.append(e.getName()).append(" (HP: ").append(e.getHp()).append(")");
			
			if (i < waveEnemies.size() - 1) {
				enemyInfo.append(" + ");
			}
		}

		System.out.println("All initial enemies eliminated \u2192 Backup Spawn triggered! " 
						   + enemyInfo.toString() + " enter simultaneously"); 
	}

	@Override
	public void displayMessage(String message) {
		System.out.println(message);
	}

	@Override
	public void endOfBattleReport(BattleState state) {
		System.out.println("\n[Battle Report] Ending game state recorded.");
	}
	
	private Item promptItemUsageHelper(List<Item> inventory) {
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
		
		if (choice == cancelOption) return null; 
		return inventory.get(choice - 1); 
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