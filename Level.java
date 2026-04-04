package com.combat.control;

import com.combat.entity.combatant.Enemy;
import com.combat.entity.combatant.Goblin;
import com.combat.entity.combatant.Wolf;
import java.util.ArrayList;
import java.util.List;

/**
 * Encapsulates the enemy spawn configuration for a single difficulty level.
 * SRP: Only responsible for providing spawn data.
 */
public class Level {

    public enum Difficulty { EASY, MEDIUM, HARD }

    private final Difficulty difficulty;
    private final List<Enemy> initialWave;
    private final List<Enemy> backupWave; // empty list if no backup

    private Level(Difficulty difficulty, List<Enemy> initial, List<Enemy> backup) {
        this.difficulty = difficulty;
        this.initialWave = initial;
        this.backupWave  = backup;
    }

    public static Level easy() {
        List<Enemy> initial = List.of(new Goblin("A"), new Goblin("B"), new Goblin("C"));
        return new Level(Difficulty.EASY, new ArrayList<>(initial), new ArrayList<>());
    }

    public static Level medium() {
        List<Enemy> initial = new ArrayList<>(List.of(new Goblin("A"), new Wolf("A")));
        List<Enemy> backup  = new ArrayList<>(List.of(new Wolf("B"), new Wolf("C")));
        return new Level(Difficulty.MEDIUM, initial, backup);
    }

    public static Level hard() {
        List<Enemy> initial = new ArrayList<>(List.of(new Goblin("A"), new Goblin("B")));
        List<Enemy> backup  = new ArrayList<>(List.of(new Goblin("C"), new Wolf("A"), new Wolf("B")));
        return new Level(Difficulty.HARD, initial, backup);
    }

    public static Level fromDifficulty(Difficulty d) {
        return switch (d) {
            case EASY   -> easy();
            case MEDIUM -> medium();
            case HARD   -> hard();
        };
    }

    public Difficulty getDifficulty()     { return difficulty; }
    public List<Enemy> getInitialWave()   { return initialWave; }
    public List<Enemy> getBackupWave()    { return backupWave; }
    public boolean hasBackupWave()        { return !backupWave.isEmpty(); }
}
