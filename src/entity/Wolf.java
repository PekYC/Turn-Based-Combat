package entity;


import control.AutoDecider;

public class Wolf extends Enemy {

    public Wolf(String id) {
        super("Wolf " + id, 40, 45, 5, 35, new AutoDecider());
    }
}