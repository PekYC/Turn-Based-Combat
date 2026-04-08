package entity.levels;

import java.util.ArrayList;
import java.util.List;

import entity.Wave;

public abstract class Level {
    protected List<Wave> waves = new ArrayList<>();
    private String levelName;
    
    public Level(String levelName) {
    	this.levelName = levelName;
    }
    
    public List<Wave> getWaves() {
    	return waves;
    }
    
    public String getLevelName() {
    	return levelName;
    }
}
